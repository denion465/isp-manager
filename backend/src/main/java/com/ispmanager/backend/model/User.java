package com.ispmanager.backend.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ispmanager.backend.enums.Permission;
import com.ispmanager.backend.util.ConfigUrl;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(schema = ConfigUrl.SCHEMA_ISP_MANAGER, name = "user")
public class User {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
  @SequenceGenerator(name = "user_id_seq", sequenceName = ConfigUrl.SCHEMA_ISP_MANAGER +
    ".user_id_seq", allocationSize = 1)
  @EqualsAndHashCode.Include
  private int id;

  @Column(name = "public_id",nullable = false)
  private String publicId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String cpf;

  @Column(nullable = false)
  private String rg;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(name = "encrypted_password",nullable = false)
  private String encryptedPassword;

  @CreationTimestamp
  @Column(name = "registration_date", nullable = false, columnDefinition = "timestamp")
  private LocalDateTime registrationDate;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Permission permission;
}
