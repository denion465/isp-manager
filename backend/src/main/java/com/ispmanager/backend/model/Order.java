package com.ispmanager.backend.model;

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

import com.ispmanager.backend.enums.InternetSpeed;
import com.ispmanager.backend.util.ConfigUrl;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(schema = ConfigUrl.SCHEMA_ISP_MANAGER, name = "order")
public class Order {
  @Id @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
  @SequenceGenerator(name = "order_id_seq", sequenceName = ConfigUrl.SCHEMA_ISP_MANAGER +
    ".order_id_seq", allocationSize = 1)
  @EqualsAndHashCode.Include
  private Integer id;

  @Embedded
  private Address address;

  @Column(name = "internet_speed", nullable = false)
  private InternetSpeed internetSpeed;

  @Column(name = "monthly_payment", nullable = false)
  private String monthlyPayment;

  @Column(name = "equip_lending", nullable = false)
  private Boolean equip_lending;

  private String observations;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
