package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.SanPhamLapRap1;
import model.dao.SanPhamLapRapDAO;

public class SanPhamLapRapBO {
	SanPhamLapRapDAO sanPhamLapRapDAO = new SanPhamLapRapDAO();
	public ArrayList<SanPhamLapRap1> getdsSanPhamRapRap() throws SQLException {
		// TODO Auto-generated method stub
		return sanPhamLapRapDAO.getdsSanPhamLapRap();
	}
	public ArrayList<SanPhamLapRap1> getdsctSanPhamRapRap(String maSPLR) throws SQLException {
		// TODO Auto-generated method stub
		return sanPhamLapRapDAO.getdsctSanPhamLapRap(maSPLR);
	}
	public SanPhamLapRap1 getThongTin(String maSPLR) throws SQLException {
		// TODO Auto-generated method stub
		return sanPhamLapRapDAO.getThongTin(maSPLR);
	}

}
