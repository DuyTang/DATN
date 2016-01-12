package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectDB;
import model.bean.BoPhan;
public class BoPhanDAO {
	ConnectDB cn = new  ConnectDB();
	PreparedStatement preSt = null;
	public ArrayList<BoPhan> getListBoPhan() {
		// TODO Auto-generated method stub
		cn.Connect();
		String sql=	"select bp.MaChiTiet,bp.MaLoai,bp.TenBoPhan,bp.Gia,bp.SoLuong,bp.ThoiGianBH,lbp.TenLoai "
						+"from CHITIETBOPHAN bp inner join LOAIBOPHAN lbp on bp.MaLoai = lbp.MaLoai where bp.TinhTrang='True'";
		ResultSet rs = null;
		try {
			Statement stmt = cn.con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BoPhan> list = new ArrayList<BoPhan>();
		BoPhan boPhan;
		try {
			while(rs.next()){
				boPhan = new BoPhan();
				boPhan.setMaChiTiet(rs.getString(1));
				boPhan.setTenLoai(rs.getString("TenLoai"));
				boPhan.setTenChiTiet(rs.getString(3));
				String giaBan = rs.getString(4).substring(0,rs.getString(4).length()-5);
				boPhan.setGia(giaBan);
				boPhan.setSoLuong(rs.getString(5));
				boPhan.setThoiGianBH(rs.getString(6));
				list.add(boPhan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<BoPhan> getListBoPhan(String maLoai) {
		// TODO Auto-generated method stub
		cn.Connect();
		String sql=	"select bp.MaChiTiet,bp.MaLoai,bp.TenBoPhan,bp.Gia,bp.SoLuong,bp.ThoiGianBH,lbp.TenLoai "
						+"from CHITIETBOPHAN bp inner join LOAIBOPHAN lbp on bp.MaLoai = lbp.MaLoai"
						+ " where bp.MaLoai = '"+maLoai+"' and bp.TinhTrang='true'";
		ResultSet rs = null;
		try {
			Statement stmt = cn.con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<BoPhan> list = new ArrayList<BoPhan>();
		BoPhan boPhan;
		try {
			while(rs.next()){
				boPhan = new BoPhan();
				boPhan.setMaChiTiet(rs.getString(1));
				boPhan.setTenLoai(rs.getString("TenLoai"));
				boPhan.setTenChiTiet(rs.getString(3));
				String giaBan = rs.getString(4).substring(0,rs.getString(4).length()-5);
				boPhan.setGia(giaBan);
				boPhan.setSoLuong(rs.getString(5));
				boPhan.setThoiGianBH(rs.getString(6));
				list.add(boPhan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		BoPhanDAO b = new BoPhanDAO();
		b.getListBoPhan();
	}
	public String getMaChiTiet() {
		// TODO Auto-generated method stub
		 cn.Connect();
	        String sql = "select top 1 MaChiTiet from CHITIETBOPHAN order by MaChiTiet desc";
	        Statement st = null;
	        ResultSet rs = null;
	        String id = null;
	        int soTang2 = 0;
	        String traVe = "CT";
	        try {
	            st = cn.con.createStatement();
	            rs = st.executeQuery(sql);
	            rs.next();
	            id = rs.getString(1);
	            String soTang = id.substring(2, id.length());
	            soTang2 = Integer.parseInt(soTang);
	            if (soTang2 < 9) {
	                traVe = "CT0";
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return traVe + (soTang2 + 1);
	}
	public void themBoPhan(String maChiTiet, String maLoai, String tenChiTiet,
			String gia, String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		 cn.Connect();
	        try {
	            String sql = "insert into CHITIETBOPHAN values(?,?,?,?,?,?,'true')";
	            preSt= cn.con.prepareStatement(sql);
	            preSt.setString(1 , maChiTiet);
	            preSt.setString(2 , maLoai);
	            preSt.setString(3 , tenChiTiet);
	            preSt.setString(4 , gia);
	            preSt.setString(5 , soLuong);
	            preSt.setString(6 , thoiGianBH);
	            preSt.executeUpdate();
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        } finally {
	            if(preSt != null){
	                preSt.close();
	            }
	            cn.Disconnect();
	        }
	}
	public BoPhan getThongTinBoPhan(String maChiTiet) throws SQLException {
		// TODO Auto-generated method stub
		cn.Connect();
        String sql = "select * from CHITIETBOPHAN where MaChiTiet=?";
        preSt = cn.con.prepareStatement(sql);
        preSt.setString(1, maChiTiet);
        ResultSet rs = preSt.executeQuery();
        BoPhan boPhan = new BoPhan();
        while (rs.next()) {
        	boPhan.setMaChiTiet(maChiTiet);
        	boPhan.setMaLoai(rs.getString(2));
        	boPhan.setTenChiTiet(rs.getString(3));
        	boPhan.setGia(rs.getString(4));
        	boPhan.setSoLuong(rs.getString(5));
        	boPhan.setThoiGianBH(rs.getString(6));
        }
        cn.Disconnect();
        return boPhan;
	}
	public void suaBoPhan(String maChiTiet, String maLoai, String tenChiTiet,
			String gia, String soLuong, String thoiGianBH) throws SQLException {
		// TODO Auto-generated method stub
		 cn.Connect();
	        try {
	            String sql = "UPDATE CHITIETBOPHAN SET MaLoai = ?, TenBoPhan=?,Gia=?, SoLuong=?,ThoiGianBH=? WHERE MaChiTiet = ?";
	            preSt = cn.con.prepareStatement(sql);
	            preSt.setString(1, maLoai);
	            preSt.setString(2, tenChiTiet);
	            preSt.setString(3, gia);
	            preSt.setString(4, soLuong);
	            preSt.setString(5, thoiGianBH); 
	            preSt.setString(6, maChiTiet);
	            preSt.executeUpdate();
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        } finally {
	            if (preSt != null) {
	                preSt.close();
	            }
	            cn.Disconnect();
	        }
	}
	public void xoaBoPhan(String id) {
		// TODO Auto-generated method stub
		cn.Connect();
		String cauLenh = "update CHITIETBOPHAN set tinhtrang = 'false' where MaChiTiet = '"+id+"' ";
		Statement st = null;
		try {
			st = cn.con.createStatement();
			st.executeUpdate(cauLenh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
