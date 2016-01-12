package action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.OrderBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.MyException;
import common.Validate;

import form.OrderForm;

public class AddOrderAction extends Action {
   @Override
   public ActionForward execute(ActionMapping mapping, ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception {
      request.setCharacterEncoding("UTF-8");
      OrderForm orderForm = (OrderForm) form;
      OrderBO orderBO = new OrderBO();
      if ("SUBMIT".equals(orderForm.getButtonClicked())) {
         String maHD = orderForm.getMaHD();
         String maKH = orderForm.getMaKH();
         String ngayDatHang = orderForm.getNgayDatHang();
         String ngayGiaoHang = orderForm.getNgayGiaoHang();
         String noiGiaoHang = orderForm.getNoiGiaoHang();
         String tongTien = orderForm.getTongTien();
         String tinhTrangGiaoHang = orderForm.getTinhTrangGiaoHang();

         // Validate
         ActionErrors actionErrors = new ActionErrors();
         // validate tong tien
         if (!Validate.isValidPrice(tongTien)) {
            actionErrors.add("tongTienError", new ActionMessage(
                  "error.tongTien"));
         }

         // Validate ngay giao hang
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
         Date parsedNgayDatHang = null;
         Date parsedNgayGiaoHang = null;
         try {
            parsedNgayDatHang = format.parse(ngayDatHang);
            parsedNgayGiaoHang = format.parse(ngayGiaoHang);

            // kiem tra tinh hop le cua ngay giao hang
            if (!Validate.isValidDeliverDay(parsedNgayDatHang,
                  parsedNgayGiaoHang)) {
               actionErrors.add("ngayGiaoHangError", new ActionMessage(
                     "error.ngayGiaoHang"));
            }
         } catch (ParseException e) {
            actionErrors.add("ngayGiaoHangError", new ActionMessage(
                  "error.ngayGiaoHangParse"));
         }
         
         //kiem tra ma khach hang
         if(!orderBO.isExistedCustomer(maKH)){
            actionErrors.add("maKhachHangError", new ActionMessage(
                  "error.khachHangChuaTonTai"));
         }
         
         saveErrors(request, actionErrors);
         if (actionErrors.size() > 0) {
            return mapping.findForward("failed");
         }

         try {
            orderBO.addOrder(maHD, maKH, parsedNgayDatHang, parsedNgayGiaoHang,
                  noiGiaoHang, tongTien, tinhTrangGiaoHang);
         } catch (MyException e) {
            orderForm.setMessage(e.getMessage());
            return mapping.findForward("failed");
         }
         orderForm.setMessage("success");
         return mapping.findForward("success");
      } else {
         // Neu chua nhan submit thi day la lan dau hien thi
         try {
            String autoIncrementMaHD = orderBO.getAutoIncrementMaHD();
            orderForm.setMaHD(autoIncrementMaHD);
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            orderForm.setNgayDatHang(format.format(date));
         } catch (MyException e) {
            orderForm.setMessage(e.getMessage());
         }
         return mapping.findForward("firstShowScreen");
      }
   }
}
