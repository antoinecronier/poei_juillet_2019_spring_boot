package com.tactfactory.monsuperprojet;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monsuperprojet.database.repositories.EntrepriseRepository;
import com.tactfactory.monsuperprojet.entities.Entreprise;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EntrepriseRepositoryTest {

  @Autowired
  private EntrepriseRepository repository;

  @Before
  public void beforeTests() {
    repository.deleteAll();
  }

  @Test
  public void isInserted() {
    Entreprise entreprise = new Entreprise("entrepriseTest","super address","type1");
    repository.save(entreprise);
    Entreprise entrepriseTest = repository.findAll().iterator().next();
    assertTrue(entreprise.getNom().equals(entrepriseTest.getNom())&&entreprise.getAdresse().equals(entrepriseTest.getAdresse())&&entreprise.getType().equals(entrepriseTest.getType()));
  }
}
