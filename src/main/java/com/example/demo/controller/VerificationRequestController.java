package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/verification")
@Tag(name = "Verification Requests")
public class VerificationRequestController {

    @Autowired
    private VerificationRequestService service;

    @PostMapping
    public VerificationRequest initiate(@RequestBody VerificationRequest request) {
        return service.initiate(request);
    }

    @PutMapping("/{id}/process")
    public VerificationRequest process(@PathVariable Long id) {
        return service.process(id);
    }

    @GetMapping("/credential/{credentialId}")
    public List<VerificationRequest> getByCredential(@PathVariable Long credentialId) {
        return service.findByCredentialId(credentialId);
    }

    @GetMapping("/{id}")
    public VerificationRequest getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<VerificationRequest> getAll() {
        return service.getAll();
    }
}
