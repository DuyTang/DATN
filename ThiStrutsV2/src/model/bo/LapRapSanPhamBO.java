package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.SanPhamLapRap;
import model.dao.LapRapSanPhamDAO;

public class LapRapSanPhamBO {
	LapRapSanPhamDAO lapRapSanPhamDAO = new LapRapSanPhamDAO();
	
	public void addLapRap(String maSPLapRap,String main1, String ram1, String chip1,
			String chuot1, String banPhim1, String hdd1, String manHinh1,
			boolean tinhTrang, int soLuongRam,String maHD, String caseS1, String nguon1,
			String dvd1, String tanNhiet1, String phuKien1) throws SQLException {
		// TODO Auto-generated method stub
		lapRapSanPhamDAO.addLapRap(maSPLapRap,main1,ram1,chip1,chuot1,banPhim1,hdd1,manHinh1,tinhTrang,soLuongRam,maHD,caseS1,nguon1,dvd1,tanNhiet1,phuKien1);
	}

	public String getMaSPLapRapDesc() throws SQLException {
		// TODO Auto-generated method stub
		String maSPLapRap = lapRapSanPhamDAO.getMaSPLapRapDesc();
	      System.out.println(maSPLapRap.substring(2, maSPLapRap.length()));
	     
	         int toNumber = Integer.parseInt(maSPLapRap.substring(2,
	               maSPLapRap.length()));
	         toNumber += 1;
	         if (toNumber < 10) {
	            return "SP0" + toNumber;
	         } else {
	            return "SP" + toNumber;
	         }
	}

	public ArrayList<SanPhamLapRap> getListSanPhamLapRap(String maSPLapRap) throws SQLException {
		// TODO Auto-generated method stub
		return lapRapSanPhamDAO.getListSanPhamLapRap(maSPLapRap);
	}
	
	}

	

