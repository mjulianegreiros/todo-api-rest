package com.example.todo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.todo.models.Todo;
import com.example.todo.models.User;
import com.example.todo.repositories.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Page<Todo> getAllTodos(Pageable page){
        return todoRepository.findAll(page);
    }

    public Optional<Todo> findById(Long id){
        return todoRepository.findById(id);
    }

    public Todo updateTodo(Long id , String title , String description){
        Optional<Todo> toChange = todoRepository.findById(id);
        toChange.orElseThrow(() -> new RuntimeException("Todo não encontrado."));
        toChange.get().setTitle(title);
        toChange.get().setDescription(description);
        return todoRepository.save(toChange.get());
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}