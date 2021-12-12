package com.codeup.iknowaspot.config;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class LoginRedirectHandler extends SimpleUrlAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    public LoginRedirectHandler() {
        super();
        setUseReferer(true);
    }

}
