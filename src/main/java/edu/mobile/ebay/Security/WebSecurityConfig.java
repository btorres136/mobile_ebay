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
        .userSearchBase("ou=Users")
        .userSearchFilter("uid={0}")
        .groupSearchBase("ou=Groups")
        .groupSearchFilter("uniqueMember={0}")
        .contextSource().url("ldap://192.168.8.139:389/dc=mobile_ebay,dc=com")
        .managerDn("cn=ldapadm,dc=mobile_ebay,dc=com")
        .managerPassword("87512738")
        .and()
        .passwordCompare()
        .passwordEncoder(new BCryptPasswordEncoder())
        .passwordAttribute("userPassword");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/sec/Menu","/products", "/", "/index", "/CSS/**", "/JS/**", "/IMG/**")
        .permitAll().antMatchers("/sec/**").hasRole("CUSTOMERS").anyRequest().denyAll().and().formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/process_login")
        .successHandler(new CustomAuthenticationSuccessHandler());
    }

}