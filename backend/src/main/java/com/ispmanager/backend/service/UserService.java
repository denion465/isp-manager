package com.ispmanager.backend.service;

import com.ispmanager.backend.model.User;
import com.ispmanager.backend.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }
}
