package com.tactfactory.monsuperprojet.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.monsuperprojet.database.repositories.RoleRepository;
import com.tactfactory.monsuperprojet.database.repositories.UserRepository;
import com.tactfactory.monsuperprojet.entities.User;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void save(User user) {
    userRepository.save(user);
  }

  @Override
  public User findByLogin(String login) {
    return userRepository.findByLogin(login);
  }

}
