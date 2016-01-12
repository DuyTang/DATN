package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.HangSanPham;
import model.bean.OrderDetail;
import model.dao.CusSendOrderDetailDAO;
import common.MyException;
import common.Validate;

public class CusSendOrderDetailBO {
   CusSendOrderDetailDAO orderDetailDAO = new CusSendOrderDetailDAO();

   public void addOrderDetail(String maHD, String maLoaiSP, String imei,
         String giaBan, String maChiTietDonHang,int soLuong1) throws MyException, SQLException {
      // TODO Auto-generated method stub
      // Validate

	   //Neu imei khac null tuc la DL do khach hang truyen ve tu web khong phai do NV nhap 
	      if (imei != null) {
	         // Neu IMEI da co trong 2 bang chitietdonlaprap va chitietdondathang
	         if (!Validate.isValidImei(imei)
	               || orderDetailDAO.isImeiInChiTietDonLapRap(imei)
	               || orderDetailDAO.isImeiInChiTietDonDatHang(imei)) {
	            throw new MyException("IMEI không hợp lệ hoặc đã tồn tại");
	         }
	      }
      // kiem tra tinh hop le cua gia ban
      if (!Validate.isValidPrice(giaBan)) {
         throw new MyException("Lỗi giá bán không hợp lệ: chỉ chữ số và dấu phẩy được chấp nhận");
      } else {
         // Neu tongTien chua dau cham thi xoa het
         if (giaBan.contains(".")) {
            String[] temp = giaBan.split("\\.");
            giaBan = "";
            for (int i = 0; i < temp.length; i++) {
               giaBan += temp[i];
            }
         }
      }
      orderDetailDAO.addOrderDetail(maHD, maLoaiSP, imei, giaBan,
            maChiTietDonHang);
      // orderDetailDAO.updateSoLuong(maLoaiSP,soLuong1);

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
      // Validate

      if (!Validate.isValidImei(imei) || orderDetailDAO.isImeiInChiTietDonLapRap(imei)) {
         throw new MyException(
               "IMEI này không hợp lệ hoặc trùng với IMEI trong bảng chi tiết đơn lắp ráp");
      }

      // kiem tra tinh hop le cua gia ban
      if (!Validate.isValidPrice(giaBan)) {
         throw new MyException("Lỗi giá bán không hợp lệ: chỉ chữ số và dấu phẩy được chấp nhận");
      } else {
         // Neu tongTien chua dau cham thi xoa het
         if (giaBan.contains(".")) {
            String[] temp = giaBan.split("\\.");
            giaBan = "";
            for (int i = 0; i < temp.length; i++) {
               giaBan += temp[i];
            }
         }
      }

      // vi maHD khong the chinh sua nen khong can truyen vao
      // phai truyen maChiTietDonHang de xac dinh dang chinh sua dong nao
      orderDetailDAO.editOrderDetail(maHD, maLoaiSP, imei, giaBan, maChiTietDonHang);
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

   public ArrayList<HangSanPham> getArrHangSP() throws MyException{
      return orderDetailDAO.getArrHangSP();
   }
}
