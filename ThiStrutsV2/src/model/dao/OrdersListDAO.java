package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.bean.Order;

import common.MyException;

public class OrdersListDAO extends BaseDAO {
	public ArrayList<Order> getOrdersList() throws MyException {
		ArrayList<Order> ordersList = new ArrayList<Order>();
		openConnection();
		ResultSet rs = null;
		Statement st = null;
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String command = "SELECT MaHD, a.MaKH, b.TenKH, NgayDatHang, NgayGiaoHang, NoiGiaoHang, CONVERT(INT, ROUND(TongTien, 0)) AS TongTien, TinhTrangGiaoHang "
					+ "FROM DONDATHANG a JOIN KHACHHANG b ON a.MaKH = b.MaKH "
					+ "WHERE a.TinhTrang = 1";
			st = con.createStatement();
			rs = st.executeQuery(command);
			if (!rs.isBeforeFirst()) {
				throw new MyException(
						"Result set không có bản ghi nào -> Không có đơn hàng nào trong CSDL");
			} else {
				while (rs.next()) {
					Order order = new Order();
					order.setMaHD(rs.getString("MaHD"));
					order.setMaKH(rs.getString("MaKH"));
					order.setTenKH(rs.getString("TenKH"));
					order.setNgayDatHang(format.format(new java.util.Date(rs
							.getDate("NgayDatHang").getTime())));
					try {
						order.setNgayGiaoHang(format.format(new java.util.Date(
								rs.getDate("NgayGiaoHang").getTime())));
					} catch (NullPointerException exc) {
						order.setNgayGiaoHang("");
					}
					order.setNoiGiaoHang(rs.getString("NoiGiaoHang"));
					order.setTongTien(rs.getString("TongTien"));
					order.setTinhTrangGiaoHang(rs
							.getBoolean("TinhTrangGiaoHang"));
					ordersList.add(order);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return ordersList;
	}
}
