package ru.cgpb.securityappauth.controllers;

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
public class MainPageController {

    MainPageService mainPageService;
    @GetMapping("/")
    public String mainPage (Model model) {
        Connection conn = null;
        String connectionUrl = "jdbc:jtds:sqlserver://10.168.34.28/NEWSTAT";
        String userName = "21_Забродин К. А.";
        String userPass = "123456";
        try {
            conn = DriverManager.getConnection(connectionUrl, userName, userPass);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("EXEC [dbo].[pKV_V40V_MNU]");
            ArrayList<Otdels> sqlOtdelItems = new ArrayList<>();
            while (resultSet.next()) {
                String otdelID = resultSet.getString("V40V");
                String otdelName = resultSet.getString("OTDEL");
                sqlOtdelItems.add(new Otdels(otdelID, otdelName));
            }
            model.addAttribute("sqlOtdelItems", sqlOtdelItems);

            resultSet = statement.executeQuery("SELECT * FROM [dbo].[tblMenu] WHERE ParentID='frmMAIN' ORDER BY [Order]");
            ArrayList<StatForms> sqlStatMenuItems = new ArrayList<>();
            while (resultSet.next()) {
                String menuid = resultSet.getString("ID");
                String menuname = resultSet.getString("Title");
                sqlStatMenuItems.add(new StatForms(menuid, menuname));
            }
            model.addAttribute("sqlStatMenuItems", sqlStatMenuItems);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
