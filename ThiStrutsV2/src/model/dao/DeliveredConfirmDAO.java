package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.MyException;
import common.Validate;

public class DeliveredConfirmDAO extends BaseDAO {

   @SuppressWarnings("resource")
   public void confirm(String maHD) throws MyException {
      // TODO Auto-generated method stub
      boolean notError = true;
      openConnection();
      PreparedStatement preSt = null;
      ResultSet rs = null;

      // kiem tra tat ca don dat hang deu phai co imei
      try {
         String command = "SELECT IMEI FROM CHITIETDONDATHANG WHERE MaHD = ? AND TinhTrang = 1";
         preSt = con.prepareStatement(command);
         preSt.setString(1, maHD);
         rs = preSt.executeQuery();
         if (!rs.isBeforeFirst()) {
            throw new MyException("Đơn hàng này không có sản phẩm nào");
         }
         while (rs.next()) {
            if (!Validate.isValidImei(rs.getString("IMEI"))) {
               throw new MyException(
                     "Trong đơn hàng có chứa Imei không hợp lệ, hãy kiểm tra lại.");
            }
         }
      } catch (Exception e) {
         notError = false;
         throw new MyException(e.getMessage());
      } finally {
         try {
            if (preSt != null) {
               preSt.close();
            }
            if (rs != null) {
               rs.close();
            }
            closeConnection();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         if (notError) {
            // cap nhat CSDL
            openConnection();
            try {
               String command = "UPDATE DONDATHANG SET TinhTrangGiaoHang = 0 WHERE MaHD = ?";
               preSt = con.prepareStatement(command);
               preSt.setString(1, maHD);
               preSt.executeUpdate();
            } catch (Exception e) {
               throw new MyException(e.getMessage());
            } finally {
               try {
                  if (preSt != null) {
                     preSt.close();
                  }
                  closeConnection();
               } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }
         }
      }
   }
}
