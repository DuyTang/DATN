package model.bo;

import java.util.ArrayList;

import model.bean.OrderDetail;
import model.bean.OrderInfor;
import model.dao.OrderDetailListDAO;

import common.MyException;

public class OrderDetailListBO {
	OrderDetailListDAO orderDetailListDAO = new OrderDetailListDAO();

	public ArrayList<OrderDetail> getOrderDetailList(String maHD)
			throws MyException {
		// TODO Auto-generated method stub
		return orderDetailListDAO.getOrderDetailList(maHD);
	}

	public OrderInfor getOrderInfor(String maHD) throws MyException {
		// TODO Auto-generated method stub
		return orderDetailListDAO.getOrderInfor(maHD);
	}

}
