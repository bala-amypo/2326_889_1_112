package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/credentials")
public class CredentialRecordController {
    
    private final CredentialRecordService credentialService;
    
    public CredentialRecordController(CredentialRecordService credentialService) {
        this.credentialService = credentialService;
    }
    
    @PostMapping
    public ResponseEntity<CredentialRecord> create(@RequestBody CredentialRecord record) {
        return ResponseEntity.ok(credentialService.createCredential(record));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CredentialRecord> update(@PathVariable Long id, @RequestBody CredentialRecord update) {
        return ResponseEntity.ok(credentialService.updateCredential(id, update));
    }
    
    @GetMapping("/holder/{holderId}")
    public ResponseEntity<List<CredentialRecord>> getByHolder(@PathVariable Long holderId) {
        return ResponseEntity.ok(credentialService.getCredentialsByHolder(holderId));
    }
    
    @GetMapping("/code/{code}")
    public ResponseEntity<CredentialRecord> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(credentialService.getCredentialByCode(code));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CredentialRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(credentialService.getCredentialById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<CredentialRecord>> getAll() {
        return ResponseEntity.ok(credentialService.getAllCredentials());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        credentialService.deleteCredential(id);
        return ResponseEntity.noContent().build();
    }
}