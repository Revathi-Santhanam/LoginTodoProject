package com.rev.springbootjpa.service;

import com.rev.springbootjpa.model.AppUser;
import com.rev.springbootjpa.model.Todo;
import com.rev.springbootjpa.repository.AppUserRepository;
import com.rev.springbootjpa.repository.TodoRepository;
import com.rev.springbootjpa.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    public List<Todo> findAllTodo(int uId){
        return todoRepository.findAll()
                .stream().filter(todo -> todo.getAppUser().getUId()==uId)
                .collect(Collectors.toList());
    }

    public List<Todo> addTodo(TodoRequest todo){
        Todo org = new Todo();
        org.setTodo(todo.getTodo());
        AppUser user=appUserRepository.findById(todo.getUserId()).get();
        org.setAppUser(user);
        todoRepository.save(org);
        return findAllTodo(todo.getUserId());
    }

    public List<Todo> updateTodo(Integer id,TodoRequest todo){
        Todo org = new Todo();
        org.setTId(id);
        org.setTodo(todo.getTodo());
        AppUser user=appUserRepository.findById(todo.getUserId()).get();
        org.setAppUser(user);
        todoRepository.save(org);
        return findAllTodo(todo.getUserId());
    }

    public List<Todo> deleteTodoById(Integer id){
        int userId=todoRepository.findById( id).get().getAppUser().getUId();
        todoRepository.deleteById(id);
        return findAllTodo(userId);
    }
}
