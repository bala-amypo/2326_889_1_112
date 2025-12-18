package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(
    name = "credential_record",
    uniqueConstraints = @UniqueConstraint(columnNames = "credentialCode")
)
public class CredentialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long holderId;

    @Column(nullable = false, unique = true)
    private String credentialCode;

    private String title;
    private String issuer;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String credentialType;
    private String status;

    @Column(columnDefinition = "TEXT")
    private String metadataJson;

    // ✅ THIS FIELD WAS MISSING
    @ManyToMany
    @JoinTable(
        name = "credential_verification_rules",
        joinColumns = @JoinColumn(name = "credential_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<VerificationRule> rules;

    public CredentialRecord() {
    }

    // getters & setters (keep existing ones)

    public Set<VerificationRule> getRules() {
        return rules;
    }

    public void setRules(Set<VerificationRule> rules) {
        this.rules = rules;
    }
}
