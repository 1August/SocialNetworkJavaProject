package com.example.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.socialnetwork.entities.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User, Integer> {
    User getUserById(Integer id);
    User getUserByEmail(String email);
}