package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "verification_request")
public class VerificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long credentialId;
    private String status;

    private LocalDateTime requestedAt;
    private LocalDateTime processedAt;

    public VerificationRequest() {
        this.requestedAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCredentialId() { return credentialId; }
    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getRequestedAt() { return requestedAt; }
    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public LocalDateTime getProcessedAt() { return processedAt; }
    public void setProcessedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
    }
}
