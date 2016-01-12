package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Ram;
import model.dao.RamDAO;

public class RamBO {
	static RamDAO ramDAO = new RamDAO();
	public ArrayList<Ram> getListRam() throws SQLException {
		// TODO Auto-generated method stub
		return ramDAO.getListRam();
	}
	public ArrayList<Ram> getListRam(String ram1) throws SQLException {
		// TODO Auto-generated method stub
		return ramDAO.getListRam(ram1);
	}
	public ArrayList<Ram> getListRam1(String loaiRam) throws SQLException {
		// TODO Auto-generated method stub
		return ramDAO.getListRam1(loaiRam);
	}
	
	

}
