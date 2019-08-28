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
import com.tactfactory.monsuperprojet.database.repositories.EntrepriseRepository;
import com.tactfactory.monsuperprojet.entities.Entreprise;
import com.tactfactory.monsuperprojet.entities.Role;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = MonsuperprojetApplication.class)
public class EntrepriseRestControllerTest extends BaseRestControllerTest<Entreprise, Integer> {

  @Autowired
  private EntrepriseRepository repository;

  public EntrepriseRestControllerTest() {
    super("/entreprises");
  }

  @Override
  protected JpaRepository<Entreprise, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Entreprise> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Entreprise>>() {
    });
  }

  @Override
  protected boolean compareTo(Entreprise item1, Entreprise item2) {
    return item1.getId().equals(item2.getId()) && item1.getNom().equals(item2.getNom())
        && item1.getAdresse().equals(item2.getAdresse()) && item1.getType().equals(item2.getType());
  }

  @Override
  protected Entreprise parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Entreprise>() {
    });
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

}
