package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.bean.Order;
import model.dao.OrderDAO;
import common.MyException;

public class OrderBO {
   OrderDAO orderDAO = new OrderDAO();

   public String getAutoIncrementMaHD() throws MyException {
      // TODO Auto-generated method stub
      String largestNumber = orderDAO.getTheLargestNumberOfMaHD();
      System.out.println(largestNumber.substring(2, largestNumber.length()));
      try {
         int toNumber = Integer.parseInt(largestNumber.substring(2,
               largestNumber.length()));
         toNumber += 1;
         if (toNumber < 10) {
            return "HD0" + toNumber;
         } else {
            return "HD" + toNumber;
         }
      } catch (NumberFormatException e) {
         throw new MyException("Lỗi OrderBO->getAuto...: lỗi parse Int");
      }
   }

   public void addOrder(String maHD, String maKH, Date parsedNgayDatHang,
         Date parsedNgayGiaoHang, String noiGiaoHang, String tongTien,
         String tinhTrangGiaoHang) throws MyException {
      // TODO Auto-generated method stub
            
      orderDAO.addOrder(maHD, maKH, parsedNgayDatHang, parsedNgayGiaoHang,
            noiGiaoHang, tongTien, tinhTrangGiaoHang);
   }

   public void editOrder(String maHD, String maKH, Date ngayDatHang,
         Date ngayGiaoHang, String noiGiaoHang, String tongTien,
         String tinhTrangGiaoHang) throws MyException {      

      // Ket noi CSDL
      orderDAO.editOrder(maHD, maKH, ngayDatHang, ngayGiaoHang,
            noiGiaoHang, tongTien, tinhTrangGiaoHang);
   }

   public Order getOrder(String maHD) throws MyException {
      // TODO Auto-generated method stub
      return orderDAO.getOrder(maHD);
   }

   public void deleteOrder(String maHD) throws MyException{
      // TODO Auto-generated method stub
      orderDAO.deleteOrder(maHD);
   }

   public boolean isExistedCustomer(String maKH) {
      // TODO Auto-generated method stub
      return orderDAO.isExistedCustomer(maKH);
   }

public String getSoLuongBanThoiGian1(String thoiGian1) {
	// TODO Auto-generated method stub
	return orderDAO.getSoLuongBanThoiGian1(thoiGian1);
}

public String getSoLuongBanThoiGian12(String thoiGian1) {
	// TODO Auto-generated method stub
	return orderDAO.getSoLuongBanThoiGian12(thoiGian1);
}

public ArrayList<String> getListTen() {
	// TODO Auto-generated method stub
	return orderDAO.getListTen();
}

public ArrayList<String> getListGiaTri(ArrayList<String> ten) {
	// TODO Auto-generated method stub
	return orderDAO.getListGiaTri(ten);
}

public ArrayList<String> getListGiaTriThang(String nam) {
	// TODO Auto-generated method stub
	return orderDAO.getListGiaTriThang(nam);
}

public String getMaHoaDon() throws SQLException, MyException {
	// TODO Auto-generated method stub
	return orderDAO.getMaHoaDon();
}
}
