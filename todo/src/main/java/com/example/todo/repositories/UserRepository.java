package com.example.todo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.models.User;

public interface UserRepository extends JpaRepository<User , Long>{
    Optional<User> findByEmail(String email);
}
