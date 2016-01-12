package common;

import java.util.Date;

public class Validate {
   private final static String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
         + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

   public static boolean isValidEmail(String email) {
      // TODO Auto-generated method stub
      if (!email.matches(EMAIL_REGEX)) {
         return false;
      }
      return true;
   }

   public static boolean isValidDeliverDay(Date parsedNgayDatHang,
         Date parsedNgayGiaoHang) {
      // TODO Auto-generated method stub

      // Neu ngay giao hang o truoc ngay dat hang thi return false
      if (parsedNgayGiaoHang.before(parsedNgayDatHang)) {
         return false;
      }
      return true;
   }

   public static boolean isValidPrice(String tongTien) {
      // TODO Auto-generated method stub
      if ("".equals(tongTien) || tongTien == null) {
         return false;
      }
      // Neu tong tien co chua ky ty khac tu 0 - 9 va khac dau cham
      for (int i = 0; i < tongTien.length(); i++) {
         if ((tongTien.charAt(i) < '0' || tongTien.charAt(i) > '9')) {
            if (tongTien.charAt(i) != ',') {
               return false;
            }
         }
      }
      return true;
   }

   public static boolean isValidImei(String imei) {
      // TODO Auto-generated method stub
      if ("".equals(imei) || imei == null) {
         return false;
      }
      for (int i = 0; i < imei.length(); i++) {
         char c = imei.charAt(i);
         if (!Character.isDigit(c) && !Character.isLetter(c)) {
            return false;
         }
      }
      return true;
   }
}
