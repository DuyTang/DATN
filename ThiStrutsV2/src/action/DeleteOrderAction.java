package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.OrderBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.MyException;

import form.OrdersListForm;

public class DeleteOrderAction extends Action {
   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception {
      request.setCharacterEncoding("UTF-8");
      String maHD = request.getParameter("maHD");
      OrdersListForm ordersListForm = (OrdersListForm) form;
      OrderBO orderBO = new OrderBO();      
         try {            
            orderBO.deleteOrder(maHD);
            return mapping.findForward("success");
         } catch (MyException e) {
            ordersListForm.setMessage(e.getMessage());
            return mapping.findForward("failed");
         }         
   }
}
