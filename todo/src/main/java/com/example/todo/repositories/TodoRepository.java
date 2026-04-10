package com.example.todo.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.models.Todo;
import com.example.todo.models.User;

public interface TodoRepository extends JpaRepository<Todo , Long>{
    Page<Todo> findByUser(User user , Pageable page);
}
