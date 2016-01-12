package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.Main1BO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.MainForm;

public class XoaMainAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MainForm mainForm = (MainForm) form;
		String id = mainForm.getMaMain();
		Main1BO main1BO = new Main1BO();
		main1BO.xoaMain(id);
		return mapping.findForward("xoaThanhCong");
	}
}
