package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class OrderForm extends ActionForm {
   private static final long serialVersionUID = 1L;
   private String maHD;
   private String maKH;
   private String ngayDatHang;
   private String ngayGiaoHang;
   private String noiGiaoHang;
   private String tongTien;
   private String tinhTrangGiaoHang = "1";
   private String message;
   private String buttonClicked;

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public String getButtonClicked() {
      return buttonClicked;
   }

   public void setButtonClicked(String buttonClicked) {
      this.buttonClicked = buttonClicked;
   }

   public String getMaHD() {
      return maHD;
   }

   public void setMaHD(String maHD) {
      this.maHD = maHD;
   }

   public String getMaKH() {
      return maKH;
   }

   public void setMaKH(String maKH) {
      this.maKH = maKH;
   }

   public String getNgayDatHang() {
      return ngayDatHang;
   }

   public void setNgayDatHang(String ngayDatHang) {
      this.ngayDatHang = ngayDatHang;
   }

   public String getNgayGiaoHang() {
      return ngayGiaoHang;
   }

   public void setNgayGiaoHang(String ngayGiaoHang) {
      this.ngayGiaoHang = ngayGiaoHang;
   }

   public String getNoiGiaoHang() {
      return noiGiaoHang;
   }

   public void setNoiGiaoHang(String noiGiaoHang) {
      this.noiGiaoHang = noiGiaoHang;
   }

   public String getTongTien() {
      return tongTien;
   }

   public void setTongTien(String tongTien) {
      this.tongTien = tongTien;
   }

   public String getTinhTrangGiaoHang() {
      return tinhTrangGiaoHang;
   }

   public void setTinhTrangGiaoHang(String tinhTrangGiaoHang) {
      this.tinhTrangGiaoHang = tinhTrangGiaoHang;
   }
   public void reset(ActionMapping mapping, HttpServletRequest request) {
      try {
         request.setCharacterEncoding("UTF-8");
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
   }

}
