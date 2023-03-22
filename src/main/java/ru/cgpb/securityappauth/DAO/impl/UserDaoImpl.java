package ru.cgpb.securityappauth.DAO.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.cgpb.securityappauth.DAO.UserDao;
import ru.cgpb.securityappauth.models.Client;
import ru.cgpb.securityappauth.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate;
    @Override
    public Optional<Client> findUserByLogin(String login) {
        String sql = "SELECT * FROM CLIENT_M WHERE LOG = ?";
        List<Client> client = jdbcTemplate.query(sql,(rs, rowNum) -> makeClient(rs), login);
        if (client.isEmpty()) return Optional.empty();
        else return Optional.of(client.get(0));
    }

    //Need to rewrite as I left all the fields blank
    @Override
    public Client createClient(Client client) {
        String sql = "INSERT INTO CLIENT_M (LOG, PWD) VALUES (?, ?)";
        jdbcTemplate.update(sql, client.getLogin(), client.getPassword());
        return client;
    }

    @Override
    public void deleteClientById(long id) {

    }

    private Client makeClient (ResultSet rs) throws SQLException {
        long id = rs.getLong("ID");
        String login = rs.getString("LOG");
        String password = rs.getString("PWD");
        Role role;
        try {
             role = Role.values()[rs.getByte("ADM")];
        }
        catch (Exception e){
            role = Role.USER;
        }
        return new Client(id, login, password, role);
    }


}
