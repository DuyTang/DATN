package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Ram1;
import model.bo.Ram1BO;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;
import form.RamForm;

public class SuaRamAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		 RamForm ramForm= (RamForm) form;
	       Ram1BO ramBO = new Ram1BO();
	        String maRam = ramForm.getMaRam();

	        if("submit".equals(ramForm.getSubmit())){
	        	ActionErrors actionErrors = new ActionErrors();
	        	if(Process1.notVaild(ramForm.getTenRam())==true){
	        		actionErrors.add("tenRamError",new ActionMessage("error.tenRam"));
	        	}
	        	if(Process1.notVaild(ramForm.getLoaiRam())==true){
	        		actionErrors.add("loaiRamError",new ActionMessage("error.loaiRam"));
	        	}
	        	if(Process1.notVaild(ramForm.getDungLuong())==true){
	        		actionErrors.add("dungLuongError",new ActionMessage("error.dungLuong"));
	        	}
	        	if(Process1.notVaild(ramForm.getGia())==true){
	        		actionErrors.add("giaError", new ActionMessage("error.gia"));
	        	}
	        	if(Process1.notVaild(ramForm.getSoLuong())==true){
	        		actionErrors.add("soLuongError",new ActionMessage("error.soLuong"));
	        	}
	        	if(Process1.notVaild(ramForm.getThoiGianBH())==true){
	        		actionErrors.add("thoiGianError",new ActionMessage("error.thoiGian"));
	        	}
	        	
	        	saveErrors(request, actionErrors);
				if(actionErrors.size()>0){
					return mapping.findForward("suaError");
				}
	        }
	       
	        if("submit".equals(ramForm.getSubmit())){
	        	String tenRam = ramForm.getTenRam();
	        	String loaiRam = ramForm.getLoaiRam();
	            String dungLuong= ramForm.getDungLuong();
	            String gia= ramForm.getGia();
	            String soLuong = ramForm.getSoLuong();
	            String thoiGianBH = ramForm.getThoiGianBH();
	            
	            ramBO.suaRam(maRam,tenRam,loaiRam,dungLuong,gia,soLuong,thoiGianBH);
	            return mapping.findForward("suaThanhCong");
	        }else{
	            Ram1 ram = ramBO.getThongTinRam(maRam);
	            ramForm.setTenRam(ram.getTenRam());
	            ramForm.setLoaiRam(ram.getLoaiRam());
	            ramForm.setDungLuong(ram.getDungLuong());
	            ramForm.setGia(ram.getGia());
	            ramForm.setSoLuong(ram.getSoLuong());
	            ramForm.setThoiGianBH(ram.getThoiGianBH());;
	            
	            return mapping.findForward("sua");
	        }
	}
}
