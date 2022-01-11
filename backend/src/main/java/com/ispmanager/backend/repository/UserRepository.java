package com.ispmanager.backend.repository;

import com.ispmanager.backend.model.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
  UserEntity findByEmail(String email);
}
