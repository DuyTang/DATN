package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.LoaiSanPhamBean;

public class LoaiSanPhamDAO {
	String url = "jdbc:sqlserver://localhost; databaseName=QuanLyLapTop";
	String userName = "sa";
	String password = "12345678";
	Connection connection;
	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	void closeConnect(ResultSet rs, Statement st) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<LoaiSanPhamBean> getListLoaiSP() {
		connect();
		String cauLenh = "Select maloai, tenloai from loaisanpham where tinhtrang = 1";
		Statement st = null;
		ResultSet rs = null;
		ArrayList<LoaiSanPhamBean> arr = new ArrayList<LoaiSanPhamBean>();
		LoaiSanPhamBean loaiSanPham;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(cauLenh);
			while(rs.next()) {
				loaiSanPham = new LoaiSanPhamBean();
				loaiSanPham.setMaLoai(rs.getString(1));
				loaiSanPham.setTenLoai(rs.getString(2));
				arr.add(loaiSanPham);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
}
