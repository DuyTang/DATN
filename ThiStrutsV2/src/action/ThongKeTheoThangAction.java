package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.OrderBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeForm;

public class ThongKeTheoThangAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		ThongKeForm thongKeForm = (ThongKeForm) form;
		OrderBO orderBO = new OrderBO();
		if("Xem".equals(thongKeForm.getSubmit())) {
			
			String thoiGian1 = thongKeForm.getThoiGian1();
			String thoiGian2 = thongKeForm.getThoiGian2();
			
			String so1 = orderBO.getSoLuongBanThoiGian1(thoiGian1);
			String so2 = orderBO.getSoLuongBanThoiGian1(thoiGian2);
			
			thongKeForm.setThoiGian1(thoiGian1);
			thongKeForm.setThoiGian2(thoiGian2);
			thongKeForm.setSoLuong1(so1);
			thongKeForm.setSoLuong2(so2);
			
			System.out.println(so1 + "fdsf" + so2);
			return mapping.findForward("thanhCong2");
		}
		
		return mapping.findForward("thanhCong");
	}
	
}
