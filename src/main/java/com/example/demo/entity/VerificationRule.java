package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(
    name = "verification_rule",
    uniqueConstraints = @UniqueConstraint(columnNames = "ruleCode")
)
public class VerificationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    private String description;
    private String appliesToType;
    private String validationExpression;
    private Boolean active = true;

    @ManyToMany(mappedBy = "rules")
    private Set<CredentialRecord> credentials;

    /* ===== Constructors ===== */

    public VerificationRule() {}

    /* ===== Getters & Setters ===== */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppliesToType() {
        return appliesToType;
    }

    public void setAppliesToType(String appliesToType) {
        this.appliesToType = appliesToType;
    }

    public String getValidationExpression() {
        return validationExpression;
    }

    public void setValidationExpression(String validationExpression) {
        this.validationExpression = validationExpression;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<CredentialRecord> getCredentials() {
        return credentials;
    }

    public void setCredentials(Set<CredentialRecord> credentials) {
        this.credentials = credentials;
    }
}
