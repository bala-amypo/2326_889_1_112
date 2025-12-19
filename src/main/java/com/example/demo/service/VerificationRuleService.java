package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VerificationRule;

public interface VerificationRuleService {

    VerificationRule save(VerificationRule rule);

    VerificationRule update(Long id, VerificationRule rule);

    VerificationRule getById(Long id);

    List<VerificationRule> getActiveRules();

    List<VerificationRule> getAll();
}
