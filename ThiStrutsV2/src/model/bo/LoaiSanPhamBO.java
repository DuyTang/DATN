package model.bo;

import java.util.ArrayList;

import model.bean.LoaiSanPhamBean;
import model.dao.LoaiSanPhamDAO;

public class LoaiSanPhamBO {
	LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
	public ArrayList<LoaiSanPhamBean> getListLoaiSP() {
		// TODO Auto-generated method stub
		return loaiSanPhamDAO.getListLoaiSP();
	}

}
