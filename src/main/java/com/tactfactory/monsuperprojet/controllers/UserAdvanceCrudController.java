package com.tactfactory.monsuperprojet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.monsuperprojet.database.repositories.UserRepository;
import com.tactfactory.monsuperprojet.entities.User;

@RestController
@RequestMapping("/customs/users")
public class UserAdvanceCrudController {

  @Autowired
  private UserRepository repository;

  @RequestMapping(value= {"/",""}, method= {RequestMethod.GET})
  public List<User> getAllUsersWithSubDatas(){
    return (List<User>) repository.findAll();
  }
}
