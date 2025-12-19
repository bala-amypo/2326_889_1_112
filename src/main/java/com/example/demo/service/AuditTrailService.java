package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AuditTrailRecord;

public interface AuditTrailService {

    AuditTrailRecord save(AuditTrailRecord record);

    List<AuditTrailRecord> getAll();

    AuditTrailRecord getById(Long id);

   
}
