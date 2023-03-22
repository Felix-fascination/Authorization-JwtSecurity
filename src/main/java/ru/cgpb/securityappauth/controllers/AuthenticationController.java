package ru.cgpb.securityappauth.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.cgpb.securityappauth.models.authentication.AuthenticationRequest;
import ru.cgpb.securityappauth.services.AuthenticationService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authService;

    @GetMapping("/auth")
    public String getAuthForm(){
        return "auth";
    }

    @ResponseBody
    @PostMapping("/authenticate")
    public HashMap<String, String> authenticate(@RequestBody AuthenticationRequest request,
                                  HttpServletResponse response) {
        return authService.authenticate(request.getUserLogin(), request.getUserPass(), response);

    }

    @GetMapping("/errors")
    public String unauthorized(){
        return "unauthorized";
    }

}
