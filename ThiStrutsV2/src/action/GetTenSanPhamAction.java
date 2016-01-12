package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SanPham2;
import model.bo.ProductBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.MyException;
import form.OrderDetailForm;

public class GetTenSanPhamAction extends Action {
   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception {
      OrderDetailForm a = (OrderDetailForm) form;
      String tenHang = a.getTenHang();
      System.out.println(tenHang);
      ProductBO productBO = new ProductBO();
      try {
         ArrayList<SanPham2> arrSanPham = productBO.getArrSanPham(tenHang);
         arrSanPham.add(0, new SanPham2("null","--Chọn sản phẩm--"));
         a.setArrSanPham(arrSanPham);
      } catch (MyException e) {
         System.out.println(e.getMessage());
         ArrayList<SanPham2> arrSanPham = new ArrayList<SanPham2>();
         arrSanPham.add(new SanPham2("null","Không có sản phẩm nào"));
         a.setArrSanPham(arrSanPham);
         a.setMessage(e.getMessage());
      }
      return mapping.findForward("getAjax");
   }
}
