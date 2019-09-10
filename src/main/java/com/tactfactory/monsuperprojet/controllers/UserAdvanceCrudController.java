package com.tactfactory.monsuperprojet.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.monsuperprojet.controllers.dtos.UserRichDto;
import com.tactfactory.monsuperprojet.database.repositories.EntrepriseRepository;
import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.database.repositories.UserRepository;
import com.tactfactory.monsuperprojet.entities.User;

@RestController
@RequestMapping("/customs/users")
public class UserAdvanceCrudController {

  @Autowired
  private UserRepository repository;

  @Autowired
  private RoleRepository repositoryRole;

  @Autowired
  private EntrepriseRepository repositoryEntreprise;

  @RequestMapping(value = { "/", "" }, method = { RequestMethod.GET })
  public List<User> getAllUsersWithSubDatas() {
    return (List<User>) repository.findAll();
  }

  @GetMapping("/userByFLName")
  public List<User> getAllUserByFirstnameLastname(@PathParam(value = "firstname") String firstname,
      @PathParam(value = "lastname") String lastname) {
    return (List<User>) repository.findAllByFirstnameAndLastname(firstname, lastname);
  }

  @PostMapping("/create")
  public void createUser(User user) {
    if (user.getRole() != null) {
      repositoryRole.save(user.getRole());
    }
    if (user.getEntreprise() != null) {
      repositoryEntreprise.save(user.getEntreprise());
    }

    repository.save(user);
  }

  @PostMapping("/createRich")
  public void createUser(UserRichDto userRich) {
    for (int i = 0; i < userRich.getNumberItem(); i++) {
      System.out.println(userRich.getCreatedFor());
      System.out.println(userRich.getUser());
    }
  }
}
