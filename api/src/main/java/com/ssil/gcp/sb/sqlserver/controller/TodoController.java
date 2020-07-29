package com.ssil.gcp.sb.sqlserver.controller;

import com.ssil.gcp.sb.sqlserver.model.Todo;
import com.ssil.gcp.sb.sqlserver.exception.ErrorMessage;
import com.ssil.gcp.sb.sqlserver.exception.ResourceNotFoundExcetion;
import com.ssil.gcp.sb.sqlserver.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService service;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getTodos() {
        return new ResponseEntity<List<Todo>>(service.getTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) throws ResourceNotFoundExcetion {
        return new ResponseEntity<Todo>(service.getTodo(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveTodo(@RequestBody Todo todo) {
        service.saveTodo(todo);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateTodo(@PathVariable Long id, @RequestBody Todo todo) throws ResourceNotFoundExcetion {
        service.updateTodo(id, todo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(ResourceNotFoundExcetion.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundExceptionHandler(ResourceNotFoundExcetion ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        errorMessage.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.PRECONDITION_FAILED);
    }
}
