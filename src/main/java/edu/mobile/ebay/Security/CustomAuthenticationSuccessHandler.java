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
        Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
        logger.info("auth: Brian "+authorities.size());
        authorities.forEach(authority -> {
            logger.info("auth: Brian "+authority);
            if (authority.getAuthority().equals("ROLE_CUSTOMERS")) {
                try {
                    res.sendRedirect("/sec/Menu");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}