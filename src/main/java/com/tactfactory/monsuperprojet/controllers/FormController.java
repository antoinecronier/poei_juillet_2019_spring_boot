package com.tactfactory.monsuperprojet.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

  @GetMapping("/index")
  public String getIndex() {
    return "/index";
  }

  @GetMapping("/index2")
  public String getIndex2(){
    return "/index2";
  }
}
