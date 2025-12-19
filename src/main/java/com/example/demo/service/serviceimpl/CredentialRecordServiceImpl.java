package com.example.demo.service.serviceimpl;

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
        if (existing != null) {
            existing.setTitle(record.getTitle());
            existing.setIssuer(record.getIssuer());
            existing.setIssueDate(record.getIssueDate());
            existing.setExpiryDate(record.getExpiryDate());
            existing.setCredentialType(record.getCredentialType());
            existing.setStatus(record.getStatus());
            existing.setMetadataJson(record.getMetadataJson());
            existing.setRules(record.getRules());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public CredentialRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CredentialRecord getByCode(String credentialCode) {
        return repository.findByCredentialCode(credentialCode).orElse(null);
    }

    @Override
    public List<CredentialRecord> getByHolderId(Long holderId) {
        return repository.findByHolderId(holderId);
    }

    @Override
    public List<CredentialRecord> getAll() {
        return repository.findAll();
    }
}
