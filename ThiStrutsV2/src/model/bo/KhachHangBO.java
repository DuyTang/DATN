package model.bo;

import java.sql.SQLException;

import model.dao.KhachHangDAO;

public class KhachHangBO {
	KhachHangDAO khachHangDAO = new KhachHangDAO();
	public void addKhachHang(String maKH, String tenKH, String diaChi,
			String email, String soDienThoai,boolean tinhTrang) throws Exception {
		// TODO Auto-generated method stub
		khachHangDAO.addKhachHang(maKH,tenKH,diaChi,email,soDienThoai,tinhTrang);
	}
	public String getMaKHDesc() throws SQLException {
		// TODO Auto-generated method stub
		String maKH = khachHangDAO.getMaKHDesc();
	      System.out.println(maKH.substring(2, maKH.length()));
	     
	         int toNumber = Integer.parseInt(maKH.substring(2,
	               maKH.length()));
	         toNumber += 1;
	         if (toNumber < 10) {
	            return "KH0" + toNumber;
	         } else {
	            return "KH" + toNumber;
	         }
	      
	}

}
