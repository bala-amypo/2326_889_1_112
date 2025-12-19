package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/credentials")
@Tag(name = "Credentials")
public class CredentialRecordController {

    @Autowired
    private CredentialRecordService service;

    @PostMapping
    public CredentialRecord create(@RequestBody CredentialRecord record) {
        return service.save(record);
    }

    @PutMapping("/{id}")
    public CredentialRecord update(@PathVariable Long id,
                                   @RequestBody CredentialRecord record) {
        return service.update(id, record);
    }

    @GetMapping("/holder/{holderId}")
    public List<CredentialRecord> getByHolder(@PathVariable Long holderId) {
        return service.findByHolderId(holderId);
    }

    @GetMapping("/code/{credentialCode}")
    public CredentialRecord getByCode(@PathVariable String credentialCode) {
        return service.findByCode(credentialCode);
    }

    @GetMapping
    public List<CredentialRecord> getAll() {
        return service.getAll();
    }
}
