
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectDB;
import model.bean.LoaiBoPhan;

public class LoaiBoPhanDAO {
	ConnectDB cn = new  ConnectDB();
	PreparedStatement preSt = null;
	public ArrayList<LoaiBoPhan> getListLoaiBoPhan() {
		// TODO Auto-generated method stub
		cn.Connect();
		String sql=	"SELECT MaLoai,TenLoai FROM LoaiBoPhan";
		ResultSet rs = null;
		try {
			Statement stmt = cn.con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<LoaiBoPhan> list = new ArrayList<LoaiBoPhan>();
		LoaiBoPhan loaiBoPhan;
		try {
			while(rs.next()){
				loaiBoPhan = new LoaiBoPhan();
				loaiBoPhan.setMaLoai(rs.getString(1));
				loaiBoPhan.setTenLoai(rs.getString(2));
				list.add(loaiBoPhan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
