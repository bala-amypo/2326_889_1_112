package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.service.VerificationRuleService;

@Service
public class VerificationRuleServiceImpl
        implements VerificationRuleService {

    @Autowired
    private VerificationRuleRepository repository;

    @Override
    public VerificationRule create(VerificationRule rule) {
        return repository.save(rule);
    }

    @Override
    public VerificationRule
