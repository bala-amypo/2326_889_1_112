package com.example.demo.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
@RestController
@RequestMapping("/student")
public class CredentialHolderController {
    @Autowired
    private CredentialHolderProfileService src;
    @PostMapping("/post")  
    public CredentialHolderProfile postdata(@RequestBody CredentialHolderProfile st){
        return src.savedata(st);
    }
    @GetMapping("/get")
    public List<CredentialHolderProfile>getdata(){
        return src.retdata();
    }
    @GetMapping("/getid/{id}")
    public CredentialHolderProfile getIdVal(@PathVariable Long id){
        return src.getidval(id);
    }
    @PutMapping("/update/{id}")
    public CredentialHolderProfile updateId(@PathVariable Long id,@RequestBody CredentialHolderProfile st){
     return src.upid(id,st);
    }
   
}