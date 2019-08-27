package com.tactfactory.monsuperprojet.controllers.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.monsuperprojet.controllers.restcontrollers.base.BaseRestController;
import com.tactfactory.monsuperprojet.database.repositories.EntrepriseRepository;
import com.tactfactory.monsuperprojet.entities.Entreprise;

@RestController
@RequestMapping("/api/entreprises")
public class EntrepriseRestController extends BaseRestController<Entreprise, Integer> {

  public EntrepriseRestController(@Autowired EntrepriseRepository repository) {
    super(repository);
  }
}
