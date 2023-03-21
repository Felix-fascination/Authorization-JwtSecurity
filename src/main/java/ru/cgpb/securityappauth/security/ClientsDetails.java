package ru.cgpb.securityappauth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.cgpb.securityappauth.models.Clients;

import java.util.Collection;

public class ClientsDetails implements UserDetails {

    private final Clients clients;

    public ClientsDetails(Clients clients) {
        this.clients = clients;
    }

    // Коллекция тех прав, которые есть у пользователя (роли)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.clients.getPassword();
    }

    @Override
    public String getUsername() {
        return this.clients.getLogin();
    }

    // Аккаунт действительный
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Аккаунт не заблокированный
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Пароль не просрочен
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Аккаунт работает(включён)
    @Override
    public boolean isEnabled() {
        return true;
    }

    // Нужно, чтобы получать данные аутентифицированного пользователя
    public Clients getClients() {
        return this.clients;
    }
}
