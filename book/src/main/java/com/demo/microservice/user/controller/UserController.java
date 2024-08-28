package com.demo.microservice.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        User user = new User(userRequest.getId(), userRequest.getName());
        users.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    private static class User {
        private Long id;
        private String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    private static class UserRequest {
        private Long id;
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}