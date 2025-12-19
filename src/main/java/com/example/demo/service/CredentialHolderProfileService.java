package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialHolder;

public interface CredentialHolderProfileService {

    CredentialHolderProfile create(CredentialHolderProfile holder);

    CredentialHolderProfile getById(Long id);

    List<CredentialHolderProfile> getAll();

    CredentialHolderProfile updateStatus(Long id, Boolean active);
}
