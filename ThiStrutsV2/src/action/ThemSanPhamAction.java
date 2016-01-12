package action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.HangSanPhamBean;
import model.bean.LoaiSanPhamBean;
import model.bo.HangSanPhamBO;
import model.bo.LoaiSanPhamBO;
import model.bo.SanPhamBO;
import model.dao.LoaiSanPhamDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import common.StringProcess;
import form.DanhSachSanPhamForm;
import form.SanPhamForm;

public class ThemSanPhamAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LoaiSanPhamBO loaiSanPhamBO = new LoaiSanPhamBO();
		ArrayList<LoaiSanPhamBean> arrLoaiSP = loaiSanPhamBO.getListLoaiSP();
		HangSanPhamBO hangSanPhamBO = new HangSanPhamBO();
		ArrayList<HangSanPhamBean> arrHangSP = hangSanPhamBO.getListHangSP();
		SanPhamBO sanPhamBO = new SanPhamBO();
		String idSanPham = sanPhamBO.getMaSanPham();
		SanPhamForm sanPhamForm = (SanPhamForm) form;
		sanPhamForm.setArrHangSanPham(arrHangSP);
		sanPhamForm.setArrLoaiSanPham(arrLoaiSP);
		sanPhamForm.setMaLoaiSP(idSanPham);

		// validate du lieu
		if ("submit".equals(sanPhamForm.getSubmit())) {
			ActionErrors errors = new ActionErrors();
			if (StringProcess.kiemTraTrong(sanPhamForm.getTenSP())) {
				errors.add("common.tenSP",
						new ActionMessage("error.tenSPTrong"));
			}
			if (StringProcess.kiemTraNumber(sanPhamForm.getGiaNhapSP()) == true) {
				errors.add("common.giaNhapSP",
						new ActionMessage("error.nhapSo"));
			}
			if (StringProcess.kiemTraNumber(sanPhamForm.getGiaBanSP()) == true) {
				errors.add("common.giaBanSP",
						new ActionMessage("error.nhapSo"));
			}

			if (sanPhamForm.getAnhSP().getFileSize() == 0) {
				errors.add("common.file", new ActionMessage(
						"error.common.file.required"));
			}
			if (sanPhamForm.getAnhSP().getContentType().length() > 5) {
				String tam = sanPhamForm.getAnhSP().getContentType().substring(0, 5);
				if (!"image".equals(tam)) {
					errors.add("common.file", new ActionMessage(
							"error.common.file.textfile.only"));
				}
			}
			if (sanPhamForm.getAnhSP().getFileSize() > 100240) {
				errors.add("common.file", new ActionMessage(
						"error.common.file.size.limit"));
			}

			if (StringProcess.kiemTraNumber(sanPhamForm.getSoLuong()) == true) {
				errors.add("common.soLuong", new ActionMessage("error.nhapSo"));
			}
			if (StringProcess.kiemTraNumber(sanPhamForm.getThoiGianBaoHanh()) == true) {
				errors.add("common.thoiGianBaoHang", new ActionMessage(
						"error.nhapSo"));
			}
			saveErrors(request, errors);
			if (errors.size() > 0) {
				return mapping.findForward("themSPerror");
			}
		}

		if ("submit".equals(sanPhamForm.getSubmit())) {
			String tenAnh = "";
			FormFile file = sanPhamForm.getAnhSP();

			String kieu = file.getContentType();
			System.out.println("--------" + kieu);

			String filePath = StringProcess.LINKIMG;
			File folder = new File(filePath);
			if (!folder.exists()) {
				folder.mkdir();
			}
			String fileName = file.getFileName();
			if (!("").equals(fileName)) {
				System.out.println("Server path:" + filePath);
				File newFile = new File(filePath, fileName);
				if (!newFile.exists()) {
					FileOutputStream fos = new FileOutputStream(newFile);
					fos.write(file.getFileData());
					fos.flush();
					fos.close();
				}
			}
			if (!("").equals(fileName)) {
				System.out.println("Server path:" + filePath);
				File newFile = new File(filePath, fileName);
				if (!newFile.exists()) {
					FileOutputStream fos = new FileOutputStream(newFile);
					fos.write(file.getFileData());
					fos.flush();
					fos.close();
				}
				tenAnh = newFile.getName();
			}
			String maLoaiSP = sanPhamForm.getMaLoaiSP();
			String tenSP = sanPhamForm.getTenSP();
			String giaNhap = sanPhamForm.getGiaNhapSP();
			String giaBan = sanPhamForm.getGiaBanSP();
			String maLoai = sanPhamForm.getMaLoai();
			String maHang = sanPhamForm.getMaHang();
			String soLuong = sanPhamForm.getSoLuong();
			String cpu = sanPhamForm.getCpu();
			String ram = sanPhamForm.getRam();
			String manHinh = sanPhamForm.getManHinh();
			String doHoa = sanPhamForm.getDoHoa();
			String trongLuong = sanPhamForm.getTrongLuong();
			String thoiGianBH = sanPhamForm.getThoiGianBaoHanh();
			String sanPhamMoi = sanPhamForm.getSanPhamMoi();
			if(sanPhamMoi == null) {
				sanPhamMoi = "1";
			}
			System.out.println(sanPhamMoi+"--------------sp moi-----");
			sanPhamBO.themSanPham(maLoaiSP, tenSP, giaNhap, giaBan, maLoai,
					maHang, soLuong, cpu, ram, manHinh, doHoa, trongLuong,
					thoiGianBH,sanPhamMoi,tenAnh);
			return mapping.findForward("themSanPhamXong");
		} else
			return mapping.findForward("themSanPham");
	}
}
