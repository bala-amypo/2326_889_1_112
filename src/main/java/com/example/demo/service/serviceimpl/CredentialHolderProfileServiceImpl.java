package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CredentialHolder;
import com.example.demo.repository.CredentialHolderRepository;
import com.example.demo.service.CredentialHolderService;

@Service
public class CredentialHolderServiceImpl implements CredentialHolderService {

    @Autowired
    private CredentialHolderRepository repository;

    @Override
    public CredentialHolder save(CredentialHolder holder) {
        return repository.save(holder);
    }

    @Override
    public CredentialHolder getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CredentialHolder> getAll() {
        return repository.findAll();
    }

    @Override
    public CredentialHolder updateStatus(Long id, boolean active) {
        CredentialHolder holder = getById(id);
        holder.setActive(active);
        return repository.save(holder);
    }
}
