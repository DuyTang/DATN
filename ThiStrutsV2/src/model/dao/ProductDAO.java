package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.SanPham2;

import common.MyException;

public class ProductDAO extends BaseDAO {

   public ArrayList<SanPham2> getArrSanPham(String tenHang) throws MyException {
      // TODO Auto-generated method stub
      openConnection();
      PreparedStatement preSt = null;
      ResultSet rs = null;
      try {
         String command = "SELECT MaLoaiSP, TenSP, CONVERT(INT, ROUND(GiaBanSP, 0)) AS GiaBanSP FROM SANPHAM a JOIN HangSanPham b ON a.MaHang = b.MaHang WHERE b.TenHang = ?";
         preSt = con.prepareStatement(command);
         preSt.setString(1, tenHang);
         rs = preSt.executeQuery();
         if (!rs.isBeforeFirst()) {
            throw new MyException("Không có sản phẩm nào có hãng SP là "
                  + tenHang);
         } else {
            ArrayList<SanPham2> arrSanPham = new ArrayList<SanPham2>();
            SanPham2 sp;
            while (rs.next()) {
               sp = new SanPham2();
               sp.setMaLoaiSP(rs.getString("MaLoaiSP")+"-"+rs.getInt("GiaBanSP"));
               sp.setTenSP(rs.getString("TenSP"));
               arrSanPham.add(sp);
            }
            return arrSanPham;
         }
      } catch (Exception e) {
         throw new MyException("Lỗi ProductDAO->getArrSanPham(): "
               + e.getMessage());
      } finally {
         closeConnection();
         try {
            if (preSt != null) {
               preSt.close();
            }
            if (rs != null) {
               rs.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new MyException(
                  "Lỗi ProductDAO->getArrSanPham(): không thể đóng preSt, rs");
         }
      }
   }
}
