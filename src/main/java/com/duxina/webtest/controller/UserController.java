package com.duxina.webtest.controller;

import com.duxina.webtest.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    static List<User> users = new ArrayList<>();
    Integer userCount = 3;

    static {
        users.add(new User(1, "Widy", 17, "Jakarta"));
        users.add(new User(2, "Jack", 20, "Bekasi"));
        users.add(new User(3, "Entong", 17, "Depok"));
    }

    @GetMapping(path = "/getAll")
    public List<User> getAll() {
        return users;
    }

    @GetMapping(path = "/get/{id}")
    public User getById(@PathVariable(name = "id") Integer id) throws Exception {
        Optional<User> user = users.stream().filter(x -> x.getId().equals(id)).findFirst();
        if (!user.isPresent()) {
            throw new Exception();
        }
        return user.get();
    }

    @PostMapping(path = "/save")
    public User saveUser(@RequestBody User user) throws Exception {
        if (user == null) {
            throw new Exception();
        }
        if (user.getName() == null) {
            throw new Exception();
        }
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public User deleteById(@PathVariable(name = "id") Integer id) throws Exception {
        Optional<User> user = users.stream().filter(x -> x.getId().equals(id)).findFirst();
        if (!user.isPresent()) {
            throw new Exception();
        }
        users.remove(user.get());
        return user.get();
    }
}
