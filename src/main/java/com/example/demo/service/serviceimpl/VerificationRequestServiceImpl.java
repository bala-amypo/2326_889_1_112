package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.VerificationRequestService;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    @Autowired
    private VerificationRequestRepository repository;

    @Override
    public VerificationRequest initiate(VerificationRequest request) {
        request.setStatus("PENDING");
        return repository.save(request);
    }

    @Override
    public VerificationRequest process(Long id) {
        VerificationRequest request = getById(id);
        request.setStatus("VERIFIED");
        return repository.save(request);
    }

    @Override
    public VerificationRequest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<VerificationRequest> findByCredentialId(Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }

    @Override
    public List<VerificationRequest> getAll() {
        return repository.findAll();
    }
}
