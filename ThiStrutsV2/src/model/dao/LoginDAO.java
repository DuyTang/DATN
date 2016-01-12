package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.ConnectDB;

public class LoginDAO {
    ConnectDB cn = new ConnectDB();
    public boolean checkLogin(String user, String pass) throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql="select * from QUANTRI where TenDangNhap='"+user+"' and MatKhau='"+pass+"'";
        Statement st = cn.con.createStatement();
        ResultSet rs= st.executeQuery(sql);
        if(rs.next()){
            return true;
        }else{
            cn.Disconnect();
            return false;
        }
   }
}
