package com.example.todo.dtos;

import jakarta.validation.constraints.NotBlank;

public class TodoRequestDTO {
    @NotBlank(message = "A tarefa precisa ter um nome.")
    private String title;
    @NotBlank(message = "A tarefa precisa de uma descrição.")
    private String description;

    public TodoRequestDTO(String title , String description){
        this.title = title;
        this.description = description;
    }
    public TodoRequestDTO(){}

    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
