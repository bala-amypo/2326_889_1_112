package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordService {

    CredentialRecord save(CredentialRecord record);

    CredentialRecord update(Long id, CredentialRecord record);

    List<CredentialRecord> findByHolderId(Long holderId);

    CredentialRecord findByCode(String credentialCode);

    List<CredentialRecord> getAll();
}
