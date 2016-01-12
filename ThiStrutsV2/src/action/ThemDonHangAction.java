package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SanPhamBean;
import model.bo.CustomerBO;
import model.bo.CusSendOrderBO;
import model.bo.CusSendOrderDetailBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ThemDonHangAction extends Action {

   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception {
      HttpSession session = request.getSession();
      ArrayList<SanPhamBean> arr = (ArrayList<SanPhamBean>) session
            .getAttribute("arrSP");
      if (arr == null) {
         return mapping.findForward("chuaCoSP");
      } else {
         String tenKH = request.getParameter("tenKH");
         String diaChi = request.getParameter("diaChiKH");
         String email = request.getParameter("emailKH");
         String sdt = request.getParameter("sdtKH");
         String tongGia = request.getParameter("tongGiaGioHang");
         CustomerBO customer = new CustomerBO();
         String id = customer.getMaKH();
         boolean tinhTrang = true;
         customer.addCus(id, tenKH, diaChi, email, sdt, tinhTrang);

         CusSendOrderBO orderBO = new CusSendOrderBO();
         String autoIncrementMaHD = orderBO.getAutoIncrementMaHD();
         try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String ngayDatHang = format.format(new Date());
            orderBO.addOrder(autoIncrementMaHD, id, ngayDatHang, null, diaChi,
                  tongGia, "1");
         } catch (Exception e) {
            e.printStackTrace();
         }

         // them vao Chi Tiet Don Hang
         try {
            CusSendOrderDetailBO orderDetailBO = new CusSendOrderDetailBO();
            for (int i = 0; i < arr.size(); i++) {
               SanPhamBean sp = arr.get(i);
               String maHD = autoIncrementMaHD;
               String maLoaiSP = sp.getMaSP();
               String imei = null;
               String giaBan = sp.getGiaNhapSP();
               String soLuong = sp.getSoLuong();
               int soLuong1 = Integer.parseInt(soLuong);
               
               if(Integer.parseInt(soLuong) > 1) {
            	   for (int j = 0; j < Integer.parseInt(soLuong); j++) {
            		   String maCTDH = orderDetailBO.getAutoIncrementMaCTDH();
                       orderDetailBO.addOrderDetail(maHD, maLoaiSP, imei, giaBan,
                             maCTDH,soLuong1);
				}
               }
               else {
            	   String maCTDH = orderDetailBO.getAutoIncrementMaCTDH();
                   orderDetailBO.addOrderDetail(maHD, maLoaiSP, imei, giaBan,
                         maCTDH,soLuong1);
               }
               
               
            }
            ArrayList<SanPhamBean> arr4 = new ArrayList<SanPhamBean>();
            session.setAttribute("arrSP", arr4);
         } catch (Exception e) {
            e.printStackTrace();
         }

         return mapping.findForward("thanhCong");
      }
   }
}
