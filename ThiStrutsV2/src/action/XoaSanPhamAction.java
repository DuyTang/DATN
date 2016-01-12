package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.SanPhamForm;

public class XoaSanPhamAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SanPhamForm sanPhamForm = (SanPhamForm) form;
		String id = sanPhamForm.getMaLoaiSP();
		SanPhamBO spbo = new SanPhamBO();
		spbo.suaXoaSP(id);
		return mapping.findForward("xoaThanhCong");
	}
	
}
