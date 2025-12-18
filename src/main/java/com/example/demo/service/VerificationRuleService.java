package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VerificationRule;

public interface VerificationRuleService {

    VerificationRule save(VerificationRule rule);

    List<VerificationRule> getAll();

    VerificationRule getById(Long id);

    VerificationRule update(Long id, VerificationRule rule);

    void delete(Long id);
}
