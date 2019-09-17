package com.tactfactory.monsuperprojet.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie")
public class CookieController {

  @Value("${custom.values.cookie.value}")
  private String cookieValue;

  @Value("#{'${custom.values.cookie.ids}'.split(',')}")
  private List<String> ids;

  @GetMapping("/setCookie")
  public void setCookie(HttpServletResponse response) {
    Cookie cookie = new Cookie("testCookie", cookieValue);

    response.addCookie(cookie);
  }

  @GetMapping("/setCookies")
  public void setCookies(HttpServletResponse response) {
    for (String string : ids) {
      Cookie cookie = new Cookie(string, cookieValue);

      response.addCookie(cookie);
    }
  }

  @GetMapping("/getCookie")
  public String getCookie(@CookieValue(value = "testCookie", defaultValue = "") String monCookie) {
    return monCookie;
  }

  @GetMapping("/getCookies")
  public String getCookies(HttpServletRequest request) {

    StringBuilder builder = new StringBuilder();

    for (Cookie cookie : request.getCookies()) {
      builder.append(cookie.getName() + " : " + cookie.getValue() + ", ");
    }


    return builder.toString();
  }
}
