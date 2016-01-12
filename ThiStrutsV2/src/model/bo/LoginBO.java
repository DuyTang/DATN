package model.bo;

import java.sql.SQLException;

import model.dao.LoginDAO;

public class LoginBO {
        LoginDAO loginDAO = new LoginDAO();
    public boolean checkLogin(String user, String pass) throws SQLException {
        // TODO Auto-generated method stub
        return loginDAO.checkLogin(user,pass);
    }

}
