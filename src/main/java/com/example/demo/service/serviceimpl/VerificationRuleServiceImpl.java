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
    public VerificationRule save(VerificationRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<VerificationRule> getAll() {
        return repository.findAll();
    }

    @Override
    public VerificationRule getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public VerificationRule update(Long id, VerificationRule rule) {
        VerificationRule existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setRuleName(rule.getRuleName());
            existing.setCredentials(rule.getCredentials());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
