package com.example.demo.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CredentialRecordprofile;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;

@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {

    @Autowired
    private CredentialRecordRepository repository;

    @Override
    public CredentialRecordProfile save(CredentialRecord record) {
        return repository.save(record);
    }

    @Override
    public List<CredentialRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public CredentialRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 🔴 THIS METHOD WAS MISSING — NOW FIXED
    @Override
    public CredentialRecord update(Long id, CredentialRecord record) {
        CredentialRecord existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCredentialType(record.getCredentialType());
            existing.setCredentialValue(record.getCredentialValue());
            existing.setIssuedDate(record.getIssuedDate());
            existing.setExpiryDate(record.getExpiryDate());
            existing.setStatus(record.getStatus());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
