package edu.mobile.ebay.Security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;

@Component
@Configurable
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
            throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        boolean condition = authorities.stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_CUSTOMERS")
                || authority.getAuthority().equals("ROLE_PRODUCTOWNER"));
        if (condition) {
            try {
                res.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                res.sendRedirect("/403");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}