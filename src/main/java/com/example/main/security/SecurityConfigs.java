package com.example.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigs extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users").hasAnyAuthority("MENADZER","STEFAN","ADMIN")
                .antMatchers("/clients").hasAnyAuthority("MENADZER","STEFAN","ADMIN")
                .antMatchers("/links").hasAnyAuthority("MENADZER","STEFAN","ADMIN")
                .antMatchers("/requests").hasAnyAuthority("MENADZER","STEFAN","ADMIN")
                .antMatchers("/linkcheck").hasAnyAuthority("MENADZER","STEFAN","ADMIN")
                .antMatchers("/messages").hasAnyAuthority("MENADZER","STEFAN","ADMIN")
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
        http.cors().and().csrf().disable();
    }
}
