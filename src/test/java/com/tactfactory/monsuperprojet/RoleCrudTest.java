package com.tactfactory.monsuperprojet;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.entities.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = MonsuperprojetApplication.class)
public class RoleCrudTest {

  @Autowired
  private RoleRepository repository;

  @Test
  public void getRoles() throws Exception {

    URL url = new URL("http://127.0.0.1:1234/roles");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.connect();
    int responsecode = conn.getResponseCode();
    StringBuilder builder = null;
    if (responsecode != 200)
      throw new RuntimeException("HttpResponseCode: " + responsecode);
    else {
      Scanner sc = new Scanner(url.openStream());
      builder = new StringBuilder();
      while (sc.hasNext()) {
        builder.append(sc.nextLine());
      }
      System.out.println("\nJSON data in string format");
      System.out.println(builder.toString());
      sc.close();
    }
  }

  @Autowired
  private RestTemplate restTemplate;

  private MockRestServiceServer mockServer;
  private ObjectMapper mapper = new ObjectMapper();

  @Before
  public void init() {
    mockServer = MockRestServiceServer.createServer(restTemplate);
  }

  @Test
  public void givenMockingIsDoneByMockRestServiceServer_whenGetIsCalled_thenReturnsMockedObject()
      throws JsonProcessingException, URISyntaxException {
    Role role = new Role("roleTest");
    repository.save(role);
    mockServer.expect(ExpectedCount.once(), requestTo(new URI("http://127.0.0.1:1234/roles/" + role.getId())))
        .andExpect(method(HttpMethod.GET)).andRespond(
            withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(role)));

    Optional<Role> checkRole = repository.findById(role.getId());
    mockServer.verify();
    Assert.assertEquals(checkRole, role);
  }

}
