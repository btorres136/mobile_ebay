package edu.mobile.ebay.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapUserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    LdapContextSource ldapContext;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String searchBase = "ou=Users";
        String searchFilter = "(&(objectClass=person)(uid={0}))";
        FilterBasedLdapUserSearch search = new FilterBasedLdapUserSearch(searchBase, searchFilter, ldapContext);
        search.setSearchSubtree(true);
        DefaultLdapAuthoritiesPopulator pop = new DefaultLdapAuthoritiesPopulator(ldapContext, "ou=Groups");
        pop.setGroupSearchFilter("uniqueMember={0}");
        LdapUserDetailsService userDetailsService = new LdapUserDetailsService(search, pop);
        return userDetailsService.loadUserByUsername(username);
    }

}