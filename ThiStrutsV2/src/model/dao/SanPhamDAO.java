package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import model.bean.SanPhamBean;

public class SanPhamDAO {
	String url = "jdbc:sqlserver://localhost; databaseName=QuanLyLapTop";
	String userName = "sa";
	String password = "12345678";
	Connection connection;
	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	void closeConnect(ResultSet rs, Statement st) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<SanPhamBean> getListSanPham(int soTrang, String timKiem, String maHang) {
		connect();
		int soDongHien;
		String cauLenh;

			cauLenh = "select top 10 maloaisp, tensp, giaBanSP, giaNhapSP, soLuong, cpu, ram from sanpham where  tinhtrang <> 0 and tenSP like '%"
					+ timKiem
					+ "%' and maHang like '%"+maHang+"%' and maloaisp not in (select top "
					+ (soTrang - 1)
					* 10
					+ " maloaisp from sanpham where tinhtrang <> 0 and maHang like '%"+maHang+"%' and tenSP like '%"
					+ timKiem + "%')";

		ArrayList<SanPhamBean> arrList = new ArrayList<SanPhamBean>();
		SanPhamBean sanPhamBean;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(cauLenh);
			
			int i = 0;
			while (rs.next()) {
				sanPhamBean = new SanPhamBean();
				sanPhamBean.setMaSP(rs.getString(1));
				sanPhamBean.setTenSP(rs.getString(2));
				
				String giaNhap = rs.getString(3).substring(0,rs.getString(3).length()-5);
				sanPhamBean.setGiaBanSP(giaNhap);
				String giaBan = rs.getString(4).substring(0,rs.getString(4).length()-5);
				sanPhamBean.setGiaNhapSP(giaBan);
				
				
				sanPhamBean.setSoLuong(rs.getString(5));
				sanPhamBean.setCpu(rs.getString(6));
				sanPhamBean.setRam(rs.getString(7));
				arrList.add(sanPhamBean);
				
				i ++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrList;
	}

	public int getTongSoTrang(String timKiem, String maHang) {
		connect();
		String cauLenh = "Select count(maloaisp) from sanpham where tinhtrang <> 0 and tenSP like '%"
				+ timKiem + "%' and maHang like '%"+maHang+"%' ";
		int trang = 1;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(cauLenh);
			rs.next();
			trang = rs.getInt(1);
			if (trang % 10 == 0) {
				trang = trang / 10;
			} else {
				trang = (trang / 10) + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trang;
	}

	public String getMaSanPham() {
		connect();
		String cauLenh = "select top 1 maLoaiSP from SanPham order by MaLoaiSP desc";
		Statement st = null;
		ResultSet rs = null;
		String id = null;
		int soTang2 = 0;
		String traVe = "SP";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(cauLenh);
			rs.next();
			id = rs.getString(1);
			String soTang = id.substring(2, id.length());
			soTang2 = Integer.parseInt(soTang);
			if (soTang2 < 9) {
				traVe = "SP0";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return traVe + (soTang2 + 1);
	}

	public void themSanPham(String maLoaiSP, String tenSP, String giaNhap,
			String giaBan, String maLoai, String maHang, String soLuong,
			String cpu, String ram, String manHinh, String doHoa,
			String trongLuong, String thoiGianBH, String sanPhamMoi,
			String tenAnh) {
		connect();
		String cauLenh = String
				.format("insert into SanPham (MaLoaiSP,TenSP,GiaNhapSP,GiaBanSP,MaLoai,MaHang,SoLuong,CPU,RAM,ManHinh,DoHoa,TrongLuong,ThoiGianBH,TinhTrang,anhSP) values ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
						maLoaiSP, tenSP, giaNhap, giaBan, maLoai, maHang,
						soLuong, cpu, ram, manHinh, doHoa, trongLuong,
						thoiGianBH, sanPhamMoi,tenAnh);
		Statement st;
		try {
			st = connection.createStatement();
			st.executeUpdate(cauLenh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SanPhamBean getSP(String idSanPham) {
		connect();
		String cauLenh = "select MaLoaiSP,TenSP,GiaNhapSP,GiaBanSP,SoLuong,CPU,RAM,ManHinh,DoHoa,TrongLuong,ThoiGianBH,TinhTrang,anhsp from sanpham where maloaisp = '"
				+ idSanPham + "' ";
		
		Statement st;
		SanPhamBean sanPhamBean = new SanPhamBean();
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(cauLenh);
			rs.next();
			sanPhamBean.setMaSP(rs.getString(1));
			sanPhamBean.setTenSP(rs.getString(2));
			String giaNhap = rs.getString(3).substring(0,rs.getString(3).length()-5);
			sanPhamBean.setGiaBanSP(giaNhap);
			String giaBan = rs.getString(4).substring(0,rs.getString(4).length()-5);
			sanPhamBean.setGiaNhapSP(giaBan);
			
			sanPhamBean.setSoLuong(rs.getString(5));
			sanPhamBean.setCpu(rs.getString(6));
			sanPhamBean.setRam(rs.getString(7));
			sanPhamBean.setManHinh(rs.getString(8));
			sanPhamBean.setDoHoa(rs.getString(9));
			sanPhamBean.setTrongLuong(rs.getString(10));
			sanPhamBean.setThoiGianBH(rs.getString(11));
			sanPhamBean.setTinhTrang(rs.getInt(12));
			sanPhamBean.setAnhSP(rs.getString(13));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanPhamBean;
	}

	public void suaSanPham(String maLoaiSP, String tenSP, String giaNhap,
			String giaBan, String maLoai, String maHang, String soLuong,
			String cpu, String ram, String manHinh, String doHoa,
			String trongLuong, String thoiGianBH, String tenAnh) {
		connect();
		String cauLenh = String
				.format("update sanpham set tenSP = '%s', giaBanSP = '%s', giaNhapSP = '%s',maLoai = '%s', maHang = '%s',soLuong = '%s',cpu = '%s', ram = '%s', manhinh = '%s', dohoa = '%s',trongLuong = '%s',thoigianBH = '%s', anhSP = '%s'  where maloaisp = '%s'  ",
						tenSP,giaNhap,giaBan,maLoai,maHang,soLuong,cpu, ram,manHinh,doHoa,trongLuong,thoiGianBH,tenAnh,maLoaiSP);
		Statement st;
		try {
			st = connection.createStatement();
			st.executeUpdate(cauLenh);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void suaXoaSP(String id) {
		connect();
		String cauLenh = "update sanpham set tinhtrang = '0' where maloaisp = '"+id+"' ";
		Statement st = null;
		try {
			st = connection.createStatement();
			st.executeUpdate(cauLenh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getSoTrangChu(String timKiem, String maHang, String tenCPU) {
		connect();
		String cauLenh = "";
		if("khac".equals(tenCPU)) {
			cauLenh = "select count(maloaisp) from sanpham where TinhTrang <>0 and tenSP like '%"
					+ timKiem
					+ "%' and maHang like '%"
					+ maHang
					+ "%' and CPU  not in(select cpu from sanpham where TinhTrang <>0 and tenSP like '%"
					+ timKiem
					+ "%' and maHang like '%"
					+ maHang
					+ "%' and (cpu like '%3%' or cpu like '%5%' or cpu like '%7%')) ";
		}
		else 
		cauLenh = "select count(maloaisp) from sanpham where TinhTrang <>0 and tenSP like '%"+timKiem+"%' and maHang like '%"+maHang+"%' and CPU like '%"+tenCPU+"%'";
		Statement st = null;
		ResultSet rs = null;
		int soTrang = 0;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(cauLenh);
			rs.next();
			soTrang  =  rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soTrang;
	}

	public ArrayList<SanPhamBean> getListSanPhamTrangChu(int soTrang,
			String timKiem, String maHang, String tenCPU) {
		connect();
		int soDongHien;
		String cauLenh = "";
		if("khac".equals(tenCPU)) {
			cauLenh = "select top 12 maloaisp, tensp, giaBanSP, giaNhapSP, soLuong, cpu, ram,anhSP from sanpham where CPU  not in(select cpu from sanpham where TinhTrang <>0 and tenSP like '%"
					+ timKiem
					+ "%' and maHang like '%"
					+ maHang
					+ "%' and (cpu like '%3%' or cpu like '%5%' or cpu like '%7%')) and tinhtrang <> 0 and tenSP like '%"
					+ timKiem
					+ "%' and maHang like '%"+maHang+"%' and maloaisp not in (select top "
					+ soTrang
					+ " maloaisp from sanpham where CPU  not in(select cpu from sanpham where TinhTrang <>0 and tenSP like '%"
					+ timKiem
					+ "%' and maHang like '%"
					+ maHang
					+ "%' and (cpu like '%3%' or cpu like '%5%' or cpu like '%7%')) and tinhtrang <> 0 and maHang like '%"+maHang+"%' and tenSP like '%"
					+ timKiem + "%')";
		}
		else 
			cauLenh = "select top 12 maloaisp, tensp, giaBanSP, giaNhapSP, soLuong, cpu, ram,anhSP from sanpham where cpu like '%"+tenCPU+"%' and tinhtrang <> 0 and tenSP like '%"
					+ timKiem
					+ "%' and maHang like '%"+maHang+"%' and maloaisp not in (select top "
					+ soTrang
					+ " maloaisp from sanpham where cpu like '%"+tenCPU+"%' and tinhtrang <> 0 and maHang like '%"+maHang+"%' and tenSP like '%"
					+ timKiem + "%')";

		ArrayList<SanPhamBean> arrList = new ArrayList<SanPhamBean>();
		SanPhamBean sanPhamBean;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(cauLenh);
			
			int i = 0;
			String ten = "";
			while (rs.next()) {
				sanPhamBean = new SanPhamBean();
				sanPhamBean.setMaSP(rs.getString(1));
				if(rs.getString(2).length() > 18) {
					ten = rs.getString(2).substring(0,16) + "...";
				}
				else {
					ten = rs.getString(2);
				}
				sanPhamBean.setTenSP(ten);
				
				int giaNhap =Integer.parseInt( rs.getString(3).substring(0,rs.getString(3).length()-5));
				NumberFormat formatter = new DecimalFormat("#,###,###");
				String formattedNumber = formatter.format(giaNhap);
				sanPhamBean.setGiaBanSP(formattedNumber);
				
				int giaBan =Integer.parseInt(rs.getString(4).substring(0,rs.getString(4).length()-5));
				NumberFormat formatter1 = new DecimalFormat("#,###,###");
				String formattedNumber1 = formatter1.format(giaBan);
				sanPhamBean.setGiaNhapSP(formattedNumber1);
				
				sanPhamBean.setSoLuong(rs.getString(5));
				sanPhamBean.setCpu(rs.getString(6));
				sanPhamBean.setRam(rs.getString(7));
				sanPhamBean.setAnhSP(rs.getString(8));
				arrList.add(sanPhamBean);
				i ++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrList;
	}

	public ArrayList<SanPhamBean> listHoaDon(String maSP) {
		// TODO Auto-generated method stub
		connect();
		ArrayList<SanPhamBean> list = new ArrayList<SanPhamBean>();
		try{
		PreparedStatement pst = connection.prepareStatement("select * from SANPHAM where MaLoaiSP = ?");
		pst.setString(1, maSP);
		ResultSet rs = pst.executeQuery();
		SanPhamBean sp;
		while(rs.next()){
			sp = new SanPhamBean();
			sp.setTenSP(rs.getString("TenSP"));
			sp.setGiaBanSP(rs.getString("GiaBanSP"));
			list.add(sp);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
