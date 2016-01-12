package model.bean;

public class OrderDetail {
   private String maHD;
   private String maLoaiSP;
   private String tenSP;
   private String imei;
   private String giaBan;
   private String maChiTietDonHang;
   private String tenHang;
   
   public String getTenHang() {
      return tenHang;
   }

   public void setTenHang(String tenHang) {
      this.tenHang = tenHang;
   }

   public OrderDetail() {

   }

   public String getMaLoaiSP() {
      return maLoaiSP;
   }

   public void setMaLoaiSP(String maLoaiSP) {
      this.maLoaiSP = maLoaiSP;
   }

   public String getMaHD() {
      return maHD;
   }

   public void setMaHD(String maHD) {
      this.maHD = maHD;
   }

   public String getTenSP() {
      return tenSP;
   }

   public void setTenSP(String tenSP) {
      this.tenSP = tenSP;
   }

   public String getImei() {
      return imei;
   }

   public void setImei(String imei) {
      this.imei = imei;
   }

   public String getGiaBan() {
      return giaBan;
   }

   public void setGiaBan(String giaBan) {
      this.giaBan = giaBan;
   }

   public String getMaChiTietDonHang() {
      return maChiTietDonHang;
   }

   public void setMaChiTietDonHang(String maChiTietDonHang) {
      this.maChiTietDonHang = maChiTietDonHang;
   }

}
