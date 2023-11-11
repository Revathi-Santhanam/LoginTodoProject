package com.rev.springbootjpa.controller;

import com.rev.springbootjpa.model.Todo;
import com.rev.springbootjpa.request.TodoRequest;
import com.rev.springbootjpa.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all/{uId}")
    public List<Todo> findAllTodo(@PathVariable int uId){

        return todoService.findAllTodo(uId);
    }
    @PostMapping
    public List<Todo> addTodo(@RequestBody TodoRequest todo){
        return todoService.addTodo(todo);
    }
    @PutMapping("/{id}")
    public List<Todo> updateTodo(@PathVariable Integer id,@RequestBody TodoRequest todo){
        return todoService.updateTodo(id,todo);
    }
    @DeleteMapping("/{id}")
    public List<Todo> deleteTodoById(@PathVariable Integer id){
        return todoService.deleteTodoById(id);
    }

}
