package edu.mobile.ebay.DAO.LDAP;

import javax.naming.ldap.LdapName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LdapManager {
    
    @Autowired
    private LdapTemplate ldapTemplate;


    public void create(String username, String password) {
        LdapName dn = LdapNameBuilder.newInstance().add("ou", "Users").add("cn", username).build();
        DirContextAdapter context = new DirContextAdapter(dn);

        context.setAttributeValues("objectclass",
                new String[] { "top", "person", "organizationalPerson", "inetOrgPerson" });
        context.setAttributeValue("cn", username);
        context.setAttributeValue("sn", username);
        context.setAttributeValue("userPassword", new BCryptPasswordEncoder().encode(password));

        ldapTemplate.bind(context);

        LdapName group = LdapNameBuilder.newInstance("cn=Customers,ou=Groups").build();
        DirContextOperations groupcontext = ldapTemplate.lookupContext(group);

        groupcontext.addAttributeValue("uniqueMember", LdapNameBuilder.newInstance().add("ou", "users").add("cn", username).build().toString());

        ldapTemplate.modifyAttributes(groupcontext);



    }

}