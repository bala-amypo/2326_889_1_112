package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "verification_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = "rule_code")
)
public class VerificationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_code", nullable = false, unique = true)
    private String ruleCode;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String appliesToType;

    @Column(nullable = false)
    private String validationExpression;

    @Column(nullable = false)
    private Boolean active = true;

    // ===== Constructors =====
    public VerificationRule() {
    }

    public VerificationRule(Long id, String ruleCode, String description,
                            String appliesToType, String validationExpression,
                            Boolean active) {
        this.id = id;
        this.ruleCode = ruleCode;
        this.description = description;
        this.appliesToType = appliesToType;
        this.validationExpression = validationExpression;
        this.active = active;
    }

    // ===== Getters & Setters =====
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
}
