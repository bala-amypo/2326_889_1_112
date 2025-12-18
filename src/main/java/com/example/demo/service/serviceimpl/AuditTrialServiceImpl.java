package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrialRepository;
import com.example.demo.service.AuditTrialService;

@Service
public class AuditTrialServiceImpl implements AuditTrialService {

    @Autowired
    private AuditTrialRepository repository;

    @Override
    public AuditTrailRecord save(AuditTrailRecord record) {
        return repository.save(record);
    }

    @Override
    public List<AuditTrailRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public AuditTrailRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
