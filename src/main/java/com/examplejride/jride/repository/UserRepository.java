package com.examplejride.jride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplejride.jride.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
