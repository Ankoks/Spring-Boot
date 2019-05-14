package com.example.postgresdemo.config;

import com.example.postgresdemo.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * User: ankoks
 * Date: 13/05/2019
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProviderImpl authProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/sign-up", "/login").anonymous()
//                .and().csrf().disable()
////                .formLogin()
////                .loginPage("/login")
////                .loginPage("/login/process")
////                .and()
//                .logout();
        http.authorizeRequests()
//                .anyRequest().anonymous()
                .antMatchers("/sign-up").anonymous()
                .antMatchers("/*").authenticated()
                .and().csrf().disable()
                .httpBasic();
    }
}
