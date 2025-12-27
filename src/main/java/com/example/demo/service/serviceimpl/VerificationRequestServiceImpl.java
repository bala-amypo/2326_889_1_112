package com.example.demo.service.serviceimpl;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.AuditTrailService;
import com.example.demo.service.CredentialRecordService;
import com.example.demo.service.VerificationRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    private final VerificationRequestRepository verificationRequestRepo;
    private final CredentialRecordService credentialService;
    private final AuditTrailService auditService;

    public VerificationRequestServiceImpl(
            VerificationRequestRepository verificationRequestRepo,
            CredentialRecordService credentialService,
            AuditTrailService auditService) {

        this.verificationRequestRepo = verificationRequestRepo;
        this.credentialService = credentialService;
        this.auditService = auditService;
    }

    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        request.setStatus("PENDING");
        return verificationRequestRepo.save(request);
    }

    @Override
    public VerificationRequest processVerification(Long requestId) {

        VerificationRequest request = verificationRequestRepo.findById(requestId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Verification request not found"));

        // ✅ Fetch credential using EXISTING service method
        CredentialRecord credential =
                credentialService.getCredentialByCode(
                        request.getCredentialId().toString()
                );

        boolean expired =
                credential.getExpiryDate() != null &&
                credential.getExpiryDate().isBefore(LocalDate.now());

        request.setStatus(expired ? "FAILED" : "SUCCESS");
        verificationRequestRepo.save(request);

        // ✅ Audit log
        AuditTrailRecord audit = new AuditTrailRecord();
        audit.setCredentialId(request.getCredentialId());
        audit.setLoggedAt(LocalDateTime.now());
        auditService.logEvent(audit);

        return request;
    }

    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return verificationRequestRepo.findByCredentialId(credentialId);
    }

    @Override
    public List<VerificationRequest> getAllRequests() {
        return verificationRequestRepo.findAll();
    }
}
