package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ChiTietBoPhan;
import model.bean.Chip;
import model.bean.Mainboard;
import model.bean.Ram;
import model.bo.ChiTietBoPhanBO;
import model.bo.ChipBO;
import model.bo.MainboardBO;
import model.bo.RamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LapRapForm;

public class ShowListLapRapSanPhamAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LapRapForm lapRapForm = (LapRapForm) form;
		ChiTietBoPhanBO chiTietBoPhanBO = new ChiTietBoPhanBO();
		// 
//		String maSPLapRap = lapRapForm.getMaSPLapRap();
//		LapRapSanPhamBO lapRapSanPhamBO = new LapRapSanPhamBO();
//		ArrayList<SanPhamLapRap>listSanPhamLapRap = lapRapSanPhamBO.getListSanPhamLapRap(maSPLapRap);
//		lapRapForm.setListSanPhamLapRap(listSanPhamLapRap);
		
		String tongTien = lapRapForm.getTongCong();
		lapRapForm.setTongTienLapRap(tongTien);
		
		
		
		// danh sách sản phẩm chip
		String chip = lapRapForm.getMaChip();
		String[] chipSplit = chip.split("-");
		String chip1 = chipSplit[1];
		ChipBO chipBO = new ChipBO();
		ArrayList<Chip> listChip = chipBO.getListChip(chip1);
		lapRapForm.setListChip(listChip);
		
		//danh sach san pham HDD
		String hdd = lapRapForm.getMaHDD();
		String[] hddSplit = hdd.split("-");
		String hdd1 = hddSplit[1];
		ArrayList<ChiTietBoPhan> listChiTietBoPhanHDD = chiTietBoPhanBO
				.getListChiTietBoPhanHDD(hdd1);
		lapRapForm.setListChiTietBoPhanHDD(listChiTietBoPhanHDD);
		
		//danh sach san pham Main
		String main = lapRapForm.getMaMainboard();
		String[] mainSplit = main.split("-");
		String main1 = mainSplit[1];
		MainboardBO mainboardBO = new MainboardBO();
		ArrayList<Mainboard> listMainboard = mainboardBO.getListMainboard(main1);
		lapRapForm.setListMainboard(listMainboard);
		
		//danh sach san pham Ram
		String ram = lapRapForm.getMaRam();
		String[] ramsplit = ram.split("-");
		String ram1 = ramsplit[1];
		RamBO ramBO = new RamBO();
		ArrayList<Ram> listRam = ramBO.getListRam(ram1);
		lapRapForm.setListRam(listRam);
		
		//danh sach san pham man hinh\
		String manHinh = lapRapForm.getMaManHinh();
		String[] manHinhSplit = manHinh.split("-");
		String manHinh1 = manHinhSplit[1];
		ArrayList<ChiTietBoPhan> listChiTietBoPhanManHinh = chiTietBoPhanBO.getListChiTietBoPhanManHinh(manHinh1);
		lapRapForm.setListChiTietBoPhanManHinh(listChiTietBoPhanManHinh);
		
		//danh sach san pham ban phim 
		String banPhim = lapRapForm.getMaBanPhim();
		String[] banPhimSplit = banPhim.split("-");
		String banPhim1 =banPhimSplit[1];
		ArrayList<ChiTietBoPhan> listChiTietBoPhanBanPhim = chiTietBoPhanBO.getListChiTietBoPhanBanPhim(banPhim1);
		lapRapForm.setListChiTietBoPhanBanPhim(listChiTietBoPhanBanPhim);
		
		// danh sach san pham Case
		String caseS = lapRapForm.getMaCase();
		String[] caseSplit = caseS.split("-");
		String caseS1 =caseSplit[1];
		ArrayList<ChiTietBoPhan> listChiTietBoPhanCase = chiTietBoPhanBO.getListChiTietBoPhanCase(caseS1);
		lapRapForm.setListChiTietBoPhanCase(listChiTietBoPhanCase);
		
		//danh sach san pham Nguon
		String nguon = lapRapForm.getMaNguon();
		String[] nguonSplit = nguon.split("-");
		String nguon1 = nguonSplit[1];
		ArrayList<ChiTietBoPhan> listChiTietBoPhanNguon = chiTietBoPhanBO.getListChiTietBoPhanNguon(nguon1);
		lapRapForm.setListChiTietBoPhanNguon(listChiTietBoPhanNguon);
		
		//danh sach san pham phu kien
		String phuKien = lapRapForm.getMaPhuKien();
		String[] phuKienSplit = phuKien.split("-");
		String phuKien1 = phuKienSplit[1];
		ArrayList<ChiTietBoPhan> listChiTietBoPhanPhuKien = chiTietBoPhanBO.getListChiTietBoPhanPhuKien(phuKien1);
		lapRapForm.setListChiTietBoPhanPhuKien(listChiTietBoPhanPhuKien);
		
		//danh sach san pham tan nhiet
		String tanNhiet = lapRapForm.getMaTanNhiet();
		String[] tanNhietSplit = tanNhiet.split("-");
		String tanNhiet1 = tanNhietSplit[1];
		ArrayList<ChiTietBoPhan> listChiTietBoPhanTanNhiet = chiTietBoPhanBO.getListChiTietBoPhanTanNhiet(tanNhiet1);
		lapRapForm.setListChiTietBoPhanTanNhiet(listChiTietBoPhanTanNhiet);
		
		//danh sach san pham dvd
		String dvd = lapRapForm.getMaDVD();
		String[] dvdSplit = dvd.split("-");
		String dvd1 = dvdSplit[1];
		ArrayList<ChiTietBoPhan> listChiTietBoPhanDVD = chiTietBoPhanBO.getListChiTietBoPhanDVD(dvd1);
		lapRapForm.setListChiTietBoPhanDVD(listChiTietBoPhanDVD);

		
		// danh sách sản phẩm chuột
		String chuot = lapRapForm.getMaChuot();
		String[] chuotSplit = chuot.split("-");
		String chuot1 = chuotSplit[1];
		ArrayList<ChiTietBoPhan> listChiTietBoPhanChuot = chiTietBoPhanBO.getListChiTietBoPhanChuot(chuot1);
		lapRapForm.setListChiTietBoPhanChuot(listChiTietBoPhanChuot);
		
		
		return mapping.findForward("listChuot");
}
}