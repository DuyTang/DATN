package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.SanPhamLapRap1;
import model.bo.SanPhamLapRapBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.SanPhamLapRap1Form;

public class DanhSachLapRapAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		 	SanPhamLapRap1Form sanPhamLapRapForm = (SanPhamLapRap1Form) form ;
	        ArrayList<SanPhamLapRap1> list;
	        SanPhamLapRapBO sanPhamLapRapBO = new SanPhamLapRapBO();
	        list = sanPhamLapRapBO.getdsSanPhamRapRap();
	        sanPhamLapRapForm.setList(list);
	        return mapping.findForward("dssplr");
	}

}
