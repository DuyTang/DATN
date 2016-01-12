package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Mainboard;
import model.dao.MainboardDAO;

public class MainboardBO {
	MainboardDAO mainboardDAO = new MainboardDAO();
	public ArrayList<Mainboard> getListMainboard() throws SQLException {
		// TODO Auto-generated method stub
		return mainboardDAO.getListMainboard();
	}
	public ArrayList<Mainboard> getListMainboard(String main1) throws SQLException {
		// TODO Auto-generated method stub
		return mainboardDAO.getListMainboard(main1);
	}
	public String getSocket(String main1) throws SQLException {
		// TODO Auto-generated method stub
		return mainboardDAO.getSocket(main1);
	}
	public String getLoaiRam(String main1) throws SQLException {
		// TODO Auto-generated method stub
		return mainboardDAO.getLoaiRam(main1);
	}


}
