package com.assignment.zorvyn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.zorvyn.entity.User;
import com.assignment.zorvyn.service.UserService;

import jakarta.validation.Valid;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    
    public User createUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        user.setId(id);
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PatchMapping("/{id}/status")
    public User updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return userService.updateStatus(id, active);
    }
    
    @PatchMapping("/{id}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUserRole(@PathVariable Long id,
                              @RequestParam String role) {

        return userService.updateRole(id, role);
    }
}