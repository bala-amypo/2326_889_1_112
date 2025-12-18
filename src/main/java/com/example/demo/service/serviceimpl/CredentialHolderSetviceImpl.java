package com.example.service.impl;
import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.CredentialHolderEntity;
import com.example.demo.service.CredentialHolderService;
@Service
public class CredentialHolderServiceImpl implements CredentialHolderService{
    private List<CredentialHolderEntity> list =new ArrayList<>();

    @Override

    public CredentialHolderEntity savedata(CredentialHolderEntity st){
        list.add(st);
        return st;
    }
    @Override
    public CredentialHolderEntity getidval(Long id){
        for(CredentialHolderEntity s: list){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }
    @Override
    public List<StudentEntity>getall(){
        return list;
    }
    @Override
    public CredentialHolderEntity update(Long id, CedentialHolderEntity st){
        for(CredentialHolderEntity  s:list){
            
        }
    }
}