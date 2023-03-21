package ru.cgpb.securityappauth.DAO;

import ru.cgpb.securityappauth.models.Clients;

import java.util.Optional;

public interface ClientsDao {
    public Optional<Clients> findUserByLogin(String login);

    public Clients createClient(Clients client);

    public void deleteClientById(long id);
}
