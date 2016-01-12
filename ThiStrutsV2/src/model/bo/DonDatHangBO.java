package model.bo;

import java.sql.SQLException;

import model.dao.DonDatHangDAO;

public class DonDatHangBO {
	DonDatHangDAO donDatHangDAO = new DonDatHangDAO();
	public void addDonDatHang(String maHD, String maKH,String ngayDatHang, String diaChi,
			String tongTien, boolean tinhTrang, boolean tinhTrangGiaoHang) throws SQLException {
		// TODO Auto-generated method stub
		donDatHangDAO.addDonDatHang(maHD,maKH,ngayDatHang,diaChi,tongTien,tinhTrang,tinhTrangGiaoHang);
		
		
	}
	public String getMaHDDesc() throws SQLException {
		// TODO Auto-generated method stub
		String maHD = donDatHangDAO.getMaKHDesc();
	      System.out.println(maHD.substring(2, maHD.length()));
	     
	         int toNumber = Integer.parseInt(maHD.substring(2,
	               maHD.length()));
	         toNumber += 1;
	         if (toNumber < 10) {
	            return "HD0" + toNumber;
	         } else {
	            return "HD" + toNumber;
	         }
	}

}
