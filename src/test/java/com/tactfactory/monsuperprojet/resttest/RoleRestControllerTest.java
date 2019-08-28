package com.tactfactory.monsuperprojet.resttest;

import java.io.IOException;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tactfactory.monsuperprojet.MonsuperprojetApplication;
import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.entities.Role;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = MonsuperprojetApplication.class)
public class RoleRestControllerTest extends BaseRestControllerTest<Role, Integer> {

  @Autowired
  private RoleRepository repository;

  public RoleRestControllerTest() {
    super("/roles");
  }

  @Override
  protected JpaRepository<Role, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Role> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Role>>() {});
  }

  @Override
  protected boolean compareTo(Role item1, Role item2) {
    return item1.getId().equals(item2.getId()) && item1.getName().equals(item2.getName());
  }

  @Override
  protected Role parseJsonToObject(StringBuilder builder) throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Role>() {});
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }
}
