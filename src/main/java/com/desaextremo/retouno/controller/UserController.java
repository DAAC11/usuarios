package com.desaextremo.retouno.controller;

import com.desaextremo.retouno.business.UserService;
import com.desaextremo.retouno.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> listUser(){
        return service.getAll();
    }

    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.existEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.autenticateUser(email,password);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User creatUser(@RequestBody User user){
        return service.createUser(user);
    }
}
