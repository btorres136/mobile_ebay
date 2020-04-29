package edu.mobile.ebay.DAO.LDAP;

import javax.naming.ldap.LdapName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LDAPManager {

    public void create(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        LdapName dn = LdapNameBuilder.newInstance().add("ou", "Users").add("cn", username).build();
        DirContextAdapter context = new DirContextAdapter(dn);

        context.setAttributeValues("objectclass",
                new String[] { "top", "person", "organizationalPerson", "inetOrgPerson" });
        context.setAttributeValue("cn", username);
        context.setAttributeValue("sn", username);
        context.setAttributeValue("userPassword", encoder.encode(password));

        ldapTemplate().bind(context);
    }

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