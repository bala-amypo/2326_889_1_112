package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialRecordProfile;

public interface CredentialRecordService {

    CredentialRecordProfile save(CredentialRecordProfile record);

    List<CredentialRecordProfile> getAll();

    CredentialRecordProfile getById(Long id);

    CredentialRecordProfile update(Long id, CredentialRecordProfile record);

    void delete(Long id);
}
