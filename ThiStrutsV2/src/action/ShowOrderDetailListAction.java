package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.OrderDetailListBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.MyException;

import form.OrderDetailListForm;


public class ShowOrderDetailListAction extends Action {
   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form, 
         HttpServletRequest request, HttpServletResponse response) throws Exception {
	   OrderDetailListForm orderDetailListForm = (OrderDetailListForm) form;
	   OrderDetailListBO orderDetailListBO = new OrderDetailListBO();
	   String maHD = request.getParameter("maHD");
	   try{
		   orderDetailListForm.setOrderDetailList(orderDetailListBO.getOrderDetailList(maHD));
		   orderDetailListForm.setMaHD(maHD);
		   orderDetailListForm.setOrderInfor(orderDetailListBO.getOrderInfor(maHD));
		   orderDetailListForm.setMessage("success");
	   }catch(MyException e){
		   orderDetailListForm.setOrderInfor(orderDetailListBO.getOrderInfor(maHD));
		   orderDetailListForm.setMessage(e.getMessage());
	   }
	   return mapping.findForward("showOrderDetailList");      
   }
}
