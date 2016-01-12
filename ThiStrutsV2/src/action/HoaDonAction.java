package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SanPhamBean;
import model.bo.OrderBO;
import model.bo.OrderDetailBO;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.SanPhamForm;
public class HoaDonAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SanPhamForm sanPhamForm = (SanPhamForm) form;	
		OrderBO orderBO = new OrderBO();
		String maHoaDon = orderBO.getMaHoaDon();
		ArrayList<SanPhamBean> list;
		OrderDetailBO orderDetailBO = new OrderDetailBO();
		list = orderDetailBO.getListSP(maHoaDon);
		System.out.println(list);
		sanPhamForm.setArrSanPhamBean(list);
		return mapping.findForward("hoaDon");
	}
}

