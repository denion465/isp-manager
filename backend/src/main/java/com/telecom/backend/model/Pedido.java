package com.telecom.backend.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

  @Embedded
  private Endereco endereco;

  @Column(name = "velocidade", nullable = false)
  private Velocidade velocidade;

  @Column(name = "mensalidade", nullable = false)
  private String mensalidade;

  @Column(name = "equip_comodato", nullable = false)
  private Boolean equipComodato;

  @Column(name = "observacoes")
  private String observacoes;

  @ManyToOne
  @JoinColumn(name = "usuario_id", nullable = false)
  private Usuario usuario;
}
