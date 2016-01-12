package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BoPhan;
import model.bean.LoaiBoPhan;
import model.bo.BoPhanBO;
import model.bo.LoaiBoPhanBO;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachBoPhanForm;

public class DanhSachBoPhanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		DanhSachBoPhanForm danhSachBoPhanForm = (DanhSachBoPhanForm)form;
		
		//lay danh sach loai bo phan
		LoaiBoPhanBO loaiBoPhanBO =new LoaiBoPhanBO();
		ArrayList<LoaiBoPhan> listLoaiBoPhan = loaiBoPhanBO.getListLoaiBoPhan();
		danhSachBoPhanForm.setListLoaiBoPhan(listLoaiBoPhan);
		
		// lay danh sach bo phan chi tiet
		ArrayList<BoPhan> listBoPhan;
		BoPhanBO boPhanBO = new BoPhanBO();
		String maLoai =danhSachBoPhanForm.getMaLoai();
		if(maLoai==null || maLoai.length()==0){
			listBoPhan = boPhanBO.getListBoPhan();
		} else {
			listBoPhan = boPhanBO.getListBoPhan(maLoai);
		}
		danhSachBoPhanForm.setListBoPhan(listBoPhan);
		
		return mapping.findForward("dsBoPhan");
	}
	
}
