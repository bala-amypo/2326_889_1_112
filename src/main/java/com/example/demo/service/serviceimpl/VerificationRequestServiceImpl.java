package com.example.demo.service.serviceimpl;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.VerificationRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    private final VerificationRequestRepository verificationRequestRepository;
    private final CredentialRecordRepository credentialRecordRepository;

    public VerificationRequestServiceImpl(
            VerificationRequestRepository verificationRequestRepository,
            CredentialRecordRepository credentialRecordRepository) {
        this.verificationRequestRepository = verificationRequestRepository;
        this.credentialRecordRepository = credentialRecordRepository;
    }

    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        request.setStatus("PENDING");
        request.setRequestedAt(LocalDateTime.now());
        return verificationRequestRepository.save(request);
    }

    @Override
    public VerificationRequest processVerification(Long requestId) {

        VerificationRequest request = verificationRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Verification request not found"));

        CredentialRecord credential = credentialRecordRepository.findById(request.getCredentialId())
                .orElseThrow(() -> new RuntimeException("Credential not found"));

        if (credential.getExpiryDate() != null &&
            credential.getExpiryDate().isBefore(LocalDate.now())) {
            request.setStatus("FAILED");
        } else {
            request.setStatus("SUCCESS");
        }

        request.setProcessedAt(LocalDateTime.now());
        return verificationRequestRepository.save(request);
    }

    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return verificationRequestRepository.findByCredentialId(credentialId);
    }

    @Override
    public List<VerificationRequest> getAllRequests() {
        return verificationRequestRepository.findAll();
    }
}
