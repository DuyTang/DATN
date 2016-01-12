package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectDB;
import model.bean.Chip1;

public class Chip1DAO {
	ConnectDB cn = new ConnectDB();
	PreparedStatement preSt = null;
	public ArrayList<Chip1> getdsMain() throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
		String sql = " select * from CHIP where TinhTrang = 'true' order by MaChip";
		 Statement st = cn.con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        ArrayList<Chip1> list = new ArrayList<Chip1>();
	        Chip1 ram;
	        while(rs.next()){
	        	ram = new Chip1();
	        	ram.setMaChip(rs.getString(1));
	        	ram.setTenChip(rs.getString(2));
				ram.setSocket(rs.getString(3));
	        	String giaBan = rs.getString(4).substring(0,rs.getString(4).length()-5);
				ram.setGia(giaBan);
				ram.setSoLuong(rs.getString(5));
				ram.setThoiGianBH(rs.getString(6));
	        	ram.setTinhTrang(rs.getString(7));
	        	list.add(ram);
	        }
		return list;
	}
	public String getMaMain() {
		// TODO Auto-generated method stub
		 cn.Connect();
	        String sql = "select top 1 MaChip from CHIP order by MaChip desc";
	        Statement st = null;
	        ResultSet rs = null;
	        String id = null;
	        int soTang2 = 0;
	        String traVe = "C";
	        try {
	            st = cn.con.createStatement();
	            rs = st.executeQuery(sql);
	            rs.next();
	            id = rs.getString(1);
	            String soTang = id.substring(2, id.length());
	            soTang2 = Integer.parseInt(soTang);
	            if (soTang2 < 9) {
	                traVe = "C0";
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return traVe + (soTang2 + 1);
	}
	public void themMain(String maChip, String tenChip,String socket, String gia,
			String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		 cn.Connect();
	        try {
	            String sql = "insert into CHIP values(?,?,?,?,?,?,'true')";
	            preSt= cn.con.prepareStatement(sql);
	            preSt.setString(1 , maChip);
	            preSt.setString(2 , tenChip);
	            preSt.setString(3, socket);
	            preSt.setString(4 , gia);
	            preSt.setString(5 , soLuong);
	            preSt.setString(6 , thoiGianBH);
	            preSt.executeUpdate();
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        } finally {
	            if(preSt != null){
	                preSt.close();
	            }
	            cn.Disconnect();
	        }
	}
	public Chip1 getThongTin(String maChip) throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
        String sql = "select * from CHIP where MaChip=?";
        preSt = cn.con.prepareStatement(sql);
        preSt.setString(1, maChip);
        ResultSet rs = preSt.executeQuery();
        Chip1 ram = new Chip1();
        while (rs.next()) {
        	ram.setMaChip(maChip);
        	ram.setTenChip(rs.getString(2));
        	ram.setSocket(rs.getString(3));
        	ram.setGia(rs.getString(4));
        	ram.setSoLuong(rs.getString(5));
        	ram.setThoiGianBH(rs.getString(6));
        }
        cn.Disconnect();
        return ram;
	}
	public void suaMain(String maChip, String tenMain,String socket, String gia,
			String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
        try {
            String sql = "UPDATE CHIP SET TenChip = ?,Socket=?, Gia=?, SoLuong=?,ThoiGianBH=? WHERE MaChip = ?";
            preSt = cn.con.prepareStatement(sql);
            preSt.setString(1, tenMain);
            preSt.setString(2, socket);
            preSt.setString(3, gia);
            preSt.setString(4, soLuong);
            preSt.setString(5, thoiGianBH);
            preSt.setString(6, maChip);
            preSt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            if (preSt != null) {
                preSt.close();
            }
            cn.Disconnect();
        }
	}
	public void xoaMain(String id) {
		// TODO Auto-generated method stub
		cn.Connect();
		String cauLenh = "update CHIP set tinhtrang = 'false' where MaChip = '"+id+"' ";
		Statement st = null;
		try {
			st = cn.con.createStatement();
			st.executeUpdate(cauLenh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
