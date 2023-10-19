package com.cristinelpavel.nerulssiach5ex2.config;

import com.cristinelpavel.nerulssiach5ex2.security.StaticKeyAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class ProjectConfig {

  private final StaticKeyAuthenticationFilter filter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception {
    http
      .addFilterAt(filter, BasicAuthenticationFilter.class)
      .authorizeHttpRequests(c -> c.anyRequest().permitAll());

    return http.build();
  }
}
