package com.tactfactory.monsuperprojet.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .withUser("u1").password("{noop}u1").roles("USER")
      .and()
      .withUser("a1").password("{noop}a1").roles("ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    .antMatchers("/index/**").hasAnyRole("USER","ADMIN").anyRequest().authenticated()
    .antMatchers("/index2").hasRole("ADMIN").anyRequest().authenticated()
    .anyRequest().authenticated()
    .and().httpBasic();
  }
}
