package com.tactfactory.monsuperprojet.services.security;

import com.tactfactory.monsuperprojet.entities.User;

public interface UserService {

  void save(User user);
  User findByLogin(String login);
}
