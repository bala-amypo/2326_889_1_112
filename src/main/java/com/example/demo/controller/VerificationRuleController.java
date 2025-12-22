package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VerificationRule;
import com.example.demo.service.VerificationRuleService;

@RestController
@RequestMapping("/api/rules")
public class VerificationRuleController {

    private final VerificationRuleService service;

    public VerificationRuleController(VerificationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public VerificationRule createRule(@RequestBody VerificationRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public VerificationRule updateRule(
            @PathVariable Long id,
            @RequestBody VerificationRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<VerificationRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping
    public List<VerificationRule> getAllRules() {
        return service.getAllRules();
    }
}
