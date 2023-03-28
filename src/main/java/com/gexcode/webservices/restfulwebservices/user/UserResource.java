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
import java.util.Optional;

@RestController
public class UserResource {

    private UserDaoService service;

    private MessageSource messageSource;

    private UserRepository userRepository;

    public UserResource(UserDaoService service, MessageSource messageSource, UserRepository userRepository) {

        this.service = service;
        this.messageSource = messageSource;
        this.userRepository = userRepository;
    }

    // Get all users
    @GetMapping("/users")
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    // find one user by id
    @GetMapping("/users/{id}")
    public User findAll(@PathVariable Integer id) {
        Optional<User> user = this.userRepository.findById(id);

        if(user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        return user.get();
    }

    // Create a new user
    @PostMapping("/users")
    public ResponseEntity<User> save(@Valid @RequestBody User user) throws URISyntaxException {
        User newUser = this.userRepository.save(user);
        URI location = new URI("/users/" + newUser.getId());
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id) {
        this.userRepository.deleteById(id);
    }

    @GetMapping("/hello")
    public String getHello() {
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println(locale.getLanguage());
        return messageSource
                .getMessage("good.morning.message", null, "Default message", locale);
    }
}
