package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;

@RestController
@RequestMapping("/api/credential-records")
public class CredentialRecordController {

    @Autowired
    private CredentialRecordService service;

    @PostMapping
    public CredentialRecord save(@RequestBody CredentialRecord credential) {
        return service.save(credential);
    }

    @GetMapping
    public List<CredentialRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CredentialRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public CredentialRecord update(@PathVariable Long id,
                                   @RequestBody CredentialRecord credential) {
        return service.update(id, credential);
    }

  
}
