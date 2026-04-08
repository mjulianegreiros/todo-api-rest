package com.example.todo.services;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.todo.models.User;
import com.example.todo.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository , JwtService jwtService){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public User register(User user){
        String gen = BCrypt.gensalt();
        
        user.setPassword(BCrypt.hashpw(user.getPassword(), gen));
        return userRepository.save(user);
    }

    public String login(String email , String password){
        Optional<User> userToLog = userRepository.findByEmail(email);
        userToLog.orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if(BCrypt.checkpw(password, userToLog.get().getPassword())){
            return jwtService.generateToken(userToLog.get());
        } else{
            throw new RuntimeException("Credenciais inválidas.");
        }
    }

    public User findByEmail(String email){
        Optional<User> toReturn = userRepository.findByEmail(email);
        toReturn.orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return toReturn.get();
    }
}
