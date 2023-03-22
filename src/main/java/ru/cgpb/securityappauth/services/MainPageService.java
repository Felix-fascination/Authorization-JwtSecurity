package ru.cgpb.securityappauth.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.cgpb.securityappauth.DAO.MainPageDao;
import ru.cgpb.securityappauth.models.Otdels;
import ru.cgpb.securityappauth.models.StatForms;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class MainPageService {
    MainPageDao mainPageDao;
    public void makeModel(Model model){
        ArrayList<Otdels> sqlOtdelItems = mainPageDao.getSqlOtdels();
        ArrayList<StatForms> sqlStatMenuItems = mainPageDao.getSqlStatMenuItems();
        model.addAttribute("sqlOtdelItems", sqlOtdelItems);
        model.addAttribute("sqlStatMenuItems", sqlStatMenuItems);
    }

}
