package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.LoginBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoginForm;

public class LoginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginForm loginForm = (LoginForm) form;
        LoginBO loginBO= new LoginBO();
        String user = loginForm.getUsername();
        String pass= loginForm.getPassword();
        if(loginBO.checkLogin(user,pass)){
            return mapping.findForward("thanhCong");
        }else{
        	loginForm.setThongBao("Login Fail");
        	return mapping.findForward("thatBai");
        
        }
    }
}
