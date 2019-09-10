package com.tactfactory.monsuperprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages="com.tactfactory")
public class MonsuperprojetApplication {

  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(MonsuperprojetApplication.class, args);
  }

//  @Bean
//  @Qualifier(value="integerDatasInsertors")
//  public DatasInsertors getInsertors() {
//    return new DatasInsertors(5161);
//  }
//
//  @Bean
//  public RestTemplate restTemplate() {
//      return new RestTemplate();
//  }
}
