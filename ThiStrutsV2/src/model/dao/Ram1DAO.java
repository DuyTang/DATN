package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Ram1;

import common.ConnectDB;

public class Ram1DAO {
	ConnectDB cn = new ConnectDB();
	PreparedStatement preSt = null;
	public ArrayList<Ram1> getdsRam() throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
		String sql = " select * from Ram where TinhTrang = 'true' order by MaRam";
		 Statement st = cn.con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        ArrayList<Ram1> list = new ArrayList<Ram1>();
	        Ram1 ram;
	        while(rs.next()){
	        	ram = new Ram1();
	        	ram.setMaRam(rs.getString(1));
	        	ram.setTenRam(rs.getString(2));
	        	ram.setLoaiRam(rs.getString(3));
	        	ram.setDungLuong(rs.getString(4));
	        	String giaBan = rs.getString(5).substring(0,rs.getString(5).length()-5);
				ram.setGia(giaBan);
	        	ram.setSoLuong(rs.getString(6));
	        	ram.setThoiGianBH(rs.getString(7));
	        	ram.setTinhTrang(rs.getString(8));
	        	list.add(ram);
	        }
		return list;
	}
	public Ram1 getThongTin(String maRam) throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
        String sql = "select * from Ram where MaRam=?";
        preSt = cn.con.prepareStatement(sql);
        preSt.setString(1, maRam);
        ResultSet rs = preSt.executeQuery();
        Ram1 ram = new Ram1();
        while (rs.next()) {
        	ram.setMaRam(maRam);
        	ram.setTenRam(rs.getString(2));
        	ram.setLoaiRam(rs.getString(3));
        	ram.setDungLuong(rs.getString(4));
        	ram.setGia(rs.getString(5));
        	ram.setSoLuong(rs.getString(6));
        	ram.setThoiGianBH(rs.getString(7));
        }
        cn.Disconnect();
        return ram;
	}
	public void suaRam(String maRam, String tenRam, String loaiRam,
			String dungLuong, String gia, String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		 cn.Connect();
	        try {
	            String sql = "UPDATE Ram SET TenRam = ?, LoaiRam=?, DungLuong=?,Gia=?, SoLuong=?,ThoiGianBBH WHERE MaRam = ?";
	            preSt = cn.con.prepareStatement(sql);
	            preSt.setString(1, tenRam);
	            preSt.setString(2, loaiRam);
	            preSt.setString(3, dungLuong);
	            preSt.setString(4, gia);
	            preSt.setString(5, soLuong);
	            preSt.setString(6, thoiGianBH); 
	            preSt.setString(7, maRam);
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
	public void xoaRam(String id) {
		// TODO Auto-generated method stub
		cn.Connect();
		String cauLenh = "update Ram set tinhtrang = 'false' where MaRam = '"+id+"' ";
		Statement st = null;
		try {
			st = cn.con.createStatement();
			st.executeUpdate(cauLenh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getMaRam() {
		// TODO Auto-generated method stub
		   cn.Connect();
	        String sql = "select top 1 MaRam from RAM order by MaRam desc";
	        Statement st = null;
	        ResultSet rs = null;
	        String id = null;
	        int soTang2 = 0;
	        String traVe = "R";
	        try {
	            st = cn.con.createStatement();
	            rs = st.executeQuery(sql);
	            rs.next();
	            id = rs.getString(1);
	            String soTang = id.substring(2, id.length());
	            soTang2 = Integer.parseInt(soTang);
	            if (soTang2 < 9) {
	                traVe = "R0";
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return traVe + (soTang2 + 1);
	}
	public void themRam(String maRam, String tenRam, String loaiRam,
			String dungLuong, String gia, String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		 cn.Connect();
	        try {
	            String sql = "insert into RAM values(?,?,?,?,?,?,?,'true')";
	            preSt= cn.con.prepareStatement(sql);
	            preSt.setString(1 , maRam);
	            preSt.setString(2 , tenRam);
	            preSt.setString(3 , loaiRam);
	            preSt.setString(4 , dungLuong);
	            preSt.setString(5 , gia);
	            preSt.setString(6 , soLuong);
	            preSt.setString(7 , thoiGianBH);
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
}
