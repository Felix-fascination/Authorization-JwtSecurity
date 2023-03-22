package ru.cgpb.securityappauth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client implements UserDetails {
    private long id;

    private String login;

    private String password;

    private Role role;

    // Коллекция тех прав, которые есть у пользователя (роли)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRole().name()));

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getLogin();
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
}
