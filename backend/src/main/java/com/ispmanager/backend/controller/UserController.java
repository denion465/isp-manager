package com.ispmanager.backend.controller;

// import java.util.List;

import com.ispmanager.backend.dto.UserDto;
import com.ispmanager.backend.model.User;
// import com.ispmanager.backend.repository.UserRepository;
import com.ispmanager.backend.service.UserService;

// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  // private final UserRepository usuarioRepository;
  private final UserService userService;

  // @GetMapping
  // public List<User> listUsers() {
  //   return usuarioRepository.findAll();
  // }

  @PostMapping
  public UserDto registerUser(@RequestBody User user) {
    return userService.saveUser(user);
  }
}
