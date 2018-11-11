package com.resume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by sjambudi on 11/11/2018.
 */

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        final User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
                userBuilder
                .username("sidjam")
                .password("$weet123!")
                .roles("USER")
                .build();

        auth.inMemoryAuthentication().withUser(userBuilder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/v1/SiddhiJambudiResume/**").authorizeRequests().anyRequest().authenticated()
                .and().httpBasic()
                .and().csrf().disable();
    }

}
