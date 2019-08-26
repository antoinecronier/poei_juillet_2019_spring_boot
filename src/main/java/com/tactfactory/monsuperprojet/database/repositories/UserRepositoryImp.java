package com.tactfactory.monsuperprojet.database.repositories;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tactfactory.monsuperprojet.database.contracts.UserContract;
import com.tactfactory.monsuperprojet.entities.User;

@Service
@Repository
@Transactional(readOnly = true)
public class UserRepositoryImp implements UserRepositoryCustom {

  @Autowired
  private EntityManager entityManager;

  public List<User> getUserIfOlderThan18AtDate(LocalDateTime timeToCheck) {

    return entityManager.createQuery(
        "SELECT u FROM " + UserContract.TABLE + " u WHERE u." + UserContract.COL_DATE_OF_BIRTH + " < ?1")
        .setParameter(1,timeToCheck.minusYears(18)).getResultList();
  }


}
