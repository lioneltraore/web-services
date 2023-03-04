package com.gexcode.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // Get all users
    @GetMapping("/users")
    public List<User> findAll() {
        return this.service.findAll();
    }

    // find one user by id
    @GetMapping("/users/{id}")
    public User findAll(@PathVariable Integer id) {
        return this.service.findOne(id);
    }
}
