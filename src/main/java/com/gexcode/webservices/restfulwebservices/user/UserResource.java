package com.gexcode.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
        User user = this.service.findOne(id);

        if(user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        return user;
    }

    // Create a new user
    @PostMapping("/users")
    public ResponseEntity<User> save(@Valid @RequestBody User user) throws URISyntaxException {
        User newUser = this.service.save(user);
        URI location = new URI("/users/" + user.getId());
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id) {
        this.service.delete(id);
    }
}
