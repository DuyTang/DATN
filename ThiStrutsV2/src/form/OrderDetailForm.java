package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.HangSanPham;
import model.bean.SanPham2;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class OrderDetailForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String maHD;
	private String maLoaiSP;
	private String imei;
	private String giaBan;
	private String maChiTietDonHang;
	private String message;
	private String buttonClicked;
	private ArrayList<HangSanPham> arrHangSP;
	private ArrayList<SanPham2> arrSanPham = new ArrayList<SanPham2>();
	private String maSP;
	private String tenHang;
	private String tenSP;

	// Getters and setters
	public String getTenSP() {
		return tenSP;
	}

	public ArrayList<HangSanPham> getArrHangSP() {
		return arrHangSP;
	}

	public void setArrHangSP(ArrayList<HangSanPham> arrHangSP) {
		this.arrHangSP = arrHangSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public ArrayList<SanPham2> getArrSanPham() {
		return arrSanPham;
	}

	public void setArrSanPham(ArrayList<SanPham2> arrSanPham) {
		this.arrSanPham = arrSanPham;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getButtonClicked() {
		return buttonClicked;
	}

	public void setButtonClicked(String buttonClicked) {
		this.buttonClicked = buttonClicked;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(String giaBan) {
		this.giaBan = giaBan;
	}

	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}

	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
