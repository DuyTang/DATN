package form;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;

public class ThongKeForm extends ActionForm{
	private String thoiGian1;
	private String thoiGian2;
	private String soLuong1;
	private String soLuong2;
	private String ten1;
	private String ten2;
	private String submit;
	
	public String getThoiGian1() {
		return thoiGian1;
	}
	public void setThoiGian1(String thoiGian1) {
		this.thoiGian1 = thoiGian1;
	}
	public String getThoiGian2() {
		return thoiGian2;
	}
	public void setThoiGian2(String thoiGian2) {
		this.thoiGian2 = thoiGian2;
	}
	public String getSoLuong1() {
		return soLuong1;
	}
	public void setSoLuong1(String soLuong1) {
		this.soLuong1 = soLuong1;
	}
	public String getSoLuong2() {
		return soLuong2;
	}
	public void setSoLuong2(String soLuong2) {
		this.soLuong2 = soLuong2;
	}
	public String getTen1() {
		return ten1;
	}
	public void setTen1(String ten1) {
		this.ten1 = ten1;
	}
	public String getTen2() {
		return ten2;
	}
	public void setTen2(String ten2) {
		this.ten2 = ten2;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
}
