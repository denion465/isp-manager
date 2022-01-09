package com.ispmanager.backend.service;

import com.ispmanager.backend.dto.UserDto;

import org.springframework.security.core.userdetails.UserDetailsService;
public interface UserService extends UserDetailsService {
  UserDto createUser(UserDto user);

}
