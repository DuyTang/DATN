package form;

import java.util.ArrayList;

import model.bean.HangSanPhamBean;
import model.bean.SanPhamBean;

import org.apache.struts.action.ActionForm;

public class TrangChuForm extends ActionForm {
	private String maSP;
	private String tenSP;
	private int soTrang = 1;
	private String txtTimKiem = "";
	private ArrayList<SanPhamBean> arrSanPham;
	private ArrayList<HangSanPhamBean> arrHangSanPham;
	private String maHang = "";
	private String tenCPU = "";
	private String deBiet = "";
	
	
	
	
	public String getDeBiet() {
		return deBiet;
	}
	public void setDeBiet(String deBiet) {
		this.deBiet = deBiet;
	}
	public ArrayList<SanPhamBean> getArrSanPham() {
		return arrSanPham;
	}
	public void setArrSanPham(ArrayList<SanPhamBean> arrSanPham) {
		this.arrSanPham = arrSanPham;
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
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public String getTxtTimKiem() {
		return txtTimKiem;
	}
	public void setTxtTimKiem(String txtTimKiem) {
		this.txtTimKiem = txtTimKiem;
	}
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
	public String getTenCPU() {
		return tenCPU;
	}
	public void setTenCPU(String tenCPU) {
		this.tenCPU = tenCPU;
	}
	
	
}
