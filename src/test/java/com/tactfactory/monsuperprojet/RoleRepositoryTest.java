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

import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.entities.Role;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RoleRepositoryTest {

  @Autowired
  private RoleRepository repository;

  @Before
  public void beforeTests() {
    repository.deleteAll();
  }

  @Test
  public void isInserted() {
    Role role = new Role("roleTest");
    repository.save(role);
    Role roleTest = repository.findAll().iterator().next();
    assertTrue(role.getName().equals(roleTest.getName()));
  }
}
