package com.tapsCabs.loginAndSecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote spring security configurations
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Bean
   public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                 .authorizeRequests()
                .antMatchers("/cab/**","/city/**").hasRole("ADMIN")
                .antMatchers("/explore/**","/user/reg","/swagger-ui.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/bookingform");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());

    }
}
