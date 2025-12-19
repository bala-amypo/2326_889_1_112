package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;

@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {

    @Autowired
    private CredentialRecordRepository repository;

    @Override
    public CredentialRecord save(CredentialRecord record) {
        return repository.save(record);
    }

    @Override
    public CredentialRecord update(Long id, CredentialRecord record) {
        CredentialRecord existing = repository.findById(id).orElse(null);
        record.setId(existing.getId());
        return repository.save(record);
    }

    @Override
    public List<CredentialRecord> findByHolderId(Long holderId) {
        return repository.findByHolderId(holderId);
    }

    @Override
    public CredentialRecord findByCode(String credentialCode) {
        return repository.findByCredentialCode(credentialCode);
    }

    @Override
    public List<CredentialRecord> getAll() {
        return repository.findAll();
    }
}
