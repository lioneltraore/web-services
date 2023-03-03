package com.gexcode.webservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.gexcode.webservices.restfulwebservices.domain.User;

import org.springframework.stereotype.Component;

@Component()
public class UserDaoService {
    
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Bob", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Jhon", LocalDate.now().minusYears(20)));
        users.add(new User(3, "Ali", LocalDate.now().minusYears(26)));
    }

    public List<User> findAll() {
        return users;
    }
}
