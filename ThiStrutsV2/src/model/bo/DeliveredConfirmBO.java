package model.bo;

import model.dao.DeliveredConfirmDAO;
import common.MyException;

public class DeliveredConfirmBO {

	DeliveredConfirmDAO deliveredConfirmDAO = new DeliveredConfirmDAO();
	
	public void confirm(String maHD) throws MyException {
		// TODO Auto-generated method stub
		deliveredConfirmDAO.confirm(maHD);
	}
}
