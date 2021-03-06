package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaoHanh;
import model.bo.BaoHanhBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaoHanhForm;

public class BaoHanhAction extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // TODO Auto-generated method stub
        BaoHanhForm baoHanhForm = (BaoHanhForm) form;
        ArrayList<BaoHanh> list;
        BaoHanhBO baoHanhBO = new BaoHanhBO();
        list = baoHanhBO.getdsBaoHanh();
        baoHanhForm.setList(list);
        return mapping.findForward("danhSach");
    }
 
}
