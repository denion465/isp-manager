package com.telecom.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.telecom.backend.enums.Velocidade;
import com.telecom.backend.util.ConfigUrl;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(schema = ConfigUrl.SCHEMA_TELECOM_SYS, name = "pedido")
public class Pedido {
  @Id @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_id_seq")
  @SequenceGenerator(name = "pedido_id_seq", sequenceName = ConfigUrl.SCHEMA_TELECOM_SYS +
    ".pedido_id_seq", allocationSize = 1)
  @EqualsAndHashCode.Include
  private Integer id;

  @Column(name = "endereco", nullable = false)
  private Endereco endereco;

  @Column(name = "velocidade", nullable = false)
  private Velocidade velocidade;

  @Column(name = "equip_comodato", nullable = false)
  private Boolean equip_comodato;

  @Column(name = "observacoes")
  private String observacoes;
}
