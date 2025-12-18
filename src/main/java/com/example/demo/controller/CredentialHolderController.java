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
public class Studentcontroller {
    @Autowired
    Studentservice src;
    @PostMapping("/post")  
    public Studententity postdata(@RequestBody Studententity st){
        return src.savedata(st);
    }
    @GetMapping("/get")
    public List<Studententity>getdata(){
        return src.retdata();
    }
    @GetMapping("/getid/{id}")
    public Studententity getIdVal(@PathVariable int id){
        return src.id(id);
    }
    @PutMapping("/update/{id}")
    public Studententity updateId(@PathVariable int id,@RequestBody Studententity st){
     return src.upid(id,st);
    }
   
}

