package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.ConnectDB;

public class abc {
ConnectDB cn = new ConnectDB();
	public void select() throws SQLException{
		cn.Connect();
		String sql = " select AnhSP from SanPham ";
		Statement st = cn.con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getString("AnhSP"));
		}
	}	
}
