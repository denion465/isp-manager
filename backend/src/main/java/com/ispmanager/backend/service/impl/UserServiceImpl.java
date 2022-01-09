package com.ispmanager.backend.service.impl;

import com.ispmanager.backend.dto.UserDto;
import com.ispmanager.backend.model.User;
import com.ispmanager.backend.repository.UserRepository;
import com.ispmanager.backend.service.UserService;
import com.ispmanager.backend.util.Utils;

import org.springframework.beans.BeanUtils;
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
    User storedUserDetails = userRepository.findByEmail(userDto.getEmail());

    if (storedUserDetails != null)
      throw new RuntimeException("Usuário já cadastrado");

    User userModel = new User();
    BeanUtils.copyProperties(userDto, userModel);

    String publicUserId = utils.generatePublicId(30);
    userModel.setPublicId(publicUserId);
    userModel.setEncryptedPassword(bcryptPasswordEncoder.encode(userDto.getPassword()));

    User storedUserDetail = userRepository.save(userModel);

    UserDto returnValue = new UserDto();
    BeanUtils.copyProperties(storedUserDetail, returnValue);

    return returnValue;
  }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

}
