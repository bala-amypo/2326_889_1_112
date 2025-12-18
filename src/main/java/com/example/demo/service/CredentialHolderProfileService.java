package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.CredentialHolderProfile;
public interface CredentialHolderProfileService{
     CredentialHolderProfile savedata(CredentialHolderProfile st);
     CredentialHolderProfile retdata(Long id);
     List<CredentialHolderProfile>getidval(Long id);
     CredentialHolderProfile upid(Long id, CredentialHolderProfile st);
     void delete(Long id);
}