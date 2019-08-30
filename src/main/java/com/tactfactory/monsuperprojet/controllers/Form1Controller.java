package com.tactfactory.monsuperprojet.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tactfactory.monsuperprojet.entities.Form1;

@Controller
@RequestMapping("/forms/form1")
public class Form1Controller {

  @GetMapping
  public String getForm() {
    return "/form1";
  }

  @PostMapping
  public String postForm(@Valid Form1 form1) {
    System.out.println(form1);

    return "redirect:/forms/form1";
  }
}
