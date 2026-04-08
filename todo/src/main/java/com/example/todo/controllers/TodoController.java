package com.example.todo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dtos.TodoRequestDTO;
import com.example.todo.dtos.TodoResponseDTO;
import com.example.todo.models.Todo;
import com.example.todo.models.User;
import com.example.todo.services.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public Page<TodoResponseDTO> getAllTodos(Pageable page){
        Page<Todo> allTodos = todoService.getAllTodos(page);
        // O map() itera sobre cada elemento — o newTodo representa um todo de cada vez.
        return allTodos.map(newTodo -> new TodoResponseDTO(newTodo.getId(), newTodo.getTitle(), newTodo.getDescription(), null));
    }
    
    @PostMapping("/todos")
    public TodoResponseDTO createTodo(@Valid @RequestBody TodoRequestDTO todoRequestDTO ){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Todo toSave = new Todo(todoRequestDTO.getTitle() , todoRequestDTO.getDescription() , user);
        Todo saved = todoService.createTodo(toSave);

        return new TodoResponseDTO(saved.getId() , saved.getTitle() , saved.getDescription() , user.getId());
    }

    @PutMapping("/todos/{id}")
    public TodoResponseDTO updateTodo(@PathVariable Long id , @Valid @RequestBody TodoRequestDTO todoRequestDTO){
        Todo toChange = todoService.updateTodo(id, todoRequestDTO.getTitle(), todoRequestDTO.getDescription());
        return new TodoResponseDTO(toChange.getId() , toChange.getTitle() , toChange.getDescription() , null);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
