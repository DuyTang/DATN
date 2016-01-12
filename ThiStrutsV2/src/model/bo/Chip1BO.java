package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Chip1;
import model.dao.Chip1DAO;

public class Chip1BO {
	Chip1DAO main1DAO = new Chip1DAO();
	public ArrayList<Chip1> getdsMain() throws SQLException {
		// TODO Auto-generated method stub
		return main1DAO.getdsMain();
	}
	public String getMaMain() {
		// TODO Auto-generated method stub
		return main1DAO.getMaMain();
	}
	public void themMain(String maChip, String tenChip,String socket, String gia,
			String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		main1DAO.themMain(maChip,tenChip,socket,gia,soLuong,thoiGianBH);
	}
	public Chip1 getThongTin(String maChip) throws SQLException {
		// TODO Auto-generated method stub
		return main1DAO.getThongTin(maChip);
	}
	public void suaMain(String maChip, String tenMain,String socket, String gia,
			String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		main1DAO.suaMain(maChip,tenMain,socket,gia,soLuong,thoiGianBH);
	}
	public void xoaMain(String id) {
		// TODO Auto-generated method stub
		main1DAO.xoaMain(id);
	}

}
