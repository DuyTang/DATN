package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SanPhamBean;
import model.bo.SanPhamBO;

import org.apache.catalina.Session;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class XuLyDoHangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String maSP = request.getParameter("maSP");
		if (maSP == null) {
			HttpSession session = request.getSession();
			ArrayList<SanPhamBean> arr = new ArrayList<SanPhamBean>();
			if (session.getAttribute("arrSP") == null) {
				session.setAttribute("arrSP", arr);
				return mapping.findForward("thanhCong");
			}
			else {
				return mapping.findForward("thanhCong");
			}
		}
		SanPhamBO spbo = new SanPhamBO();
		SanPhamBean spbean = spbo.getSP(maSP);
		HttpSession session = request.getSession();

		if (session.getAttribute("arrSP") == null) {
			ArrayList<SanPhamBean> arr = new ArrayList<SanPhamBean>();
			spbean.setSoLuong("1");
			arr.add(spbean);
			session.setAttribute("arrSP", arr);
		} else {
			ArrayList<SanPhamBean> arr = (ArrayList<SanPhamBean>) session
					.getAttribute("arrSP");
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getMaSP().equals(spbean.getMaSP())) {
					int soLuong = Integer.parseInt(arr.get(i).getSoLuong());
					arr.get(i).setSoLuong((soLuong + 1) + "");
					return mapping.findForward("thanhCong");
				}
			}
			spbean.setSoLuong("1");
			arr.add(spbean);
			session.setAttribute("arrSP", arr);
		}
		return mapping.findForward("thanhCong");
	}
}
