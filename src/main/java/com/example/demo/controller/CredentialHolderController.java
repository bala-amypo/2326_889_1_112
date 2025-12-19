package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/holders")
@Tag(name = "Credential Holders")
public class CredentialHolderController {

    @Autowired
    private CredentialHolderService service;

    @PostMapping
    public CredentialHolderProfile create(@RequestBody CredentialHolderProfile holder) {
        return service.create(holder);
    }

    @GetMapping("/{id}")
    public CredentialHolderProfile get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CredentialHolderProfile> all() {
        return service.getAll();
    }

    @PutMapping("/{id}/status")
    public CredentialHolderProfile updateStatus(
            @PathVariable Long id,
            @RequestParam Boolean active) {
        return service.updateStatus(id, active);
    }
}
