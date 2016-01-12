package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.BoPhan;
import model.bean.LoaiBoPhan;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class BoPhanForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maChiTiet;
	private String maLoai;
	private String tenChiTiet;
	private String gia;
	private String soLuong;
	private String thoiGianBH;
	private String tinhTrang;
	private String submit;
	private ArrayList<LoaiBoPhan> listLoaiBoPhan;
	private BoPhan boPhan;
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
	public String getTenChiTiet() {
		return tenChiTiet;
	}
	public void setTenChiTiet(String tenChiTiet) {
		this.tenChiTiet = tenChiTiet;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	public String getThoiGianBH() {
		return thoiGianBH;
	}
	public void setThoiGianBH(String thoiGianBH) {
		this.thoiGianBH = thoiGianBH;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	public ArrayList<LoaiBoPhan> getListLoaiBoPhan() {
		return listLoaiBoPhan;
	}
	public void setListLoaiBoPhan(ArrayList<LoaiBoPhan> listLoaiBoPhan) {
		this.listLoaiBoPhan = listLoaiBoPhan;
	}
	public BoPhan getBoPhan() {
		return boPhan;
	}
	public void setBoPhan(BoPhan boPhan) {
		this.boPhan = boPhan;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
