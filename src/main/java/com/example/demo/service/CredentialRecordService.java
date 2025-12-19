package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordService {

    CredentialRecord save(CredentialRecord record);

    CredentialRecord update(Long id, CredentialRecord record);

    CredentialRecord getById(Long id);

    CredentialRecord getByCode(String credentialCode);

    List<CredentialRecord> getByHolderId(Long holderId);

    List<CredentialRecord> getAll();
}
