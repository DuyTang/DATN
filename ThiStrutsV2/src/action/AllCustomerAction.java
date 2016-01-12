package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Customer;
import model.bo.CustomerBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CustomerForm;

public class AllCustomerAction extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // TODO Auto-generated method stub
        CustomerForm customerForm = (CustomerForm)form;
        ArrayList<Customer> list;
        
        CustomerBO customerBO = new CustomerBO();
        list = customerBO.getAllListCus();
        customerForm.setList(list);
        return mapping.findForward("allCus");
    }
}
