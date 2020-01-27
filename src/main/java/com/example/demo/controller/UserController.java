package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.models.User;

@RestController
public class UserController {
    static List<User> users = new ArrayList<User>();

    // POST - Creating
    @PostMapping("/users")
    public List<User> createUser(@RequestBody User user) {
        users.add(user);
        return users;
    }

    // GET ALL
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return users;
    }

    // GET
    @GetMapping("/users/{id}")
    public User findUser(@PathVariable("id") long id) {
        for (User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // EDIT
    @PutMapping("/users/{id}")
    public List<User> editUser(@PathVariable("id") long id, @RequestBody User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, user);
            }
        }
        return users;
    }

    // DELETE - Deleting
    @DeleteMapping("users/{id}")
    public List<User> deleteUser(@PathVariable("id") long id) {
        int idx = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                idx = i;
                break;
            }
        }
        if (idx >= 0) {
            users.remove(idx);
        }
        return users;
    }
}