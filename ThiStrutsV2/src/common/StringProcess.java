package common;

import java.net.FileNameMap;
import java.net.URLConnection;
import java.text.SimpleDateFormat;

public class StringProcess {
	/**
	 * Ham kiem tra xau rong hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean kiemTraTrong(String s) {
		if (s == null || s.length() == 0)
			return true;
		return false;
	}

	/**
	 * Ham kiem tra xem xau co bao gom chi chu so hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static final String LINKIMG = "D:\\Material\\doan\\ThiStrutsV2\\WebContent\\img\\imgLapTop";
	public static final String LINKAJAX = "E:D:\\Material\\doan\\ThiStrutsV2\\WebContent";
	
	
	
	public static boolean kiemTraNumber(String s) {
		if (kiemTraTrong(s))
			return true;
		String regex = "[0-9]+";
		if (s.matches(regex))
			return false;
		return true;
	}

	// ham kiem tra ngay co dung dinh dang hay khong
	public static boolean kiemTraNgay(String tam) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(tam);
		} catch (Exception pe) {
			return false;
		}
		return true;
	}

	// ham kiem tra email co hop le hay khong
	public static boolean kiemTraEmail(String email) {
		String emailDung = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "gmail.com||yahoo.com";
		if (email.matches(emailDung) == false) {
			return false;
		}
		return true;
	}

	// ham kiem tra so dien thoai co hop le hay khong
	public static boolean kiemTraSoDienThoai(String sdt) {
		String so = "0\\d{10}";
		if (sdt.matches(so) == false) {
			return false;
		}
		return true;
	}
	// kieu tra kieu du lieu upload: 
	public static String getMimeType(String fileUrl) throws java.io.IOException {
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String type = fileNameMap.getContentTypeFor(fileUrl);
		return type;
	}
	public static String suaTien(String tien) {
		return tien.substring(0,tien.length() - 5);
	}
	public static boolean notValid(String s){
		if(s == null || s.length() ==0){
			return true;
		}
		return false;
	}
	/**
	 * ham kiem tra xem xau co bao gom chi chu so hay ko 
	 * 
	 */
	public static boolean notValidNumber(String s){
		if(notValid(s)) return true;
		String regex = "[0-9]+";
		if(s.matches(regex)) return false;
		return true;
	}
	/**
	 * do dai MA nhan vien khong duoc vuot qua 4
	 * 
	 */
	public static boolean notStringLenght(String s){
		if(s.length()<=4){
			return false;
		}
		return true;
	}
	/**
	 * kiem tra tinh hop le cua Email
	 * 
	 */
	public static boolean ValidEmail(String email){
		String emailDung = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "gmail.com||yahoo.com";
	        if(email.matches(emailDung) == false) {
	            return false;
	        }
	        return true;
	}
	public static boolean ValidSoDienThoai(String soDienThoai){
		 String so = "01\\d{9}||09\\d{8}";
	        if(soDienThoai.matches(so) == false) {
	            return false;
	        }
	        return true;
	}
}
