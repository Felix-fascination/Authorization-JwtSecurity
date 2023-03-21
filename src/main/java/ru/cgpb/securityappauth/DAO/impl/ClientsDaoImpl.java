package ru.cgpb.securityappauth.DAO.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.cgpb.securityappauth.DAO.ClientsDao;
import ru.cgpb.securityappauth.models.Clients;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ClientsDaoImpl implements ClientsDao {
    JdbcTemplate jdbcTemplate;
    @Override
    public Optional<Clients> findUserByLogin(String login) {
        String sql = "SELECT * FROM CLIENT_M WHERE LOG = ?";
        List<Clients> client = jdbcTemplate.query(sql,(rs, rowNum) -> makeClient(rs), login);
        if (client.isEmpty()) return Optional.empty();
        else return Optional.of(client.get(0));
    }

    //Need to rewrite as I left all the fields blank
    @Override
    public Clients createClient(Clients client) {
        String sql = "INSERT INTO CLIENT_M (LOG, PWD) VALUES (?, ?)";
        jdbcTemplate.update(sql, client.getLogin(), client.getPassword());
        return client;
    }

    @Override
    public void deleteClientById(long id) {

    }

    private Clients makeClient (ResultSet rs) throws SQLException {
        long id = rs.getLong("ID");
        String login = rs.getString("LOG");
        String password = rs.getString("PWD");
        return new Clients(id, login, password);
    }


}
