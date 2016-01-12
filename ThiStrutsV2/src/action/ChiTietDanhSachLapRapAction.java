package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.SanPhamLapRap1;
import model.bo.SanPhamLapRapBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;
import form.SanPhamLapRap1Form;


public class ChiTietDanhSachLapRapAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		SanPhamLapRap1Form ram = (SanPhamLapRap1Form) form;
		SanPhamLapRapBO main1BO = new SanPhamLapRapBO();
		String maSPLR = ram.getMaSPLR();
		
     
        	SanPhamLapRap1 main = main1BO.getThongTin(maSPLR);
        	ram.setTenChip(main.getTenChip());
        	ram.setTenHDD(main.getTenHDD());
        	ram.setTenMain(main.getTenMain());
        	ram.setTenRam(main.getTenRam());
        	ram.setSoLuong(main.getSoLuong());
        	ram.setTenChuot(main.getTenChuot());
        	ram.setTenBanPhim(main.getTenBanPhim());
        	ram.setTenManHinh(main.getTenManHinh());
        	ram.setTenCase(main.getTenCase());
        	ram.setTenNguon(main.getTenNguon());
    		ram.setTenDVD(main.getTenDVD());
    		ram.setTenTanNhiet(main.getTenTanNhiet());
        	ram.setTenPhuKien(main.getTenPhuKien());
        	ram.setMaSPLR(main.getMaSPLR());
        	
        	
        	 return mapping.findForward("dsctsplr");
        
	}

}
