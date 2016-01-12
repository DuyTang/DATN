package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.HangSanPham;
import model.bo.OrderDetailBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.MyException;
import common.Validate;

import form.OrderDetailForm;

public class AddOrderDetailAction extends Action {
   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception {
      request.setCharacterEncoding("UTF-8");
      String maHD = request.getParameter("maHD");
      OrderDetailForm orderDetailForm = (OrderDetailForm) form;
      OrderDetailBO orderDetailBO = new OrderDetailBO();
      if ("SUBMIT".equals(orderDetailForm.getButtonClicked())) {
         try {
            /*
             * vi ma hoa don da set cung voi gia tri truyen ve tu parameter nen
             * khong can getMaHD nua
             */
            ActionErrors actionErrors = new ActionErrors();
            String maLoaiSP = orderDetailForm.getMaLoaiSP();
            String imei = orderDetailForm.getImei();
            String giaBan = orderDetailForm.getGiaBan();
            String maChiTietDonHang = orderDetailForm.getMaChiTietDonHang();

            // Validate
            // validate giaBan
            if (!Validate.isValidPrice(giaBan)) {
               actionErrors.add("giaBanError", new ActionMessage(
                     "error.giaBanError"));
            }

            // validate imei
            if (!Validate.isValidImei(imei)) {
               actionErrors.add("imeiError", new ActionMessage(
                     "error.imeiKhongHopLe"));
            }
            // Neu IMEI da co trong 2 bang chitietdonlaprap va chitietdondathang
            if (orderDetailBO.isImeiInChiTietDonLapRap(imei)
                  || orderDetailBO.isImeiInChiTietDonDatHang(imei)) {
               actionErrors.add("imeiError", new ActionMessage(
                     "error.imeiDaTonTai"));
            }

            // validate ma loai sp
            if (maLoaiSP == null || "".equals(maLoaiSP)) {
               actionErrors.add("maLoaiSPError", new ActionMessage(
                     "error.maLoaiSPNull"));
            } else if (!orderDetailBO.isExistedMaLoaiSP(maLoaiSP)) {
               actionErrors.add("maLoaiSPError", new ActionMessage(
                     "error.maLoaiSPKhongTonTai"));
            }

            saveErrors(request, actionErrors);
            if (actionErrors.size() > 0) {
               String autoIncrementMaCTDH = orderDetailBO
                     .getAutoIncrementMaCTDH();
               orderDetailForm.setMaChiTietDonHang(autoIncrementMaCTDH);
               orderDetailForm.setMaHD(maHD);
               ArrayList<HangSanPham> arrHangSP = orderDetailBO.getArrHangSP();
               orderDetailForm.setArrHangSP(arrHangSP);
               return mapping.findForward("failed");
            }

            orderDetailBO.addOrderDetail(maHD, maLoaiSP, imei, giaBan,
                  maChiTietDonHang);
         } catch (MyException e) {
            ArrayList<HangSanPham> arrHangSP = orderDetailBO.getArrHangSP();
            orderDetailForm.setArrHangSP(arrHangSP);
            orderDetailForm.setMessage(e.getMessage());
            return mapping.findForward("failed");
         }
         // orderDetailForm.setMessage("success");

         /*
          * Gan lai parameter maHD truyen ve cho orderDetail de tranh loi define
          * bean
          */
         String path = mapping.findForward("success").getPath();
         path = path + "?maHD=" + maHD;
         return new ActionForward(path);
         // return mapping.findForward("success");
      } else {
         // Neu chua nhan submit thi day la lan dau hien thi
         try {
            // lay ma chi tiet don hang tu dong tang
            String autoIncrementMaCTDH = orderDetailBO.getAutoIncrementMaCTDH();
            orderDetailForm.setMaChiTietDonHang(autoIncrementMaCTDH);
            orderDetailForm.setMaHD(maHD);
            ArrayList<HangSanPham> arrHangSP = orderDetailBO.getArrHangSP();
            orderDetailForm.setArrHangSP(arrHangSP);
         } catch (MyException e) {
            orderDetailForm.setMessage(e.getMessage());
         }
         return mapping.findForward("firstShowScreen");
      }
   }
}
