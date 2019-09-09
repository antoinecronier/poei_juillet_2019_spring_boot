package com.tactfactory.monsuperprojet.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tactfactory.monsuperprojet.services.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
//@EnableTransactionManagement
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsServiceImpl userDetailsServiceImpl;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsServiceImpl);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers("/index").hasAnyRole("USER","ADMIN")
      .antMatchers("/index2").hasRole("ADMIN")
      .anyRequest().authenticated()
    .and()
      // .antMatchers("/login").anonymous().anyRequest().permitAll()
      .formLogin()
        .loginPage("/login")
        .usernameParameter("login")
        .passwordParameter("pwd")
        .defaultSuccessUrl("/index",true)
        .permitAll()
    .and()
      .logout()
        .logoutUrl("/deconnexion")
        .deleteCookies("JSESSIONID")
        .logoutSuccessUrl("http://www.google.com")
    .and()
      .httpBasic()
    .and()
      .cors();
  }

  @Bean
  public AuthenticationManager customAuthenticationManager() throws Exception {
    return authenticationManager();
  }
}
