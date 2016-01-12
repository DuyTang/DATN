package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SanPhamBean;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.SanPhamForm;

public class ChiTietSanPhamAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SanPhamBO sanPhamBO = new SanPhamBO();
		SanPhamForm sanPhamForm = (SanPhamForm) form;
		String idSanPham = sanPhamForm.getMaLoaiSP();
		SanPhamBean spbean = sanPhamBO.getSP(idSanPham);
		
		sanPhamForm.setTenSP(spbean.getTenSP());
		sanPhamForm.setGiaNhapSP(spbean.getGiaNhapSP());
		sanPhamForm.setGiaBanSP(spbean.getGiaBanSP());
		sanPhamForm.setThoiGianBaoHanh(spbean.getThoiGianBH());
		sanPhamForm.setSoLuong(spbean.getSoLuong());
		sanPhamForm.setCpu(spbean.getCpu());
		sanPhamForm.setRam(spbean.getRam());
		sanPhamForm.setManHinh(spbean.getManHinh());
		sanPhamForm.setDiaCung(spbean.getDiaCung());
		sanPhamForm.setDoHoa(spbean.getDoHoa());
		sanPhamForm.setTrongLuong(spbean.getTrongLuong());
		sanPhamForm.setLinkAnh(spbean.getAnhSP());
		
		return mapping.findForward("thanhCong");
	}
	
}
