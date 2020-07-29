package com.ssil.gcp.sb.sqlserver.service;

import com.ssil.gcp.sb.sqlserver.exception.ResourceNotFoundExcetion;
import com.ssil.gcp.sb.sqlserver.model.Todo;

import java.util.List;

public interface TodoService {

    Todo getTodo(Long id) throws ResourceNotFoundExcetion;
    List<Todo> getTodos();
    void saveTodo(Todo todo);
    void updateTodo(Long id, Todo todo) throws ResourceNotFoundExcetion;

}
