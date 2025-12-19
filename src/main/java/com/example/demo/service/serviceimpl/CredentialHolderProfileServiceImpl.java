package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.service.CredentialHolderProfilerService;

@Service
public class CredentialHolderProfileServiceImpl implements CredentialHolderProfileService {

    @Autowired
    private CredentialHolderProfileRepository repository;

    @Override
    public CredentialHolderProfile create(CredentialHolderProfile holder) {
        return repository.save(holder);
    }

    @Override
    public CredentialHolderProfile getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CredentialHolderProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public CredentialHolderProfile updateStatus(Long id, Boolean active) {
        CredentialHolderProfile holder = getById(id);
        holder.setActive(active);
        return repository.save(holder);
    }
}
