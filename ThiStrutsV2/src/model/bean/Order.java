package model.bean;


public class Order {
   
	private String maHD;
	private String maKH;
	private String tenKH;
	private String ngayDatHang;
	private String ngayGiaoHang;
	private String noiGiaoHang;
	private String tongTien;
	private boolean tinhTrangGiaoHang;
	
	public Order(){
	   
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
      
   public String getTenKH() {
      return tenKH;
   }

   public void setTenKH(String tenKH) {
      this.tenKH = tenKH;
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
   public boolean getTinhTrangGiaoHang() {
      return tinhTrangGiaoHang;
   }
   public void setTinhTrangGiaoHang(boolean tinhTrangGiaoHang) {
      this.tinhTrangGiaoHang = tinhTrangGiaoHang;
   }
	
}
