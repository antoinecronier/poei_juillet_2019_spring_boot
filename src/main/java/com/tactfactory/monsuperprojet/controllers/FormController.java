package com.tactfactory.monsuperprojet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

  @GetMapping("/index")
  public String getIndex() {
    return "/index";
  }
}
