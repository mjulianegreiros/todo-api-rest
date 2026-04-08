package com.example.todo.dtos;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;

    public UserResponseDTO(Long id , String name , String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
}