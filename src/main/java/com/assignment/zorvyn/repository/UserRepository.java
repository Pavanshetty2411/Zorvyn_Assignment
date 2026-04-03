package com.assignment.zorvyn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.zorvyn.entity.User;

import jakarta.persistence.Id;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

	Optional<User> getById(Id id);
    
}