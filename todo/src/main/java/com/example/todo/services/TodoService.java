package com.example.todo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.todo.exceptions.ForbiddenException;
import com.example.todo.exceptions.ResourceNotFoundException;
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

    public Page<Todo> getAllTodos(User user , Pageable page){
        return todoRepository.findByUser(user, page);
    }

    public Optional<Todo> findById(Long id){
        return todoRepository.findById(id);
    }

    public Todo updateTodo(Long id , String title , String description , Long userId){
        Optional<Todo> toChange = todoRepository.findById(id);
        toChange.orElseThrow(() -> new ResourceNotFoundException("Todo não encontrado."));
        if(!(toChange.get().getUser().getId().equals(userId))){
            throw new ForbiddenException("Usuário não autorizado.");
        }
        toChange.get().setTitle(title);
        toChange.get().setDescription(description);
        return todoRepository.save(toChange.get());
    }

    public void deleteTodo(Long id , Long userId){
        Optional<Todo> toDelete = todoRepository.findById(id);
        toDelete.orElseThrow(() -> new ResourceNotFoundException("Todo não encontrado."));
        if(!(toDelete.get().getUser().getId().equals(userId))){
            throw new ForbiddenException("Usuário não autorizado.");
        }
        todoRepository.deleteById(id);
    }
}