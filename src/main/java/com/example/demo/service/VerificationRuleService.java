package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordService {

    CredentialRecord create(CredentialRecord record);

    CredentialRecord update(Long id, CredentialRecord record);

    CredentialRecord getById(Long id);

    CredentialRecord getByCode(String code);

    List<CredentialRecord> getByHolder(Long holderId);

    List<CredentialRecord> getAll();
}
