package com.ssil.gcp.sb.sqlserver.service;

import com.ssil.gcp.sb.sqlserver.exception.ResourceNotFoundExcetion;
import com.ssil.gcp.sb.sqlserver.model.Todo;
import com.ssil.gcp.sb.sqlserver.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository repository;

    public Todo getTodo(Long id) throws ResourceNotFoundExcetion {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExcetion("Todo not found"));
    }

    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public void saveTodo(Todo todo) {
        repository.save(todo);
    }

    public void updateTodo(Long id, Todo todo) throws ResourceNotFoundExcetion {
        Todo updatedTodo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExcetion("Todo not found"));
        updatedTodo.setTodo_completed(todo.getTodo_completed());
        updatedTodo.setTodo_description(todo.getTodo_description());
        updatedTodo.setTodo_priority(todo.getTodo_priority());
        updatedTodo.setTodo_responsible(todo.getTodo_responsible());
        repository.save(todo);
    }

}
