package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Ram;
import model.bean.Ram1;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
public class RamForm extends ActionForm{
	private String maRam;
	private String tenRam;
	private String loaiRam;
	private String dungLuong;
	private String gia;
	private String soLuong;
	private String thoiGianBH;
	private String tinhTrang;
	private String submit;
	private ArrayList<Ram1> list;
	public String getMaRam() {
		return maRam;
	}
	public void setMaRam(String maRam) {
		this.maRam = maRam;
	}
	public String getTenRam() {
		return tenRam;
	}
	public void setTenRam(String tenRam) {
		this.tenRam = tenRam;
	}
	public String getLoaiRam() {
		return loaiRam;
	}
	public void setLoaiRam(String loaiRam) {
		this.loaiRam = loaiRam;
	}
	public String getDungLuong() {
		return dungLuong;
	}
	public void setDungLuong(String dungLuong) {
		this.dungLuong = dungLuong;
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
	public ArrayList<Ram1> getList() {
		return list;
	}
	public void setList(ArrayList<Ram1> list) {
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
