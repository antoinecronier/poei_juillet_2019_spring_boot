package com.tactfactory.monsuperprojet.resttest;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tactfactory.monsuperprojet.utils.HttpUtils;

public abstract class BaseRestControllerTest<T, ID> {

  public static final String BASE_API = "/api";
  private String entityPath;
  private HttpUtils httpUtils = new HttpUtils();

  public BaseRestControllerTest(String entityPath) {
    this.entityPath = entityPath;
  }

  protected abstract JpaRepository<T, ID> getRepository();

  @Test
  public void getAll() throws IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }

    List<T> dbItems = getRepository().findAll();

    List<T> httpItems = parseJsonToList(builder);

    if (dbItems.size() != httpItems.size()) {
      fail("List sized are not same");
    }

    for (int i = 0; i < httpItems.size(); i++) {
      if (!compareTo(dbItems.get(i), httpItems.get(i))) {
        fail();
      }
    }
  }

  protected abstract List<T> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException;

  protected abstract boolean compareTo(T item1, T item2);

  @Test
  public void getById() throws JsonParseException, JsonMappingException, IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath + "/" + getItemIdToTest());
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }

    Optional<T> dbItem = getRepository().findById(getItemIdToTest());

    T httpItem = parseJsonToObject(builder);

    if (dbItem.get() == null || httpItem == null) {
      fail("One of objects is null");
    }

    if (!compareTo(dbItem.get(), httpItem)) {
      fail();
    }
  }

  protected abstract T parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException;

  protected abstract ID getItemIdToTest();

  @Test
  public void deleteById() {
  }

  @Test
  public void deleteAll() {
  }

  @Test
  public void save() {
  }

  @Test
  public void count() {
  }

}
