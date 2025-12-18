package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CredentialHolderEntity;
@Repository
public interface StudentRepo extends JpaRepository<CredentialHolderProfile, Long>{
}