package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Ram1;
import model.dao.Ram1DAO;

public class Ram1BO {
	Ram1DAO ramDAO = new Ram1DAO();
	public ArrayList<Ram1> getdsRam() throws SQLException {
		// TODO Auto-generated method stub
		return ramDAO.getdsRam();
	}
	public void suaRam(String maRam, String tenRam, String loaiRam,
			String dungLuong, String gia, String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		ramDAO.suaRam(maRam,tenRam,loaiRam,dungLuong,gia,soLuong,thoiGianBH);
	}
	public Ram1 getThongTinRam(String maRam) throws SQLException {
		// TODO Auto-generated method stub
		return ramDAO.getThongTin(maRam);
	}
	public void xoaRam(String id) {
		// TODO Auto-generated method stub
		ramDAO.xoaRam(id);
	}
	public String getMaRam() {
		// TODO Auto-generated method stub
		return ramDAO.getMaRam();
	}
	public void themRam(String maRam, String tenRam, String loaiRam,
			String dungLuong, String gia, String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		ramDAO.themRam(maRam,tenRam,loaiRam,dungLuong,gia,soLuong,thoiGianBH);
	}
}
