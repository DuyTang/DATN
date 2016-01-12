package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.OrderDetail;
import model.bean.OrderInfor;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class OrderDetailListForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private ArrayList<OrderDetail> orderDetailList;
	private String maHD;
	private String message;
	private String listStatus;

	/*
	 * Ta tao moi 1 bean la OrderInfor luu tru cac thong tin sau: tenKH
	 * ngayDatHang noiGiaoHang tinhTrangGiaoHang
	 */
	private OrderInfor orderInfor;
	
	// Getters and setters

	public OrderInfor getOrderInfor() {
		return orderInfor;
	}

	public void setOrderInfor(OrderInfor orderInfor) {
		this.orderInfor = orderInfor;
	}

	public String getListStatus() {
		return listStatus;
	}

	public void setListStatus(String listStatus) {
		this.listStatus = listStatus;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(ArrayList<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	 @Override
	    public void reset(ActionMapping mapping, HttpServletRequest request) {
	        try {
	            request.setCharacterEncoding("UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	    }
}
