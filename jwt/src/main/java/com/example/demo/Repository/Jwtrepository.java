package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.User;

public interface Jwtrepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
