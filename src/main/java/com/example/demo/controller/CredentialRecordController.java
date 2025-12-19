package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/credentials")
@Tag(name = "Credential Records")
public class CredentialRecordController {

    @Autowired
    private CredentialRecordService service;

    @PostMapping
    public CredentialRecord create(@RequestBody CredentialRecord record) {
        return service.create(record);
    }

    @PutMapping("/{id}")
    public CredentialRecord update(
            @PathVariable Long id,
            @RequestBody CredentialRecord record) {
        return service.update(id, record);
    }

    @GetMapping("/holder/{holderId}")
    public List<CredentialRecord> byHolder(
            @PathVariable Long holderId) {
        return service.getByHolder(holderId);
    }

    @GetMapping("/code/{credentialCode}")
    public CredentialRecord byCode(
            @PathVariable String credentialCode) {
        return service.getByCode(credentialCode);
    }

    @GetMapping
    public List<CredentialRecord> all() {
        return service.getAll();
    }
}
