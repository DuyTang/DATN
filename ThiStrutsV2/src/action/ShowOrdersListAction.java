package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.OrdersListBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.MyException;

import form.OrdersListForm;


public class ShowOrdersListAction extends Action {
   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form, 
         HttpServletRequest request, HttpServletResponse response) throws Exception {
	   OrdersListForm ordersListForm = (OrdersListForm) form;
	   OrdersListBO orderListBO = new OrdersListBO();
	   try{
	      ordersListForm.setOrdersList(orderListBO.getOrdersList());
	      ordersListForm.setMessage("success");
	   }catch(MyException e){
	      ordersListForm.setMessage(e.getMessage());
	   }
	   return mapping.findForward("showOrdersList");      
   }
}
