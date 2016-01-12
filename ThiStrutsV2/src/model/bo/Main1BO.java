package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Main1;
import model.dao.Main1DAO;

public class Main1BO {
	Main1DAO main1DAO = new Main1DAO();
	public ArrayList<Main1> getdsMain() throws SQLException {
		// TODO Auto-generated method stub
		return main1DAO.getdsMain();
	}
	public String getMaMain() {
		// TODO Auto-generated method stub
		return main1DAO.getMaMain();
	}
	public void themMain(String maMain, String tenMain, String gia,
			String soLuong, String thoiGianBH, String soKheCam, String socket,
			String dungLuong, String loaiRam) throws SQLException {
		// TODO Auto-generated method stub
		main1DAO.themMain(maMain,tenMain,gia,soLuong,thoiGianBH,soKheCam,socket,dungLuong,loaiRam);
	}
	public Main1 getThongTin(String maMain) throws SQLException {
		// TODO Auto-generated method stub
		return main1DAO.getThongTin(maMain);
	}
	public void suaMain(String maMain, String tenMain, String gia,
			String soLuong, String thoiGianBH, String soKheCam, String socket,
			String dungLuong, String loaiRam) throws SQLException {
		// TODO Auto-generated method stub
		main1DAO.suaMain(maMain,tenMain,gia,soLuong,thoiGianBH,soKheCam,socket,dungLuong,loaiRam);
	}
	public void xoaMain(String id) {
		// TODO Auto-generated method stub
		main1DAO.xoaMain(id);
	}

}
