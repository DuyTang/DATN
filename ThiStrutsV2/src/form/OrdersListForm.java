package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Order;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class OrdersListForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private ArrayList<Order> ordersList;
	private String message;
	private String status = "notError";
	
		
	public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(ArrayList<Order> ordersList) {
		this.ordersList = ordersList;
	}
	 @Override
	    public void reset(ActionMapping mapping, HttpServletRequest request) {
	        try {
	            request.setCharacterEncoding("UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	    }
}
