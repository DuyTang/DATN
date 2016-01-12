package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.BaoHanhBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;

import form.BaoHanhForm;

public class ThemMoiBaoHanhAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		 BaoHanhForm baoHanhForm= (BaoHanhForm) form;
		 BaoHanhBO baoHanhBO = new BaoHanhBO();
		 String idMaBH= baoHanhBO.getMaBH();
		 baoHanhForm.setMaBH(idMaBH);
	        
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
	        	}else{
	        	    if(Process1.isValidDate(baoHanhForm.getNgayNhanMay(), "MM/dd/yyyy")==false){
	        	        actionErrors.add("ngayNhanMayError",new ActionMessage("error.ngayNhanMay1"));
	        	    }
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
					return mapping.findForward("themError");
				}
	        }
	 
	        if("submit".equals(baoHanhForm.getSubmit())){
	        	String maBH = baoHanhForm.getMaBH();
	            String lanBaoHanh= baoHanhForm.getLanBaoHanh();
	            String tenKH=baoHanhForm.getTenKH();
	            String ngayNhanMay=baoHanhForm.getNgayNhanMay();
	            String ngayTraMay=baoHanhForm.getNgayTraMay();
	            String lyDo= baoHanhForm.getLyDo();
	            String cachXuLy = baoHanhForm.getCachXuLy();
	            String IMEI = baoHanhForm.getIMEI();
	            String soDienThoai = baoHanhForm.getSoDienThoai();
	            baoHanhBO.themBaoHanh(maBH,lanBaoHanh,tenKH,ngayNhanMay,ngayTraMay,lyDo,cachXuLy,IMEI,soDienThoai);
	            return mapping.findForward("themThanhCong");
	        }else{
	            return mapping.findForward("them");
	        }    
	    }
}
	

