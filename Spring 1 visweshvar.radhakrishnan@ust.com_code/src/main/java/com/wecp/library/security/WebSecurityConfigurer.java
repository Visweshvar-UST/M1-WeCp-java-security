package com.wecp.library.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configure Spring Security class here. Don't forget to extend the class with the necessary Spring Security class.
 * user and renew-user-subscription APIs must be authenticated and issue-book must be permitAll.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        // super.configure(http);
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/v1/issue-book").permitAll()
            .antMatchers("/api/v1/user","/api/v1/renew-user-subscription/**").authenticated()
            .and()
            .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}