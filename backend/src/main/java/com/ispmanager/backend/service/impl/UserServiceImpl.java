package com.ispmanager.backend.service.impl;

import java.util.ArrayList;

import com.ispmanager.backend.dto.UserDto;
import com.ispmanager.backend.model.UserEntity;
import com.ispmanager.backend.repository.UserRepository;
import com.ispmanager.backend.service.UserService;
import com.ispmanager.backend.util.Utils;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final Utils utils;
  private final BCryptPasswordEncoder bcryptPasswordEncoder;

  @Override
  public UserDto createUser(UserDto userDto) {
    UserEntity storedUserDetails = userRepository.findByEmail(userDto.getEmail());

    if (storedUserDetails != null)
      throw new RuntimeException("Usuário já cadastrado");

    UserEntity userModel = new UserEntity();
    BeanUtils.copyProperties(userDto, userModel);

    String publicUserId = utils.generatePublicId(30);
    userModel.setPublicId(publicUserId);
    userModel.setEncryptedPassword(bcryptPasswordEncoder.encode(userDto.getPassword()));

    UserEntity storedUserDetail = userRepository.save(userModel);

    UserDto returnValue = new UserDto();
    BeanUtils.copyProperties(storedUserDetail, returnValue);

    return returnValue;
  }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserEntity userEntity = userRepository.findByEmail(email);

    if (userEntity == null) throw new UsernameNotFoundException(email);

    return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}
}
