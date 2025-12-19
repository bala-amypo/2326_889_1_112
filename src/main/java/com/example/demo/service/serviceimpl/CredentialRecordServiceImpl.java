package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;

@Service
public class CredentialRecordServiceImpl
        implements CredentialRecordService {

    @Autowired
    private CredentialRecordRepository repository;

    @Override
    public CredentialRecord create(CredentialRecord record) {
        return repository.save(record);
    }


   

    @Override
    public CredentialRecord getByCode(String code) {
        return repository.findByCredentialCode(code).orElse(null);
    }

    @Override
    public List<CredentialRecord> getByHolder(Long holderId) {
        return repository.findByHolderId(holderId);
    }

    @Override
    public List<CredentialRecord> getAll() {
        return repository.findAll();
    }
}
