package xyz.codingdaddy.repository;

import org.springframework.stereotype.Component;
import xyz.codingdaddy.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In-memory repository for user entities
 *
 * @author serhiy
 */
@Component
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("admin", "admin", "admin@example.com"));
        users.add(new User("user", "user", "user@example.com"));
    }

    public Optional<User> findUser(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }
}
