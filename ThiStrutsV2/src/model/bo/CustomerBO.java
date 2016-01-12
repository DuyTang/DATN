package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Customer;
import model.dao.CustomerDAO;

public class CustomerBO {
       static CustomerDAO customerDAO = new CustomerDAO();
    public ArrayList<Customer> getListCus() throws SQLException {
        // TODO Auto-generated method stub
        return customerDAO.getListCus();
    }
    public void delCustomer(String maKh) throws SQLException {
        // TODO Auto-generated method stub
        customerDAO.delCustomer(maKh);      
    }

    public Customer getInfoCustomer(String maKh) throws SQLException {
        // TODO Auto-generated method stub
        return customerDAO.getInfoCustomer(maKh);
    }

	public void addCus(String maKH, String tenKH, String diaChi, String email,
			String soDienThoai, boolean tinhTrang) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.addCus(maKH,tenKH,diaChi,email,soDienThoai,tinhTrang);
	}

	public void editCus(String maKH, String tenKH, String diaChi, String email,
			String soDienThoai, boolean tinhTrang) throws SQLException {
		// TODO Auto-generated method stub
		customerDAO.editCus(maKH,tenKH,diaChi,email,soDienThoai,tinhTrang);
	}
    public static String getMaKH() {
        // TODO Auto-generated method stub
        return  customerDAO.getMaKH();
    }
    public ArrayList<Customer> getAllListCus() throws SQLException {
        // TODO Auto-generated method stub
        return customerDAO.getAllListCus();
    }
 
}
