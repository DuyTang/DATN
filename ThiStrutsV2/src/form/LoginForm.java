package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;

public class LoginForm extends ActionForm{
    private String username;
    private String password;
    private String thongBao;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors actionErrors = new ActionErrors();
		if(Process1.notVaild(username)){
			actionErrors.add("userError",new ActionMessage("error.user"));
		}
		if(Process1.notVaild(password)){
			actionErrors.add("passError",new ActionMessage("error.pass"));
		}
		return actionErrors;
	}
    
    
}
