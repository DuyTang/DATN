package action;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ChiTietBoPhan;
import model.bean.Chip;
import model.bean.Mainboard;
import model.bean.Ram;
import model.bo.ChiTietBoPhanBO;
import model.bo.ChipBO;
import model.bo.DonDatHangBO;
import model.bo.KhachHangBO;
import model.bo.LapRapSanPhamBO;
import model.bo.MainboardBO;
import model.bo.RamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

import form.LapRapForm;

public class LapRapAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LapRapForm lapRapForm = (LapRapForm) form;

		// LoaiBoPhanBO lbpBO = new LoaiBoPhanBO();
		// ArrayList<LoaiBoPhan>listLoaiBoPhan = lbpBO.getListLoaiBoPhan();
		// lapRapForm.setListLoaiBoPhan(listLoaiBoPhan);

		// List Mainboard
		MainboardBO mainboardBO = new MainboardBO();
		ArrayList<Mainboard> listMainboard = mainboardBO.getListMainboard();
		lapRapForm.setListMainboard(listMainboard);
		if ("submit".equals(lapRapForm.getSubmit())) {
			// split main
			String main = lapRapForm.getMaMainboard();
			String[] mainSplit = main.split("-");
			String main1 = null;
			if (!"null".equals(mainSplit[1])) {
				main1 = mainSplit[1];
				System.out.println(main1);
			} else {
				main1 = null;
			}
			String socket = mainboardBO.getSocket(main1);
			String loaiRam = mainboardBO.getLoaiRam(main1);
			// List Chip
			ChipBO chipBO = new ChipBO();
			ArrayList<Chip> listChip = chipBO.getListChip1(socket);
			lapRapForm.setListChip(listChip);

			// List RAM
			RamBO ramBO = new RamBO();
			ArrayList<Ram> listRam = ramBO.getListRam1(loaiRam);
			lapRapForm.setListRam(listRam);

		} else {

			// List Chip
			ChipBO chipBO = new ChipBO();
			ArrayList<Chip> listChip = chipBO.getListChip();
			lapRapForm.setListChip(listChip);

			// List RAM
			RamBO ramBO = new RamBO();
			ArrayList<Ram> listRam = ramBO.getListRam();
			lapRapForm.setListRam(listRam);
		}
		// List Chi tiết bộ phận HDD
		ChiTietBoPhanBO chiTietBoPhanBO = new ChiTietBoPhanBO();
		ArrayList<ChiTietBoPhan> listChiTietBoPhanHDD = chiTietBoPhanBO
				.getListChiTietBoPhanHDD();
		lapRapForm.setListChiTietBoPhanHDD(listChiTietBoPhanHDD);

		// List Chi tiết bộ phận chuột
		ArrayList<ChiTietBoPhan> listChiTietBoPhanChuot = chiTietBoPhanBO
				.getListChiTietBoPhanChuot();
		lapRapForm.setListChiTietBoPhanChuot(listChiTietBoPhanChuot);

		// List chi tiết bộ phận màn hình
		ArrayList<ChiTietBoPhan> listChiTietBoPhanManHinh = chiTietBoPhanBO
				.getListChiTietBoPhanManHinh();
		lapRapForm.setListChiTietBoPhanManHinh(listChiTietBoPhanManHinh);

		// List chi tiết bộ phận bàn phím
		ArrayList<ChiTietBoPhan> listChiTietBoPhanBanPhim = chiTietBoPhanBO
				.getListChiTietBoPhanBanPhim();
		lapRapForm.setListChiTietBoPhanBanPhim(listChiTietBoPhanBanPhim);

		// List chi tiết bộ phận Case
		ArrayList<ChiTietBoPhan> listChiTietBoPhanCase = chiTietBoPhanBO
				.getListChiTietBoPhanCase();
		lapRapForm.setListChiTietBoPhanCase(listChiTietBoPhanCase);

		// List chi tiết bộ phận Nguồn
		ArrayList<ChiTietBoPhan> listChiTietBoPhanNguon = chiTietBoPhanBO
				.getListChiTietBoPhanNguon();
		lapRapForm.setListChiTietBoPhanNguon(listChiTietBoPhanNguon);

		// List chi tiết bộ phận Phụ kiện
		ArrayList<ChiTietBoPhan> listChiTietBoPhanPhuKien = chiTietBoPhanBO
				.getListChiTietBoPhanPhuKien();
		lapRapForm.setListChiTietBoPhanPhuKien(listChiTietBoPhanPhuKien);

		// List chi tiết bộ phận DVD
		ArrayList<ChiTietBoPhan> listChiTietBoPhanDVD = chiTietBoPhanBO
				.getListChiTietBoPhanDVD();
		lapRapForm.setListChiTietBoPhanDVD(listChiTietBoPhanDVD);

		// List chi tiết bộ phận Tản nhiệt
		ArrayList<ChiTietBoPhan> listChiTietBoPhanTanNhiet = chiTietBoPhanBO
				.getListChiTietBoPhanTanNhiet();
		lapRapForm.setListChiTietBoPhanTanNhiet(listChiTietBoPhanTanNhiet);

		// Validate dữ liệu
		if ("submit".equals(lapRapForm.getSubmit())) {
			ActionErrors actionErrors = new ActionErrors();

			// validate email
			if (StringProcess.notValid(lapRapForm.getEmail())) {
				actionErrors
						.add("emailError", new ActionMessage("error.email"));
			} else {
				if (StringProcess.ValidEmail(lapRapForm.getEmail()) == false) {
					actionErrors.add("emailError", new ActionMessage(
							"error.email.dinhdang"));
				}
			}

			// validate ten khach hang
			if (StringProcess.notValid(lapRapForm.getTenKH())) {
				actionErrors
						.add("tenkhError", new ActionMessage("error.tenkh"));
			} else {

			}

			// validate Dia chi
			if (StringProcess.notValid(lapRapForm.getDiaChi())) {
				actionErrors.add("diachiError", new ActionMessage(
						"error.diachi"));
			} else {

			}
			// validate So Dien Thoai
			if (StringProcess.notValid(lapRapForm.getSoDienThoai())) {
				actionErrors.add("soDienThoaiError", new ActionMessage(
						"error.dienthoai"));
			} else {

				if (StringProcess.ValidSoDienThoai(lapRapForm.getSoDienThoai()) == false) {
					actionErrors.add("soDienThoaiError", new ActionMessage(
							"error.dienthoai.dinhdang"));
				}
			}

			if ("0-null".equals(lapRapForm.getMaHDD())) {
				actionErrors.add("hddError", new ActionMessage("error.hdd"));
			}
			if ("0-null".equals(lapRapForm.getMaChip())) {
				actionErrors.add("chipError", new ActionMessage("error.Chip"));
			}
			if ("0-null".equals(lapRapForm.getMaMainboard())) {
				actionErrors.add("mainError", new ActionMessage("error.Main"));
			}
			if ("0-null".equals(lapRapForm.getMaRam())) {
				actionErrors.add("ramError", new ActionMessage("error.Ram"));
			}
			if ("0-null".equals(lapRapForm.getMaCase())) {
				actionErrors.add("caseError", new ActionMessage("error.Case"));
			}
			if ("0-null".equals(lapRapForm.getMaNguon())) {
				actionErrors
						.add("nguonError", new ActionMessage("error.Nguon"));
			}
			saveErrors(request, actionErrors);
			if (actionErrors.size() > 0) {
				return mapping.findForward("themError");
			}
		}

		// update dữ liệu phần Lắp ráp vào cơ sở dữ liệu
		LapRapSanPhamBO lapRapSanPhamBO = new LapRapSanPhamBO();
		KhachHangBO khachHangBO = new KhachHangBO();
		DonDatHangBO donDatHangBO = new DonDatHangBO();
		if ("submit".equals(lapRapForm.getSubmit())) {

			// split ram
			String ram = lapRapForm.getMaRam();
			String[] ramsplit = ram.split("-");
			String ram1 = null;
			if (!"null".equals(ramsplit[1])) {
				ram1 = ramsplit[1];
			} else {
				ram1 = null;
			}

			// split chip
			String chip = lapRapForm.getMaChip();
			String[] chipSplit = chip.split("-");
			String chip1 = null;
			if (!"null".equals(chipSplit[1])) {
				chip1 = chipSplit[1];
			} else {
				chip1 = null;
			}

			// split hdd
			String hdd = lapRapForm.getMaHDD();
			String[] hddSplit = hdd.split("-");
			String hdd1 = null;
			if (!"null".equals(hddSplit[1])) {
				hdd1 = hddSplit[1];
			} else {
				hdd1 = null;
			}

			// split main
			String main = lapRapForm.getMaMainboard();
			String[] mainSplit = main.split("-");
			String main1 = null;
			if (!"null".equals(mainSplit[1])) {
				main1 = mainSplit[1];
			} else {
				main1 = null;
			}
			// split chuot
			String chuot = lapRapForm.getMaChuot();
			String[] chuotSplit = chuot.split("-");
			String chuot1 = null;
			if (!"null".equals(chuotSplit[1])) {
				chuot1 = chuotSplit[1];
			} else {
				chuot1 = null;
			}

			// split ban phim
			String banPhim = lapRapForm.getMaBanPhim();
			String[] banPhimSplit = banPhim.split("-");
			String banPhim1 = null;
			if (!"null".equals(banPhimSplit[1])) {
				banPhim1 = banPhimSplit[1];
			} else {
				banPhim1 = null;
			}

			// split màn hình
			String manHinh = lapRapForm.getMaManHinh();
			String[] manHinhSplit = manHinh.split("-");
			String manHinh1 = null;
			if (!"null".equals(manHinhSplit[1])) {
				manHinh1 = manHinhSplit[1];
			} else {
				manHinh1 = null;
			}

			// split case
			String caseS = lapRapForm.getMaCase();
			String[] caseSplit = caseS.split("-");
			String caseS1 = null;
			if (!"null".equals(caseSplit[1])) {
				caseS1 = caseSplit[1];
			} else {
				caseS1 = null;
			}

			// split nguồn
			String nguon = lapRapForm.getMaNguon();
			String[] nguonSplit = nguon.split("-");
			String nguon1 = null;
			if (!"null".equals(nguonSplit[1])) {
				nguon1 = nguonSplit[1];
			} else {
				nguon1 = null;
			}

			// split DVD
			String dvd = lapRapForm.getMaDVD();
			String[] dvdSplit = dvd.split("-");
			String dvd1 = null;
			if (!"null".equals(dvdSplit[1])) {
				dvd1 = dvdSplit[1];
			} else {
				dvd1 = null;
			}

			// split tản nhiệt
			String tanNhiet = lapRapForm.getMaTanNhiet();
			String[] tanNhietSplit = tanNhiet.split("-");
			String tanNhiet1 = null;
			if (!"null".equals(tanNhietSplit[1])) {
				tanNhiet1 = tanNhietSplit[1];
			} else {
				tanNhiet1 = null;
			}
			// split phụ kiện
			String phuKien = lapRapForm.getMaPhuKien();
			String[] phuKienSplit = phuKien.split("-");
			String phuKien1 = null;
			if (!"null".equals(phuKienSplit[1])) {
				phuKien1 = phuKienSplit[1];
			} else {
				phuKien1 = null;
			}

			// lấy giá trị mã khách hàng tự động tăng
			String maKH = khachHangBO.getMaKHDesc();
			lapRapForm.setMaKH(maKH);

			// lấy giá trị mã đơn đặt hàng tự động tăng
			String maHD = donDatHangBO.getMaHDDesc();
			lapRapForm.setMaHD(maHD);

			// lấy giá trị mã sản phẩm lắp ráp tự động tăng
			String maSPLapRap = lapRapSanPhamBO.getMaSPLapRapDesc();
			lapRapForm.setMaSPLapRap(maSPLapRap);

			// cap nhat khach hang vao co so du lieu
			maKH = lapRapForm.getMaKH();
			String tenKH = lapRapForm.getTenKH();
			String diaChi = lapRapForm.getDiaChi();
			String email = lapRapForm.getEmail();
			String soDienThoai = lapRapForm.getSoDienThoai();
			boolean tinhTrang = lapRapForm.isTinhTrang();
			khachHangBO.addKhachHang(maKH, tenKH, diaChi, email, soDienThoai,
					tinhTrang);

			// cập nhật đơn đặt hàng vào cơ sở dữ liệu
			maHD = lapRapForm.getMaHD();
			String ngayDatHang = lapRapForm.getDate();
			String tongTien = lapRapForm.getTongCong();
			boolean tinhTrangGiaoHang = lapRapForm.isTinhTrang();
			donDatHangBO.addDonDatHang(maHD, maKH, ngayDatHang, diaChi,
					tongTien, tinhTrang, tinhTrangGiaoHang);

			// cập nhật sản phẩm lắp ráp vào cơ sở dữ liệu
			maSPLapRap = lapRapForm.getMaSPLapRap();
			int soLuongRam = lapRapForm.getSoLuongRam();
			lapRapSanPhamBO.addLapRap(maSPLapRap, main1, ram1, chip1, chuot1,
					banPhim1, hdd1, manHinh1, tinhTrang, soLuongRam, maHD,
					caseS1, nguon1, dvd1, tanNhiet1, phuKien1);

			// thêm sp vào hóa đơn

			return mapping.findForward("oke");
		}
		// set ngày đặt hàng
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		lapRapForm.setDate(dateFormat.format(date));

		return mapping.findForward("LapRap");

	}

}