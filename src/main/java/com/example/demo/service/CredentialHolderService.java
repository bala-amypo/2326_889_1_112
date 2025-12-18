package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.CredentialHolderEntity;
public interface CredentialHolderService{
     CredentialHolderEntity savedata(CredentialHolderEntity st);
     CredentialHolderEntity getidval(Long id);
     List<CredentialHolderEntity>getall();
     CredentialHolderEntity update(Long id, CredentialHolderEntity st);
     void delete(Long id);