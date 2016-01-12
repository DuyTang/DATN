package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ChiTietBoPhan;
import model.bean.SanPhamLapRap;
import model.dao.ChiTietBoPhanDAO;
    
public class ChiTietBoPhanBO {
	ChiTietBoPhanDAO chiTietBoPhanDAO = new ChiTietBoPhanDAO();
	
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanHDD() throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanHDD();
	}
	
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanChuot() throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanChuot();
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanManHinh() throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanManHinh();
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanBanPhim() throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanBanPhim();
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanCase() throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanCase();
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanNguon() throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanNguon();
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanPhuKien() throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanPhuKien();
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanDVD() throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanDVD();
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanTanNhiet() throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanTanNhiet();
	}

	public SanPhamLapRap getChuot(String chuot1) throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getChuot(chuot1);
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanChuot(String chuot1) throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanChuot(chuot1);
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanHDD(String hdd1) {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanHDD(hdd1);
	}
	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanManHinh(String manHinh1) throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanManHinh(manHinh1);
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanBanPhim(String banPhim1) throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanBanPhim(banPhim1);
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanCase(String caseS1) throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanCase(caseS1);
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanNguon(String nguon1) throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanNguon(nguon1);
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanPhuKien(String phuKien1) throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanPhuKien(phuKien1);
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanDVD(String dvd1) throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanDVD(dvd1);
	}

	public ArrayList<ChiTietBoPhan> getListChiTietBoPhanTanNhiet(String tanNhiet1) throws SQLException {
		// TODO Auto-generated method stub
		return chiTietBoPhanDAO.getListChiTietBoPhanTanNhiet(tanNhiet1);
	}

}
