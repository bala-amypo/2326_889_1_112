package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long> {
}
