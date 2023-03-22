package ru.cgpb.securityappauth.DAO;

import ru.cgpb.securityappauth.models.Otdels;
import ru.cgpb.securityappauth.models.StatForms;

import java.util.ArrayList;

public interface MainPageDao {

    ArrayList<Otdels> getSqlOtdels();

    ArrayList<StatForms> getSqlStatMenuItems();

}
