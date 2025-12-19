package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.service.VerificationRuleService;

@Service
public class VerificationRuleServiceImpl implements VerificationRuleService {

    @Autowired
    private VerificationRuleRepository repository;

    @Override
    public VerificationRule saveRule(VerificationRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<VerificationRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public VerificationRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public VerificationRule updateRule(Long id, VerificationRule rule) {
        VerificationRule existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setRuleCode(rule.getRuleCode());
            existing.setDescription(rule.getDescription());
            existing.setAppliesToType(rule.getAppliesToType());
            existing.setValidationExpression(rule.getValidationExpression());
            existing.setActive(rule.getActive());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
