package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class ThongKeBieuDoNamForm extends ActionForm{
	private String nam;
	private ArrayList<String> arrGiaTri;
	private String submit;
	
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
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
