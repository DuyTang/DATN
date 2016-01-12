package model.bo;

import java.util.ArrayList;

import common.MyException;
import model.bean.Order;
import model.dao.OrdersListDAO;

public class OrdersListBO{
   OrdersListDAO ordersListDAO = new OrdersListDAO();
   
   public ArrayList<Order> getOrdersList() throws MyException {
      // TODO Auto-generated method stub
      return ordersListDAO.getOrdersList();
   }

}
