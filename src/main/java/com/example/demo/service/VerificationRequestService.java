package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VerificationRequest;

public interface VerificationRequestService {

    VerificationRequest create(VerificationRequest request);

    VerificationRequest process(Long id, String status);

    VerificationRequest getById(Long id);

    List<VerificationRequest> getByCredential(Long credentialId);

    List<VerificationRequest> getAll();
}
