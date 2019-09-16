package com.tactfactory.monsuperprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tactfactory.monsuperprojet.validators.PasswordValidator;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages="com.tactfactory")
public class MonsuperprojetApplication extends SpringBootServletInitializer{

  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(MonsuperprojetApplication.class, args);
  }

  @Bean
  public PasswordValidator beforeCreateUserValidator() {
    return new PasswordValidator();
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
