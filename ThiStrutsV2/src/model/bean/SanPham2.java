package model.bean;

public class SanPham2 {
   private String maLoaiSP;
   private String tenSP;
   
   public SanPham2(){
      
   }
   
   public SanPham2(String maLoaiSP, String tenSP) {
      super();
      this.maLoaiSP = maLoaiSP;
      this.tenSP = tenSP;
   }
   public String getMaLoaiSP() {
      return maLoaiSP;
   }
   public void setMaLoaiSP(String maLoaiSP) {
      this.maLoaiSP = maLoaiSP;
   }
   public String getTenSP() {
      return tenSP;
   }
   public void setTenSP(String tenSP) {
      this.tenSP = tenSP;
   }   
}
