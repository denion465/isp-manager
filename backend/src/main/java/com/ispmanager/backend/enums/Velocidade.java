package com.ispmanager.backend.enums;

import lombok.Getter;

@Getter
public enum Velocidade {
  CINQUENTAMEGAS("50MEGAS", "50 Megas"),
  CEMMEGAS("100MEGAS", "100 Megas"),
  DUZENTOSMEGAS("200MEGAS", "200 Megas"),
  TREZENTOSMEGAS("300MEGAS", "300 Megas"),
  QUATROCENTOSMEGAS("400MEGAS", "400 Megas"),
  QUINHENTOSMEGAS("500MEGAS", "500 Megas"),
  UMGIGA("1GIGA", "1 Giga");

  private final String codigo;
  private final String nome;

  Velocidade(String codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;
  }
}
