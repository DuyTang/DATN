package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.BoPhanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BoPhanForm;


public class XoaBoPhanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		BoPhanForm boPhanForm = (BoPhanForm) form;
		String id = boPhanForm.getMaChiTiet();
		BoPhanBO boPhanBO = new BoPhanBO();
		boPhanBO.xoaBoPhan(id);
		return mapping.findForward("xoaThanhCong");
	}
	
}
