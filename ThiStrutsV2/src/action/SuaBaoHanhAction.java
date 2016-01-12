package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaoHanh;
import model.bo.BaoHanhBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;

import form.BaoHanhForm;

public class SuaBaoHanhAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		 BaoHanhForm baoHanhForm= (BaoHanhForm) form;
	        BaoHanhBO baoHanhBO = new BaoHanhBO();
	        String maBH = baoHanhForm.getMaBH();

	        if("submit".equals(baoHanhForm.getSubmit())){
	        	ActionErrors actionErrors = new ActionErrors();
	        	if(Process1.notVaild(baoHanhForm.getLanBaoHanh())==true){
	        		actionErrors.add("lanBHError",new ActionMessage("error.lanBH"));
	        	}else{
	        		if(Process1.isNumericOnlyNumber(baoHanhForm.getLanBaoHanh())==false){
		        		actionErrors.add("lanBHError",new ActionMessage("error.lanBH1"));
		        	}
	        	}
	        	if(Process1.notVaild(baoHanhForm.getTenKH())==true){
	        		actionErrors.add("tenKHError",new ActionMessage("error.tenKH"));
	        	}
	        	if(Process1.notVaild(baoHanhForm.getNgayNhanMay())==true){
	        		actionErrors.add("ngayNhanMayError",new ActionMessage("error.ngayNhanMay"));
	        	}
	        	if(Process1.notVaild(baoHanhForm.getLyDo())==true){
	        		actionErrors.add("lyDoError", new ActionMessage("error.lyDo"));
	        	}
	        	if(Process1.notVaild(baoHanhForm.getCachXuLy())==true){
	        		actionErrors.add("cachXuLyError",new ActionMessage("error.cachXuLy"));
	        	}
	        	if(Process1.notVaild(baoHanhForm.getIMEI())==true){
	        		actionErrors.add("imeiError",new ActionMessage("error.imei"));
	        	}
	        	if(Process1.notVaild(baoHanhForm.getSoDienThoai())==true){
	        		actionErrors.add("dienThoaiError",new ActionMessage("error.dienThoai"));
	        	}else{
	        		if(Process1.kiemTraSoDienThoai(baoHanhForm.getSoDienThoai())==false){
		        		actionErrors.add("dienThoaiError",new ActionMessage("error.dienThoai1"));
	        		}
	        	}
	        	saveErrors(request, actionErrors);
				if(actionErrors.size()>0){
					return mapping.findForward("suaError");
				}
	        }
	       
	        if("submit".equals(baoHanhForm.getSubmit())){
	        	String IMEI = baoHanhForm.getIMEI();
	        	String lanBaoHanh = baoHanhForm.getLanBaoHanh();
	            String tenKH= baoHanhForm.getTenKH();
	            String ngayNhanMay= baoHanhForm.getNgayNhanMay();
	            String ngayTraMay= baoHanhForm.getNgayTraMay();
	            String lyDo = baoHanhForm.getLyDo();
	            String cachXuLy = baoHanhForm.getCachXuLy();
	            String tinhTrangSua = baoHanhForm.getTinhTrangSua();
	            String soDienThoai= baoHanhForm.getSoDienThoai();
	            
	            
	            baoHanhBO.suaBaoHanh(maBH,lanBaoHanh,tenKH, ngayNhanMay, ngayTraMay, lyDo, cachXuLy,tinhTrangSua,soDienThoai,IMEI);
	            return mapping.findForward("suaThanhCong");
	        }else{
	            BaoHanh baoHanh = baoHanhBO.getThongTinBH(maBH);
	            baoHanhForm.setIMEI(baoHanh.getIMEI());
	            baoHanhForm.setLanBaoHanh(baoHanh.getLanBaoHanh());
	            baoHanhForm.setTenKH(baoHanh.getTenKH());
	            baoHanhForm.setNgayNhanMay(baoHanh.getNgayNhanMay());
	            baoHanhForm.setNgayTraMay(baoHanh.getNgayTraMay());
	            baoHanhForm.setLyDo(baoHanh.getLyDo());
	            baoHanhForm.setCachXuLy(baoHanh.getCachXuLy());
	            baoHanhForm.setTinhTrangSua(baoHanh.getTinhTrangSua());
	            baoHanhForm.setSoDienThoai(baoHanh.getSoDienThoai());
	            
	            return mapping.findForward("sua");
	        }
	}
	
}
