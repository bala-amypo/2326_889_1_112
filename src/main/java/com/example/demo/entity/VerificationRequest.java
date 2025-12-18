package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "verification_request")
public class VerificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;

    private String status;

    // 🔹 Empty constructor
    public VerificationRequest() {}

    // 🔹 Parameterized constructor
    public VerificationRequest(Long id, String applicantName, String status) {
        this.id = id;
        this.applicantName = applicantName;
        this.status = status;
    }

    // 🔹 Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
