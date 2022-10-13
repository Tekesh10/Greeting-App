package com.example.greetingapp.controller;

import com.example.greetingapp.Repository.UserRepo;
import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired
    private UserRepo userRepo;
    private static final String template = "Hello, %s";
    private final AtomicLong counter= new AtomicLong();
    @GetMapping("/")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User userdto){
        User user=new User(userdto.getFirstName(),userdto.getLastName());
        return userRepo.save(user);
    }
    @GetMapping("/getAll")
    public List<User> getUser(){
        return userRepo.findAll();
    }
    @GetMapping("/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        return userRepo.findById(id);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        userRepo.deleteById(id);
    }
}