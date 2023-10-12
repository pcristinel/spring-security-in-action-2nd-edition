package com.cristinelpavel.nerulssiach2ex4.config;

import com.cristinelpavel.nerulssiach2ex4.security.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

  private final CustomAuthenticationProvider authenticationProvider;

  public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
    this.authenticationProvider = authenticationProvider;
  }

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.httpBasic(Customizer.withDefaults());

    http.authenticationProvider(authenticationProvider);

    // All requests must be authenticated
    http.authorizeHttpRequests(c -> c.anyRequest().authenticated());

    // Request don't need to be authenticated
//    http.authorizeHttpRequests(c -> c.anyRequest().permitAll());

    final var user = User.withUsername("john")
                        .password("12345")
                        .authorities("read")
                        .build();

    final var userDetailsManager = new InMemoryUserDetailsManager(user);

    http.userDetailsService(userDetailsManager);

    return http.build();
  }
}
