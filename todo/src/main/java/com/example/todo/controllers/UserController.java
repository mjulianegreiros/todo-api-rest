package com.example.todo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dtos.LoginRequestDTO;
import com.example.todo.dtos.LoginResponseDTO;
import com.example.todo.dtos.UserRequestDTO;
import com.example.todo.dtos.UserResponseDTO;
import com.example.todo.models.User;
import com.example.todo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody @Valid UserRequestDTO user){
        User toSave = new User(user.getName() , user.getEmail() , user.getPassword());
        User saved = userService.register(toSave);
        UserResponseDTO userResponseDTO = new UserResponseDTO(saved.getId(), saved.getName(), saved.getEmail());
        return userResponseDTO;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        String tokenToLog = userService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        return new LoginResponseDTO(tokenToLog);
    }
}
