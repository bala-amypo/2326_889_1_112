package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VerificationRule;
import com.example.demo.service.VerificationRuleService;

@RestController
@RequestMapping("/verification-rules")
public class VerificationRuleController {

    @Autowired
    private VerificationRuleService service;

    @PostMapping
    public VerificationRule save(@RequestBody VerificationRule rule) {
        return service.save(rule);
    }

    @GetMapping
    public List<VerificationRule> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public VerificationRule getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public VerificationRule update(
            @PathVariable Long id,
            @RequestBody VerificationRule rule) {
        return service.update(id, rule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
