package com.example.demo.service.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.AuditTrailService;
import com.example.demo.service.CredentialRecordService;
import com.example.demo.service.VerificationRequestService;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    @Autowired
    private VerificationRequestRepository verificationRequestRepo;

    @Autowired
    private CredentialRecordService credentialService;

    @Autowired
    private AuditTrailService auditService;

    // REQUIRED by VerificationRequestService
    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        return verificationRequestRepo.save(request);
    }

    // REQUIRED by VerificationRequestService
    @Override
    public VerificationRequest processVerification(Long requestId) {

        VerificationRequest request = verificationRequestRepo.findById(requestId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Verification request not found"));

        // Get all credentials of the holder
        List<CredentialRecord> credentials =
                credentialService.getCredentialsByHolder(request.getHolderId());

        CredentialRecord credential = credentials.stream()
                .filter(c -> c.getId().equals(request.getCredentialId()))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Credential not found"));

        boolean expired =
                credential.getExpiryDate() != null &&
                credential.getExpiryDate().isBefore(LocalDate.now());

        request.setStatus(expired ? "FAILED" : "SUCCESS");
        verificationRequestRepo.save(request);

        AuditTrailRecord audit = new AuditTrailRecord();
        audit.setCredentialId(request.getCredentialId());
        audit.setLoggedAt(LocalDateTime.now());
        auditService.logEvent(audit);

        return request;
    }

    // REQUIRED by VerificationRequestService
    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return verificationRequestRepo.findByCredentialId(credentialId);
    }
}
