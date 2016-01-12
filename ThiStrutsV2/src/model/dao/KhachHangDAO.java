package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class KhachHangDAO {
	ConnectionDB con = new ConnectionDB();
	
	 public static void send(String smtpServer, String to, String from,String psw,
	    		String subject, String body) throws Exception{
	    		// java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	    		Properties props = System.getProperties();
	    		props.put("mail.smtp.host", smtpServer);
	    		props.put("mail.smtp.port", "587");
	    		props.put("mail.smtp.starttls.enable","true");
	    		final String login = from;//”nth001@gmail.com”;//usermail
	    		final String pwd = psw;//”password cua ban o day”;
	    		Authenticator pa = null; //default: no authentication
	    		if (login != null && pwd != null) { //authentication required?
	    		props.put("mail.smtp.auth", "true");
	    		pa = new Authenticator (){
	    		public PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication(login, pwd);
	    		}
	    		};
	    		}//else: no authentication
	    		Session session = Session.getInstance(props, pa);
	    		// — Create a new message –
	    		Message msg = new MimeMessage(session);
	    		// — Set the FROM and TO fields –
	    		msg.setFrom(new InternetAddress(from));
	    		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(
	    		to, false));

	    		// — Set the subject and body text –
	    		msg.setSubject(subject);
	    		msg.setText(body);
	    		// — Set some other header information –
	    		msg.setHeader("X-Mailer", "LOTONtechEmail");
	    		msg.setSentDate(new Date());
	    		msg.saveChanges();
	    		// — Send the message –
	    		Transport.send(msg);
	    		}
	
	
	public void addKhachHang(String maKH, String tenKH, String diaChi,
			String email, String soDienThoai, boolean tinhTrang)
			throws Exception {
		// TODO Auto-generated method stub
		con.ConnectionData();
		PreparedStatement pst;
		String smtpServer="smtp.aol.com";
		String to=email;
		String from="duytangdhv@aol.com";
		String subject="Thu Xac Nhan";
		String body="Chao "+tenKH+ ". Chung toi da nhan duoc yeu cau dat hang cua ban./r/n"+
    					" Chung toi se lien lac voi ban qua thong tin ban de lai. Cam on";
		String password="number123";
		//send(smtpServer, to, from, password, subject, body);
		try {
			pst = con.cn
					.prepareStatement("insert into KhachHang(MaKH,TenKH,DiaChi,Email,SoDienThoai,TinhTrang) values(?,?,?,?,?,?)");
			pst.setString(1, maKH);
			pst.setString(2, tenKH);
			pst.setString(3, diaChi);
			pst.setString(4, email);
			pst.setString(5, soDienThoai);
			pst.setBoolean(6, tinhTrang);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.cn.close();
		}

	}

	public String getMaKHDesc() throws SQLException {
		// TODO Auto-generated method stub
		con.ConnectionData();
		Statement st = con.cn.createStatement();
		String sql = "SELECT TOP 1 MaKH FROM KHACHHANG ORDER BY MaKH DESC";
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		return rs.getString("maKH");

	}

}
