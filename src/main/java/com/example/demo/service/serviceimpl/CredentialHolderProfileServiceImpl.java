package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.repository.CredentialHolderProfileRepository;

@Service
public class CredentialHolderProfileServiceImpl implements CredentialHolderProfileService {

    @Autowired
    private CredentialHolderProfileRepository repository;

    @Override
    public CredentialHolderProfile savedata(CredentialHolderProfile st) {
        return repository.save(st);
    }

    @Override
    public List<CredentialHolderProfile> retdata() {
        return repository.findAll();
    }

    @Override
    public CredentialHolderProfile getidval(Long id) {
        Optional<CredentialHolderProfile> optionalProfile = repository.findById(id);
        if (optionalProfile.isPresent()) {
            return optionalProfile.get();
        } else {
            throw new RuntimeException("CredentialHolderProfile not found with id: " + id);
        }
    }

    @Override
    public CredentialHolderProfile upid(Long id, CredentialHolderProfile st) {
        Optional<CredentialHolderProfile> optionalProfile = repository.findById(id);
        if (optionalProfile.isPresent()) {
            CredentialHolderProfile existingProfile = optionalProfile.get();

            // Update the fields as needed
            existingProfile.setFullName(st.getFullName()); // example field
            existingProfile.setEmail(st.getEmail());
            existingProfile.setActive(st.active());
            existingProfile.setOrganization(st.getOrganization());
            // add more fields if needed

            return repository.save(existingProfile);
        } else {
            throw new RuntimeException("CredentialHolderProfile not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<CredentialHolderProfile> optionalProfile = repository.findById(id);
        if (optionalProfile.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("CredentialHolderProfile not found with id: " + id);
        }
    }
}