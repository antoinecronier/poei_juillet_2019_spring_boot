package com.tactfactory.monsuperprojet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class MainFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    System.out.println("Method = " + req.getMethod());
    System.out.println("Uri = " + req.getRequestURI());
    System.out.println("ip = " + req.getRemoteAddr());

    System.out.println("content = " + res.getContentType());

    if (!req.getRemoteAddr().equals("127.0.0.1")) {
      chain.doFilter(request, response);

      System.out.println("content = " + res.getContentType());
    }else {
      String responseToClient= "<tdcp><cmd><ack cmd=”Init”><panelistid>3849303</panelistid></ack></cmd></tdcp>";

      res.setStatus(HttpServletResponse.SC_OK);
      res.getWriter().write(responseToClient);
      res.getWriter().flush();
      res.getWriter().close();
    }
  }

}
