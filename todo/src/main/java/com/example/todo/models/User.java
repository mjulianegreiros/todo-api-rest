package com.example.todo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //define como vão ser geradas as chaves primárias
    private Long id;

    private String name;
    private String email;
    private String password;

    // constructors
    public User(){
        
    }
    public User(String name , String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // getters
    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
