package com.example.home.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.home.entity.Studententity;
import com.example.home.service.Studentservice;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
@RestController
@RequestMapping("/student")
public class CredentialHolderController {
    @Autowired
    CredentialHolderProfileService src;
    @PostMapping("/post")  
    public CredentialHolderProfile postdata(@RequestBody CredentialHolderProfile st){
        return src.savedata(st);
    }
    @GetMapping("/get")
    public List<CredentialHolderProfile>getdata(){
        return src.retdata();
    }
    @GetMapping("/getid/{id}")
    public CredentialHolderProfile getIdVal(@PathVariable int id){
        return src.id(id);
    }
    @PutMapping("/update/{id}")
    public CredentialHolderProfile updateId(@PathVariable int id,@RequestBody CredentialHolderProfile st){
     return src.upid(id,st);
    }
    @DeleteMapping("/delete/{id}")
    public String deleted(@PathVariable int id){
        src.delete(id);
        
    }
   
}

