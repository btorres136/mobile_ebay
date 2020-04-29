package edu.mobile.ebay.DAO.LDAP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfiguration {
 
    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://192.168.8.139:389/dc=mobile_ebay,dc=com");
        contextSource.setBase("ou=Users,dc=mobile_ebay,dc=com");
        contextSource.setUserDn("cn=ldapadm,dc=mobile_ebay,dc=com");
        contextSource.setPassword("87512738");
        return contextSource;
    }
}