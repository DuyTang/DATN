package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Mainboard;

public class MainboardDAO {
	ConnectionDB con = new ConnectionDB();
	public ArrayList<Mainboard> getListMainboard() throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;	
		ArrayList<Mainboard>list = new ArrayList<Mainboard>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from MAINBOARD";
			ResultSet rs = st.executeQuery(sql);
		
			Mainboard main;
			while(rs.next()){
				main = new Mainboard();
				main.setMaMainboard(rs.getString("MaMainboard"));
				main.setTenMainboard(rs.getString("TenMainboard"));
				main.setGia(rs.getInt("Gia"));
				main.setSocket(rs.getString("Socket"));
				main.setThoiGianBH(rs.getInt("ThoiGianBH"));
				main.setTinhTrang(rs.getBoolean("TinhTrang"));
				main.setSoLuong(rs.getInt("SoLuong"));
				main.setLoaiRam(rs.getString("LoaiRam"));
				main.setSoLuongKheCamRam(rs.getInt("SoLuongKheCamRam"));
				String giaVaLoai = rs.getInt("Gia") +"-" + rs.getString("MaMainboard")+"-" + rs.getString("LoaiRam") + "-" + rs.getInt("SoLuongKheCamRam")+"-"+rs.getInt("DungLuongRAMToiDa");
				main.setGiaVaLoaiMain(giaVaLoai);
				list.add(main);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.cn.close();
		}
		
		return list;
	}
	public ArrayList<Mainboard> getListMainboard(String main1) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<Mainboard>list = new ArrayList<Mainboard>();
		try {
			pst = con.cn.prepareStatement("select * from MAINBOARD where MaMainboard = ?");	
			pst.setString(1, main1);
			ResultSet rs = pst.executeQuery();
			Mainboard main;
			while(rs.next()){
				main = new  Mainboard();
				main.setMaMainboard(rs.getString("MaMainboard"));
				main.setTenMainboard(rs.getString("TenMainboard"));
				main.setGia(rs.getInt("Gia"));
				main.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(main);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.cn.close();
		}
		return list;
	}
	public String getSocket(String main1) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		String sql = "select Socket from MAINBOARD where MaMainBoard ='"+main1+"'";
		System.out.println(main1);
		Statement stm = con.cn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		String socket = null;
		while (rs.next()) {
			 socket = rs.getString(1);
		}
		System.out.println(socket);
		return socket;
	}

	public String getLoaiRam(String main1) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		String sql = "select LoaiRam from MAINBOARD where MaMainBoard ='"+main1+"'";
		System.out.println(main1);
		Statement stm = con.cn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		String loaiRam = null;
		while (rs.next()) {
			loaiRam = rs.getString(1);
		}
		System.out.println(loaiRam);
		return loaiRam;
	}
	
	}


