package edu.mobile.ebay.Security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .ldapAuthentication()
        .userDnPatterns("uid={0}, ou=people")
        .userSearchBase("ou=people")
        .userSearchFilter("uid={0}")
        .groupSearchFilter("uniqueMember={0}")
        .groupSearchBase("ou=groups")
        .contextSource().url("ldap://localhost:8389/dc=mobile_ebay,dc=com")
        .and()
        .passwordCompare()
        .passwordEncoder(new BCryptPasswordEncoder())
        .passwordAttribute("userPassword");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/", "/index", "/CSS/*", "/JS/*", "/IMG/*")
        .permitAll().antMatchers("/sec/**").hasRole("ADMINS").anyRequest().denyAll().and().formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/process_login")
        .successHandler(new CustomAuthenticationSuccessHandler());
    }

}