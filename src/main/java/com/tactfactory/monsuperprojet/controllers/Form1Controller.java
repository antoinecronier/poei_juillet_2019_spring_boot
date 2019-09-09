package com.tactfactory.monsuperprojet.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tactfactory.monsuperprojet.entities.Form1;

@Controller
@RequestMapping("/forms/form1")
public class Form1Controller {

  @GetMapping
  public String getForm() {
    return "/form1";
  }

  @PostMapping
  public String postForm(@Valid Form1 form1) throws Exception {
    System.out.println(form1);

    if (form1.getEmail() == null || form1.getEmail().trim().isEmpty()) {
      throw new Exception("email not correctly set");
    }

    return "redirect:/forms/form1";
  }
}
