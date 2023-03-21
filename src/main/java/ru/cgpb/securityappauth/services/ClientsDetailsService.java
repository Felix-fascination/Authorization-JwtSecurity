package ru.cgpb.securityappauth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.cgpb.securityappauth.DAO.impl.ClientsDaoImpl;
import ru.cgpb.securityappauth.models.Clients;
import ru.cgpb.securityappauth.security.ClientsDetails;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientsDetailsService implements UserDetailsService {

    private final ClientsDaoImpl clientsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Clients> client = clientsDao.findUserByLogin(username);

        if (client.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new ClientsDetails(client.get());
    }
}
