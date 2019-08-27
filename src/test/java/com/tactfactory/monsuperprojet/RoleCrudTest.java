package com.tactfactory.monsuperprojet;

import static org.junit.Assert.fail;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.entities.Role;
import com.tactfactory.monsuperprojet.utils.HttpUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = MonsuperprojetApplication.class)
public class RoleCrudTest {

  @Autowired
  private RoleRepository repository;

  @Test
  public void getRoles() throws IOException {

    try {
      // Create base URL to go
      URL url = new URL("http://127.0.0.1:1234/roles");

      // Allow to access HTTP via defined URL
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      // Set HTTP verbb to use
      conn.setRequestMethod("GET");

      // Real request connection with all configs
      conn.connect();

      // Retrieve current status for request
      int responsecode = conn.getResponseCode();

      // Actions before request ended from server side
      StringBuilder builder = null;
      if (!(responsecode >= 200 && responsecode < 300))
        throw new RuntimeException("HttpResponseCode: " + responsecode);
      else {
        // If all is ok parse server datas
        Scanner sc = new Scanner(url.openStream());
        builder = new StringBuilder();

        // Loop over scanner datas to parse them
        while (sc.hasNext()) {
          builder.append(sc.nextLine());
        }

        System.out.println("\nJSON data in string format");
        System.out.println(builder.toString());

        // Close scanner
        sc.close();
      }

      // Close url connection
      conn.disconnect();
    } catch (MalformedURLException e) {
      e.printStackTrace();
      throw e;
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Test
  public void getRolesJson() throws IOException {

    StringBuilder builder = null;

    HttpUtils util = new HttpUtils();
    builder = util.callServer(builder,"/api/roles");

    List<Role> dbRoles = repository.findAll();

    ObjectMapper mapper = new ObjectMapper();
    List<Role> httpRoles = mapper.readValue(builder.toString(), new TypeReference<List<Role>>(){});

    if (dbRoles.size() == httpRoles.size()) {

    }

    for (int i = 0; i < httpRoles.size(); i++) {
      if (!(dbRoles.get(i).getId().equals(httpRoles.get(i).getId()))) {
        fail();
      }
    }
  }

  private StringBuilder callServer(StringBuilder builder, String subUrl) throws MalformedURLException, IOException {
    try {
      // Create base URL to go
      URL url = new URL("http://127.0.0.1:1234"+subUrl);

      // Allow to access HTTP via defined URL
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      // Set HTTP verbb to use
      conn.setRequestMethod("GET");

      // Real request connection with all configs
      conn.connect();

      // Retrieve current status for request
      int responsecode = conn.getResponseCode();

      // Actions before request ended from server side
      if (!(responsecode >= 200 && responsecode < 300))
        throw new RuntimeException("HttpResponseCode: " + responsecode);
      else {
        // If all is ok parse server datas
        Scanner sc = new Scanner(url.openStream());
        builder = new StringBuilder();

        // Loop over scanner datas to parse them
        while (sc.hasNext()) {
          builder.append(sc.nextLine());
        }

        System.out.println("\nJSON data in string format");
        System.out.println(builder.toString());

        // Close scanner
        sc.close();
      }

      // Close url connection
      conn.disconnect();
    } catch (MalformedURLException e) {
      e.printStackTrace();
      throw e;
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
    return builder;
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
