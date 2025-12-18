package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VerificationRequest;

public interface VerificationRequestService {

    VerificationRequest save(VerificationRequest request);

    List<VerificationRequest> getAll();

    VerificationRequest getById(Long id);

    VerificationRequest update(Long id, VerificationRequest request);

    void delete(Long id);
}
