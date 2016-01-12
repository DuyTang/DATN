package model.bean;

public class HangSanPham {
   private String maHang;
   private String tenHang;
   public HangSanPham(String maHang, String tenHang) {
      // TODO Auto-generated constructor stub
      this.maHang = maHang;
      this.tenHang = tenHang;
   }
   public HangSanPham() {
      // TODO Auto-generated constructor stub
   }
   public String getMaHang() {
      return maHang;
   }
   public void setMaHang(String maHang) {
      this.maHang = maHang;
   }
   public String getTenHang() {
      return tenHang;
   }
   public void setTenHang(String tenHang) {
      this.tenHang = tenHang;
   }
}
