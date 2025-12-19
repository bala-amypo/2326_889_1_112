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
    public VerificationRequest create(@RequestBody VerificationRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}/process")
    public VerificationRequest process(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.process(id, status);
    }

    @GetMapping("/{id}")
    public VerificationRequest get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/credential/{credentialId}")
    public List<VerificationRequest> byCredential(
            @PathVariable Long credentialId) {
        return service.getByCredential(credentialId);
    }

    @GetMapping
    public List<VerificationRequest> all() {
        return service.getAll();
    }
}
