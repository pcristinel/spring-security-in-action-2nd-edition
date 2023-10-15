package com.cristinelpavel.nerulssiach5ex1.config;

import com.cristinelpavel.nerulssiach5ex1.security.AuthenticationLoggingFilter;
import com.cristinelpavel.nerulssiach5ex1.security.RequestValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig {


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
      .addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
      .addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
      .authorizeHttpRequests(c -> c.anyRequest().permitAll());

    return httpSecurity.build();
  }
}
