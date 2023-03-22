package ru.cgpb.securityappauth.models.authentication;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class AuthenticationRequest {
    private String userLogin;

    private String userPass;
}
