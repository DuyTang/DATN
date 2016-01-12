package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectDB;
import model.bean.Main1;

public class Main1DAO {
	ConnectDB cn = new ConnectDB();
	PreparedStatement preSt = null;
	public ArrayList<Main1> getdsMain() throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
		String sql = " select * from MAINBOARD where TinhTrang = 'true' order by MaMainBoard";
		 Statement st = cn.con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        ArrayList<Main1> list = new ArrayList<Main1>();
	        Main1 ram;
	        while(rs.next()){
	        	ram = new Main1();
	        	ram.setMaMain(rs.getString(1));
	        	ram.setTenMain(rs.getString(2));
	        	String giaBan = rs.getString(3).substring(0,rs.getString(3).length()-5);
				ram.setGia(giaBan);
				ram.setSoLuong(rs.getString(4));
				ram.setThoiGianBH(rs.getString(5));
				ram.setSoKheCam(rs.getString(6));
				ram.setSocket(rs.getString(7));
				ram.setDungLuong(rs.getString(8));
	        	ram.setLoaiRam(rs.getString(9));
	        	ram.setTinhTrang(rs.getString(10));
	        	list.add(ram);
	        }
		return list;
	}
	public String getMaMain() {
		// TODO Auto-generated method stub
		 cn.Connect();
	        String sql = "select top 1 MaMainBoard from MAINBOARD order by MaMainBoard desc";
	        Statement st = null;
	        ResultSet rs = null;
	        String id = null;
	        int soTang2 = 0;
	        String traVe = "MB";
	        try {
	            st = cn.con.createStatement();
	            rs = st.executeQuery(sql);
	            rs.next();
	            id = rs.getString(1);
	            String soTang = id.substring(2, id.length());
	            soTang2 = Integer.parseInt(soTang);
	            if (soTang2 < 9) {
	                traVe = "MB0";
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return traVe + (soTang2 + 1);
	}
	public void themMain(String maMain, String tenMain, String gia,
			String soLuong, String thoiGianBH, String soKheCam, String socket,
			String dungLuong, String loaiRam) throws SQLException {
		// TODO Auto-generated method stub
		 cn.Connect();
	        try {
	            String sql = "insert into MAINBOARD values(?,?,?,?,?,?,?,?,?,'true')";
	            preSt= cn.con.prepareStatement(sql);
	            preSt.setString(1 , maMain);
	            preSt.setString(2 , tenMain);
	            preSt.setString(3 , gia);
	            preSt.setString(4 , soLuong);
	            preSt.setString(5 , thoiGianBH);
	            preSt.setString(6 , soKheCam);
	            preSt.setString(7 , socket);
	            preSt.setString(8 , dungLuong);
	            preSt.setString(9 , loaiRam);
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
	public Main1 getThongTin(String maMain) throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
        String sql = "select * from MAINBOARD where MaMainBoard=?";
        preSt = cn.con.prepareStatement(sql);
        preSt.setString(1, maMain);
        ResultSet rs = preSt.executeQuery();
        Main1 ram = new Main1();
        while (rs.next()) {
        	ram.setMaMain(maMain);
        	ram.setTenMain(rs.getString(2));
        	ram.setGia(rs.getString(3));
        	ram.setSoLuong(rs.getString(4));
        	ram.setThoiGianBH(rs.getString(5));
        	ram.setSoKheCam(rs.getString(6));
        	ram.setSocket(rs.getString(7));
        	ram.setDungLuong(rs.getString(8));
        	ram.setLoaiRam(rs.getString(9));
        	
        }
        cn.Disconnect();
        return ram;
	}
	public void suaMain(String maMain, String tenMain, String gia,
			String soLuong, String thoiGianBH, String soKheCam, String socket,
			String dungLuong, String loaiRam) throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
        try {
            String sql = "UPDATE MAINBOARD SET TenMainBoard = ?, Gia=?, SoLuong=?,ThoiGianBH=?,SoLuongKheCam=?, Socket=?,"+
            		"DungLuongRam=?,LoaiRam=? WHERE MaRam = ?";
            preSt = cn.con.prepareStatement(sql);
            preSt.setString(1, tenMain);
            preSt.setString(2, gia);
            preSt.setString(3, soLuong);
            preSt.setString(4, thoiGianBH);
            preSt.setString(5, soKheCam);
            preSt.setString(6, socket); 
            preSt.setString(7, dungLuong);
            preSt.setString(8, loaiRam);
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
		String cauLenh = "update MAINBOARD set tinhtrang = 'false' where MaMainBoard = '"+id+"' ";
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
