package model.bean;

import java.util.ArrayList;

public class SanPham {
	private String  maSP;
	private String tenSP;
	private String giaNhap;
	private String giaBan;
	private String maLoai;
	private String maHang;
	private int soLuong;
	private String cpu;
	private String ram;
	private String manHinh;
	private String diaCung;
	private String doHoa;
	private int trongLuong;
	private String thoiGianBH;
	private ArrayList<SanPhamBean> arrSanPhamBean;
	public ArrayList<SanPhamBean> getArrSanPhamBean() {
		return arrSanPhamBean;
	}
	public void setArrSanPhamBean(ArrayList<SanPhamBean> arrSanPhamBean) {
		this.arrSanPhamBean = arrSanPhamBean;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	
	public String getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(String giaNhap) {
		this.giaNhap = giaNhap;
	}
	public String getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(String giaBan) {
		this.giaBan = giaBan;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getManHinh() {
		return manHinh;
	}
	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}
	public String getDiaCung() {
		return diaCung;
	}
	public void setDiaCung(String diaCung) {
		this.diaCung = diaCung;
	}
	public String getDoHoa() {
		return doHoa;
	}
	public void setDoHoa(String doHoa) {
		this.doHoa = doHoa;
	}
	public int getTrongLuong() {
		return trongLuong;
	}
	public void setTrongLuong(int trongLuong) {
		this.trongLuong = trongLuong;
	}
	public String getThoiGianBH() {
		return thoiGianBH;
	}
	public void setThoiGianBH(String thoiGianBH) {
		this.thoiGianBH = thoiGianBH;
	}
}
