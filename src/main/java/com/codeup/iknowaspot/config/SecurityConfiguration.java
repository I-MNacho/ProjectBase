package com.codeup.iknowaspot.config;

import com.codeup.iknowaspot.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader) // How to find users by their username
                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
        ;
    }
//}
//    @Override
//    protected void configure(HttpSecurity security, AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(usersLoader) // How to find users by their username
//                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
//                .and()
//        security.csrf()
//                .disable()
//                .httpBasic()
//                .disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll();
//    }
//}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/spots/create", // only authenticated users can create ads
                        "/events/create",
                        "/events/mine",
                        "/events/create/{spot_id}",
                        "/events/edit/{id}",
                        "/events/delete/{id}",
                        "/events/save/{id}",
                        "/events/rsvp/{id}",
                        "/events/unsave/{id}",
                        "/events/unrsvp/{id}",
                        "/spots/save/{id}",
                        "/spots/{id}/edit", // only authenticated users can edit ads
                        "/profile", //only authenticated users can view profile
                        "/profile/edit" //only authenticated users can edit profile
                )
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(new LoginRedirectHandler())
                .defaultSuccessUrl("/home") // user's home page, it can be any URL
                /* Logout configuration */
                .and()
                .authorizeRequests()
                .antMatchers("/events", "/home", "/spots", "/about", "/register") // anyone can see the home and the ads pages
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/home") // append a query string value
                /* Pages that can be viewed without having to log in */
                .and()
        ;
    }
}