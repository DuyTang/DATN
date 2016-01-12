package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.ChiTietBoPhan;
import model.bean.Chip;
import model.bean.LoaiBoPhan1;
import model.bean.Mainboard;
import model.bean.Ram;
import model.bean.SanPhamLapRap;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LapRapForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maRam;
	private String loaiRam;
	private int gia;
	private String tenRam;
	private int soLuong;
	private int thoiGianBH;
	private boolean tinhTrang;
	private String maMainboard;
	private String tenMainboard;
	private int soLuongKheCamRam;
	private String socket;
	private String maChip;
	private String tenChip;
	private String maChiTiet;
	private String maLoai;
	private String tenBoPhan;
	private String idLoai;
	private String tenLoai;
	private int soLuongRam;
	private String giaVaLoai;
	private String giaVaLoaiMain;
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String email;
	private String soDienThoai;
	private String submit;
	private String submit1;
	private String chon;
	private String maChuot;
	private String maBanPhim;
	private String maManHinh;
	private String maHDD;
	private String maTanNhiet;
	private String maCase;
	private String maNguon;
	private String maPhuKien;
	private String maDVD;
	private String maSPLapRap;
	private String date;
	private String tongCong;
	private String maHD;
	private String tongTienLapRap;
	private ArrayList<Chip>listChip;
	private ArrayList<Ram>listRam;
	private ArrayList<Mainboard>listMainboard;
	private ArrayList<LoaiBoPhan1>listLoaiBoPhan;
	private ArrayList<ChiTietBoPhan>listChiTietBoPhanChuot;
	private ArrayList<ChiTietBoPhan>listChiTietBoPhanBanPhim;
	private ArrayList<ChiTietBoPhan>listChiTietBoPhanManHinh;
	private ArrayList<ChiTietBoPhan>listChiTietBoPhanHDD;
	private ArrayList<ChiTietBoPhan>listChiTietBoPhanCase;
	private ArrayList<ChiTietBoPhan>listChiTietBoPhanNguon;
	private ArrayList<ChiTietBoPhan>listChiTietBoPhanPhuKien;
	private ArrayList<ChiTietBoPhan>listChiTietBoPhanDVD;
	private ArrayList<ChiTietBoPhan>listChiTietBoPhanTanNhiet;
	private ArrayList<SanPhamLapRap>listSanPhamLapRap;
	
	
	
	public String getSubmit1() {
		return submit1;
	}
	public void setSubmit1(String submit1) {
		this.submit1 = submit1;
	}
	public String getChon() {
		return chon;
	}
	public void setChon(String chon) {
		this.chon = chon;
	}
	public String getTongTienLapRap() {
		return tongTienLapRap;
	}
	public void setTongTienLapRap(String tongTienLapRap) {
		this.tongTienLapRap = tongTienLapRap;
	}
	public ArrayList<SanPhamLapRap> getListSanPhamLapRap() {
		return listSanPhamLapRap;
	}
	public void setListSanPhamLapRap(ArrayList<SanPhamLapRap> listSanPhamLapRap) {
		this.listSanPhamLapRap = listSanPhamLapRap;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getTongCong() {
		return tongCong;
	}
	public void setTongCong(String tongCong) {
		this.tongCong = tongCong;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMaSPLapRap() {
		return maSPLapRap;
	}
	public void setMaSPLapRap(String maSPLapRap) {
		this.maSPLapRap = maSPLapRap;
	}
	public String getMaDVD() {
		return maDVD;
	}
	public void setMaDVD(String maDVD) {
		this.maDVD = maDVD;
	}
	public String getMaChuot() {
		return maChuot;
	}
	public void setMaChuot(String maChuot) {
		this.maChuot = maChuot;
	}
	public String getMaBanPhim() {
		return maBanPhim;
	}
	public void setMaBanPhim(String maBanPhim) {
		this.maBanPhim = maBanPhim;
	}
	public String getMaManHinh() {
		return maManHinh;
	}
	public void setMaManHinh(String maManHinh) {
		this.maManHinh = maManHinh;
	}
	public String getMaHDD() {
		return maHDD;
	}
	public void setMaHDD(String maHDD) {
		this.maHDD = maHDD;
	}
	public String getMaTanNhiet() {
		return maTanNhiet;
	}
	public void setMaTanNhiet(String maTanNhiet) {
		this.maTanNhiet = maTanNhiet;
	}
	public String getMaCase() {
		return maCase;
	}
	public void setMaCase(String maCase) {
		this.maCase = maCase;
	}
	public String getMaNguon() {
		return maNguon;
	}
	public void setMaNguon(String maNguon) {
		this.maNguon = maNguon;
	}
	public String getMaPhuKien() {
		return maPhuKien;
	}
	public void setMaPhuKien(String maPhuKien) {
		this.maPhuKien = maPhuKien;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getGiaVaLoaiMain() {
		return giaVaLoaiMain;
	}
	public void setGiaVaLoaiMain(String giaVaLoaiMain) {
		this.giaVaLoaiMain = giaVaLoaiMain;
	}
	public String getGiaVaLoai() {
		return giaVaLoai;
	}
	public void setGiaVaLoai(String giaVaLoai) {
		this.giaVaLoai = giaVaLoai;
	}
	public int getSoLuongRam() {
		return soLuongRam;
	}
	public void setSoLuongRam(int soLuongRam) {
		this.soLuongRam = soLuongRam;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanCase() {
		return listChiTietBoPhanCase;
	}
	public void setListChiTietBoPhanCase(
			ArrayList<ChiTietBoPhan> listChiTietBoPhanCase) {
		this.listChiTietBoPhanCase = listChiTietBoPhanCase;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanNguon() {
		return listChiTietBoPhanNguon;
	}
	public void setListChiTietBoPhanNguon(
			ArrayList<ChiTietBoPhan> listChiTietBoPhanNguon) {
		this.listChiTietBoPhanNguon = listChiTietBoPhanNguon;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanPhuKien() {
		return listChiTietBoPhanPhuKien;
	}
	public void setListChiTietBoPhanPhuKien(
			ArrayList<ChiTietBoPhan> listChiTietBoPhanPhuKien) {
		this.listChiTietBoPhanPhuKien = listChiTietBoPhanPhuKien;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanDVD() {
		return listChiTietBoPhanDVD;
	}
	public void setListChiTietBoPhanDVD(
			ArrayList<ChiTietBoPhan> listChiTietBoPhanDVD) {
		this.listChiTietBoPhanDVD = listChiTietBoPhanDVD;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanTanNhiet() {
		return listChiTietBoPhanTanNhiet;
	}
	public void setListChiTietBoPhanTanNhiet(
			ArrayList<ChiTietBoPhan> listChiTietBoPhanTanNhiet) {
		this.listChiTietBoPhanTanNhiet = listChiTietBoPhanTanNhiet;
	}
	public String getMaRam() {
		return maRam;
	}
	public void setMaRam(String maRam) {
		this.maRam = maRam;
	}
	public String getLoaiRam() {
		return loaiRam;
	}
	public void setLoaiRam(String loaiRam) {
		this.loaiRam = loaiRam;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getTenRam() {
		return tenRam;
	}
	public void setTenRam(String tenRam) {
		this.tenRam = tenRam;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getThoiGianBH() {
		return thoiGianBH;
	}
	public void setThoiGianBH(int thoiGianBH) {
		this.thoiGianBH = thoiGianBH;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getMaMainboard() {
		return maMainboard;
	}
	public void setMaMainboard(String maMainboard) {
		this.maMainboard = maMainboard;
	}
	public String getTenMainboard() {
		return tenMainboard;
	}
	public void setTenMainboard(String tenMainboard) {
		this.tenMainboard = tenMainboard;
	}
	public int getSoLuongKheCamRam() {
		return soLuongKheCamRam;
	}
	public void setSoLuongKheCamRam(int soLuongKheCamRam) {
		this.soLuongKheCamRam = soLuongKheCamRam;
	}
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public String getMaChip() {
		return maChip;
	}
	public void setMaChip(String maChip) {
		this.maChip = maChip;
	}
	public String getTenChip() {
		return tenChip;
	}
	public void setTenChip(String tenChip) {
		this.tenChip = tenChip;
	}
	public String getMaChiTiet() {
		return maChiTiet;
	}
	public void setMaChiTiet(String maChiTiet) {
		this.maChiTiet = maChiTiet;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenBoPhan() {
		return tenBoPhan;
	}
	public void setTenBoPhan(String tenBoPhan) {
		this.tenBoPhan = tenBoPhan;
	}
	public String getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(String idLoai) {
		this.idLoai = idLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public ArrayList<Chip> getListChip() {
		return listChip;
	}
	public void setListChip(ArrayList<Chip> listChip) {
		this.listChip = listChip;
	}
	public ArrayList<Ram> getListRam() {
		return listRam;
	}
	public void setListRam(ArrayList<Ram> listRam) {
		this.listRam = listRam;
	}
	public ArrayList<Mainboard> getListMainboard() {
		return listMainboard;
	}
	public void setListMainboard(ArrayList<Mainboard> listMainboard) {
		this.listMainboard = listMainboard;
	}
	public ArrayList<LoaiBoPhan1> getListLoaiBoPhan() {
		return listLoaiBoPhan;
	}
	public void setListLoaiBoPhan(ArrayList<LoaiBoPhan1> listLoaiBoPhan) {
		this.listLoaiBoPhan = listLoaiBoPhan;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanChuot() {
		return listChiTietBoPhanChuot;
	}
	public void setListChiTietBoPhanChuot(
			ArrayList<ChiTietBoPhan> listChiTietBoPhanChuot) {
		this.listChiTietBoPhanChuot = listChiTietBoPhanChuot;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanBanPhim() {
		return listChiTietBoPhanBanPhim;
	}
	public void setListChiTietBoPhanBanPhim(
			ArrayList<ChiTietBoPhan> listChiTietBoPhanBanPhim) {
		this.listChiTietBoPhanBanPhim = listChiTietBoPhanBanPhim;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanManHinh() {
		return listChiTietBoPhanManHinh;
	}
	public void setListChiTietBoPhanManHinh(
			ArrayList<ChiTietBoPhan> listChiTietBoPhanManHinh) {
		this.listChiTietBoPhanManHinh = listChiTietBoPhanManHinh;
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanHDD() {
		return listChiTietBoPhanHDD;
	}
	public void setListChiTietBoPhanHDD(
			ArrayList<ChiTietBoPhan> listChiTietBoPhanHDD) {
		this.listChiTietBoPhanHDD = listChiTietBoPhanHDD;
	}
	
@Override
public void reset(ActionMapping mapping, HttpServletRequest request) {
	// TODO Auto-generated method stub
	super.reset(mapping, request);
	try {
		request.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	}
	
	
	

