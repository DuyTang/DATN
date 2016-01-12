package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Ram;

public class RamDAO {
	ConnectionDB con  = new ConnectionDB();
	public ArrayList<Ram> getListRam() throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<Ram>list = new ArrayList<Ram>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from RAM";
			ResultSet rs = st.executeQuery(sql);
			
			Ram ram;
			while(rs.next()){
				ram = new Ram();
				ram.setMaRam(rs.getString("MaRam"));
				ram.setTenRam(rs.getString("TenRam"));
				ram.setGia(rs.getInt("Gia"));
				ram.setLoaiRam(rs.getString("LoaiRam"));
				ram.setSoLuong(rs.getInt("SoLuong"));
				ram.setThoiGianBH(rs.getInt("ThoiGianBH"));
				ram.setTinhTrang(rs.getBoolean("TinhTrang"));
				String tam = rs.getInt("Gia") + "-" + rs.getString("MaRam")+ "-" + rs.getString("LoaiRam") + "-" + rs.getInt("DungLuong");
				ram.setGiaVaLoai(tam);
				list.add(ram);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.cn.close();
		}
		
		return list;
	}
	public ArrayList<Ram> getListRam(String ram1) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<Ram>list = new ArrayList<Ram>();
		try {
			pst = con.cn.prepareStatement("select * from RAM where MaRam = ?");	
			pst.setString(1, ram1);
			ResultSet rs = pst.executeQuery();
			Ram ram;
			while(rs.next()){
				ram = new  Ram();
				ram.setMaRam(rs.getString("MaRam"));
				ram.setTenRam(rs.getString("TenRam"));
				ram.setGia(rs.getInt("Gia"));
				ram.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ram);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.cn.close();
		}
		return list;
	}
	public ArrayList<Ram> getListRam1(String loaiRam) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<Ram>list = new ArrayList<Ram>();
		try {
			pst = con.cn.prepareStatement("select * from RAM where LoaiRam = ?");	
			pst.setString(1, loaiRam);
			ResultSet rs = pst.executeQuery();
			Ram ram;
			while(rs.next()){
				ram = new  Ram();
				ram.setMaRam(rs.getString("MaRam"));
				ram.setTenRam(rs.getString("TenRam"));
				ram.setGia(rs.getInt("Gia"));
				ram.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ram);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.cn.close();
		}
		return list;
	}
	
	
	}
	
		
	
	

