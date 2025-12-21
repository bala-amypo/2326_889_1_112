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

    // POST /api/rules → Create rule
    @PostMapping
    public VerificationRule createRule(@RequestBody VerificationRule rule) {
        return service.createRule(rule);
    }

    // PUT /api/rules/{id} → Update rule
    @PutMapping("/{id}")
    public VerificationRule updateRule(
            @PathVariable Long id,
            @RequestBody VerificationRule rule) {
        return service.updateRule(id, rule);
    }

    // GET /api/rules/active → List active rules
    @GetMapping("/active")
    public List<VerificationRule> getActiveRules() {
        return service.getActiveRules();
    }

    // GET /api/rules → List all rules
    @GetMapping
    public List<VerificationRule> getAllRules() {
        return service.getAllRules();
    }
}
