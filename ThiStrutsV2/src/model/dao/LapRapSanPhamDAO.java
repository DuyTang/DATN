package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.SanPhamLapRap;
public class LapRapSanPhamDAO {
	ConnectionDB con = new ConnectionDB();
	Statement stm = null;
	ResultSet rs= null;
	public void addLapRap(String maSPLapRap,String main1, String ram1, String chip1,
			String chuot1, String banPhim1, String hdd1, String manHinh1,
			boolean tinhTrang, int soLuongRam,String maHD, String caseS1, String nguon1,
			String dvd1, String tanNhiet1, String phuKien1) throws SQLException  {
		// TODO Auto-generated method stub
			con.ConnectionData();
			PreparedStatement pst;
			stm = con.cn.createStatement();
			pst = con.cn.prepareStatement("insert into SANPHAMLAPRAP(MaSPLapRap,MaMainboard,MaRAM,MaChip,MaChuot,MaBanPhim,MaHDD,MaManHinh,TinhTrang,SoLuongRAM,MaHD,MaCase,MaNguon,MaDVD,MaTanNhiet,MaPhuKien) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, maSPLapRap);
			pst.setString(2, main1);
			pst.setString(3, ram1);
			pst.setString(4, chip1);
			pst.setString(5, chuot1);
			pst.setString(6, banPhim1);
			pst.setString(7, hdd1);
			pst.setString(8, manHinh1);
			pst.setBoolean(9, tinhTrang);
			pst.setInt(10, soLuongRam);
			pst.setString(11, maHD);
			pst.setString(12, caseS1);
			pst.setString(13, nguon1);
			pst.setString(14, dvd1);
			pst.setString(15, tanNhiet1);
			pst.setString(16, phuKien1);
			pst.executeUpdate();
			// Tru so luong main
			String sql1 = "update MAINBOARD set SoLuong = SoLuong - 1 where MaMainboard = '"+main1+"'";
			stm.executeUpdate(sql1);
			// Tru so luong chip
			String sql2 = "update CHIP set SoLuong = SoLuong - 1 where MaChip = '"+chip1+"'";
			stm.executeUpdate(sql2);
			//Tru so luong ram
			String sql3 = "update RAM set SoLuong = SoLuong - "+soLuongRam+" where MaRam = '"+ram1+"'";
			stm.executeUpdate(sql3);
			//Tru so luong chuot
			String sql4 = "update CHITIETBOPHAN set SoLuong = SoLuong - 1 where MaChiTiet = '"+chuot1+"'";
			stm.executeUpdate(sql4);
			//Tru so luong ban phim
			String sql5 = "update CHITIETBOPHAN set SoLuong = SoLuong - 1 where MaChiTiet = '"+banPhim1+"'";
			stm.executeUpdate(sql5);
			//Tru so luong hdd
			String sql6 = "update CHITIETBOPHAN set SoLuong = SoLuong - 1 where MaChiTiet = '"+hdd1+"'";
			stm.executeUpdate(sql6);
			//Tru so luong man hinh
			String sql7 = "update CHITIETBOPHAN set SoLuong = SoLuong - 1 where MaChiTiet = '"+manHinh1+"'";
			stm.executeUpdate(sql7);
			//Tru so luong case
			String sql8 = "update CHITIETBOPHAN set SoLuong = SoLuong - 1 where MaChiTiet = '"+caseS1+"'";
			stm.executeUpdate(sql8);
			//Tru so luong nguon
			String sql9 = "update CHITIETBOPHAN set SoLuong = SoLuong - 1 where MaChiTiet = '"+nguon1+"'";
			stm.executeUpdate(sql9);
			//Tru so luong DVD
			String sql10 = "update CHITIETBOPHAN set SoLuong = SoLuong - 1 where MaChiTiet = '"+dvd1+"'";
			stm.executeUpdate(sql10);
			//Tru so luong tan nhiet
			String sql11 = "update CHITIETBOPHAN set SoLuong = SoLuong - 1 where MaChiTiet = '"+tanNhiet1+"'";
			stm.executeUpdate(sql11);
			//Tru so luong phu kien
			String sql12 = "update CHITIETBOPHAN set SoLuong = SoLuong - 1 where MaChiTiet = '"+phuKien1+"'";
			stm.executeUpdate(sql12);
			
			con.cn.close();
		}
	public String getMaSPLapRapDesc() throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st;
		String maSpLapRap = null; 
		try {
			st = con.cn.createStatement();
			String sql = "SELECT TOP 1 MaSPLapRap FROM SANPHAMLAPRAP ORDER BY MaSpLapRap DESC";
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			maSpLapRap= rs.getString("MaSPLapRap");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.cn.close();
		}
		return maSpLapRap;
	}
	public ArrayList<SanPhamLapRap> getListSanPhamLapRap(String maSPLapRap) throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		ArrayList<SanPhamLapRap>list =  new ArrayList<SanPhamLapRap>();
		try {
			pst = con.cn.prepareStatement("select dh.TongTien from SANPHAMLAPRAP splr inner join DONDATHANG dh on dh.MaHD = splr.MaHD where splr.MaSPLapRap = ?");
			pst.setString(1, maSPLapRap);
			ResultSet rs = pst.executeQuery();
		
			SanPhamLapRap sp;
			while(rs.next()){
				sp = new SanPhamLapRap();
				sp.setTongTien(rs.getInt("TongTien"));
				list.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.cn.close();
		}
		
		return list;
		
	}
		
	}


