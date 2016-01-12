package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.Ram1BO;
import model.bo.RamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;
import form.RamForm;

public class ThemRamAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		 RamForm ramForm= (RamForm) form;
	       Ram1BO ramBO = new Ram1BO();
	       String idMaRam= ramBO.getMaRam();
			 ramForm.setMaRam(idMaRam);

	        if("submit".equals(ramForm.getSubmit())){
	        	ActionErrors actionErrors = new ActionErrors();
	        	if(Process1.notVaild(ramForm.getTenRam())==true){
	        		actionErrors.add("lanBHError",new ActionMessage("error.lanBH"));
	        	}
	        	if(Process1.notVaild(ramForm.getLoaiRam())==true){
	        		actionErrors.add("tenKHError",new ActionMessage("error.tenKH"));
	        	}
	        	if(Process1.notVaild(ramForm.getDungLuong())==true){
	        		actionErrors.add("ngayNhanMayError",new ActionMessage("error.ngayNhanMay"));
	        	}
	        	if(Process1.notVaild(ramForm.getGia())==true){
	        		actionErrors.add("lyDoError", new ActionMessage("error.lyDo"));
	        	}
	        	if(Process1.notVaild(ramForm.getSoLuong())==true){
	        		actionErrors.add("cachXuLyError",new ActionMessage("error.cachXuLy"));
	        	}
	        	if(Process1.notVaild(ramForm.getThoiGianBH())==true){
	        		actionErrors.add("imeiError",new ActionMessage("error.imei"));
	        	}
	        	
	        	saveErrors(request, actionErrors);
				if(actionErrors.size()>0){
					return mapping.findForward("themError");
				}
	        }
	       
	        if("submit".equals(ramForm.getSubmit())){
	        	String maRam = ramForm.getMaRam();
	        	String tenRam = ramForm.getTenRam();
	        	String loaiRam = ramForm.getLoaiRam();
	            String dungLuong= ramForm.getDungLuong();
	            String gia= ramForm.getGia();
	            String soLuong = ramForm.getSoLuong();
	            String thoiGianBH = ramForm.getThoiGianBH();
	            
	            ramBO.themRam(maRam,tenRam,loaiRam,dungLuong,gia,soLuong,thoiGianBH);
	            return mapping.findForward("themThanhCong");
	        }else{
	        	 return mapping.findForward("them");
	        }
	}
}
