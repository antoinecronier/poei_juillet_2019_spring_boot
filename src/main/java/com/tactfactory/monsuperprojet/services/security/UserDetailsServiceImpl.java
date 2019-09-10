package com.tactfactory.monsuperprojet.services.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tactfactory.monsuperprojet.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserServiceImpl userServiceImpl;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userServiceImpl.findByLogin(username);

    if (user == null) {
      return null;
    }

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    if (user.getRole() != null) {
      grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
    }

//    String idForEncode = "bcrypt";
//    Map<String, PasswordEncoder> encoders = new HashMap<String, PasswordEncoder>();
//    encoders.put(idForEncode, new BCryptPasswordEncoder());
//    encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//    encoders.put("scrypt", new SCryptPasswordEncoder());
//
//    PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

    UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();
    userBuilder.username(user.getLogin());
    userBuilder.password(user.getPassword());
    userBuilder.authorities(grantedAuthorities);

    return userBuilder.build();
  }

}
