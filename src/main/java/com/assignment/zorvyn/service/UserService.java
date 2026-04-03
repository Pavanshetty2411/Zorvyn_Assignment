package com.assignment.zorvyn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.zorvyn.entity.Role;
import com.assignment.zorvyn.entity.User;
import com.assignment.zorvyn.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAll() {
	    return userRepository.findAll();
	}

	public Optional<User> getById(Long id) {
	    return userRepository.findById(id);
	}

	public void delete(Long id) {
	    userRepository.deleteById(id);
	}

	public User updateStatus(Long id, boolean active) {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    user.setActive(active);
	    return userRepository.save(user);
	}
	
	public User updateRole(Long id, String role) {

	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    try {
	        user.setRole(Role.valueOf(role.toUpperCase()));
	    } catch (IllegalArgumentException e) {
	        throw new RuntimeException("Invalid role value");
	    }

	    return userRepository.save(user);
	}
	
	
	

}
