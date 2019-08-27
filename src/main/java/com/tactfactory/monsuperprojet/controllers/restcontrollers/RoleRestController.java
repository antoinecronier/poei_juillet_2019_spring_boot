package com.tactfactory.monsuperprojet.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.monsuperprojet.controllers.restcontrollers.base.BaseRestController;
import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.entities.Role;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController extends BaseRestController<Role, Integer> {

  public RoleRestController(@Autowired RoleRepository repository) {
    super(repository);
  }
}
