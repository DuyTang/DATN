package form;

import java.util.ArrayList;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;

public class ThongKeTheoHangSanXuatForm extends ActionForm{
	private ArrayList<String> arrTen;
	private ArrayList<String> arrGiaTri;
	private String submit;
	

	public ArrayList<String> getArrTen() {
		return arrTen;
	}
	public void setArrTen(ArrayList<String> arrTen) {
		this.arrTen = arrTen;
	}
	
	public ArrayList<String> getArrGiaTri() {
		return arrGiaTri;
	}
	public void setArrGiaTri(ArrayList<String> arrGiaTri) {
		this.arrGiaTri = arrGiaTri;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
}
