package com.tactfactory.monsuperprojet.entities;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class Form1 {

  @Range(min = 0, max = 100)
  @NotNull
  private Integer offset;
  @Range(min = 10, max = 50)
  @NotNull
  private Integer tribe;
  @Email
  @NotNull
  private String email;
  @Range(min = -10, max = 10)
  @NotNull
  private Integer nombreItem;
  private String description;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  @NotNull
  private LocalDateTime appliqueA;

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getTribe() {
    return tribe;
  }

  public void setTribe(Integer tribe) {
    this.tribe = tribe;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getNombreItem() {
    return nombreItem;
  }

  public void setNombreItem(Integer nombreItem) {
    this.nombreItem = nombreItem;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getAppliqueA() {
    return appliqueA;
  }

  public void setAppliqueA(LocalDateTime appliqueA) {
    this.appliqueA = appliqueA;
  }

  @Override
  public String toString() {
    return "Form1 [offset=" + offset + ", tribe=" + tribe + ", email=" + email + ", nombreItem=" + nombreItem
        + ", description=" + description + ", appliqueA=" + appliqueA + "]";
  }

}
