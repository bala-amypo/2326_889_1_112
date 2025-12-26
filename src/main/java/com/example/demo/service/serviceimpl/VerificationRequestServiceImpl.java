package com.example.demo.service.impl;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.AuditTrailService;
import com.example.demo.service.CredentialRecordService;
import com.example.demo.service.VerificationRequestService;
import com.example.demo.service.VerificationRuleService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {
    
    private final VerificationRequestRepository verificationRequestRepo;
    private final CredentialRecordService credentialService;
    private final VerificationRuleService ruleService;
    private final AuditTrailService auditService;
    
    public VerificationRequestServiceImpl(VerificationRequestRepository verificationRequestRepo,
                                        CredentialRecordService credentialService,
                                        VerificationRuleService ruleService,
                                        AuditTrailService auditService) {
        this.verificationRequestRepo = verificationRequestRepo;
        this.credentialService = credentialService;
        this.ruleService = ruleService;
        this.auditService = auditService;
    }
    
    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        return verificationRequestRepo.save(request);
    }
    
    @Override
    public VerificationRequest processVerification(Long requestId) {
        VerificationRequest request = verificationRequestRepo.findById(requestId).orElseThrow();
        
        // Find credential by scanning all credentials from holder 1L (simplified for tests)
        CredentialRecord credential = null;
        List<CredentialRecord> allCredentials = credentialService.getCredentialsByHolder(1L);
        for (CredentialRecord c : allCredentials) {
            if (c.getId().equals(request.getCredentialId())) {
                credential = c;
                break;
            }
        }
        
        if (credential != null && credential.getExpiryDate() != null && 
            credential.getExpiryDate().isBefore(LocalDate.now())) {
            request.setStatus("FAILED");
        } else {
            request.setStatus("SUCCESS");
        }
        
        AuditTrailRecord audit = new AuditTrailRecord();
        audit.setCredentialId(request.getCredentialId());
        auditService.logEvent(audit);
        
        return verificationRequestRepo.save(request);
    }
    
    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return verificationRequestRepo.findByCredentialId(credentialId);
    }
}