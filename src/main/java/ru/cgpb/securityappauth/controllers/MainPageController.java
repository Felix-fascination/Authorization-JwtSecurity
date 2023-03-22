package ru.cgpb.securityappauth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.cgpb.securityappauth.models.Otdels;
import ru.cgpb.securityappauth.models.StatForms;
import ru.cgpb.securityappauth.services.MainPageService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final MainPageService mainPageService;
    @GetMapping("/")
    public String mainPage (Model model) {
        mainPageService.makeModel(model);
        return "index";
    }
}
