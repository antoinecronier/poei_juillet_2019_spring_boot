package com.tactfactory.monsuperprojet.controllers.restcontrollers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.monsuperprojet.controllers.restcontrollers.base.BaseRestController;
import com.tactfactory.monsuperprojet.database.repositories.EntrepriseRepository;
import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.database.repositories.UserRepository;
import com.tactfactory.monsuperprojet.entities.User;

@RestController
@RequestMapping("/api/users")
public class UserRestController extends BaseRestController<User, Integer> {

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private EntrepriseRepository entrepriseRepository;

  public UserRestController(@Autowired UserRepository repository) {
    super(repository);
  }

  @GetMapping("/userByFLName")
  public List<User> getAllUserByFirstnameLastname(@PathParam(value = "firstname") String firstname,
      @PathParam(value = "lastname") String lastname) {
    return (List<User>) ((UserRepository) repository).findAllByFirstnameAndLastname(firstname, lastname);
  }

  @Override
  public User save(User item) {
    if (item.getRole() != null && item.getRole().getId() == null) {
      roleRepository.save(item.getRole());
    }
    if (item.getEntreprise() != null && item.getEntreprise().getId() == null) {
      entrepriseRepository.save(item.getEntreprise());
    }
    return super.save(item);
  }

}
