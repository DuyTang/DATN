package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.BaoHanh;
import model.dao.BaoHanhDAO;

public class BaoHanhBO {
	 BaoHanhDAO baoHanhDAO= new BaoHanhDAO();
	public ArrayList<BaoHanh> getdsBaoHanh() throws SQLException {
		// TODO Auto-generated method stub
		 return baoHanhDAO.getdsBaoHanh();
	}
	public void themBaoHanh(String maBH,String lanBaoHanh, String tenKH,
			String ngayNhanMay, String ngayTraMay, String lyDo,
			String cachXuLy, String iMEI, String soDienThoai) throws SQLException {
		// TODO Auto-generated method stub
		baoHanhDAO.themBaoHanh(maBH,lanBaoHanh, tenKH, ngayNhanMay, ngayTraMay, lyDo, cachXuLy, iMEI, soDienThoai);

	}
	public void traBaoHanh(String maBH) throws SQLException {
		// TODO Auto-generated method stub
		baoHanhDAO.traBH(maBH);
	}
	
	
	public BaoHanh getThongTinBH(String maBH) throws SQLException {
		// TODO Auto-generated method stub
		return baoHanhDAO.getThongTinBH(maBH);
	}
	public String getMaBH() {
		// TODO Auto-generated method stub
		return baoHanhDAO.getMaBH();
	}
    public void suaBaoHanh(String maBH, String lanBaoHanh, String tenKH,
            String ngayNhanMay, String ngayTraMay, String lyDo,
            String cachXuLy, String tinhTrangSua, String soDienThoai,
            String iMEI) throws SQLException {
        // TODO Auto-generated method stub
        baoHanhDAO.suaBaoHanh(maBH,lanBaoHanh,tenKH, ngayNhanMay, ngayTraMay, lyDo, cachXuLy,tinhTrangSua,soDienThoai,iMEI);
    }
    public ArrayList<BaoHanh> getdsBaoHanhDaSua() throws SQLException {
        // TODO Auto-generated method stub
        return baoHanhDAO.getdsBaoHanhDaSua();
    }
    
    public ArrayList<BaoHanh> getdsBaoHanhDangSua() throws SQLException {
        // TODO Auto-generated method stub
        return baoHanhDAO.getdsBaoHanhDangSua();
    }
    
    public ArrayList<BaoHanh> getThongTinBaoHanh(String maBH) throws SQLException {
        // TODO Auto-generated method stub
        return baoHanhDAO.getThongTinBaoHanh(maBH);
    }
	public String getLanBH(String maSP) {
		// TODO Auto-generated method stub
		return baoHanhDAO.getLanBH(maSP);
	}
	public ArrayList<BaoHanh> getdsBaoHanhKH() throws SQLException {
		// TODO Auto-generated method stub
		return baoHanhDAO.getdsBaoHanhDaSua();
	}

}
