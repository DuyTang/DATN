package model.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Chip;

public class ChipDAO {
	ConnectionDB con =  new ConnectionDB();
	public ArrayList<Chip> getListChip() throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<Chip>list = new ArrayList<Chip>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from Chip";
			ResultSet rs = st.executeQuery(sql);
			
			Chip chip;
			while(rs.next()){
				chip = new  Chip();
				chip.setMaChip(rs.getString("MaChip"));
				chip.setTenChip(rs.getString("TenChip"));
				chip.setGia(rs.getInt("Gia"));
				chip.setSocket(rs.getString("Socket"));
				chip.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chip.setTinhTrang(rs.getBoolean("TinhTrang"));
				chip.setSoLuong(rs.getInt("SoLuong"));
				String and  = rs.getInt("Gia") + "-" + rs.getString("MaChip");
				chip.setGiaVaLoai(and);
				list.add(chip);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.cn.close();
		}
		return list;
	
		
		
	}
	public ArrayList<Chip> getListChip(String chip1) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<Chip>list = new ArrayList<Chip>();
		try {
			pst = con.cn.prepareStatement("select * from Chip where MaChip = ?");	
			pst.setString(1, chip1);
			ResultSet rs = pst.executeQuery();
			Chip chip;
			while(rs.next()){
				chip = new  Chip();
				chip.setMaChip(rs.getString("MaChip"));
				chip.setTenChip(rs.getString("TenChip"));
				chip.setGia(rs.getInt("Gia"));
				chip.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(chip);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.cn.close();
		}
		return list;
	}
	public ArrayList<Chip> getListChip1(String socket) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<Chip>list = new ArrayList<Chip>();
		try {
			pst = con.cn.prepareStatement("select * from Chip where Socket = ?");	
			pst.setString(1, socket);
			ResultSet rs = pst.executeQuery();
			Chip chip;
			while(rs.next()){
				chip = new  Chip();
				chip.setMaChip(rs.getString("MaChip"));
				chip.setTenChip(rs.getString("TenChip"));
				chip.setGia(rs.getInt("Gia"));
				chip.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(chip);
				
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
