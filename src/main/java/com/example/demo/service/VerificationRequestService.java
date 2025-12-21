package com.example.demo.service;

import com.example.demo.entity.VerificationRequest;
import java.util.List;

public interface VerificationRequestService {

    // Initiate verification
    VerificationRequest initiateVerification(VerificationRequest request);

    // Process verification (check expiry, update status, log audit)
    VerificationRequest processVerification(Long requestId);

    // Get requests for a credential
    List<VerificationRequest> getRequestsByCredential(Long credentialId);

    // Get all verification requests
    List<VerificationRequest> getAllRequests();
}
