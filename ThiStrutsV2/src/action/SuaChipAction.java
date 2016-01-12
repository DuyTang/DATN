package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Chip1;
import model.bo.Chip1BO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Process1;
import form.ChipForm;

public class SuaChipAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ChipForm mainForm = (ChipForm) form;
		Chip1BO main1BO = new Chip1BO();
		String maChip = mainForm.getMaChip();
		if("submit".equals(mainForm.getSubmit())){
        	ActionErrors actionErrors = new ActionErrors();
        	if(Process1.notVaild(mainForm.getTenChip())==true){
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
        	if(Process1.notVaild(mainForm.getSocket())==true){
        		actionErrors.add("socketError",new ActionMessage("error.socket"));
        	}
        	saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themError");
			}
        }
       
        if("submit".equals(mainForm.getSubmit())){
        	String tenMain = mainForm.getTenChip();
        	String socket = mainForm.getSocket();
        	String gia= mainForm.getGia();
        	String soLuong = mainForm.getSoLuong();
        	String thoiGianBH = mainForm.getThoiGianBH();
          main1BO.suaMain(maChip,tenMain,socket,gia,soLuong,thoiGianBH);
            return mapping.findForward("suaThanhCong");
        }else{
        	Chip1 main = main1BO.getThongTin(maChip);
        	mainForm.setTenChip(main.getTenChip());
        	mainForm.setSocket(main.getSocket());
        	mainForm.setGia(main.getGia());
        	mainForm.setSoLuong(main.getSoLuong());
        	mainForm.setThoiGianBH(main.getThoiGianBH());
        	 return mapping.findForward("sua");
        }
		
	}

}
