package com.tactfactory.monsuperprojet.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.tactfactory.monsuperprojet.database.repositories.DataRepository;
import com.tactfactory.monsuperprojet.entities.Data;

@Service(value="baseDatasInsertors")
public class DatasInsertors {

  @Autowired
  private DataRepository entrepriseRepository;

  @PostConstruct
  public void InsertData() {
    Faker faker = new Faker(Locale.FRENCH);
    Integer loop = faker.random().nextInt(10, 100);
    List<Data> datas = new ArrayList<Data>();
    for (int i = 0; i < loop; i++) {
      datas.add(new Data(faker.lorem().word(),faker.lorem().sentence(),LocalDateTime.now()));

      List<Data> toInsert = new ArrayList<>();
      for (int j = 0; j < faker.random().nextInt(datas.size()); j++) {
        toInsert.add(datas.get(faker.random().nextInt(datas.size()-1)));
      }

      datas.get(i).setDatas(toInsert);
      entrepriseRepository.save(datas.get(i));
    }

  }
}
