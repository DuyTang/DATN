package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.HangSanPhamBean;
import model.bean.SanPhamBean;
import model.bo.HangSanPhamBO;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachSanPhamForm;
import form.TrangChuForm;

public class TrangChuAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		TrangChuForm trangChuForm = (TrangChuForm) form;
		HangSanPhamBO hangSPBO = new HangSanPhamBO();

		ArrayList<HangSanPhamBean> arr2 = hangSPBO.getListHangSP();
		trangChuForm.setArrHangSanPham(arr2);

		String maHang = trangChuForm.getMaHang();
		String timKiem = trangChuForm.getTxtTimKiem();
		String tenCPU = trangChuForm.getTenCPU();
		int soTrangCu = trangChuForm.getSoTrang();

		SanPhamBO sanPhamBO = new SanPhamBO();
		int tongSoTrang = sanPhamBO.getSoTrangChu(timKiem, maHang, tenCPU);
		
		System.out.println("soTrang=" +tongSoTrang);
		System.out.println("soTrangHienTai" + soTrangCu);
		
		if (soTrangCu == 0) {
			soTrangCu = tongSoTrang;
		}
		boolean demo = false;
		if(soTrangCu == 9999) {
			demo = true;
			soTrangCu = tongSoTrang;
		}
		
		int conLai = soTrangCu - 12;
		int inRa = tongSoTrang - soTrangCu;
		
		ArrayList<SanPhamBean> arrSanPham = new ArrayList<SanPhamBean>();
		if (soTrangCu == tongSoTrang && demo == true) {
			
			arrSanPham = sanPhamBO.getListSanPhamTrangChu(0, timKiem, maHang,
					tenCPU);
			trangChuForm.setArrSanPham(arrSanPham);
			trangChuForm.setSoTrang(conLai);
			return mapping.findForward("thanhCong2");
		}
		if (soTrangCu == tongSoTrang) {
			
		
			arrSanPham = sanPhamBO.getListSanPhamTrangChu(0, timKiem, maHang,
					tenCPU);
			trangChuForm.setArrSanPham(arrSanPham);
			trangChuForm.setSoTrang(conLai);
			return mapping.findForward("thanhCong");
		} else {
			arrSanPham = sanPhamBO.getListSanPhamTrangChu(inRa, timKiem,
					maHang, tenCPU);
			trangChuForm.setArrSanPham(arrSanPham);
			trangChuForm.setSoTrang(conLai);
			return mapping.findForward("thanhCong2");
		}
		
	}
}
