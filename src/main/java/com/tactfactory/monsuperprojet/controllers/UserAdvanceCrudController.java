package com.tactfactory.monsuperprojet.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @RequestMapping(value = { "/", "" }, method = { RequestMethod.GET })
  public List<User> getAllUsersWithSubDatas() {
    return (List<User>) repository.findAll();
  }

  @GetMapping("/userByFLName")
  public List<User> getAllUserByFirstnameLastname(@PathParam(value = "firstname") String firstname,
      @PathParam(value = "lastname") String lastname) {
    return (List<User>) repository.findAllByFirstnameAndLastname(firstname, lastname);
  }
}
