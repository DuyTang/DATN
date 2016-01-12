package common;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import java.util.regex.Pattern;



public class Process1 {
//	public static boolean validateEmail(String email) {
//	    Pattern pattern;
//	    Matcher matcher;
//	    String EMAIL_PATTERN = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
//	    
//	    pattern = Pattern.compile(EMAIL_PATTERN);
//	    matcher = pattern.matcher(email);
//	    
//	    return matcher.matches();
//	}
	/**
	 * Ham kiem tra xau rong hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaild(String s){
		if(s==null || s.length()==0) return true;
		return false;
	}
	
	
	//ham kiem tra email co hop le hay khong
    public static boolean kiemTraEmail(String email) {
        String emailDung = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "gmail.com||yahoo.com";
        if(email.matches(emailDung) == false) {
            return false;
        }
        return true;
    }
    //ham kiem tra so dien thoai co hop le hay khong
    public static boolean kiemTraSoDienThoai(String sdt) {
        String so = "01\\d{9}||09\\d{8}";
        if(sdt.matches(so) == false) {
            return false;
        }
        return true;
    }
    // hÃ m kiá»ƒm tra xÃ¢u cÃ³ pháº£i lÃ  sá»‘ hay k
    public static boolean notVaildNumber(String s){
        if(notVaild(s)) return true;
        String regex = "^[a-zA-Z\\sÃ Ã¡áº¡Ã£_-]{3,25}$"; 
        if(s.matches(regex)) return false;
        return true;
    }

    public static boolean isValidDate(String dateToValidate, String dateFromat) {

        if (dateToValidate == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {
            // if not valid, it will throw ParseException
            java.util.Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // kiểm tra tính hợp lệ của lần bảo hành
    public static boolean isNumericOnlyNumber(String str) {
        return str.matches("\\d+");
    }

    public boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date testDate = null;
        String errorMessage;
        try {
            testDate = (Date) sdf.parse(date);
        } catch (ParseException e) {
            errorMessage = "the date you provided is in an invalid date"
                    + " format.";
            return false;
        }
        if (!sdf.format(testDate).equals(date)) {
            errorMessage = "The date that you provided is invalid.";
            return false;
        }
        return true;
    } // end isValidDate
}
