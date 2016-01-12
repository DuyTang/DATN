package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.OrderDetailBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.MyException;

import form.OrderDetailListForm;

public class DeleteOrderDetailAction extends Action {
   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception {
      request.setCharacterEncoding("UTF-8");
      String maChiTietDonHang = request.getParameter("maChiTietDonHang");
      String maHD = request.getParameter("maHD");
      OrderDetailListForm orderDetailListForm = (OrderDetailListForm) form;
      OrderDetailBO orderDetailBO = new OrderDetailBO();      
         try {            
            orderDetailBO.deleteOrderDetail(maChiTietDonHang);
            String path = mapping.findForward("success").getPath();
            path = path + "?maHD=" + maHD;
            return new ActionForward(path);
         } catch (MyException e) {
            orderDetailListForm.setMessage(e.getMessage());
            return mapping.findForward("failed");
         }         
   }
}
