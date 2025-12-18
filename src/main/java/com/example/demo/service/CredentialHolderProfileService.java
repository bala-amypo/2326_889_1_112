package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.CredentialHolderProfile;
public interface CredentialHolderProfileService{
     CredentialHolderProfile savedata(CredentialHolderProfile st);
     List<CredentialHolderProfile> retdata();
     CredentialHolderProfile getidval(Long id);
     CredentialHolderProfile upid(Long id, CredentialHolderProfile st);
     void delete(Long id);
}