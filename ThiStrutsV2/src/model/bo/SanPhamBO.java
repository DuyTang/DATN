package model.bo;

import java.util.ArrayList;

import model.bean.SanPhamBean;
import model.dao.SanPhamDAO;

public class SanPhamBO {
	SanPhamDAO sanPhamDAO = new SanPhamDAO();
	public ArrayList<SanPhamBean> getListSanPham(int soTrang, String timKiem, String maHang) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getListSanPham(soTrang, timKiem,maHang);
	}
	public int getTongSoTrang(String timKiem, String maHang) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getTongSoTrang(timKiem, maHang);
	}
	public String getMaSanPham() {
		// TODO Auto-generated method stub
		return sanPhamDAO.getMaSanPham();
	}
	public void themSanPham(String maLoaiSP, String tenSP, String giaNhap,
			String giaBan, String maLoai, String maHang, String soLuong,
			String cpu, String ram, String manHinh, String doHoa,
			String trongLuong, String thoiGianBH, String sanPhamMoi, String tenAnh) {
			sanPhamDAO.themSanPham(maLoaiSP,tenSP, giaNhap,giaBan,maLoai,maHang,soLuong,cpu,ram,manHinh,doHoa,trongLuong,thoiGianBH,sanPhamMoi,tenAnh);
		
	}
	public SanPhamBean getSP(String idSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getSP(idSanPham);
	}
	public void suaSanPham(String maLoaiSP, String tenSP, String giaNhap,
			String giaBan, String maLoai, String maHang, String soLuong,
			String cpu, String ram, String manHinh, String doHoa,
			String trongLuong, String thoiGianBH, String tenAnh) {
		sanPhamDAO.suaSanPham(maLoaiSP, tenSP, giaNhap, giaBan, maLoai,
				maHang, soLuong, cpu, ram, manHinh, doHoa, trongLuong,
				thoiGianBH,tenAnh);
		
	}
	public void suaXoaSP(String id) {
		sanPhamDAO.suaXoaSP(id);
		
	}
	public int getSoTrangChu(String timKiem, String maHang, String tenCPU) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getSoTrangChu(timKiem,maHang,tenCPU);
	}
	public ArrayList<SanPhamBean> getListSanPhamTrangChu(int i, String timKiem,
			String maHang, String tenCPU) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getListSanPhamTrangChu(i,timKiem,maHang,tenCPU);
	}
	public ArrayList<SanPhamBean> listHoaDon(String maSP) {
		// TODO Auto-generated method stub
		return sanPhamDAO.listHoaDon(maSP);
	}

}
