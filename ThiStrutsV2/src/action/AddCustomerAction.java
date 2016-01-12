package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.CustomerBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;
import form.CustomerForm;

public class AddCustomerAction extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // TODO Auto-generated method stub
        CustomerForm customerForm= (CustomerForm) form;
        CustomerBO customerBO= new CustomerBO();
        String idMaKH= CustomerBO.getMaKH();
        customerForm.setMaKH(idMaKH);
        
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
				return mapping.findForward("addCustomerError");
			}
        }
 
        if("submit".equals(customerForm.getSubmit())){
        	
            String maKH= customerForm.getMaKH();
            String tenKH=customerForm.getTenKH();
            String diaChi=customerForm.getDiaChi();
            String email=customerForm.getEmail();
            String soDienThoai= customerForm.getSoDienThoai();
            boolean tinhTrang= customerForm.isTinhTrang();
            customerBO.addCus(maKH,tenKH,diaChi,email,soDienThoai,tinhTrang);
            return mapping.findForward("addComplete");
        }else{
            return mapping.findForward("addCus");
        }    
    }
}
