package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	boolean existsByEmail(String email);
}
