package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.OrderBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeTheoHangSanXuatForm;

public class ThongKeTheoHangSanXuatAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ThongKeTheoHangSanXuatForm thongKeForm = (ThongKeTheoHangSanXuatForm) form;
		OrderBO order = new OrderBO();
		ArrayList<String> ten = order.getListTen();
		ArrayList<String> giaTri = order.getListGiaTri(ten);
		
		thongKeForm.setArrTen(ten);
		thongKeForm.setArrGiaTri(giaTri);
		
		return mapping.findForward("thanhCong");
	}
	
}
