package com.techolution.userauthservice.controllers;

import com.techolution.userauthservice.models.User;
import com.techolution.userauthservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{username}")
    public User getUserByUserName(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

}
