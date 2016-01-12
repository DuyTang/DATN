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

public class DanhSachSanPhamAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DanhSachSanPhamForm danhSachSanPhamForm = (DanhSachSanPhamForm) form;
		String timKiem = danhSachSanPhamForm.getTxtTimKiem();
		
		HangSanPhamBO hangSPBO = new HangSanPhamBO();
		ArrayList<HangSanPhamBean> arr2 = hangSPBO.getListHangSP();
		danhSachSanPhamForm.setArrHangSanPham(arr2);
		String maHang = danhSachSanPhamForm.getMaHang();
		SanPhamBO sanPhamBO = new SanPhamBO();
		int tongSoTrang = sanPhamBO.getTongSoTrang(timKiem,maHang);
		int arr[] = new  int[tongSoTrang];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		
		danhSachSanPhamForm.setMangTongSoTrang(arr);
		ArrayList<SanPhamBean> arrSanPham = new ArrayList<SanPhamBean>(); 
		int soTrang = danhSachSanPhamForm.getSoTrang();
		if(soTrang == 1) {
			arrSanPham = sanPhamBO.getListSanPham(1,timKiem,maHang);
			danhSachSanPhamForm.setArrSanPhamBean(arrSanPham);
			return mapping.findForward("thanhCong");
		}
		if(soTrang == 100) {
			arrSanPham = sanPhamBO.getListSanPham(1,timKiem,maHang);
			danhSachSanPhamForm.setArrSanPhamBean(arrSanPham);
			return mapping.findForward("thanhCong2");
		}
		else {
			arrSanPham = sanPhamBO.getListSanPham(soTrang,timKiem,maHang);
			danhSachSanPhamForm.setArrSanPhamBean(arrSanPham);
			return mapping.findForward("thanhCong2");
		}
	}
}
