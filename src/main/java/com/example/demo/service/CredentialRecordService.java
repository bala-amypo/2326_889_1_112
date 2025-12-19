package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordService {

    CredentialRecord save(CredentialRecord record);

    List<CredentialRecord> getAll();

    CredentialRecord getById(Long id);

    CredentialRecord update(Long id, CredentialRecord record);

    void delete(Long id);
}
