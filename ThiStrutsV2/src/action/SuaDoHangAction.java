package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SanPhamBean;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.SanPhamForm;

public class SuaDoHangAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SanPhamForm sp = (SanPhamForm) form;
		String maSP = sp.getMaLoaiSP();
		String soLuong = sp.getSoLuong();

		// TODO Auto-generated method stub
		HttpSession session =  request.getSession();
		ArrayList<SanPhamBean> arr = (ArrayList<SanPhamBean>) session.getAttribute("arrSP");
		for (int i = 0; i < arr.size(); i++) {
			if(maSP.equals(arr.get(i).getMaSP())) {
				arr.get(i).setSoLuong(soLuong);
				return mapping.findForward("thanhCong");
			}
		}
		return mapping.findForward("thanhCong");
	}
	
}
