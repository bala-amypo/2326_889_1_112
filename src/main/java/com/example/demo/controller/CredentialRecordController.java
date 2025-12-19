package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;

@RestController
@RequestMapping("/api/credentials")
public class CredentialRecordController {

    @Autowired
    private CredentialRecordService service;

    // POST /api/credentials
    @PostMapping
    public CredentialRecord create(@RequestBody CredentialRecord record) {
        return service.save(record);
    }

    // PUT /api/credentials/{id}
    @PutMapping("/{id}")
    public CredentialRecord update(
            @PathVariable Long id,
            @RequestBody CredentialRecord record) {
        return service.update(id, record);
    }

    // GET /api/credentials/holder/{holderId}
    @GetMapping("/holder/{holderId}")
    public List<CredentialRecord> getByHolder(@PathVariable Long holderId) {
        return service.getByHolderId(holderId);
    }

    // GET /api/credentials/code/{credentialCode}
    @GetMapping("/code/{credentialCode}")
    public CredentialRecord getByCode(@PathVariable String credentialCode) {
        return service.getByCode(credentialCode);
    }

    // GET /api/credentials
    @GetMapping
    public List<CredentialRecord> getAll() {
        return service.getAll();
    }
}
