package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailService;

@RestController
@RequestMapping("/audit-trials")
public class AuditTrailController {

    @Autowired
    private AuditTrailService service;

    @PostMapping
    public AuditTrailRecord create(@RequestBody AuditTrailRecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<AuditTrailRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AuditTrailRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
