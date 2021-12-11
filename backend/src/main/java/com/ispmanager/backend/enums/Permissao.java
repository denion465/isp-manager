package com.ispmanager.backend.enums;

import lombok.Getter;

@Getter
public enum Permissao {
  ADMINISTRADOR("ADMINISTRADOR", "Administrador"),
  CLIENTE("CLIENTE", "Cliente"),
  TECNICO("TECNICO", "Técnico");

  private final String codigo;
  private final String nome;

  Permissao(String codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;
  }
}
