package com.cristinelpavel.nerulssiach5ex1.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter implements Filter {

  private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    var httpRequest = (HttpServletRequest) request;
    var requestId = httpRequest.getHeader("Request-Id");

    logger.info(String.format("Successfully authenticated request with id %s", requestId));

    chain.doFilter(request, response);
  }
}
