package com.tactfactory.monsuperprojet.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionTestController {

  @GetMapping("/addAttribute1")
  public String addAttribute1(HttpSession session) {

    session.setAttribute("testAtt1", 20);

    return "added";
  }

  @GetMapping("/addAttribute2")
  public String addAttribute2(HttpSession session) {

    session.setAttribute("testAtt2", 5);

    return "added";
  }

  @GetMapping("/calc")
  public String doCalc(HttpSession session) {
    return String.valueOf((Integer)session.getAttribute("testAtt1") * (Integer)session.getAttribute("testAtt2"));
  }
}
