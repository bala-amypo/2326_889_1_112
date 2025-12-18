package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.CredentialHolderProfile;
public interface CredentialHolderProfileService{
     CredentialHolderProfile savedata(CredentialHolderProfile st);
     CredentialHolderProfile getidval(Long id);
     List<CredentialHolderprofile>getall();
     CredentialHolderProfile update(Long id, CredentialHolderProfile st);
     void delete(Long id);
}