package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;

@RestController
@RequestMapping("/verification-requests")
public class VerificationRequestController {

    @Autowired
    private VerificationRequestService service;

    @PostMapping
    public VerificationRequest create(@RequestBody VerificationRequest request) {
        return service.save(request);
    }

    @GetMapping
    public List<VerificationRequest> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public VerificationRequest getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public VerificationRequest update(
            @PathVariable Long id,
            @RequestBody VerificationRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
