package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CredentialHolder;
import com.example.demo.service.CredentialHolderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/holders")
@Tag(name = "Credential Holders")
public class CredentialHolderController {

    @Autowired
    private CredentialHolderService service;

    @PostMapping
    public CredentialHolder createHolder(@RequestBody CredentialHolder holder) {
        return service.save(holder);
    }

    @GetMapping("/{id}")
    public CredentialHolder getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CredentialHolder> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/status")
    public CredentialHolder updateStatus(@PathVariable Long id,
                                         @RequestParam boolean active) {
        return service.updateStatus(id, active);
    }
}
