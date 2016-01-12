package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ChiTietBoPhan;
import model.bean.SanPhamLapRap;

public class ChiTietBoPhanDAO {
	ConnectionDB con = new ConnectionDB();

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanHDD()
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from ChiTietBoPhan where MaLoai = 'MaHDD'";
			ResultSet rs = st.executeQuery(sql);

			ChiTietBoPhan chiTietBoPhan;
			while (rs.next()) {
				chiTietBoPhan = new ChiTietBoPhan();
				chiTietBoPhan.setMaChiTiet(rs.getString("MaChiTiet"));
				chiTietBoPhan.setTenBoPhan(rs.getString("TenBoPhan"));
				chiTietBoPhan.setGia(rs.getInt("Gia"));
				chiTietBoPhan.setSoLuong(rs.getInt("SoLuong"));
				chiTietBoPhan.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chiTietBoPhan.setTinhTrang(rs.getBoolean("TinhTrang"));
				String and = rs.getInt("Gia") + "-" + rs.getString("MaChiTiet");
				chiTietBoPhan.setGiaVaMa(and);
				list.add(chiTietBoPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanChuot()
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from ChiTietBoPhan where MaLoai = 'MaChuot'";
			ResultSet rs = st.executeQuery(sql);
			ChiTietBoPhan chiTietBoPhan;
			while (rs.next()) {
				chiTietBoPhan = new ChiTietBoPhan();
				chiTietBoPhan.setMaChiTiet(rs.getString("MaChiTiet"));
				chiTietBoPhan.setTenBoPhan(rs.getString("TenBoPhan"));
				chiTietBoPhan.setGia(rs.getInt("Gia"));
				chiTietBoPhan.setSoLuong(rs.getInt("SoLuong"));
				chiTietBoPhan.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chiTietBoPhan.setTinhTrang(rs.getBoolean("TinhTrang"));
				String and = rs.getInt("Gia") + "-" + rs.getString("MaChiTiet");
				chiTietBoPhan.setGiaVaMa(and);
				list.add(chiTietBoPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanManHinh()
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from ChiTietBoPhan where MaLoai = 'MaManHinh'";

			ResultSet rs = st.executeQuery(sql);

			ChiTietBoPhan chiTietBoPhan;
			while (rs.next()) {
				chiTietBoPhan = new ChiTietBoPhan();
				chiTietBoPhan.setMaChiTiet(rs.getString("MaChiTiet"));
				chiTietBoPhan.setTenBoPhan(rs.getString("TenBoPhan"));
				chiTietBoPhan.setGia(rs.getInt("Gia"));
				chiTietBoPhan.setSoLuong(rs.getInt("SoLuong"));
				chiTietBoPhan.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chiTietBoPhan.setTinhTrang(rs.getBoolean("TinhTrang"));
				String and = rs.getInt("Gia") + "-" + rs.getString("MaChiTiet");
				chiTietBoPhan.setGiaVaMa(and);
				list.add(chiTietBoPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanBanPhim()
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from ChiTietBoPhan where MaLoai = 'MaBanPhim'";
			ResultSet rs = st.executeQuery(sql);

			ChiTietBoPhan chiTietBoPhan;
			while (rs.next()) {
				chiTietBoPhan = new ChiTietBoPhan();
				chiTietBoPhan.setMaChiTiet(rs.getString("MaChiTiet"));
				chiTietBoPhan.setTenBoPhan(rs.getString("TenBoPhan"));
				chiTietBoPhan.setGia(rs.getInt("Gia"));
				chiTietBoPhan.setSoLuong(rs.getInt("SoLuong"));
				chiTietBoPhan.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chiTietBoPhan.setTinhTrang(rs.getBoolean("TinhTrang"));
				String and = rs.getInt("Gia") + "-" + rs.getString("MaChiTiet");
				chiTietBoPhan.setGiaVaMa(and);
				list.add(chiTietBoPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanCase()
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from ChiTietBoPhan where MaLoai = 'MaCase'";
			ResultSet rs = st.executeQuery(sql);

			ChiTietBoPhan chiTietBoPhan;
			while (rs.next()) {
				chiTietBoPhan = new ChiTietBoPhan();
				chiTietBoPhan.setMaChiTiet(rs.getString("MaChiTiet"));
				chiTietBoPhan.setTenBoPhan(rs.getString("TenBoPhan"));
				chiTietBoPhan.setGia(rs.getInt("Gia"));
				chiTietBoPhan.setSoLuong(rs.getInt("SoLuong"));
				chiTietBoPhan.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chiTietBoPhan.setTinhTrang(rs.getBoolean("TinhTrang"));
				String and = rs.getInt("Gia") + "-" + rs.getString("MaChiTiet");
				chiTietBoPhan.setGiaVaMa(and);
				list.add(chiTietBoPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanNguon()
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from ChiTietBoPhan where MaLoai = 'MaNguon'";
			ResultSet rs = st.executeQuery(sql);

			ChiTietBoPhan chiTietBoPhan;
			while (rs.next()) {
				chiTietBoPhan = new ChiTietBoPhan();
				chiTietBoPhan.setMaChiTiet(rs.getString("MaChiTiet"));
				chiTietBoPhan.setTenBoPhan(rs.getString("TenBoPhan"));
				chiTietBoPhan.setGia(rs.getInt("gia"));
				chiTietBoPhan.setSoLuong(rs.getInt("SoLuong"));
				chiTietBoPhan.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chiTietBoPhan.setTinhTrang(rs.getBoolean("TinhTrang"));
				String and = rs.getInt("Gia") + "-" + rs.getString("MaChiTiet");
				chiTietBoPhan.setGiaVaMa(and);
				list.add(chiTietBoPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanPhuKien()
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from ChiTietBoPhan where MaLoai = 'MaPhuKien'";
			ResultSet rs = st.executeQuery(sql);

			ChiTietBoPhan chiTietBoPhan;
			while (rs.next()) {
				chiTietBoPhan = new ChiTietBoPhan();
				chiTietBoPhan.setMaChiTiet(rs.getString("MaChiTiet"));
				chiTietBoPhan.setTenBoPhan(rs.getString("TenBoPhan"));
				chiTietBoPhan.setGia(rs.getInt("gia"));
				chiTietBoPhan.setSoLuong(rs.getInt("SoLuong"));
				chiTietBoPhan.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chiTietBoPhan.setTinhTrang(rs.getBoolean("TinhTrang"));
				String and = rs.getInt("Gia") + "-" + rs.getString("MaChiTiet");
				chiTietBoPhan.setGiaVaMa(and);
				list.add(chiTietBoPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanDVD()
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from ChiTietBoPhan where MaLoai = 'MaDVD'";
			ResultSet rs = st.executeQuery(sql);

			ChiTietBoPhan chiTietBoPhan;
			while (rs.next()) {
				chiTietBoPhan = new ChiTietBoPhan();
				chiTietBoPhan.setMaChiTiet(rs.getString("MaChiTiet"));
				chiTietBoPhan.setTenBoPhan(rs.getString("TenBoPhan"));
				chiTietBoPhan.setGia(rs.getInt("gia"));
				chiTietBoPhan.setSoLuong(rs.getInt("SoLuong"));
				chiTietBoPhan.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chiTietBoPhan.setTinhTrang(rs.getBoolean("TinhTrang"));
				String and = rs.getInt("Gia") + "-" + rs.getString("MaChiTiet");
				chiTietBoPhan.setGiaVaMa(and);
				list.add(chiTietBoPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanTanNhiet()
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			st = con.cn.createStatement();
			String sql = "select * from ChiTietBoPhan where MaLoai = 'MaTanNhiet'";
			ResultSet rs = st.executeQuery(sql);
			ChiTietBoPhan chiTietBoPhan;
			while (rs.next()) {
				chiTietBoPhan = new ChiTietBoPhan();
				chiTietBoPhan.setMaChiTiet(rs.getString("MaChiTiet"));
				chiTietBoPhan.setTenBoPhan(rs.getString("TenBoPhan"));
				chiTietBoPhan.setGia(rs.getInt("gia"));
				chiTietBoPhan.setSoLuong(rs.getInt("SoLuong"));
				chiTietBoPhan.setThoiGianBH(rs.getInt("ThoiGianBH"));
				chiTietBoPhan.setTinhTrang(rs.getBoolean("TinhTrang"));
				String and = rs.getInt("Gia") + "-" + rs.getString("MaChiTiet");
				chiTietBoPhan.setGiaVaMa(and);
				list.add(chiTietBoPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

		return list;
	}

	public SanPhamLapRap getChuot(String chuot1) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst = con.cn
				.prepareStatement("select ct.MaChiTiet,TenBoPhan from CHITIETBOPHAN ct where MaChiTiet = ? ");
		pst.setString(1, chuot1);
		ResultSet rs = pst.executeQuery();
		SanPhamLapRap sp = new SanPhamLapRap();
		while (rs.next()) {
			sp.setMaChuot(rs.getString("MaChiTiet"));
			sp.setTenChuot(rs.getString("TenBoPhan"));
		}
		return sp;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanChuot(String chuot1)
			throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst = con.cn
				.prepareStatement("select ct.MaChiTiet,TenBoPhan,Gia,ThoiGianBH from CHITIETBOPHAN ct where MaChiTiet = ? ");
		pst.setString(1, chuot1);
		ResultSet rs = pst.executeQuery();
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		ChiTietBoPhan ct;
		while (rs.next()) {
			ct = new ChiTietBoPhan();
			ct.setMaChiTiet(rs.getString("MaChiTiet"));
			ct.setTenBoPhan(rs.getString("TenBoPhan"));
			ct.setGia(rs.getInt("Gia"));
			ct.setThoiGianBH(rs.getInt("ThoiGianBH"));
			list.add(ct);
		}
		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanHDD(String hdd1) {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			pst = con.cn
					.prepareStatement("select ct.MaChiTiet,TenBoPhan,Gia,ThoiGianBH from CHITIETBOPHAN ct where MaChiTiet = ? ");
			pst.setString(1, hdd1);
			ResultSet rs = pst.executeQuery();
			ChiTietBoPhan ct;
			while (rs.next()) {
				ct = new ChiTietBoPhan();
				ct.setMaChiTiet(rs.getString("MaChiTiet"));
				ct.setTenBoPhan(rs.getString("TenBoPhan"));
				ct.setGia(rs.getInt("Gia"));
				ct.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanBanPhim(String banPhim1) {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<ChiTietBoPhan> list = new ArrayList<ChiTietBoPhan>();
		try {
			pst = con.cn
					.prepareStatement("select ct.MaChiTiet,TenBoPhan,Gia,ThoiGianBH from CHITIETBOPHAN ct where MaChiTiet = ? ");
			pst.setString(1, banPhim1);
			ResultSet rs = pst.executeQuery();
			ChiTietBoPhan ct;
			while (rs.next()) {
				ct = new ChiTietBoPhan();
				ct.setMaChiTiet(rs.getString("MaChiTiet"));
				ct.setTenBoPhan(rs.getString("TenBoPhan"));
				ct.setGia(rs.getInt("Gia"));
				ct.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanManHinh(String manHinh1) {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<ChiTietBoPhan>list = new ArrayList<ChiTietBoPhan>();
		try {
			pst = con.cn.prepareStatement("select ct.MaChiTiet,TenBoPhan,Gia,ThoiGianBH from CHITIETBOPHAN ct where MaChiTiet = ? ");
			pst.setString(1, manHinh1);
			ResultSet rs = pst.executeQuery();		
			ChiTietBoPhan ct;
			while(rs.next()){
				ct = new ChiTietBoPhan();
				ct.setMaChiTiet(rs.getString("MaChiTiet"));
				ct.setTenBoPhan(rs.getString("TenBoPhan"));
				ct.setGia(rs.getInt("Gia"));
				ct.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanCase(String caseS1) {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<ChiTietBoPhan>list = new ArrayList<ChiTietBoPhan>();
		try {
			pst = con.cn.prepareStatement("select ct.MaChiTiet,TenBoPhan,Gia,ThoiGianBH from CHITIETBOPHAN ct where MaChiTiet = ? ");
			pst.setString(1,caseS1);
			ResultSet rs = pst.executeQuery();		
			ChiTietBoPhan ct;
			while(rs.next()){
				ct = new ChiTietBoPhan();
				ct.setMaChiTiet(rs.getString("MaChiTiet"));
				ct.setTenBoPhan(rs.getString("TenBoPhan"));
				ct.setGia(rs.getInt("Gia"));
				ct.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanNguon(String nguon1) {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<ChiTietBoPhan>list = new ArrayList<ChiTietBoPhan>();
		try {
			pst = con.cn.prepareStatement("select ct.MaChiTiet,TenBoPhan,Gia,ThoiGianBH from CHITIETBOPHAN ct where MaChiTiet = ? ");
			pst.setString(1, nguon1);
			ResultSet rs = pst.executeQuery();		
			ChiTietBoPhan ct;
			while(rs.next()){
				ct = new ChiTietBoPhan();
				ct.setMaChiTiet(rs.getString("MaChiTiet"));
				ct.setTenBoPhan(rs.getString("TenBoPhan"));
				ct.setGia(rs.getInt("Gia"));
				ct.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanDVD(String dvd1) {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<ChiTietBoPhan>list = new ArrayList<ChiTietBoPhan>();
		try {
			pst = con.cn.prepareStatement("select ct.MaChiTiet,TenBoPhan,Gia,ThoiGianBH from CHITIETBOPHAN ct where MaChiTiet = ? ");
			pst.setString(1, dvd1);
			ResultSet rs = pst.executeQuery();		
			ChiTietBoPhan ct;
			while(rs.next()){
				ct = new ChiTietBoPhan();
				ct.setMaChiTiet(rs.getString("MaChiTiet"));
				ct.setTenBoPhan(rs.getString("TenBoPhan"));
				ct.setGia(rs.getInt("Gia"));
				ct.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanTanNhiet(String tanNhiet1) {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<ChiTietBoPhan>list = new ArrayList<ChiTietBoPhan>();
		try {
			pst = con.cn.prepareStatement("select ct.MaChiTiet,TenBoPhan,Gia,ThoiGianBH from CHITIETBOPHAN ct where MaChiTiet = ? ");
			pst.setString(1, tanNhiet1);
			ResultSet rs = pst.executeQuery();		
			ChiTietBoPhan ct;
			while(rs.next()){
				ct = new ChiTietBoPhan();
				ct.setMaChiTiet(rs.getString("MaChiTiet"));
				ct.setTenBoPhan(rs.getString("TenBoPhan"));
				ct.setGia(rs.getInt("Gia"));
				ct.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanPhuKien(String phuKien1) {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<ChiTietBoPhan>list = new ArrayList<ChiTietBoPhan>();
		try {
			pst = con.cn.prepareStatement("select ct.MaChiTiet,TenBoPhan,Gia,ThoiGianBH from CHITIETBOPHAN ct where MaChiTiet = ? ");
			pst.setString(1, phuKien1);
			ResultSet rs = pst.executeQuery();		
			ChiTietBoPhan ct;
			while(rs.next()){
				ct = new ChiTietBoPhan();
				ct.setMaChiTiet(rs.getString("MaChiTiet"));
				ct.setTenBoPhan(rs.getString("TenBoPhan"));
				ct.setGia(rs.getInt("Gia"));
				ct.setThoiGianBH(rs.getInt("ThoiGianBH"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
