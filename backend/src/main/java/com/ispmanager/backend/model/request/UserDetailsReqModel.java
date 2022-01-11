package com.ispmanager.backend.model.request;

import com.ispmanager.backend.enums.Permission;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsReqModel {
  private String name;
  private String cpf;
  private String rg;
  private String email;
  private String password;
  private Permission permission;
}
