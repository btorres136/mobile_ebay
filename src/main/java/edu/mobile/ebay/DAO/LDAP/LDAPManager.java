package edu.mobile.ebay.DAO.LDAP;

import javax.naming.ldap.LdapName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LDAPManager {
    
    @Autowired
    private LdapTemplate ldapTemplate;

    public void create(String username,String lastname, String uid, String email,String password) {
        LdapName dn = LdapNameBuilder.newInstance().add("ou", "Users").add("cn", uid).build();
        DirContextAdapter context = new DirContextAdapter(dn);

        context.setAttributeValues("objectclass",
                new String[] { "top", "person", "organizationalPerson", "inetOrgPerson" });
        context.setAttributeValue("cn", uid);
        context.setAttributeValue("sn", lastname);
        context.setAttributeValue("mail", email);
        context.setAttributeValue("uid", uid);
        context.setAttributeValue("userPassword", new BCryptPasswordEncoder().encode(password));

        ldapTemplate.bind(context);

        LdapName group = LdapNameBuilder.newInstance("cn=Customers,ou=Groups").build();
        DirContextOperations groupcontext = ldapTemplate.lookupContext(group);

        groupcontext.addAttributeValue("uniqueMember", "cn="+uid+",ou=Users,dc=mobile_ebay,dc=com");

        ldapTemplate.modifyAttributes(groupcontext);
    }

    public void addProduct_Owner(String username){
        LdapName group = LdapNameBuilder.newInstance("cn=ProductOwner,ou=Groups").build();
        DirContextOperations groupcontext = ldapTemplate.lookupContext(group);

        groupcontext.addAttributeValue("uniqueMember", "cn="+username+",ou=Users,dc=mobile_ebay,dc=com");

        ldapTemplate.modifyAttributes(groupcontext);
    }

}