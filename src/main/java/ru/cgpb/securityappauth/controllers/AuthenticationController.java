package ru.cgpb.securityappauth.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.cgpb.securityappauth.DAO.UserDao;
import ru.cgpb.securityappauth.models.Client;
import ru.cgpb.securityappauth.models.authentication.AuthenticationRequest;
import ru.cgpb.securityappauth.services.JwtService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserDao userDao;

    @GetMapping("/auth")
    public String getAuthForm(){
        return "auth";
    }

    @ResponseBody
    @PostMapping("/authenticate")
    public HashMap<String, String> authenticate(@RequestBody AuthenticationRequest request,
                                  HttpServletResponse response) {
        HashMap<String, String> result = new HashMap<>();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUserLogin(),
                            request.getUserPass()
                    )
            );
        }
        catch (Exception e){
            result.put("error", e.getMessage());
            return result;
        }
        Client user = userDao.findUserByLogin(request.getUserLogin()).get();
        jwtService.makeCookie(response, user);
        log.info("Cookie is added");

        result.put("success", "success");
        return result;
    }

    @GetMapping("/errors")
    public String unauthorized(){
        return "unauthorized";
    }

}
