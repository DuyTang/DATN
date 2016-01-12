package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Main1;
import model.bo.Main1BO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.MainForm;

public class MainAction extends Action{
	 @Override
	    public ActionForward execute(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        // TODO Auto-generated method stub
	        MainForm ramForm = (MainForm) form ;
	        ArrayList<Main1> list;
	        Main1BO main1BO = new Main1BO();
	        list = main1BO.getdsMain();
	        ramForm.setList(list);
	        return mapping.findForward("dsmain");
	    }
	 

}
