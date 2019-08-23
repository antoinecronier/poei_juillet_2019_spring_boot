package com.tactfactory.monsuperprojet.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tp1Controller {

  private Integer dateSaw = 0;

  @GetMapping("/getDate")
  public LocalDateTime getDate() {
    dateSaw++;
    return LocalDateTime.now();
  }

  @GetMapping("/getDateSaw")
  public Integer getDateSaw() {
    return this.dateSaw;
  }
}
