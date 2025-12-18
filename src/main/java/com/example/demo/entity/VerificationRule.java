package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "verification_rule")
public class VerificationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    // ✅ THIS FIELD WAS MISSING — NOW FIXED
    @ManyToMany
    @JoinTable(
        name = "rule_credential",
        joinColumns = @JoinColumn(name = "rule_id"),
        inverseJoinColumns = @JoinColumn(name = "credential_id")
    )
    private Set<CredentialRecord> credentials;

    // Empty constructor
    public VerificationRule() {}

    // Parameterized constructor
    public VerificationRule(Long id, String ruleName, Set<CredentialRecord> credentials) {
        this.id = id;
        this.ruleName = ruleName;
        this.credentials = credentials;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Set<CredentialRecord> getCredentials() {
        return credentials;
    }

    public void setCredentials(Set<CredentialRecord> credentials) {
        this.credentials = credentials;
    }
}
