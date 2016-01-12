package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DonDatHangDAO {
	ConnectionDB con = new ConnectionDB();

	public void addDonDatHang(String maHD, String maKH, String ngayDatHang,
			String diaChi, String tongTien, boolean tinhTrang,
			boolean tinhTrangGiaoHang) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		try {
			pst = con.cn
					.prepareStatement("insert into DONDATHANG(MaHD,MaKH,NgayDatHang,NoiGiaoHang,TongTien,TinhTrang," +
							"TinhTrangGiaoHang) values(?,?,?,?,?,?,?)");
			pst.setString(1, maHD);
			pst.setString(2, maKH);
			Date date = new Date();
			pst.setDate(3, new java.sql.Date(date.getTime()));			
			pst.setString(4, diaChi);
			pst.setString(5, String.valueOf(tongTien));
			pst.setBoolean(6, tinhTrang);
			pst.setBoolean(7, tinhTrangGiaoHang);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

	}

	public String getMaKHDesc() throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		st = con.cn.createStatement();
		String sql = "SELECT TOP 1 MaHD FROM DONDATHANG ORDER BY MaHD DESC";
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		return rs.getString("maHD");
	}

}
