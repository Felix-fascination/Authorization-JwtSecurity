package ru.cgpb.securityappauth.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.cgpb.securityappauth.DAO.UserDao;
import ru.cgpb.securityappauth.models.Client;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserDao userDao;


    public HashMap<String, String> authenticate(String userLogin, String userPass, HttpServletResponse response) {
        HashMap<String, String> result = new HashMap<>();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin, userPass));
        }
        catch (Exception e){
            result.put("error", e.getMessage());
            return result;
        }
        Client user = userDao.findUserByLogin(userLogin).get();
        jwtService.makeCookie(response, jwtService.generateToken(user));
        log.info("Cookie is added");
        result.put("success", "success");
        return  result;
    }
}
