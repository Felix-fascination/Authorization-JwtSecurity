package ru.cgpb.securityappauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.cgpb.securityappauth.services.ClientsDetailsService;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final ClientsDetailsService clientsDetailsService;

    @Autowired
    public AuthProviderImpl(ClientsDetailsService clientsDetailsService) {
        this.clientsDetailsService = clientsDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails clientsDetails = clientsDetailsService.loadUserByUsername(username);

        if (!password.equals(clientsDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }

        return new UsernamePasswordAuthenticationToken(
                clientsDetails,
                password,
                Collections.emptyList()
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
