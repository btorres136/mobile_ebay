package edu.mobile.ebay.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Order(1)
    @Configuration
    public static class RestConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private JwtRequestFilter jwtRequestFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/mobile/**").cors().and().csrf().disable().authorizeRequests().antMatchers("/mobile/api/**").permitAll().antMatchers("/mobile/auth/**").hasAnyRole("PRODUCTOWNER", "ADMINS").anyRequest().denyAll().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.ldapAuthentication().userSearchBase("ou=Users").userSearchFilter("uid={0}").groupSearchBase("ou=Groups")
                    .groupSearchFilter("uniqueMember={0}").contextSource()
                    .url("ldap://192.168.8.164:389/dc=mobile_ebay,dc=com").managerDn("cn=ldapadm,dc=mobile_ebay,dc=com")
                    .managerPassword("87512738").and().passwordCompare().passwordEncoder(new BCryptPasswordEncoder())
                    .passwordAttribute("userPassword");
        }

        @Override
        @Bean
        protected AuthenticationManager authenticationManager() throws Exception {
            return super.authenticationManager();
        }
    }

    @Order(2)
    @Configuration
    public static class WebConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.ldapAuthentication().userSearchBase("ou=Users").userSearchFilter("uid={0}").groupSearchBase("ou=Groups")
                    .groupSearchFilter("uniqueMember={0}").contextSource()
                    .url("ldap://192.168.8.164:389/dc=mobile_ebay,dc=com").managerDn("cn=ldapadm,dc=mobile_ebay,dc=com")
                    .managerPassword("87512738").and().passwordCompare().passwordEncoder(new BCryptPasswordEncoder())
                    .passwordAttribute("userPassword");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.logout().and().authorizeRequests()
                    .antMatchers("/category/**", "/Product", "/Products", "/Search", "/item/**", "/test",
                            "/login", "/SignUp", "/", "/index", "/CSS/**", "/JS/**", "/IMG/**", "/UserIMG/**")
                    .permitAll().antMatchers("/sec/ProductOwner/**").hasAnyRole("PRODUCTOWNER", "ADMINS")
                    .antMatchers("/sec/**", "/logout").hasAnyRole("CUSTOMERS", "PRODUCTOWNER", "ADMINS")
                    .antMatchers("/sec/admin/**").hasRole("ADMINS").anyRequest().denyAll().and().formLogin()
                    .loginPage("/login").loginProcessingUrl("/process_login")
                    .successHandler(new CustomAuthenticationSuccessHandler()).and().sessionManagement().maximumSessions(2);
        }
    }
}
