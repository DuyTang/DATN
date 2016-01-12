package model.bo;

import java.util.ArrayList;

import model.bean.LoaiBoPhan;
import model.dao.LoaiBoPhanDAO;

public class LoaiBoPhanBO {
	LoaiBoPhanDAO loaiBoPhanDAO = new LoaiBoPhanDAO();
	public ArrayList<LoaiBoPhan> getListLoaiBoPhan() {
		// TODO Auto-generated method stub
		return loaiBoPhanDAO.getListLoaiBoPhan();
	}

}
