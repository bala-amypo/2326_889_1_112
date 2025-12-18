package com.example.home.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.home.entity.Studententity;
import com.example.home.service.Studentservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
@RequestMapping("/student")
public class CredentialHolderController {
    @Autowired
    CredentialHolderService src;
    @PostMapping("/post")  
    public CredentialHolderEnity postdata(@RequestBody CredentialHolderEntity st){
        return src.savedata(st);
    }
    @GetMapping("/get")
    public List<CredentialHolderEntity>getdata(){
        return src.retdata();
    }
    @GetMapping("/getid/{id}")
    public CredentialHolderEntity getIdVal(@PathVariable int id){
        return src.id(id);
    }
    @PutMapping("/update/{id}")
    public CredentialHolderEntity updateId(@PathVariable int id,@RequestBody CredentialHolderEntity st){
     return src.upid(id,st);
    }
    @DeleteMapping("/delete/{id}")
    public String deleted(@PathVariable int id){
        src.delete(id);
        
    }
   
}

