package ru.cgpb.securityappauth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clients {
    private long id;

    private String login;

    private String password;



    public Clients(String username) {
        this.login = username;
    }

}
