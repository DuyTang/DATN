package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BoPhan;
import model.bean.LoaiBoPhan;
import model.bo.BoPhanBO;
import model.bo.LoaiBoPhanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;

import form.BoPhanForm;

public class SuaBoPhanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		BoPhanForm boPhanForm = (BoPhanForm) form;
		BoPhanBO boPhanBO = new BoPhanBO();
		// lay danh sach loai bao phan
		LoaiBoPhanBO loaiBoPhanBO = new LoaiBoPhanBO();
		ArrayList<LoaiBoPhan> listLoaiBoPhan = loaiBoPhanBO.getListLoaiBoPhan();
		boPhanForm.setListLoaiBoPhan(listLoaiBoPhan);
		
		if("submit".equals(boPhanForm.getSubmit())){
        	ActionErrors actionErrors = new ActionErrors();
        	if(Process1.notVaild(boPhanForm.getTenChiTiet())==true){
        		actionErrors.add("tenChiTietError",new ActionMessage("error.tenChiTiet"));
        	}
        	if(Process1.notVaild(boPhanForm.getGia())==true){
        		actionErrors.add("giaError", new ActionMessage("error.gia"));
        	}
        	if(Process1.notVaild(boPhanForm.getSoLuong())==true){
        		actionErrors.add("soLuongError",new ActionMessage("error.soLuong"));
        	}
        	if(Process1.notVaild(boPhanForm.getThoiGianBH())==true){
        		actionErrors.add("thoiGianBHError",new ActionMessage("error.thoiGianBH"));
        	}
        	saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themError");
			}
        }

		//sua bo phan
		String maChiTiet = boPhanForm.getMaChiTiet();
		if("submit".equals(boPhanForm.getSubmit())){		
			String maLoai = boPhanForm.getMaLoai();
			String tenChiTiet= boPhanForm.getTenChiTiet();
			String gia = boPhanForm.getGia();
			String soLuong = boPhanForm.getSoLuong();
			String thoiGianBH = boPhanForm.getThoiGianBH();
			
			boPhanBO.suaBoPhan(maChiTiet,maLoai,tenChiTiet,gia,soLuong,thoiGianBH);
			return mapping.findForward("suaThanhCong");
		} else {											//chuyen sang trang Them sinh vien
			BoPhan boPhan = boPhanBO.getThongTinBoPhan(maChiTiet);
			boPhanForm.setMaLoai(boPhan.getMaLoai());
			boPhanForm.setTenChiTiet(boPhan.getTenChiTiet());
			boPhanForm.setGia(boPhan.getGia());
			boPhanForm.setSoLuong(boPhan.getSoLuong());
			boPhanForm.setThoiGianBH(boPhan.getThoiGianBH());
			return mapping.findForward("sua");
		}
	}

}
