package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialHolder;

public interface CredentialHolderProfileService {

    CredentialHolderProfile create(CredentialHolderPro holder);

    CredentialHolder getById(Long id);

    List<CredentialHolder> getAll();

    CredentialHolder updateStatus(Long id, Boolean active);
}
