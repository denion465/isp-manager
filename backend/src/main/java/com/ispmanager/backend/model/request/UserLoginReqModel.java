package com.ispmanager.backend.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginReqModel {
  private String email;
  private String password;
}
