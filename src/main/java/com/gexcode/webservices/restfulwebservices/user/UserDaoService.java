package com.gexcode.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Jhon", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Elie", LocalDate.now().minusYears(20)));
        users.add(new User(3, "Patrick", LocalDate.now().minusYears(18)));
        users.add(new User(4, "Silvie", LocalDate.now().minusYears(32)));
        users.add(new User(5, "Boris", LocalDate.now().minusYears(45)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(Integer id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().get();

    }
}
