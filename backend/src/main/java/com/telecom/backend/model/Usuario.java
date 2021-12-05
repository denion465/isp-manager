package com.telecom.backend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telecom.backend.enums.Permissao;
import com.telecom.backend.util.ConfigUrl;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(schema = ConfigUrl.SCHEMA_TELECOM_SYS, name = "usuario")
public class Usuario {
  @Id @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
  @SequenceGenerator(name = "usuario_id_seq", sequenceName = ConfigUrl.SCHEMA_TELECOM_SYS +
    ".usuario_id_seq", allocationSize = 1)
  @EqualsAndHashCode.Include
  private Integer id;

  @Column(name = "nome", nullable = false)
  private String nome;

  @Column(name = "cpf", nullable = false)
  private String cpf;

  @Column(name = "rg", nullable = false)
  private String rg;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "senha", nullable = false)
  private String senha;

  @CreationTimestamp
  @Column(nullable = false, columnDefinition = "timestamp")
  private LocalDateTime data_cadastro;

  @Column(name = "permissao", nullable = false)
  @Enumerated(EnumType.STRING)
  private Permissao permissao;

  @JsonIgnore
  @OneToMany(mappedBy = "usuario")
  private List<Pedido> pedidos = new ArrayList<>();
}
