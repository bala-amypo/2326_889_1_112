package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordService {

    CredentialRecord create(CredentialRecord record);

    CredentialRecord update(Long id, CredentialRecord record);

    List<CredentialRecord> findByHolder(Long holderId);

    CredentialRecord findByCode(String code);

    List<CredentialRecord> findAll();
}
