package com.example.todo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 6 , message = "O nome deve conter, no mínimo, 6 caracteres.")
    private String name;
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ter um formato válido.")
    private String email;
    @NotBlank(message = "É necessário inserir uma senha.")
    @Size(min = 6, message = "A senha deve possuir, no mínimo, 6 caracteres.")
    private String password;

    public UserRequestDTO(String name , String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // getters
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
