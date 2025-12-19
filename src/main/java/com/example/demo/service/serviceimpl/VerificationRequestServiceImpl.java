package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.VerificationRequestService;

@Service
public class VerificationRequestServiceImpl
        implements VerificationRequestService {

    @Autowired
    private VerificationRequestRepository repository;

    @Override
    public VerificationRequest create(VerificationRequest request) {
        return repository.save(request);
    }

    @Override
    public VerificationRequest process(Long id, String status) {
        VerificationRequest req = getById(id);
        req.setStatus(status);
        req.setProcessedAt(LocalDateTime.now());
        return repository.save(req);
    }

    @Override
    public VerificationRequest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<VerificationRequest> getByCredential(Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }

    @Override
    public List<VerificationRequest> getAll() {
        return repository.findAll();
    }
}
