package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.HangSanPham;
import model.bean.OrderDetail;
import model.bean.SanPham;
import model.bean.SanPhamBean;
import model.dao.OrderDetailDAO;
import common.MyException;

public class OrderDetailBO {
   OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

   public void addOrderDetail(String maHD, String maLoaiSP, String imei,
         String giaBan, String maChiTietDonHang) throws MyException {
      // TODO Auto-generated method stub
      
      orderDetailDAO.addOrderDetail(maHD, maLoaiSP, imei, giaBan,
            maChiTietDonHang);
   }

   public String getAutoIncrementMaCTDH() throws MyException {
      // TODO Auto-generated method stub
      String largestNumber = orderDetailDAO.getLargestNumberOfMaCTDH();
      try {
         int toNumber = Integer.parseInt(largestNumber.substring(4,
               largestNumber.length()));
         toNumber += 1;
         if (toNumber < 10) {
            return "CTDH0" + toNumber;
         } else {
            return "CTDH" + toNumber;
         }
      } catch (NumberFormatException e) {
         throw new MyException("Lỗi OrderBO->getAuto...: lỗi parse Int");
      }
   }

   public void editOrderDetail(String maHD, String maLoaiSP, String imei,
         String giaBan, String maChiTietDonHang) throws MyException {
      // TODO Auto-generated method stub
      
      // phai truyen maChiTietDonHang de xac dinh dang chinh sua dong nao
      orderDetailDAO.editOrderDetail(maHD, maLoaiSP, imei, giaBan,
            maChiTietDonHang);
   }

   public OrderDetail getOrderDetail(String maChiTietDonHang)
         throws MyException {
      // TODO Auto-generated method stub
      return orderDetailDAO.getOrderDetail(maChiTietDonHang);
   }

   public void deleteOrderDetail(String maChiTietDonHang) throws MyException {
      // TODO Auto-generated method stub
      orderDetailDAO.deleteOrderDetail(maChiTietDonHang);
   }

   public ArrayList<HangSanPham> getArrHangSP() throws MyException {
      return orderDetailDAO.getArrHangSP();
   }

   public boolean isExistedMaLoaiSP(String maLoaiSP) {
      // TODO Auto-generated method stub
      return orderDetailDAO.isExistedMaLoaiSP(maLoaiSP);
   }

   public boolean isImeiInChiTietDonLapRap(String imei) throws MyException {
      return orderDetailDAO.isImeiInChiTietDonLapRap(imei);
   }

   public boolean isImeiInChiTietDonDatHang(String imei) throws MyException {
      return orderDetailDAO.isImeiInChiTietDonDatHang(imei);
   }

public ArrayList<SanPhamBean> getListSP(String maHoaDon) throws SQLException, MyException {
	// TODO Auto-generated method stub
	return orderDetailDAO.getListSP(maHoaDon);
}
}
