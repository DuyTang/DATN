package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.HangSanPhamBean;
import model.bean.LoaiSanPhamBean;
import model.bean.SanPham;
import model.bean.SanPhamBean;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import common.StringProcess;

public class SanPhamForm extends ActionForm {
	private String maLoaiSP;
	private String tenSP;
	private String giaNhapSP;
	private String giaBanSP;
	private FormFile anhSP;
	private String linkAnh;
	private ArrayList<LoaiSanPhamBean> arrLoaiSanPham;
	private String maLoai;
	private ArrayList<HangSanPhamBean> arrHangSanPham;
	private String maHang;
	private String soLuong;
	private String cpu;
	private String ram;
	private String manHinh;
	private String diaCung;
	private String doHoa;
	private String trongLuong;
	private String thoiGianBaoHanh;
	private String submit;
	private String sanPhamMoi;
	private ArrayList<SanPham> list;
	private ArrayList<SanPhamBean> arrSanPhamBean;
	public String getSanPhamMoi() {
		return sanPhamMoi;
	}
	public void setSanPhamMoi(String sanPhamMoi) {
		this.sanPhamMoi = sanPhamMoi;
	}
	public String getLinkAnh() {
		return linkAnh;
	}
	public void setLinkAnh(String linkAnh) {
		this.linkAnh = linkAnh;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}



	public FormFile getAnhSP() {
		return anhSP;
	}

	public void setAnhSP(FormFile anhSP) {
		this.anhSP = anhSP;
	}

	public ArrayList<LoaiSanPhamBean> getArrLoaiSanPham() {
		return arrLoaiSanPham;
	}

	public void setArrLoaiSanPham(ArrayList<LoaiSanPhamBean> arrLoaiSanPham) {
		this.arrLoaiSanPham = arrLoaiSanPham;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public ArrayList<HangSanPhamBean> getArrHangSanPham() {
		return arrHangSanPham;
	}

	public void setArrHangSanPham(ArrayList<HangSanPhamBean> arrHangSanPham) {
		this.arrHangSanPham = arrHangSanPham;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}


	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getManHinh() {
		return manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public String getDiaCung() {
		return diaCung;
	}

	public void setDiaCung(String diaCung) {
		this.diaCung = diaCung;
	}

	public String getDoHoa() {
		return doHoa;
	}

	public void setDoHoa(String doHoa) {
		this.doHoa = doHoa;
	}

	public String getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(String trongLuong) {
		this.trongLuong = trongLuong;
	}

	public String getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	
	public String getGiaNhapSP() {
		return giaNhapSP;
	}

	public void setGiaNhapSP(String giaNhapSP) {
		this.giaNhapSP = giaNhapSP;
	}

	public String getGiaBanSP() {
		return giaBanSP;
	}

	public void setGiaBanSP(String giaBanSP) {
		this.giaBanSP = giaBanSP;
	}

	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	
	 public ArrayList<SanPhamBean> getArrSanPhamBean() {
		return arrSanPhamBean;
	}
	public void setArrSanPhamBean(ArrayList<SanPhamBean> arrSanPhamBean) {
		this.arrSanPhamBean = arrSanPhamBean;
	}
	
	
	public ArrayList<SanPham> getList() {
		return list;
	}
	public void setList(ArrayList<SanPham> list) {
		this.list = list;
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
