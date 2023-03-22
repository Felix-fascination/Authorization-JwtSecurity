package ru.cgpb.securityappauth.DAO.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.cgpb.securityappauth.DAO.MainPageDao;
import ru.cgpb.securityappauth.models.Otdels;
import ru.cgpb.securityappauth.models.StatForms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class mainPageDaoImpl implements MainPageDao {

    JdbcTemplate jdbcTemplate;
    @Override
    public ArrayList<Otdels> getSqlOtdels() {
        String sql = "EXEC [dbo].[pKV_V40V_MNU]";
        ArrayList<Otdels> sqlOtdels  = (ArrayList) jdbcTemplate.query(sql, (rs, rowNum) -> makeOtdels(rs) );
        return sqlOtdels;
    }

    @Override
    public ArrayList<StatForms> getSqlStatMenuItems() {
        String sql = "SELECT * FROM [dbo].[tblMenu] WHERE ParentID='frmMAIN' ORDER BY [Order]";
        ArrayList<StatForms> sqlStatMenuItems  = (ArrayList) jdbcTemplate.query(sql, (rs, rowNum) -> makeStatForms(rs) );
        return sqlStatMenuItems;
    }

    private StatForms makeStatForms(ResultSet rs) throws SQLException {
        String id = rs.getString("ID");
        String menuName = rs.getString("Title");
        return new StatForms(id, menuName);
    }

    private Object makeOtdels(ResultSet rs) throws SQLException {
        String V40V = rs.getString("V40V");
        String OTDEL = rs.getString("OTDEL");
        return new Otdels(V40V, OTDEL);
    }
}
