package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.HangSanPham;
import model.bean.OrderDetail;
import model.bean.SanPhamBean;
import common.MyException;

public class OrderDetailDAO extends BaseDAO {

   public String getLargestNumberOfMaCTDH() throws MyException {
      // TODO Auto-generated method stub
      openConnection();
      Statement st = null;
      ResultSet rs = null;
      try {
         String command = "SELECT TOP 1 MaChiTietDonDatHang FROM CHITIETDONDATHANG ORDER BY MaChiTietDonDatHang DESC";
         st = con.createStatement();
         rs = st.executeQuery(command);
         if (!rs.isBeforeFirst()) {
            throw new MyException(
                  "Lỗi: OrderDAO->getTheLargest...(): result set không có bản ghi nào.");
         } else {
            rs.next();
            return rs.getString(1);
         }
      } catch (Exception e) {
         throw new MyException(e.getMessage());
      } finally {
         closeConnection();
         try {
            if (st != null) {
               st.close();
            }
            if (rs != null) {
               rs.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new MyException(
                  "Lỗi: OrderDAO->getTheLargest...(): không thể đóng st, rs.");
         }
      }
   }

   public boolean isImeiInChiTietDonDatHang(String imei) throws MyException {
      // TODO Auto-generated method stub
      openConnection();
      PreparedStatement preSt = null;
      ResultSet rs = null;
      try {

         // Kiem tra IMEI trong bang ChiTietDonDatHang
         String command = "SELECT IMEI FROM CHITIETDONDATHANG WHERE IMEI = ?";
         preSt = con.prepareStatement(command);
         preSt.setString(1, imei);
         rs = preSt.executeQuery();

         // Neu rs co ban ghi tuc la imei da ton tai trong bang
         // ChiTietdonDatHang
         if (rs.isBeforeFirst()) {
            return true;
         } else {
            return false;
         }
      } catch (Exception e) {
         throw new MyException(e.getMessage());
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
                  "Lỗi: OrderDAO->getTheLargest...(): không thể đóng preSt, rs.");
         }
      }
   }

   public boolean isImeiInChiTietDonLapRap(String imei) throws MyException {
      // TODO Auto-generated method stub
      openConnection();
      PreparedStatement preSt = null;
      ResultSet rs = null;
      try {
         // Kiem tra IMEI trong bang ChiTietDonLapRap
         String command = "SELECT IMEI FROM CHITIETDONLAPRAP WHERE IMEI = ?";
         preSt = con.prepareStatement(command);
         preSt.setString(1, imei);
         rs = preSt.executeQuery();

         // Neu rs co ban ghi tuc la imei da ton tai trong bang
         // ChiTietdonDatHang
         if (rs.isBeforeFirst()) {
            return true;
         }
      } catch (Exception e) {
         throw new MyException(e.getMessage());
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
                  "Lỗi: OrderDAO->getTheLargest...(): không thể đóng preSt, rs.");
         }
      }
      return false;
   }

   public void addOrderDetail(String maHD, String maLoaiSP, String imei,
         String giaBan, String maChiTietDonHang) throws MyException {
      // TODO Auto-generated method stub
      openConnection();
      PreparedStatement preSt = null;
     
      try {
         String command = "INSERT INTO CHITIETDONDATHANG(MaHD, MaLoaiSP, imei, "
               + "GiaBanSP, MaChiTietDonDatHang, TinhTrang) "
               + "VALUES(?,?,?,?,?,1)";
         preSt = con.prepareStatement(command);
         preSt.setString(1, maHD);
         preSt.setString(2, maLoaiSP);
         preSt.setString(3, imei);
         preSt.setString(4, giaBan);
         preSt.setString(5, maChiTietDonHang);
         preSt.executeUpdate();
      } catch (Exception e) {
         throw new MyException("Lỗi OrderDetailDAO->addOrderDetail(): "
               + e.getMessage());
      } finally {
         closeConnection();
         try {
            if (preSt != null) {
               preSt.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new MyException(
                  "Lỗi OrderDetailDAO->addOrderDetail(): không thể đóng preSt");
         }
      }
   }

   public void editOrderDetail(String maHD, String maLoaiSP, String imei,
         String giaBan, String maChiTietDonHang) throws MyException {
      // TODO Auto-generated method stub
      openConnection();
      PreparedStatement preSt = null;
      try {

         /*
          * Chi can loc WHERE theo ma chi tiet don hang nhung them vao ma hoa
          * don de tranh truong hop nguoi dung sua ma hoa don tren thanh dia chi
          * *
          */
         String command = "UPDATE CHITIETDONDATHANG SET MaLoaiSP = ?, IMEI = ?, "
               + "GiaBanSP = ? WHERE MaChiTietDonDatHang = ? AND MaHD = ?";
         preSt = con.prepareStatement(command);
         preSt.setString(1, maLoaiSP);
         preSt.setString(2, imei);
         preSt.setString(3, giaBan);
         preSt.setString(4, maChiTietDonHang);
         preSt.setString(5, maHD);
         if (preSt.executeUpdate() < 1) {
            throw new MyException(maHD + " không có đơn hàng nào có mã "
                  + maChiTietDonHang);
         }
      } catch (Exception e) {
         throw new MyException("Lỗi OrderDetailDAO->editOrderDetail(): "
               + e.getMessage());
      } finally {
         closeConnection();
         try {
            if (preSt != null) {
               preSt.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new MyException(
                  "Lỗi OrderDetailDAO->editOrderDetail(): không thể đóng preSt");
         }
      }
   }

   public OrderDetail getOrderDetail(String maChiTietDonHang)
         throws MyException {
      // TODO Auto-generated method stub
      openConnection();
      PreparedStatement preSt = null;
      ResultSet rs = null;
      try {
         String command = "SELECT MaLoaiSP, IMEI, CONVERT(INT, ROUND(GiaBanSP, 0)) AS GiaBanSP "
               + "FROM CHITIETDONDATHANG WHERE MaChiTietDonDatHang = ? AND TinhTrang = 1";
         preSt = con.prepareStatement(command);
         preSt.setString(1, maChiTietDonHang);
         rs = preSt.executeQuery();
         if (!rs.isBeforeFirst()) {
            throw new MyException(
                  "Lỗi OrderDetailDAO->getOrderDetail(): không có chi tiết đơn hàng nào có mã "
                        + maChiTietDonHang);
         } else {
            rs.next();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setMaLoaiSP(rs.getString("MaLoaiSP"));
            orderDetail.setImei(rs.getString("IMEI"));
            orderDetail.setGiaBan(rs.getString("GiaBanSP"));
            return orderDetail;
         }
      } catch (Exception e) {
         throw new MyException("Lỗi OrderDetailDAO->getOrderDetail(): "
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
                  "Lỗi OrderDetailDAO->getOrderDetail(): không thể đóng preSt, rs");
         }
      }
   }

   public void deleteOrderDetail(String maChiTietDonHang) throws MyException {
      openConnection();
      PreparedStatement preSt = null;
      try {
         String command = "UPDATE CHITIETDONDATHANG SET TinhTrang = 0 WHERE "
               + "MaChiTietDonDatHang = ?";
         preSt = con.prepareStatement(command);
         preSt.setString(1, maChiTietDonHang);
         preSt.executeUpdate();
      } catch (Exception e) {
         throw new MyException("Lỗi OrderDetailDAO->deleteOrderDetail(): "
               + e.getMessage());
      } finally {
         closeConnection();
         try {
            if (preSt != null) {
               preSt.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new MyException(
                  "Lỗi OrderDetailDAO->deleteOrderDetail(): không thể đóng preSt");
         }
      }
   }

   public ArrayList<HangSanPham> getArrHangSP() throws MyException {
      // TODO Auto-generated method stub
      openConnection();
      Statement st = null;
      ResultSet rs = null;
      try {
         String command = "SELECT MAHANG, TENHANG FROM HANGSANPHAM";
         st = con.createStatement();
         rs = st.executeQuery(command);
         if (!rs.isBeforeFirst()) {
            throw new MyException(
                  "Không có hãng sản xuất nào trong bảng HANGSANPHAM");
         } else {
            ArrayList<HangSanPham> arrHangSP = new ArrayList<HangSanPham>();
            HangSanPham hangSP;
            while (rs.next()) {
               hangSP = new HangSanPham();
               hangSP.setMaHang(rs.getString("MaHang"));
               hangSP.setTenHang(rs.getString("TenHang"));
               arrHangSP.add(hangSP);
            }
            return arrHangSP;
         }
      } catch (Exception e) {
         throw new MyException("Lỗi OrderDetailDAO->getTenHang(): "
               + e.getMessage());
      } finally {
         closeConnection();
         try {
            if (st != null) {
               st.close();
            }
            if (rs != null) {
               rs.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new MyException(
                  "Lỗi OrderDetailDAO->getTenHang(): không thể đóng st, rs");
         }
      }
   }

   public boolean isExistedMaLoaiSP(String maLoaiSP) {
      PreparedStatement preSt = null;
      ResultSet rs = null;
      try {
         openConnection();
         String command = "SELECT MaLoaiSP FROM SANPHAM WHERE MaLoaiSP = ? AND TinhTrang = 1";
         preSt = con.prepareStatement(command);
         preSt.setString(1, maLoaiSP);
         rs = preSt.executeQuery();
         if (rs.next()) {
            return true;
         } else {
            return false;
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
         return false;
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
            return false;
         }
      }
   }

public ArrayList<SanPhamBean> getListSP(String maHoaDon) throws SQLException, MyException {
	// TODO Auto-generated method stub
	
	 openConnection();
     Statement st = null;
     ResultSet rs = null;
     try {
    	 String sql = "select TenSP,ct.GiaBanSP,ThoiGianBH from SANPHAM sp "+
    				" inner join CHITIETDONDATHANG ct on sp.MaLoaiSP = ct.MaLoaiSP "+
    				" where MaHD = '"+maHoaDon+"'";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        if (!rs.isBeforeFirst()) {
           throw new MyException(
                 "Không có sản phẩm nào trong bảng Chitietdondathang");
        } else {
        	ArrayList<SanPhamBean> list = new ArrayList<SanPhamBean>();
        	SanPhamBean sp;
        	while (rs.next()) {
        		sp = new SanPhamBean();
        		sp.setTenSP(rs.getString(1));
        		
        		String gia = rs.getString(2).substring(0,rs.getString(2).length()-5);
        		sp.setGiaBanSP(gia);
        		sp.setThoiGianBH(rs.getString(3));
        		System.out.println(rs.getString(1)+","+gia+","+rs.getString(3));
        		list.add(sp);
        		
        	}
        	return list;
        }
     } catch (Exception e) {
        throw new MyException("Lỗi OrderDetailDAO->getTenHang(): "
              + e.getMessage());
     } finally {
        closeConnection();
        try {
           if (st != null) {
              st.close();
           }
           if (rs != null) {
              rs.close();
           }
        } catch (SQLException e) {
           // TODO Auto-generated catch block
           throw new MyException(
                 "Lỗi OrderDetailDAO->getTenHang(): không thể đóng st, rs");
        }
     }
}
public static void main(String[] args) throws SQLException, MyException {
	OrderDetailDAO a = new  OrderDetailDAO();
	a.getListSP("HD17");
}
}
