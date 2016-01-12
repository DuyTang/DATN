package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Customer;
import model.bo.CustomerBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;

import form.CustomerForm;

public class EditCustomerAction extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
        CustomerForm customerForm= (CustomerForm) form;
        CustomerBO customerBO = new CustomerBO();
        String maKH= customerForm.getMaKH();
        if("submit".equals(customerForm.getSubmit())){
        	ActionErrors actionErrors = new ActionErrors();
        	if(Process1.notVaild(customerForm.getTenKH())==true){
        		actionErrors.add("tenKHError",new ActionMessage("error.tenKH"));
        	}
        	
        	if(Process1.notVaild(customerForm.getDiaChi())==true){
        		actionErrors.add("diaChiError",new ActionMessage("error.diaChi"));
        	}
        	
        	if(Process1.notVaild(customerForm.getEmail())==true){
        		actionErrors.add("emailError", new ActionMessage("error.email1"));
        	}else{
        	    if(Process1.kiemTraEmail(customerForm.getEmail())==false){
                    actionErrors.add("emailError", new ActionMessage("error.email"));
                }
        	}
        	
        	if(Process1.notVaild(customerForm.getSoDienThoai())==true){
        		actionErrors.add("dienThoaiError",new ActionMessage("error.dienThoai"));
        	}else{
        	    if(Process1.kiemTraSoDienThoai(customerForm.getSoDienThoai())==false){
                    actionErrors.add("dienThoaiError", new ActionMessage("error.dienThoai1"));
                }
        	}
        	

        	saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("editCustomerError");
			}
        }
        if("submit".equals(customerForm.getSubmit())){
            String tenKH= customerForm.getTenKH();
            String diaChi= customerForm.getDiaChi();
            String email= customerForm.getEmail();
            String soDienThoai= customerForm.getSoDienThoai();
            boolean tinhTrang= customerForm.isTinhTrang();
            customerBO.editCus(maKH, tenKH, diaChi, email, soDienThoai, tinhTrang);
            return mapping.findForward("editComplete");
        }else{
            Customer customer = customerBO.getInfoCustomer(maKH);
            customerForm.setTenKH(customer.getTenKH());
            customerForm.setDiaChi(customer.getDiaChi());
            customerForm.setEmail(customer.getEmail());
            customerForm.setSoDienThoai(customer.getSoDienThoai());
            customerForm.setTinhTrang(customer.isTinhTrang());
            return mapping.findForward("editCus");
        }
        
    }

}
