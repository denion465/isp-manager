package com.ispmanager.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
  private int id;
  private String publicId;
  private String name;
  private String cpf;
  private String email;
  private String password;
  private String encryptedPassword;
}
