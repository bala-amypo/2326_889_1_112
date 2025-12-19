package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VerificationRule;
import com.example.demo.service.VerificationRuleService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Verification Rules")
public class VerificationRuleController {

    @Autowired
    private VerificationRuleService service;

    @PostMapping
    public VerificationRule create(@RequestBody VerificationRule rule) {
        return service.save(rule);
    }

    @PutMapping("/{id}")
    public VerificationRule update(@PathVariable Long id,
                                   @RequestBody VerificationRule rule) {
        return service.update(id, rule);
    }

    @GetMapping("/active")
    public List<VerificationRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/{id}")
    public VerificationRule getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<VerificationRule> getAll() {
        return service.getAll();
    }
}
