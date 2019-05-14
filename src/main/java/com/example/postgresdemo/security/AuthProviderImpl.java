package com.example.postgresdemo.security;

import com.example.postgresdemo.model.auth.Client;
import com.example.postgresdemo.model.auth.ClientRole;
import com.example.postgresdemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ankoks
 * Date: 13/05/2019
 */
@Component
public class AuthProviderImpl implements AuthenticationProvider {

    @Autowired
    private ClientService clientService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Client clientByLogin = clientService.getClientByLogin(authentication.getPrincipal().toString());

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (clientByLogin != null) {
            for (ClientRole role : clientByLogin.getRoles())
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new UsernamePasswordAuthenticationToken(clientByLogin, authentication.getCredentials(), authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
