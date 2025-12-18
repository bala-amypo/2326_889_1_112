package com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;

@Service
public class CredentialHolderProfileServiceImpl
        implements CredentialHolderProfileService {

    private List<CredentialHolderProfile> list = new ArrayList<>();

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
    public List<CredentialHolderProfile> getall() {
        return list;
    }

    @Override
    public CredentialHolderProfile update(Long id, CredentialHolderProfile st) {
        for (CredentialHolderProfile s : list) {
            if (s.getId().equals(id)) {
                s.setFullName(st.getFullName());
                s.setEmail(st.getEmail());
                s.setOrganization(st.getOrganization());
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
