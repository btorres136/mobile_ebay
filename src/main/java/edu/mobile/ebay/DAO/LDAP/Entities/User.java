package edu.mobile.ebay.DAO.LDAP.Entities;

import javax.naming.ldap.LdapName;
import javax.persistence.Id;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;

@Entry(base="ou=Users", objectClasses = {
    "top",
    "inetOrgPerson", "person", "organizationalPerson",
})
public class User {

    @Id
    private LdapName Id;

    private @Attribute(name = "uid") String uid;

    private @Attribute(name = "cn") String firstName;

    private @Attribute(name = "displayname") String displayName;

    private  @Attribute(name = "sn") String lastName;



}