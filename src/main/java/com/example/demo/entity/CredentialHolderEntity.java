package com.example.demo.entity
public class  CredentialHolderEntity{
   @Id
   private Long Id;
   private String holderld;
   private String fullName;
   
   private String email;
   private String Organization;
   private Boolean active;
   private LocalDateTime createdAt;

}