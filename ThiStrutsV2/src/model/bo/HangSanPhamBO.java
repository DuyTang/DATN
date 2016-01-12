package model.bo;

import java.util.ArrayList;

import model.bean.HangSanPhamBean;
import model.dao.HangSanPhamDAO;

public class HangSanPhamBO {
	HangSanPhamDAO hangSanPhamDAO = new HangSanPhamDAO();
	public ArrayList<HangSanPhamBean> getListHangSP() {
		// TODO Auto-generated method stub
		return hangSanPhamDAO.getListHangSP();
	}
	
}
