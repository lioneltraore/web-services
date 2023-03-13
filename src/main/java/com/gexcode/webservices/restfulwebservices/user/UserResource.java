package com.gexcode.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

@RestController
public class UserResource {

    private UserDaoService service;

    private MessageSource messageSource;

    public UserResource(UserDaoService service, MessageSource messageSource) {

        this.service = service;
        this.messageSource = messageSource;
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

    @GetMapping("/hello")
    public String getHello() {
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println(locale.getLanguage());
        return messageSource
                .getMessage("good.morning.message", null, "Default message", locale);
    }
}
