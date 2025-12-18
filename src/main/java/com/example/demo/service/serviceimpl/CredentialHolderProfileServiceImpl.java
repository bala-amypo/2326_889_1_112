package com.example.demo.service.serviceimpl;

import java.util.*;

import org.springframework.stereotype.Service;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.entity.CredentialHolderProfile; 
import com.example.demo.service.CredentialHolderProfileService; 

@Service
public class CredentialHolderProfileServiceImpl implements CredentialHolderProfileService { 
    
    private List<CredentialHolderProfile> list = new ArrayList<>(); 

    @Override
    public CredentialHolderProfile savedata(CredentialHolderProfile st) {
        list.add(st);
        return st;
    }

    @Override
    public CredentialHolderProfile retdata(Long id) {
        return list.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CredentialHolderProfile> getidval() { 
        return list;
    }

    @Override
    public CredentialHolderProfile upid(Long id, CredentialHolderProfile st) {
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
