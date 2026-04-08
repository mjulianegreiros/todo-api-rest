package com.example.todo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    public Todo(){}
    public Todo(String title , String description , User user){this.title = title; this.description = description; this.user = user;}

    // não sei que parametros colocar aqui dentro dessa anotação
    @ManyToOne()
    private User user;

    public Long getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public User getUser(){
        return this.user;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    // não sei se a função abaixo deveria existir, pois tem a anotação @ManyToOne
    public void setUser(User user){
        this.user = user;
    }



}
