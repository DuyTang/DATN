package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.SanPhamLapRap1;

public class SanPhamLapRap1Form extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maSPLR;
	private String maMain;
	private String tenMain;
	private String maRam;
	private String tenRam;
	private String soLuong;
	private String maChip;
	private String tenChip;
	private String maChuot;
	private String tenChuot;
	private String maBanPhim;
	private String tenBanPhim;
	private String maHDD;
	private String tenHDD;
	private String maManHinh;
	private String tenManHinh;
	private String tinhTrang;
	private String soLuongRam;
	private String maHD;
	private String maCase;
	private String tenCase;
	private String maNguon;
	private String tenNguon;
	private String maDVD;
	private String tenDVD;
	private String maTanNhiet;
	private String tenTanNhiet;
	private String maPhuKien;
	private String tenPhuKien;
	private String submit;
	private ArrayList<SanPhamLapRap1> list;
	public String getMaSPLR() {
		return maSPLR;
	}
	public void setMaSPLR(String maSPLR) {
		this.maSPLR = maSPLR;
	}
	public String getMaMain() {
		return maMain;
	}
	public void setMaMain(String maMain) {
		this.maMain = maMain;
	}
	public String getTenMain() {
		return tenMain;
	}
	public void setTenMain(String tenMain) {
		this.tenMain = tenMain;
	}
	public String getMaRam() {
		return maRam;
	}
	public void setMaRam(String maRam) {
		this.maRam = maRam;
	}
	public String getTenRam() {
		return tenRam;
	}
	
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	public void setTenRam(String tenRam) {
		this.tenRam = tenRam;
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
	public String getMaChuot() {
		return maChuot;
	}
	public void setMaChuot(String maChuot) {
		this.maChuot = maChuot;
	}
	public String getTenChuot() {
		return tenChuot;
	}
	public void setTenChuot(String tenChuot) {
		this.tenChuot = tenChuot;
	}
	public String getMaBanPhim() {
		return maBanPhim;
	}
	public void setMaBanPhim(String maBanPhim) {
		this.maBanPhim = maBanPhim;
	}
	public String getTenBanPhim() {
		return tenBanPhim;
	}
	public void setTenBanPhim(String tenBanPhim) {
		this.tenBanPhim = tenBanPhim;
	}
	public String getMaHDD() {
		return maHDD;
	}
	public void setMaHDD(String maHDD) {
		this.maHDD = maHDD;
	}
	public String getTenHDD() {
		return tenHDD;
	}
	public void setTenHDD(String tenHDD) {
		this.tenHDD = tenHDD;
	}
	public String getMaManHinh() {
		return maManHinh;
	}
	public void setMaManHinh(String maManHinh) {
		this.maManHinh = maManHinh;
	}
	public String getTenManHinh() {
		return tenManHinh;
	}
	public void setTenManHinh(String tenManHinh) {
		this.tenManHinh = tenManHinh;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getSoLuongRam() {
		return soLuongRam;
	}
	public void setSoLuongRam(String soLuongRam) {
		this.soLuongRam = soLuongRam;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaCase() {
		return maCase;
	}
	public void setMaCase(String maCase) {
		this.maCase = maCase;
	}
	public String getTenCase() {
		return tenCase;
	}
	public void setTenCase(String tenCase) {
		this.tenCase = tenCase;
	}
	public String getMaNguon() {
		return maNguon;
	}
	public void setMaNguon(String maNguon) {
		this.maNguon = maNguon;
	}
	public String getTenNguon() {
		return tenNguon;
	}
	public void setTenNguon(String tenNguon) {
		this.tenNguon = tenNguon;
	}
	public String getMaDVD() {
		return maDVD;
	}
	public void setMaDVD(String maDVD) {
		this.maDVD = maDVD;
	}
	public String getTenDVD() {
		return tenDVD;
	}
	public void setTenDVD(String tenDVD) {
		this.tenDVD = tenDVD;
	}
	public String getMaTanNhiet() {
		return maTanNhiet;
	}
	public void setMaTanNhiet(String maTanNhiet) {
		this.maTanNhiet = maTanNhiet;
	}
	public String getTenTanNhiet() {
		return tenTanNhiet;
	}
	public void setTenTanNhiet(String tenTanNhiet) {
		this.tenTanNhiet = tenTanNhiet;
	}
	public String getMaPhuKien() {
		return maPhuKien;
	}
	public void setMaPhuKien(String maPhuKien) {
		this.maPhuKien = maPhuKien;
	}
	public String getTenPhuKien() {
		return tenPhuKien;
	}
	public void setTenPhuKien(String tenPhuKien) {
		this.tenPhuKien = tenPhuKien;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public ArrayList<SanPhamLapRap1> getList() {
		return list;
	}
	public void setList(ArrayList<SanPhamLapRap1> list) {
		this.list = list;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
