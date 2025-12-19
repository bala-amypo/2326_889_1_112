package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialHolder;

public interface CredentialHolderService {

    CredentialHolder create(CredentialHolder holder);

    CredentialHolder getById(Long id);

    List<CredentialHolder> getAll();

    CredentialHolder updateStatus(Long id, Boolean active);
}
