package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.bean.Customer;
import common.ConnectDB;

public class CustomerDAO {
    ConnectDB cn = new ConnectDB();
    
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
    public ArrayList<Customer> getListCus() throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql= "select * from khachhang where tinhtrang = 'true' order by makh";
        Statement st = cn.con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Customer> list = new ArrayList<Customer>();
        Customer customer;
        while(rs.next()){
            customer= new Customer();
            customer.setMaKH(rs.getString(1));
            customer.setTenKH(rs.getString(2));
            customer.setDiaChi(rs.getString(3));
            customer.setEmail(rs.getString(4));
            customer.setSoDienThoai(rs.getString(5));
            customer.setTinhTrang(rs.getBoolean(6));
            list.add(customer);
        }
        cn.Disconnect();
        return list;
    }
    
    public ArrayList<Customer> getAllListCus() throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql= "select * from khachhang  order by makh";
        Statement st = cn.con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Customer> list = new ArrayList<Customer>();
        Customer customer;
        while(rs.next()){
            customer= new Customer();
            customer.setMaKH(rs.getString(1));
            customer.setTenKH(rs.getString(2));
            customer.setDiaChi(rs.getString(3));
            customer.setEmail(rs.getString(4));
            customer.setSoDienThoai(rs.getString(5));
            customer.setTinhTrang(rs.getBoolean(6));
            list.add(customer);
        }
        cn.Disconnect();
        return list;
    }

    public void addCus(String maKH, String tenKH, String diaChi,
            String email, String soDienThoai, boolean tinhTrang) throws Exception {
        // TODO Auto-generated method stub
       cn.Connect();
       String sql= "insert into khachhang values('"+maKH+"',N'"+tenKH+"',N'"+
                           diaChi+"','"+email+"','"+soDienThoai+"','true')";
    		String smtpServer="smtp.aol.com";
    		String to=email;
    		String from="duytangdhv@aol.com";
    		String subject="Thu Xac Nhan";
    		String body="Chao "+tenKH+ ". Chung toi da nhan duoc yeu cau dat hang cua ban.\r\n"+
    					" Chung toi se lien lac voi ban qua thong tin ban de lai. Cam on";
    		String password="number123";
    		//send(smtpServer, to, from, password, subject, body);
       try{
           Statement st= cn.con.createStatement();
            st.executeQuery(sql);
       }catch (Exception e) {
        // TODO: handle exception
           e.getMessage();
       }finally{
           cn.Disconnect();
       }   
      
    }

    public void delCustomer(String maKh) throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql ="update khachhang set tinhtrang="+"'false'"+" where makh='"+maKh+"'";
        try{
            Statement  st = cn.con.createStatement();
            st.executeUpdate(sql);
        }catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }finally{
            cn.Disconnect();
        }
        
    }
    public Customer getInfoCustomer(String maKh) throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql="select * from khachhang where makh='"+maKh+"'";
        Statement st = cn.con.createStatement();
        ResultSet rs= st.executeQuery(sql);
        Customer customer = new Customer();
        while(rs.next()){
            customer.setMaKH(maKh);
            customer.setTenKH(rs.getString(2));
            customer.setDiaChi(rs.getString(3));
            customer.setEmail(rs.getString(4));
            customer.setSoDienThoai(rs.getString(5));
            customer.setTinhTrang(rs.getBoolean(6)); 
        }
        cn.Disconnect();
        return customer;
    }

    public void editCus(String maKH, String tenKH, String diaChi,
            String email, String soDienThoai, boolean tinhTrang) throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql ="update khachhang set tenkh=N'"+tenKH+"',diachi=N'"+diaChi
        +"',email='"+email+"',sodienthoai='"+soDienThoai+"',tinhtrang='true' where makh='"+maKH+"'";
        try{
            Statement st = cn.con.createStatement();
            st.executeUpdate(sql);
        }catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }finally{
            cn.Disconnect();
        }
        
        
    }

    public String getMaKH() {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql = "select top 1 MaKH from KHACHHANG order by MaKH desc";
        Statement st = null;
        ResultSet rs = null;
        String id = null;
        int soTang2 = 0;
        String traVe = "KH";
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            id = rs.getString(1);
            String soTang = id.substring(2, id.length());
            soTang2 = Integer.parseInt(soTang);
            if (soTang2 < 9) {
                traVe = "KH0";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return traVe + (soTang2 + 1);
    }
//   public static void main(String[] args) throws Exception {
//    CustomerDAO c= new CustomerDAO();
//    c.addCus("KH20", "Duy", "Vinh", "hoihanlamgi@gmail.com", "01659150026", true);
//    System.out.println("sendok");
//}

}
