package com.example.demo.controller;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verification")
@Tag(name = "Verification Requests")
public class VerificationRequestController {

    private final VerificationRequestService service;

    public VerificationRequestController(VerificationRequestService service) {
        this.service = service;
    }

    // POST /api/verification
    @PostMapping
    public VerificationRequest initiate(@RequestBody VerificationRequest request) {
        return service.initiateVerification(request);
    }

    // PUT /api/verification/{id}/process
    @PutMapping("/{id}/process")
    public VerificationRequest process(@PathVariable Long id) {
        return service.processVerification(id);
    }

    // GET /api/verification/credential/{credentialId}
    @GetMapping("/credential/{credentialId}")
    public List<VerificationRequest> byCredential(@PathVariable Long credentialId) {
        return service.getRequestsByCredential(credentialId);
    }

    // GET /api/verification/{id}
    @GetMapping("/{id}")
    public VerificationRequest getById(@PathVariable Long id) {
        return service.getAllRequests()
                .stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }

    // GET /api/verification
    @GetMapping
    public List<VerificationRequest> getAll() {
        return service.getAllRequests();
    }
}
