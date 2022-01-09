package com.ispmanager.backend.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRest {
  private String publicId;
  private String name;
  private String email;
}
