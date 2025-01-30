package com.example.grocerybooking.config;

import com.example.grocerybooking.model.Role;
import com.example.grocerybooking.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            com.example.grocerybooking.model.User appUser = userRepository.findByUsername(username);
            if (appUser == null) {
                throw new RuntimeException("User not found");
            }
            UserDetails user = User.withUsername(appUser.getUsername())
                    .password(appUser.getPassword())
                    .roles(String.valueOf(appUser.getRole()))
                    .build();
            return user;
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").hasRole(String.valueOf(Role.ADMIN))
                        .requestMatchers("/user/**").hasRole(String.valueOf(Role.USER))
                        .anyRequest().authenticated()
                )
                .formLogin()
                .and()
                .httpBasic(); // Enables basic authentication
        return http.build();
    }
}
