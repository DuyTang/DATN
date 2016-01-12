package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectDB;
import model.bean.SanPhamLapRap1;

public class SanPhamLapRapDAO {
	ConnectDB cn = new ConnectDB();
	PreparedStatement preSt = null;
	public ArrayList<SanPhamLapRap1> getdsSanPhamLapRap() throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
		String sql = " select * from SANPHAMLAPRAP where TinhTrang = 'true' order by MaSPLapRap";
		 Statement st = cn.con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        ArrayList<SanPhamLapRap1> list = new ArrayList<SanPhamLapRap1>();
	        SanPhamLapRap1 ram;
	        while(rs.next()){
	        	ram = new SanPhamLapRap1();
	        	ram.setMaSPLR(rs.getString(1));
	        	ram.setMaMain(rs.getString(2));
	        	ram.setMaRam(rs.getString(3));
				ram.setMaChip(rs.getString(4));
				ram.setMaChuot(rs.getString(5));
				ram.setMaBanPhim(rs.getString(6));
				ram.setMaHDD(rs.getString(7));
				ram.setMaManHinh(rs.getString(8));
	        	ram.setTinhTrang(rs.getString(9));
	        	ram.setSoLuongRam(rs.getString(10));
	        	ram.setMaHD(rs.getString(11));
	        	ram.setMaCase(rs.getString(12));
	        	ram.setMaNguon(rs.getString(13));
	        	ram.setMaDVD(rs.getString(14));
	        	ram.setMaTanNhiet(rs.getString(15));
	        	ram.setMaPhuKien(rs.getString(16));
	        	list.add(ram);
	        }
		return list;
	}
	public ArrayList<SanPhamLapRap1> getdsctSanPhamLapRap(String maSPLR) throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
		String sql = " Select ch.TenChip,c4.TenBoPhan,mb.TenMainboard,r.TenRAM,c2.TenBoPhan,c1.TenBoPhan,c5.TenBoPhan," +
		"c9.TenBoPhan,c6.TenBoPhan,c3.TenBoPhan,c8.TenBoPhan,c7.TenBoPhan,sp.SoLuongRam,sp.MaSPLapRap from SANPHAMLAPRAP sp "+
		" inner join MAINBOARD mb on sp.MaMainboard = mb.MaMainboard"+
		" inner join RAM r on r.MaRAM = sp.MaRAM"+
		" inner join CHIP ch on ch.MaChip = sp. MaChip"+
		" inner join CHITIETBOPHAN c1 on c1.MaChiTiet = sp.MaBanPhim"+
		" inner join CHITIETBOPHAN c2 on c2.MaChiTiet = sp.MaChuot"+
		" inner join CHITIETBOPHAN c3 on c3.MaChiTiet = sp.MaDVD"+
		" inner join CHITIETBOPHAN c4 on c4.MaChiTiet = sp.MaHDD"+
		" inner join CHITIETBOPHAN c5 on c5.MaChiTiet = sp.MaManHinh"+
		" inner join CHITIETBOPHAN c6 on c6.MaChiTiet = sp.MaNguon"+
		" inner join CHITIETBOPHAN c7 on c7.MaChiTiet = sp.MaPhuKien"+
		" inner join CHITIETBOPHAN c8 on c8.MaChiTiet = sp.MaTanNhiet"+
		" inner join CHITIETBOPHAN c9 on c9.MaChiTiet = sp.MaCase"+
		" where MaSPLapRap = '"+maSPLR+"'";
		 Statement st = cn.con.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        ArrayList<SanPhamLapRap1> list = new ArrayList<SanPhamLapRap1>();
	        SanPhamLapRap1 ram;
	        while(rs.next()){
	        	ram = new SanPhamLapRap1();
	        	ram.setTenChip(rs.getString(1));
	        	System.out.println(rs.getString(1));
	        	ram.setTenHDD(rs.getString(2));
	        	ram.setTenMain(rs.getString(3));
	        	ram.setTenRam(rs.getString(4));
	        	ram.setSoLuong(rs.getString(13));
	        	ram.setTenChuot(rs.getString(5));
	        	ram.setTenBanPhim(rs.getString(6));
	        	ram.setTenManHinh(rs.getString(7));
	        	ram.setTenCase(rs.getString(8));
	        	ram.setTenNguon(rs.getString(9));
				ram.setTenDVD(rs.getString(10));
				ram.setTenTanNhiet(rs.getString(11));
	        	ram.setTenPhuKien(rs.getString(12));
	        	ram.setMaSPLR(rs.getString(13));
	        	list.add(ram);
	        }
		return list;
	}

public SanPhamLapRap1 getThongTin(String maSPLR) throws SQLException {
	// TODO Auto-generated method stub
	cn.Connect();
    String sql = "Select ch.TenChip,c4.TenBoPhan,mb.TenMainboard,r.TenRAM,c2.TenBoPhan,c1.TenBoPhan,c5.TenBoPhan," +
		"c9.TenBoPhan,c6.TenBoPhan,c3.TenBoPhan,c8.TenBoPhan,c7.TenBoPhan,sp.SoLuongRam,sp.MaSPLapRap from SANPHAMLAPRAP sp "+
		" inner join MAINBOARD mb on sp.MaMainboard = mb.MaMainboard"+
		" inner join RAM r on r.MaRAM = sp.MaRAM"+
		" inner join CHIP ch on ch.MaChip = sp. MaChip"+
		" inner join CHITIETBOPHAN c1 on c1.MaChiTiet = sp.MaBanPhim"+
		" inner join CHITIETBOPHAN c2 on c2.MaChiTiet = sp.MaChuot"+
		" inner join CHITIETBOPHAN c3 on c3.MaChiTiet = sp.MaDVD"+
		" inner join CHITIETBOPHAN c4 on c4.MaChiTiet = sp.MaHDD"+
		" inner join CHITIETBOPHAN c5 on c5.MaChiTiet = sp.MaManHinh"+
		" inner join CHITIETBOPHAN c6 on c6.MaChiTiet = sp.MaNguon"+
		" inner join CHITIETBOPHAN c7 on c7.MaChiTiet = sp.MaPhuKien"+
		" inner join CHITIETBOPHAN c8 on c8.MaChiTiet = sp.MaTanNhiet"+
		" inner join CHITIETBOPHAN c9 on c9.MaChiTiet = sp.MaCase"+
		" where MaSPLapRap = ?";
    preSt = cn.con.prepareStatement(sql);
    preSt.setString(1, maSPLR);
    ResultSet rs = preSt.executeQuery();
    SanPhamLapRap1 ram = new SanPhamLapRap1();
    while(rs.next()){
    	ram = new SanPhamLapRap1();
    	ram.setTenChip(rs.getString(1));
    	ram.setTenHDD(rs.getString(2));
    	ram.setTenMain(rs.getString(3));
    	ram.setTenRam(rs.getString(4));
    	ram.setSoLuong(rs.getString(13));
    	ram.setTenChuot(rs.getString(5));
    	ram.setTenBanPhim(rs.getString(6));
    	ram.setTenManHinh(rs.getString(7));
    	ram.setTenCase(rs.getString(8));
    	ram.setTenNguon(rs.getString(9));
		ram.setTenDVD(rs.getString(10));
		ram.setTenTanNhiet(rs.getString(11));
    	ram.setTenPhuKien(rs.getString(12));
    	ram.setMaSPLR(rs.getString(13));
    }
    cn.Disconnect();
    return ram;
}
}
