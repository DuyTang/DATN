package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.BaoHanh;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class BaoHanhForm extends ActionForm{  
	/**
     * 
     */
    private String maBH;
    private String lanBaoHanh;
    private String tenKH;
    private String ngayNhanMay;
    private String ngayTraMay;
    private String lyDo;
    private String tinhTrangSua;
    private String cachXuLy;
    private String tinhTrang;
    private String IMEI;
    private String soDienThoai;
    private String submit;
    private ArrayList<BaoHanh> list;
    
    
	public String getMaBH() {
		return maBH;
	}
	public void setMaBH(String maBH) {
		this.maBH = maBH;
	}
	public String getLanBaoHanh() {
		return lanBaoHanh;
	}
	public void setLanBaoHanh(String lanBaoHanh) {
		this.lanBaoHanh = lanBaoHanh;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getNgayNhanMay() {
		return ngayNhanMay;
	}
	public void setNgayNhanMay(String ngayNhanMay) {
		this.ngayNhanMay = ngayNhanMay;
	}
	public String getNgayTraMay() {
		return ngayTraMay;
	}
	public void setNgayTraMay(String ngayTraMay) {
		this.ngayTraMay = ngayTraMay;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	
	public String getCachXuLy() {
		return cachXuLy;
	}
	public void setCachXuLy(String cachXuLy) {
		this.cachXuLy = cachXuLy;
	}
	
	public String getTinhTrangSua() {
        return tinhTrangSua;
    }
    public void setTinhTrangSua(String tinhTrangSua) {
        this.tinhTrangSua = tinhTrangSua;
    }
    public String getTinhTrang() {
        return tinhTrang;
    }
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public ArrayList<BaoHanh> getList() {
		return list;
	}
	public void setList(ArrayList<BaoHanh> list) {
		this.list = list;
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
