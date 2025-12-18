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
    public CredentialRecord save(CredentialRecord credential) {
        return repository.save(credential);
    }

    @Override
    public List<CredentialRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public CredentialRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CredentialRecord update(Long id, CredentialRecord credential) {
        credential.setId(id);
        return repository.save(credential);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
