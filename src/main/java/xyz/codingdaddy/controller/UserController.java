package xyz.codingdaddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.codingdaddy.domain.User;
import xyz.codingdaddy.repository.UserRepository;

/**
 * REST API Controller related to user entity requests
 *
 * @author serhiy
 */
@RestController
@RequestMapping(value = "/api")
@ResponseBody
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/user")
    public ResponseEntity<User> get(@RequestParam("username") String username) {
        return userRepository.findUser(username)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
