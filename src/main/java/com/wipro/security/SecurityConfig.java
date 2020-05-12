package com.wipro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableMongoRepositories(basePackages = "com.wipro.repository")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Disabling security configuration for simplicity
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest().permitAll();/*.authenticated()
                .and().httpBasic().disable();
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("wsuser").password("{noop}wsapp").roles("USER");
    }
}