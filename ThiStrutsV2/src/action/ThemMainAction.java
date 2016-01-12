package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.Main1BO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;
import form.MainForm;

public class ThemMainAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		 MainForm mainForm= (MainForm) form;
	       Main1BO main1BO = new Main1BO();
	       String idMaMain= main1BO.getMaMain();
	       mainForm.setMaMain(idMaMain);

	        if("submit".equals(mainForm.getSubmit())){
	        	ActionErrors actionErrors = new ActionErrors();
	        	if(Process1.notVaild(mainForm.getTenMain())==true){
	        		actionErrors.add("tenMainError",new ActionMessage("error.tenMain"));
	        	}
	        	if(Process1.notVaild(mainForm.getGia())==true){
	        		actionErrors.add("giaError", new ActionMessage("error.gia"));
	        	}
	        	if(Process1.notVaild(mainForm.getSoLuong())==true){
	        		actionErrors.add("soLuongError",new ActionMessage("error.soLuong"));
	        	}
	        	if(Process1.notVaild(mainForm.getThoiGianBH())==true){
	        		actionErrors.add("thoiGianBHError",new ActionMessage("error.thoiGianBH"));
	        	}
	        	if(Process1.notVaild(mainForm.getSoKheCam())==true){
	        		actionErrors.add("soKheCamError",new ActionMessage("error.soKheCam"));
	        	}
	        	if(Process1.notVaild(mainForm.getSocket())==true){
	        		actionErrors.add("socketError",new ActionMessage("error.socket"));
	        	}
	        	if(Process1.notVaild(mainForm.getDungLuong())==true){
	        		actionErrors.add("dungLuongError",new ActionMessage("error.dungLuong"));
	        	}
	        	if(Process1.notVaild(mainForm.getLoaiRam())==true){
	        		actionErrors.add("loaiRamError",new ActionMessage("error.loaiRam"));
	        	}
	        	saveErrors(request, actionErrors);
				if(actionErrors.size()>0){
					return mapping.findForward("themError");
				}
	        }
	       
	        if("submit".equals(mainForm.getSubmit())){
	        	String maMain = mainForm.getMaMain();
	        	String tenMain = mainForm.getTenMain();
	        	String gia= mainForm.getGia();
	        	String soLuong = mainForm.getSoLuong();
	        	String thoiGianBH = mainForm.getThoiGianBH();
	        	String soKheCam = mainForm.getSoKheCam();
	        	String socket = mainForm.getSocket();
	            String dungLuong= mainForm.getDungLuong();
	            String loaiRam = mainForm.getLoaiRam();
	            
	            main1BO.themMain(maMain,tenMain,gia,soLuong,thoiGianBH,soKheCam,socket,dungLuong,loaiRam);
	            return mapping.findForward("themThanhCong");
	        }else{
	        	 return mapping.findForward("them");
	        }
	}
}
