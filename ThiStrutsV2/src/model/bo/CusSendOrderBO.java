package model.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.bean.Order;
import model.dao.OrderDAO;
import common.MyException;
import common.Validate;

public class CusSendOrderBO {
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

   public void addOrder(String maHD, String maKH, String ngayDatHang,
         String ngayGiaoHang, String noiGiaoHang, String tongTien,
         String tinhTrangGiaoHang) throws MyException {
      // TODO Auto-generated method stub
      // Validate

      // Chuyen ngay dat hang va ngay giao hang tu String ve
      // dinh dang ngay cua java
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      Date parsedNgayDatHang;
      Date parsedNgayGiaoHang = null;
      try {
         parsedNgayDatHang = format.parse(ngayDatHang);
         if (ngayGiaoHang != null) {
            parsedNgayGiaoHang = format.parse(ngayGiaoHang);
         }
      } catch (ParseException e) {
         // TODO Auto-generated catch block
         throw new MyException(
               "Lỗi OrderBO->addOrder...: lỗi ngày giao hàng không đúng định dạng");
      }

      // kiem tra tinh hop le cua ngay giao hang
      if (parsedNgayGiaoHang != null) {
         if (!Validate.isValidDeliverDay(parsedNgayDatHang, parsedNgayGiaoHang)) {
            String error = "Lỗi OrderBO->addOrder...: lỗi ngày giao hàng không hợp lệ"
                  + "\n Ngày giao hàng phải trùng hoặc ở sau ngày đặt hàng";
            throw new MyException(error);
         }
      }


      // Kiem tra tinh hop le cua tong tien
      if (!Validate.isValidPrice(tongTien)) {
         throw new MyException(
               "Lỗi OrderBO->addOrder...: lỗi tổng tiền không hợp lệ: chỉ chữ số và dấu phẩy được chấp nhận");
      }

      // Ket noi CSDL
      orderDAO.addOrder(maHD, maKH, parsedNgayDatHang, parsedNgayGiaoHang,
            noiGiaoHang, tongTien, tinhTrangGiaoHang);
   }

   public void editOrder(String maHD, String maKH, String ngayDatHang,
         String ngayGiaoHang, String noiGiaoHang, String tongTien,
         String tinhTrangGiaoHang) throws MyException {
      // TODO Auto-generated method stub
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      Date parsedNgayDatHang;
      Date parsedNgayGiaoHang;
      try {
         parsedNgayDatHang = format.parse(ngayDatHang);
         parsedNgayGiaoHang = format.parse(ngayGiaoHang);
      } catch (ParseException e) {
         // TODO Auto-generated catch block
         throw new MyException(
               "Lỗi OrderBO->editOrder...: lỗi ngày giao hàng không đúng định dạng");
      }

      // kiem tra tinh hop le cua ngay giao hang
      if (!Validate.isValidDeliverDay(parsedNgayDatHang, parsedNgayGiaoHang)) {
         String error = "Lỗi OrderBO->editOrder...: lỗi ngày giao hàng không hợp lệ"
               + "\n Ngày giao hàng phải trùng hoặc ở sau ngày đặt hàng";
         throw new MyException(error);
      }

      // Kiem tra tinh hop le cua tong tien
      if (!Validate.isValidPrice(tongTien)) {
         throw new MyException(
               "Lỗi OrderBO->editOrder...: lỗi tổng tiền không hợp lệ: chỉ chữ số và dấu phẩy được chấp nhận");
      }

      // Ket noi CSDL
      orderDAO.editOrder(maHD, maKH, parsedNgayDatHang, parsedNgayGiaoHang,
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
}
