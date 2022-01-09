package com.ispmanager.backend.service;

import com.ispmanager.backend.dto.UserDto;
import com.ispmanager.backend.model.User;
import com.ispmanager.backend.repository.UserRepository;
import com.ispmanager.backend.util.Utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final Utils utils;

  public UserDto saveUser(User user) {
    User storedUserDetails = userRepository.findByEmail(user.getEmail());

    if (storedUserDetails != null)
      throw new RuntimeException("Usuário já cadastrado");

    User userModel = new User();
    BeanUtils.copyProperties(user, userModel);

    String publicUserId = utils.generatePublicId(30);
    userModel.setPublicId(publicUserId);

    User storedUserDetail = userRepository.save(userModel);

    UserDto returnValue = new UserDto();
    BeanUtils.copyProperties(storedUserDetail, returnValue);

    return returnValue;
  }
}
