package com.assignment.zorvyn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.zorvyn.entity.User;
import com.assignment.zorvyn.repository.UserRepository;
import com.assignment.zorvyn.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return jwtUtil.generateToken(
                    email,
                    user.get().getRole().name()
            );
        }

        throw new RuntimeException("Invalid credentials");
    }
    
}
