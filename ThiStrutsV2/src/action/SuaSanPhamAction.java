package action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.HangSanPhamBean;
import model.bean.LoaiSanPhamBean;
import model.bean.SanPhamBean;
import model.bo.HangSanPhamBO;
import model.bo.LoaiSanPhamBO;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import common.StringProcess;
import form.SanPhamForm;

public class SuaSanPhamAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		LoaiSanPhamBO loaiSanPhamBO = new LoaiSanPhamBO();
		ArrayList<LoaiSanPhamBean> arrLoaiSP = loaiSanPhamBO.getListLoaiSP();
		HangSanPhamBO hangSanPhamBO = new HangSanPhamBO();
		ArrayList<HangSanPhamBean> arrHangSP = hangSanPhamBO.getListHangSP();
		SanPhamBO sanPhamBO = new SanPhamBO();

		SanPhamForm sanPhamForm = (SanPhamForm) form;
		String idSanPham = sanPhamForm.getMaLoaiSP();
		System.out.println("--------" + idSanPham);
		
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
			if (sanPhamForm.getAnhSP().getContentType().length() > 5 && ! "application/octet-stream".equals(sanPhamForm.getAnhSP().getContentType())) {
				System.out.println("----------" + sanPhamForm.getAnhSP().getContentType());
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
				return mapping.findForward("suaSPerror");
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
				if(! tenAnh.equals(sanPhamForm.getLinkAnh())) {
					File file3 = new File(StringProcess.LINKIMG+sanPhamForm.getLinkAnh()+"");
					System.out.println(file3 + "---file");
					file3.delete();
				}
			}
			else {
				tenAnh = sanPhamForm.getLinkAnh();
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
			sanPhamBO.suaSanPham(maLoaiSP, tenSP, giaNhap, giaBan, maLoai,
					maHang, soLuong, cpu, ram, manHinh, doHoa, trongLuong,
					thoiGianBH,tenAnh);
			sanPhamForm.setSubmit("");
			return mapping.findForward("suaSanPhamXong");
		} else{
			SanPhamBean spbean = sanPhamBO.getSP(idSanPham);
			
			
			sanPhamForm.setArrHangSanPham(arrHangSP);
			sanPhamForm.setArrLoaiSanPham(arrLoaiSP);
			sanPhamForm.setMaLoaiSP(idSanPham);
			
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
			return mapping.findForward("suaSanPham");
		}
	}
}
