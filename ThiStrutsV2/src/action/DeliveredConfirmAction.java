package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DeliveredConfirmBO;
import model.bo.OrdersListBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.MyException;

import form.OrdersListForm;


public class DeliveredConfirmAction extends Action {
   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form, 
         HttpServletRequest request, HttpServletResponse response) throws Exception {
	   String maHD = request.getParameter("maHD");
	   OrdersListForm ordersListForm = (OrdersListForm) form;
	   DeliveredConfirmBO deliveredConfirmBO = new DeliveredConfirmBO();
	   try{
		   deliveredConfirmBO.confirm(maHD);
		   ordersListForm.setMessage("success");
		   ordersListForm.setStatus("notError");
	   }catch(MyException e){
		   e.printStackTrace();
		   OrdersListBO orderListBO = new OrdersListBO();
		   try{
		      ordersListForm.setOrdersList(orderListBO.getOrdersList());
		      ordersListForm.setMessage("success");
		   }catch(MyException e2){
		      ordersListForm.setStatus(e2.getMessage());
		   }
		   ordersListForm.setStatus(e.getMessage());
		   return mapping.findForward("failed");
	   }	   
	   return mapping.findForward("success");      
   }
}
