package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VerificationRequest;

public interface VerificationRequestService {

    VerificationRequest initiate(VerificationRequest request);

    VerificationRequest process(Long id);

    VerificationRequest getById(Long id);

    List<VerificationRequest> findByCredentialId(Long credentialId);

    List<VerificationRequest> getAll();
}
