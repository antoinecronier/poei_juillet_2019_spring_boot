package com.tactfactory.monsuperprojet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.tactfactory.monsuperprojet.utils.DatasInsertors;

@SpringBootApplication
public class MonsuperprojetApplication {

  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(MonsuperprojetApplication.class, args);
  }

  @Bean
  @Qualifier(value="integerDatasInsertors")
  public DatasInsertors getInsertors() {
    return new DatasInsertors(5161);
  }

  @Bean
  public RestTemplate restTemplate() {
      return new RestTemplate();
  }
}
