package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Chip1;

public class ChipForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maChip;
	private String tenChip;
	private String socket;
	private String gia;
	private String soLuong;
	private String thoiGianBH;
	private String tinhTrang;
	private String submit;
	private ArrayList<Chip1> list;
	
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

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
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

	public ArrayList<Chip1> getList() {
		return list;
	}

	public void setList(ArrayList<Chip1> list) {
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
