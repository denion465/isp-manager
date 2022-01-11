package com.ispmanager.backend.controller;

import javax.transaction.Transactional;

// import java.util.List;

import com.ispmanager.backend.dto.UserDto;
import com.ispmanager.backend.model.UserEntity;
import com.ispmanager.backend.model.response.UserRest;
// import com.ispmanager.backend.repository.UserRepository;
import com.ispmanager.backend.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @Transactional
  @PostMapping
  public ResponseEntity<UserRest> registerUser(@RequestBody UserEntity user) {
    UserDto userDto = new UserDto();

    BeanUtils.copyProperties(user, userDto);

    UserDto createUser = userService.createUser(userDto);
    UserRest returnValue = new UserRest();

    BeanUtils.copyProperties(createUser, returnValue);

    return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
  }
}
