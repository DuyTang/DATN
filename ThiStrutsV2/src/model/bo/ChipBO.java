package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Chip;
import model.dao.ChipDAO;

public class ChipBO {
	ChipDAO chipDAO = new ChipDAO();
	public ArrayList<Chip> getListChip() throws SQLException {
		// TODO Auto-generated method stub
		return chipDAO.getListChip();
	}
	public ArrayList<Chip> getListChip(String chip1) throws SQLException {
		// TODO Auto-generated method stub
		return chipDAO.getListChip(chip1);
	}
	public ArrayList<Chip> getListChip1(String socket) throws SQLException {
		// TODO Auto-generated method stub
		return chipDAO.getListChip1(socket);
	}

}
