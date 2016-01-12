package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.BaoHanhBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaoHanhForm;

public class TraMayAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		 BaoHanhForm baoHanhForm = (BaoHanhForm) form;
	        BaoHanhBO baoHanhBO = new BaoHanhBO();
	         String maBh = baoHanhForm.getMaBH();
	         System.out.println(maBh);
	       
	         baoHanhBO.traBaoHanh(maBh);
	             return mapping.findForward("traBH");
	}
	
}
