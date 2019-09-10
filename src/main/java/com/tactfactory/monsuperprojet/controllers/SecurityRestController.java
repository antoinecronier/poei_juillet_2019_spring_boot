package com.tactfactory.monsuperprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.monsuperprojet.services.security.SecurityServiceImpl;

@RestController
@RequestMapping("/security")
public class SecurityRestController {

  @Autowired
  private SecurityServiceImpl secuService;

  @GetMapping("/user")
  public String showUser() {
    return secuService.findLoggedInUsername();
  }

  @GetMapping("/usersecu")
  public String showUserSecurity() {
    return SecurityContextHolder.getContext().getAuthentication().getName() + " " + SecurityContextHolder.getContext().getAuthentication().getPrincipal() + " //////\n"+
        ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPassword();
  }
}
