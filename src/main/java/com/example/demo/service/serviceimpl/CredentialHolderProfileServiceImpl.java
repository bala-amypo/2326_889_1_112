package com.example.service.impl;
import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.CredentialHolderEntity;
import com.example.demo.service.CredentialHolderService;
@Service
public class CredentialHolderProfileServiceImpl implements CredentialHolderProfileService{
    private List<CredentialHolderProfile> list =new ArrayList<>();

    @Override

    public CredentialHolderProfile savedata(CredentialHolderProfile st){
        list.add(st);
        return st;
    }
    @Override
    public CredentialHolderProfile getidval(Long id){
        for(CredentialHolderProfile s: list){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }
    @Override
    public List<StudentProfile>getall(){
        return list;
    }
    @Override
    public CredentialHolderProfile update(Long id, CredentialHolderProfile st){
        for(CredentialHolderProfile  s:list){
            if(s.getId().equals(id)){
                s.setName(st.getName());
                s.setEmail(st.getEmail());

            s.setDepartment(st.getDepartment());
            return s;
            }
        }
        return null;
    }
    @Override
    public void delete(Long id){
        list.removeIf(s -> s.getId().equals(id));
    }
}