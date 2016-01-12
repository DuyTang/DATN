package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.OrderBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeBieuDoNamForm;
import form.ThongKeForm;

public class ThongKeBieuDoNamAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ThongKeBieuDoNamForm thongKeForm = (ThongKeBieuDoNamForm) form;
		OrderBO orderBO = new OrderBO();
		if ("Xem".equals(thongKeForm.getSubmit())) {

			String nam = thongKeForm.getNam();

			ArrayList<String> giaTri = orderBO.getListGiaTriThang(nam);
			thongKeForm.setArrGiaTri(giaTri);
			return mapping.findForward("thanhCong2");
		}

		return mapping.findForward("thanhCong");
	}
}
