package com.ispmanager.backend.repository;

import com.ispmanager.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {}