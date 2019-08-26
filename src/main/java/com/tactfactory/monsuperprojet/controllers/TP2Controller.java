package com.tactfactory.monsuperprojet.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.javafaker.Faker;
import com.tactfactory.monsuperprojet.controllers.dtos.FakerRoleDto;
import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.entities.Role;

@Controller
@RequestMapping("/faker/role")
public class TP2Controller {

  @Autowired
  private RoleRepository repository;

  @GetMapping
  public String getRoleFaker() {
    return "/faker/role/index";
  }

  @PostMapping
  public String generateFake(FakerRoleDto fakerRole) {
    if (fakerRole.getFixedDatas() != null) {
      FakeRole(fakerRole, 0, fakerRole.getFixedDatas());
    } else if (fakerRole.getMinDatas() != null && fakerRole.getMaxDatas() != null
        && fakerRole.getMinDatas() < fakerRole.getMaxDatas()) {
      FakeRole(fakerRole, fakerRole.getMinDatas(), fakerRole.getMaxDatas());
    }
    return "/faker/role/index";
  }

  private void FakeRole(FakerRoleDto fakerRole, Integer min, Integer max) {
    for (int i = min; i < max; i++) {

      Faker faker = new Faker(Locale.FRENCH);
      Role role = new Role();
      if (fakerRole.getRole() != null && fakerRole.getRole().getName() != null) {
        role.setName(fakerRole.getRole().getName());
      }
      if ((fakerRole.getRole() == null || fakerRole.getRole().getName().equals(""))) {
        switch (fakerRole.getSelector()) {
        case 1:
          role.setName(faker.dog().breed());
          break;
        case 2:
          role.setName(faker.lorem().word());
          break;
        default:
          role.setName(faker.university().name());
          break;
        }
      }
      repository.save(role);
    }
  }
}
