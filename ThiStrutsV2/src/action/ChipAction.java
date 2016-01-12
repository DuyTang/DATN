package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Chip1;
import model.bo.Chip1BO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ChipForm;

public class ChipAction extends Action{
	 @Override
	    public ActionForward execute(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        // TODO Auto-generated method stub
	        ChipForm ramForm = (ChipForm) form ;
	        ArrayList<Chip1> list;
	        Chip1BO main1BO = new Chip1BO();
	        list = main1BO.getdsMain();
	        ramForm.setList(list);
	        return mapping.findForward("dschip");
	    }
	 

}
