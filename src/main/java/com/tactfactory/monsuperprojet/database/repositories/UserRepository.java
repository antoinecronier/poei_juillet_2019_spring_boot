package com.tactfactory.monsuperprojet.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tactfactory.monsuperprojet.database.contracts.UserContract;
import com.tactfactory.monsuperprojet.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT u FROM " + UserContract.TABLE + " u WHERE u." + UserContract.COL_FIRSTNAME + " = ?1 and u."
      + UserContract.COL_LASTNAME + " = ?2")
  List<User> getUserWithFirstnameLastname(String firstname, String lastname);

  List<User> findAllByFirstnameAndLastname(String firstname, String lastname);
}
