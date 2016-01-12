package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.Order;
import model.bean.SanPhamBean;
import common.ConnectDB;
import common.MyException;
import common.Validate;

public class OrderDAO extends BaseDAO {
	ConnectDB cn = new ConnectDB();
	public String getTheLargestNumberOfMaHD() throws MyException {
		// TODO Auto-generated method stub
		openConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			String command = "SELECT TOP 1 MaHD FROM DONDATHANG ORDER BY MaHD DESC";
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

	public void addOrder(String maHD, String maKH, Date ngayDatHang,
			Date ngayGiaoHang, String noiGiaoHang, String tongTien,
			String tinhTrangGiaoHang) throws MyException {
		// TODO Auto-generated method stub
		openConnection();
		PreparedStatement preSt = null;
		try {
			String command = "INSERT INTO DONDATHANG(MaHD, MaKH, NgayDatHang, "
					+ "NgayGiaoHang, NoiGiaohang, TongTien, TinhTrangGiaoHang, TinhTrang) "
					+ "VALUES(?,?,?,?,?,?,?,1)";
			preSt = con.prepareStatement(command);
			preSt.setString(1, maHD);
			preSt.setString(2, maKH);
			preSt.setDate(3, new java.sql.Date(ngayDatHang.getTime()));
			if (ngayGiaoHang != null) {
				preSt.setDate(4, new java.sql.Date(ngayGiaoHang.getTime()));
			} else {
				preSt.setDate(4, null);
			}
			preSt.setString(5, noiGiaoHang);
			preSt.setString(6, tongTien);
			preSt.setString(7, tinhTrangGiaoHang);
			preSt.executeUpdate();
		} catch (Exception e) {
			throw new MyException("Lỗi OrderDAO->addOrder(): " + e.getMessage());
		} finally {
			closeConnection();
			try {
				if (preSt != null) {
					preSt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MyException(
						"Lỗi OrderDAO->addOrder(): không thể đóng preSt");
			}
		}
	}

	@SuppressWarnings("resource")
	public void editOrder(String maHD, String maKH, Date ngayDatHang,
			Date ngayGiaoHang, String noiGiaoHang, String tongTien,
			String tinhTrangGiaoHang) throws MyException {
		// TODO Auto-generated method stub
		PreparedStatement preSt = null;
		ResultSet rs = null;
		boolean notError = true;
		// kiem tra tat ca don dat hang deu phai co imei moi cho phep cap nhat
		// la da giao hang
		if ("0".equals(tinhTrangGiaoHang)) {
			try {
				openConnection();
				String command = "SELECT IMEI FROM CHITIETDONDATHANG WHERE MaHD = ? AND TinhTrang = 1";
				preSt = con.prepareStatement(command);
				preSt.setString(1, maHD);
				rs = preSt.executeQuery();
				if (!rs.isBeforeFirst()) {
					throw new MyException(
							"Đơn hàng này không có sản phẩm nào, không thể đặt là đã giao");
				}
				while (rs.next()) {
					if (!Validate.isValidImei(rs.getString("IMEI"))) {
						throw new MyException(
								"Trong đơn hàng có chứa Imei không hợp lệ, hãy kiểm tra lại.");
					}
				}
			} catch (Exception e) {
				notError = false;
				System.out.println( e.getMessage());
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
			}
		}
		if (notError) {
			// tien hanh cap nhat
			try {
				openConnection();
				String command = "UPDATE DONDATHANG SET MaKH = ?, NgayDatHang = ?, "
						+ "NgayGiaoHang = ?, NoiGiaoHang = ?, TongTien = ?, "
						+ "TinhTrangGiaoHang = ? WHERE MaHD = ? AND TinhTrang = 1";
				preSt = con.prepareStatement(command);
				preSt.setString(1, maKH);
				preSt.setDate(2, new java.sql.Date(ngayDatHang.getTime()));
				preSt.setDate(3, new java.sql.Date(ngayGiaoHang.getTime()));
				preSt.setString(4, noiGiaoHang);
				preSt.setString(5, tongTien);
				preSt.setString(6, tinhTrangGiaoHang);
				preSt.setString(7, maHD);
				preSt.executeUpdate();
			} catch (Exception e) {
				throw new MyException("Lỗi: OrderDAO->editOrder(): "
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
							"Lỗi OrderDAO->editOrder(): không thể đóng preSt");
				}
			}
		}
	}

	public Order getOrder(String maHD) throws MyException {
		// TODO Auto-generated method stub
		openConnection();
		PreparedStatement preSt = null;
		ResultSet rs = null;
		try {
			String command = "SELECT MaHD, MaKH, NgayDatHang, NgayGiaoHang, "
					+ "NoiGiaoHang, CONVERT(INT, ROUND(TongTien, 0)) AS TongTien, TinhTrangGiaoHang "
					+ "FROM DONDATHANG WHERE MaHD = ? AND TinhTrang = 1";
			preSt = con.prepareStatement(command);
			preSt.setString(1, maHD);
			rs = preSt.executeQuery();
			if (!rs.isBeforeFirst()) {
				throw new MyException(
						"Lỗi OrderDAO->getOrder(): không có đơn hàng nào có mã "
								+ maHD);
			} else {
				rs.next();
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Order order = new Order();
				order.setMaHD(rs.getString("MaHD"));
				order.setMaKH(rs.getString("MaKH"));
				order.setNgayDatHang(format.format(new java.util.Date(rs
						.getDate("NgayDatHang").getTime())));
				try {
					order.setNgayGiaoHang(format.format(new java.util.Date(rs
							.getDate("NgayGiaoHang").getTime())));
				} catch (NullPointerException exc) {
					order.setNgayGiaoHang("");
				}
				order.setNoiGiaoHang(rs.getString("NoiGiaoHang"));
				order.setTongTien(rs.getString("TongTien"));
				order.setTinhTrangGiaoHang(rs.getBoolean("TinhTrangGiaoHang"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Lỗi OrderDAO->getOrder(): " + e.getMessage());
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
						"Lỗi OrderDAO->getOrder(): không thể đóng preSt, rs");
			}
		}
	}

	public void deleteOrder(String maHD) throws MyException {
		// TODO Auto-generated method stub
		openConnection();
		PreparedStatement preSt = null;
		try {
			String command = "UPDATE DONDATHANG SET TinhTrang = 0 WHERE "
					+ "MaHD = ?";
			preSt = con.prepareStatement(command);
			preSt.setString(1, maHD);
			preSt.executeUpdate();
		} catch (Exception e) {
			throw new MyException("Lỗi OrderDAO->deleteOrder(): "
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
						"Lỗi OrderDAO->deleteOrder(): không thể đóng preSt");
			}
		}
	}

	public boolean isExistedCustomer(String maKH) {
		PreparedStatement preSt = null;
		ResultSet rs = null;
		try {
			openConnection();
			String command = "SELECT MaKH FROM KHACHHANG WHERE MaKH = ? AND TinhTrang = 1";
			preSt = con.prepareStatement(command);
			preSt.setString(1, maKH);
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

	public String getSoLuongBanThoiGian1(String thoiGian1) {
		openConnection();
		String thoiGian[] = thoiGian1.split("-");

		String cauLenh = "select count(chitietdondathang.maloaisp) from SANPHAM inner join CHITIETDONDATHANG on SANPHAM.MaLoaiSP = CHITIETDONDATHANG.MaLoaiSP inner join "
				+ "DONDATHANG on DONDATHANG.MaHD = CHITIETDONDATHANG.MaHD "
				+ "where YEAR(DONDATHANG.NgayDatHang)"
				+ " = '"
				+ thoiGian[1]
				+ "' and MONTH(DONDATHANG.NgayDatHang) = '"
				+ thoiGian[0]
				+ "' and DONDATHANG.TinhTrangGiaoHang = '0'";
		Statement st = null;
		ResultSet rs = null;
		String soTraVe = "";
		try {
			st = con.createStatement();
			rs = st.executeQuery(cauLenh);
			rs.next();
			soTraVe = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return soTraVe;
	}

	public String getSoLuongBanThoiGian12(String thoiGian1) {
		// TODO Auto-generated method stub
		openConnection();

		String cauLenh = "select count(chitietdondathang.maloaisp) from SANPHAM inner join CHITIETDONDATHANG on SANPHAM.MaLoaiSP = CHITIETDONDATHANG.MaLoaiSP inner join "
				+ "DONDATHANG on DONDATHANG.MaHD = CHITIETDONDATHANG.MaHD "
				+ "where YEAR(DONDATHANG.NgayDatHang)"
				+ " = '"
				+ thoiGian1
				+ "' and DONDATHANG.TinhTrangGiaoHang = '0'";
		Statement st = null;
		ResultSet rs = null;
		String soTraVe = "";
		try {
			st = con.createStatement();
			rs = st.executeQuery(cauLenh);
			rs.next();
			soTraVe = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return soTraVe;
	}

	public ArrayList<String> getListTen() {
		openConnection();
		String cauLenh = "select tenHang from hangSanPham";
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> arrTen = new ArrayList<String>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(cauLenh);
			while (rs.next()) {
				arrTen.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrTen;
	}

	public ArrayList<String> getListGiaTri(ArrayList<String> ten) {
		openConnection();
		String cauLenh = "";
		ArrayList<String> giaTri = new ArrayList<String>();
		try {
			Statement st = con.createStatement();

			for (int i = 0; i < ten.size(); i++) {
				cauLenh = "select count(chitietdondathang.maloaisp) from SANPHAM inner join CHITIETDONDATHANG on SANPHAM.MaLoaiSP = CHITIETDONDATHANG.MaLoaiSP inner join DONDATHANG on DONDATHANG.MaHD = CHITIETDONDATHANG.MaHD inner join HANGSANPHAM on HANGSANPHAM.MaHang = SANPHAM.MaHang where DONDATHANG.TinhTrangGiaoHang = '0' and TenHang like '"
						+ ten.get(i) + "' ";
			ResultSet rs = st.executeQuery(cauLenh);
			rs.next();
			giaTri.add(rs.getString(1));
			rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return giaTri;
	}

	public ArrayList<String> getListGiaTriThang(String nam) {
		openConnection();
		String cauLenh = "";
		ArrayList<String> arr = new ArrayList<String>();
		try {
			Statement st = con.createStatement();
			for (int i = 1; i < 13; i++) {
				cauLenh = "select count(chitietdondathang.maloaisp) from SANPHAM inner join CHITIETDONDATHANG on SANPHAM.MaLoaiSP = CHITIETDONDATHANG.MaLoaiSP inner join DONDATHANG on DONDATHANG.MaHD = CHITIETDONDATHANG.MaHD where MONTH(DONDATHANG.NgayDatHang) = '"+i+"' and YEAR (DONDATHANG.NgayDatHang) = '"+nam+"' ";
				ResultSet rs = st.executeQuery(cauLenh);
				rs.next();
				arr.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arr;
	}

	public String getMaHoaDon() throws SQLException, MyException {
		// TODO Auto-generated method stub
		openConnection();
		openConnection();
	     Statement st = null;
	     ResultSet rs = null;
	     try {
	    	 String sql = "Select top 1 MaHD from DONDATHANG order by MaHD desc";
	        st = con.createStatement();
	        rs = st.executeQuery(sql);
	        if (!rs.isBeforeFirst()) {
	           throw new MyException(
	                 "Không có hóa đơn nào được tìm thấy");
	        } else {
	        	String maHD = null;
	        	while (rs.next()) {
	        		maHD = rs.getString(1);
	        		
	        	}
	        	return maHD;
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
		OrderDAO a = new OrderDAO();
		System.out.println(a.getMaHoaDon());
	}
}
