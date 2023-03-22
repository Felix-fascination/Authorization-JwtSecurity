package ru.cgpb.securityappauth.DAO;

import ru.cgpb.securityappauth.models.Client;

import java.util.Optional;

public interface UserDao {
    Optional<Client> findUserByLogin(String login);

     Client createClient(Client client);

     void deleteClientById(long id);
}
