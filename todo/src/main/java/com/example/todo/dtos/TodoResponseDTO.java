package com.example.todo.dtos;


public class TodoResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Long userId;

    public TodoResponseDTO(){}
    public TodoResponseDTO(Long id , String title , String description , Long userId){this.id = id; this.title = title; this.description = description; this.userId = userId;}


    public Long getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public Long getUserId(){
        return this.userId;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
}
