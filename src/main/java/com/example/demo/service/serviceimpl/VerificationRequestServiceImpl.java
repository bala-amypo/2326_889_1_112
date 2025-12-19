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
    public VerificationRequest save(VerificationRequest request) {
        return repository.save(request);
    }

    @Override
    public List<VerificationRequest> getAll() {
        return repository.findAll();
    }

    @Override
    public VerificationRequest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public VerificationRequest update(Long id, VerificationRequest request) {
        VerificationRequest existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setApplicantName(request.getApplicantName());
            existing.setStatus(request.getStatus());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
