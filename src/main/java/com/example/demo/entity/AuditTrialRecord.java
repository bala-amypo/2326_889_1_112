package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_trail_record")
public class AuditTrailRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long credentialId;

    private String eventType;

    private String details;

    private LocalDateTime loggedAt;

    // 🔹 Auto-generate timestamp
    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    // 🔹 Empty constructor
    public AuditTrailRecord() {}

    // 🔹 Parameterized constructor
    public AuditTrailRecord(Long id, Long credentialId, String eventType, String details) {
        this.id = id;
        this.credentialId = credentialId;
        this.eventType = eventType;
        this.details = details;
    }

    // 🔹 Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
