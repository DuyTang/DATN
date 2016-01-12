package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.BoPhan;
import model.dao.BoPhanDAO;

public class BoPhanBO {
	BoPhanDAO boPhanDAO = new BoPhanDAO();
	public ArrayList<BoPhan> getListBoPhan() {
		// TODO Auto-generated method stub
		return boPhanDAO.getListBoPhan();
	}
	public ArrayList<BoPhan> getListBoPhan(String maLoai) {
		// TODO Auto-generated method stub
		return boPhanDAO.getListBoPhan(maLoai);
	}
	public String getMaChiTiet() {
		// TODO Auto-generated method stub
		return boPhanDAO.getMaChiTiet();
	}
	public void themBoPhan(String maChiTiet, String maLoai, String tenChiTiet,
			String gia, String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		boPhanDAO.themBoPhan(maChiTiet,maLoai,tenChiTiet,gia,soLuong,thoiGianBH);
	}
	public BoPhan getThongTinBoPhan(String maChiTiet) throws SQLException {
		// TODO Auto-generated method stub
		return boPhanDAO.getThongTinBoPhan(maChiTiet);
	}
	public void suaBoPhan(String maChiTiet, String maLoai, String tenChiTiet,
			String gia, String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		boPhanDAO.suaBoPhan(maChiTiet,maLoai,tenChiTiet,gia,soLuong,thoiGianBH);
	}
	public void xoaBoPhan(String id) {
		// TODO Auto-generated method stub
		boPhanDAO.xoaBoPhan(id);
	}
	

}
