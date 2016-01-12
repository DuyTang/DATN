package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.OrderDetail;
import model.bean.OrderInfor;
import common.MyException;

public class OrderDetailListDAO extends BaseDAO {

	public ArrayList<OrderDetail> getOrderDetailList(String maHD)
			throws MyException {
		// TODO Auto-generated method stub
		ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		openConnection();
		ResultSet rs = null;
		PreparedStatement preSt = null;
		try {
			String command = "SELECT MaHD, TenSP, IMEI,CONVERT(INT, ROUND(b.GiaBanSP, 0)) AS GiaBanSP, MaChiTietDonDatHang "
					+ "FROM SANPHAM a JOIN CHITIETDONDATHANG b ON a.MaLoaiSP = b.MaLoaiSP "
					+ "WHERE MaHD = ? AND b.TinhTrang = 1";
			preSt = con.prepareStatement(command);
			preSt.setString(1, maHD);
			rs = preSt.executeQuery();
			if (!rs.isBeforeFirst()) {
				throw new MyException("Đơn hàng này chưa có sản phẩm nào.");
			} else {
				while (rs.next()) {
					OrderDetail orderDetail = new OrderDetail();
					orderDetail.setMaHD(rs.getString("MaHD"));
					orderDetail.setTenSP(rs.getString("TenSP"));
					orderDetail.setImei(rs.getString("IMEI"));
					orderDetail.setGiaBan(rs.getString("GiaBanSP"));
					orderDetail.setMaChiTietDonHang(rs
							.getString("MaChiTietDonDatHang"));
					orderDetailList.add(orderDetail);
				}
			}
		} catch (Exception e) {
			throw new MyException(e.getMessage());
		} finally {
			closeConnection();
			try {
				if (rs != null) {
					rs.close();
				}
				if (preSt != null) {
					preSt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MyException(
						"Lỗi: OrderDetailListDAO->getOrderDetailList(): không thể đóng preSt, rs.");
			}
		}
		return orderDetailList;
	}

	public OrderInfor getOrderInfor(String maHD) throws MyException {
		// TODO Auto-generated method stub
		openConnection();
		ResultSet rs = null;
		PreparedStatement preSt = null;
		try {
			String command = "SELECT b.TenKH, a.NgayDatHang, a.NoiGiaoHang, a.TinhTrangGiaoHang "
					+ "FROM DONDATHANG a JOIN KHACHHANG b ON a.MaKH = b.MaKH "
					+ "WHERE a.MaHD = ?";
			preSt = con.prepareStatement(command);
			preSt.setString(1, maHD);
			rs = preSt.executeQuery();
			if (!rs.isBeforeFirst()) {
				throw new MyException("Không có đơn hàng có mã " + maHD);
			} else {
				rs.next();
				OrderInfor orderInfor = new OrderInfor();
				orderInfor.setTenKH(rs.getString("TenKH"));
				orderInfor.setNgayDatHang(rs.getString("NgayDatHang"));
				orderInfor.setNoiGiaoHang(rs.getString("NoiGiaoHang"));
				orderInfor.setTinhTrangGiaoHang(rs.getString("TinhTrangGiaoHang"));
				return orderInfor;
			}
		} catch (Exception e) {
			throw new MyException(e.getMessage());
		} finally {
			closeConnection();
			try {
				if (rs != null) {
					rs.close();
				}
				if (preSt != null) {
					preSt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MyException(
						"Lỗi: OrderDetailListDAO->getOrderInfor(): không thể đóng preSt, rs.");
			}
		}
	}
}