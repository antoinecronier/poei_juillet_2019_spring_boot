package com.tactfactory.monsuperprojet.controllers.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.tactfactory.monsuperprojet.entities.User;

public class UserRichDto {

  private User user;
  @DateTimeFormat(pattern = "yyyy-MM-dd",iso=ISO.DATE)
  private Date createdFor;
  private Integer numberItem;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getCreatedFor() {
    return createdFor;
  }

  public void setCreatedFor(Date createdFor) {
    this.createdFor = createdFor;
  }

  public Integer getNumberItem() {
    return numberItem;
  }

  public void setNumberItem(Integer numberItem) {
    this.numberItem = numberItem;
  }

}
