package com.example.demo.service;

import com.example.demo.entity.VerificationRequest;
import java.util.List;

public interface VerificationRequestService {

    // Initiates a new verification request
    VerificationRequest initiateVerification(VerificationRequest request);

    // Processes a verification request by its ID
    VerificationRequest processVerification(Long requestId);

    // Get all verification requests for a specific credential
    List<VerificationRequest> getRequestsByCredential(Long credentialId);

    // Get all verification requests
    List<VerificationRequest> getAllRequests();
}
