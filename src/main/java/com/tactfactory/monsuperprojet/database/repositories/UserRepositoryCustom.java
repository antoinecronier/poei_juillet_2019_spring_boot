package com.tactfactory.monsuperprojet.database.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.tactfactory.monsuperprojet.entities.User;

@NoRepositoryBean
public interface UserRepositoryCustom {
  List<User> getUserIfOlderThan18AtDate(LocalDateTime timeToCheck);
}
