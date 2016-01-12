package form;

import java.util.ArrayList;

import model.bean.HangSanPhamBean;
import model.bean.SanPhamBean;

import org.apache.struts.action.ActionForm;

public class DanhSachSanPhamForm extends ActionForm{
	private String maSP;
	private String tenSP;
	private int soTrang = 1;
	private int[] mangTongSoTrang;
	private String txtTimKiem = "";
	private ArrayList<HangSanPhamBean> arrHangSanPham;
	private String maHang = "";
	
	
	public ArrayList<HangSanPhamBean> getArrHangSanPham() {
		return arrHangSanPham;
	}

	public void setArrHangSanPham(ArrayList<HangSanPhamBean> arrHangSanPham) {
		this.arrHangSanPham = arrHangSanPham;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTxtTimKiem() {
		return txtTimKiem;
	}

	public void setTxtTimKiem(String txtTimKiem) {
		this.txtTimKiem = txtTimKiem;
	}

	public int[] getMangTongSoTrang() {
		return mangTongSoTrang;
	}

	public void setMangTongSoTrang(int[] mangTongSoTrang) {
		this.mangTongSoTrang = mangTongSoTrang;
	}

	ArrayList<SanPhamBean> arrSanPhamBean;
	
	public ArrayList<SanPhamBean> getArrSanPhamBean() {
		return arrSanPhamBean;
	}

	public void setArrSanPhamBean(ArrayList<SanPhamBean> arrSanPhamBean) {
		this.arrSanPhamBean = arrSanPhamBean;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public String getTaSP() {
		return maSP;
	}

	public void setTaSP(String taSP) {
		this.maSP = taSP;
	}

	public String getTenSP() {
		return tenSP;
	}
	
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	
	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
}
