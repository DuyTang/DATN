package form;

import java.util.ArrayList;

import model.bean.BoPhan;
import model.bean.LoaiBoPhan;

import org.apache.struts.action.ActionForm;

public class DanhSachBoPhanForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maLoai;
	private ArrayList<LoaiBoPhan> listLoaiBoPhan;
	private ArrayList<BoPhan> listBoPhan;
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public ArrayList<LoaiBoPhan> getListLoaiBoPhan() {
		return listLoaiBoPhan;
	}
	public void setListLoaiBoPhan(ArrayList<LoaiBoPhan> listLoaiBoPhan) {
		this.listLoaiBoPhan = listLoaiBoPhan;
	}
	public ArrayList<BoPhan> getListBoPhan() {
		return listBoPhan;
	}
	public void setListBoPhan(ArrayList<BoPhan> listBoPhan) {
		this.listBoPhan = listBoPhan;
	}
	
}
