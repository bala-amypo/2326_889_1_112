package com.example.demo.service.serviceimpl; // 🔴 CHANGED package

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CredentialHolderProfile; // 🔴 CHANGED import
import com.example.demo.service.CredentialHolderProfileService; // 🔴 CHANGED import

@Service
public class CredentialHolderProfileServiceImpl
        implements CredentialHolderProfileService { // 🟢 FIXED

    private List<CredentialHolderProfile> list = new ArrayList<>(); // 🔴 CHANGED

    @Override
    public CredentialHolderProfile savedata(CredentialHolderProfile st) {
        list.add(st);
        return st;
    }

    @Override
    public CredentialHolderProfile getidval(Long id) {
        return list.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CredentialHolderProfile> getall() { // 🔴 CHANGED return type
        return list;
    }

    @Override
    public CredentialHolderProfile update(Long id, CredentialHolderProfile st) {
        for (CredentialHolderProfile s : list) {
            if (s.getId().equals(id)) {
                s.setFullName(st.getFullName()); // 🔴 CHANGED
                s.setEmail(st.getEmail());       // 🔴 CHANGED
                s.setOrganization(st.getOrganization()); // 🔴 CHANGED
                return s;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        list.removeIf(s -> s.getId().equals(id));
    }
}
