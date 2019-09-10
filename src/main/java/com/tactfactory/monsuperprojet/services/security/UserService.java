package com.tactfactory.monsuperprojet.services.security;

import javax.validation.Valid;

import com.tactfactory.monsuperprojet.entities.User;

public interface UserService {

  void save(@Valid User user);
  User findByLogin(String login);
}
