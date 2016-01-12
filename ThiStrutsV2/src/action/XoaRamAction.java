package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bo.Ram1BO;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.RamForm;

public class XoaRamAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RamForm ramForm = (RamForm) form;
		String id = ramForm.getMaRam();
		Ram1BO ramBO = new Ram1BO();
		ramBO.xoaRam(id);
		return mapping.findForward("xoaThanhCong");
	}
}
