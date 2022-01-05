package com.ispmanager.backend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
  @Column(name = "street_address")
  private String streetAddress;

  @Column(name = "street_number")
  private String streetNumber;

  private String complement;

  private String district;

  @Column(name = "zip_code")
  private String zipCode;
}
