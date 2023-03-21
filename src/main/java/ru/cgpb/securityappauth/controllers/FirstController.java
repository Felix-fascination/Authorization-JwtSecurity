package ru.cgpb.securityappauth.controllers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.cgpb.securityappauth.security.ClientsDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class FirstController {


    @GetMapping("/auth")
    public String getAuthForm(){
        return "auth";
    }


    @ResponseBody
    @PostMapping("/checkValidAuthData")
    public HashMap checkValidAuthData(
            @RequestParam(value = "userLogin") String userLogin,
            @RequestParam(value = "userPass") String userPass) {

        HashMap<String, String> result = new HashMap<>();
        Connection conn = null;
        String connectionUrl = "jdbc:jtds:sqlserver://10.168.34.28/NEWSTAT";
        String connectionName = userLogin;
        String connectionPass = userPass;
        try {
            conn = DriverManager.getConnection(connectionUrl, connectionName, connectionPass);
            result.put("success", "success");
            result.put("login", userLogin);
            result.put("pass", userPass);
        } catch (Exception e) {
            result.put("error", e.getMessage());
        }
        return result;
    }

  /*  @ResponseBody
    @PostMapping("/showUserInfo")
    public Map<String, String> showUserInfo() {
        log.info("I was here " + Logger.ROOT_LOGGER_NAME);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ClientsDetails clientsDetails = (ClientsDetails) authentication.getPrincipal();
        System.out.println(clientsDetails.getClients());
        return Map.of("error", "success");
    }*/
}
