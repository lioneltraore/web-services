package com.gexcode.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Jhon", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Elie", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "Patrick", LocalDate.now().minusYears(18)));
        users.add(new User(++userCount, "Silvie", LocalDate.now().minusYears(32)));
        users.add(new User(++userCount, "Boris", LocalDate.now().minusYears(45)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(Integer id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);

    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
