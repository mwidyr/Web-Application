package com.duxina.webtest.controller;

import com.duxina.webtest.model.User;
import com.duxina.webtest.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserDaoService service;

    @GetMapping(path = "/getAll")
    public List<User> retrieveAll() {
        List<User> users =  service.findAll();
    return users;
    }

    @GetMapping(path = "/get/{id}")
    public User getById(@PathVariable(name = "id") Integer id) throws Exception {
    return service.findOne(id);
    }

    @PostMapping(path = "/save")
    public User saveUser(@RequestBody User user) {
        User save = service.saveUser(user);
        return user;
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public User deleteById(@PathVariable(name = "id") Integer id) throws Exception {
        User user = service.deleteUser(id);
        if(user == null){
            throw new Exception();
        }
        return user;
    }
}
