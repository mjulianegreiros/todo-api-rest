package com.example.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.todo.exceptions.ForbiddenException;
import com.example.todo.exceptions.ResourceNotFoundException;
import com.example.todo.models.Todo;
import com.example.todo.models.User;
import com.example.todo.repositories.TodoRepository;
import com.example.todo.services.TodoService;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @Mock
    private TodoRepository todoRepository;
    @InjectMocks
    private TodoService todoService;

    @Test
    public void shouldCreateTodoSuccessfully(){
        Todo todo = new Todo("comprar leite" , "ir no mercado" , null);
        when(todoRepository.save(todo)).thenReturn(todo);
        Todo result = todoService.createTodo(todo);
        assertEquals("comprar leite" , result.getTitle());
    }

    @Test
    public void shouldThrowExceptionWhenTodoNotFound(){
        when(todoRepository.findById(100L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class , () -> todoService.updateTodo(100L, "comprar legume", "ir na feira", null));
    }

    @Test 
    public void shouldThrowExceptionWhenUserIsNotOwner(){
        User user = mock(User.class);
        User user2 = mock(User.class);
        when(user.getId()).thenReturn(10L);
        when(user2.getId()).thenReturn(3L);
        Todo todo = new Todo("comprar roupas" , "depois do mercado" , user);
        when(todoRepository.findById(todo.getId())).thenReturn(Optional.of(todo));
        assertThrows(ForbiddenException.class, () -> todoService.updateTodo(todo.getId(), "comprar sapato", "depois de ir pra escola", user2.getId()));

    }
}
