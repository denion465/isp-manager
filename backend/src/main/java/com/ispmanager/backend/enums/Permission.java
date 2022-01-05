package com.ispmanager.backend.enums;

import lombok.Getter;

@Getter
public enum Permission {
  ADMINISTRATOR("ADMINISTRATOR", "Administrador"),
  CUSTOMER("CUSTOMER", "Cliente"),
  TECH("TECH", "Técnico");

  private final String code;
  private final String name;

  Permission(String code, String name) {
    this.code = code;
    this.name = name;
  }
}
