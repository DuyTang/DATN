package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Ram1;
import model.bo.Ram1BO;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.RamForm;


public class RamAction extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // TODO Auto-generated method stub
        RamForm ramForm = (RamForm) form ;
        ArrayList<Ram1> list;
        Ram1BO ramBO = new Ram1BO();
        list = ramBO.getdsRam();
        ramForm.setList(list);
        return mapping.findForward("dsram");
    }
 

}
