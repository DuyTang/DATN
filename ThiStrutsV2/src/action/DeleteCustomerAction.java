package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.CustomerBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CustomerForm;

public class DeleteCustomerAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // TODO Auto-generated method stub
        CustomerForm customerForm = (CustomerForm) form;
        CustomerBO customerBO = new CustomerBO();
         String maKh= customerForm.getMaKH();
        
             customerBO.delCustomer(maKh);
             return mapping.findForward("delComplete");
         
    }
}
