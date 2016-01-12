package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BaoHanh;
import common.ConnectDB;

public class BaoHanhDAO {
    ConnectDB cn = new ConnectDB();
    PreparedStatement preSt = null;
    public ArrayList<BaoHanh> getdsBaoHanh() throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql = "select MaBH,LanBaoHanh,TenKH,NgayNhanMay,NgayTraMay,LyDo,TinhTrangSua,"+
        "CachXuLy,TinhTrang,IMEI,DienThoai from BAOHANH order by MaBH";
        Statement st = cn.con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<BaoHanh> list = new ArrayList<BaoHanh>();
        BaoHanh baoHanh;
        while (rs.next()) {
            baoHanh = new BaoHanh();
            baoHanh.setMaBH(rs.getString(1));
            baoHanh.setLanBaoHanh(rs.getString(2));
            baoHanh.setTenKH(rs.getString(3));
            baoHanh.setIMEI(rs.getString(10));
            baoHanh.setNgayNhanMay(rs.getString(4));
            baoHanh.setNgayTraMay(rs.getString(5));
            baoHanh.setLyDo(rs.getString(6));
            baoHanh.setTinhTrangSua(rs.getString(7));
            baoHanh.setCachXuLy(rs.getString(8));
            baoHanh.setTinhTrang(rs.getString(9));
            baoHanh.setSoDienThoai(rs.getString(11));
            list.add(baoHanh);
        }
        return list;
    }

    public void themBaoHanh(String maBH, String lanBaoHanh, String tenKH,
            String ngayNhanMay, String ngayTraMay, String lyDo,
            String cachXuLy, String iMEI, String soDienThoai)
            throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        try {
            String sql = "insert into BaoHanh values(?,?,?,?,NULL,?,N'Đang sửa',?,N'Chưa trả',?,?)";
            preSt= cn.con.prepareStatement(sql);
            preSt.setString(1 , maBH);
            preSt.setString(2 , lanBaoHanh);
            preSt.setString(3 , tenKH);
            preSt.setString(4 , ngayNhanMay);
            preSt.setString(5 , lyDo);
            preSt.setString(6 , cachXuLy);
            preSt.setString(7 , iMEI);
            preSt.setString(8 , soDienThoai);
            preSt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            if(preSt != null){
                preSt.close();
            }
            cn.Disconnect();
        }
    }

    public void traBH(String maBH) throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        try {
            String sql = "update BAOHANH set TinhTrang=N'Đã trả',NgayTraMay=GETDATE() where MaBH=?";
            preSt = cn.con.prepareStatement(sql);
            preSt.setString(1, maBH);
            preSt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            if(preSt != null){
                preSt.close();
            }
            cn.Disconnect();
        }
    }

    public void suaBaoHanh(String maBH, String lanBaoHanh, String tenKH,
            String ngayNhanMay, String ngayTraMay, String lyDo,
            String cachXuLy, String tinhTrangSua, String soDienThoai, String iMEI)
            throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        try {
            String sql = "UPDATE BAOHANH SET TenKH = ?, LyDo=?, CachXuLy=?,TinhTrangSua=?, DienThoai=? WHERE MaBH = ?";
            preSt = cn.con.prepareStatement(sql);
            preSt.setString(1, tenKH);
            preSt.setString(2, lyDo);
            preSt.setString(3, cachXuLy);
            preSt.setString(4, tinhTrangSua);
            preSt.setString(5, soDienThoai);
            preSt.setString(6, maBH);            
            preSt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            if (preSt != null) {
                preSt.close();
            }
            cn.Disconnect();
        }
    }

    public BaoHanh getThongTinBH(String maBH) throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql = "select MaBH,LanBaoHanh,TenKH,NgayNhanMay,NgayTraMay,LyDo,TinhTrangSua,"+
        "CachXuLy,TinhTrang,IMEI,DienThoai from BaoHanh where MaBH=?";
        preSt = cn.con.prepareStatement(sql);
        preSt.setString(1, maBH);
        ResultSet rs = preSt.executeQuery();
        BaoHanh baoHanh = new BaoHanh();
        while (rs.next()) {
            baoHanh.setMaBH(maBH);
            baoHanh.setLanBaoHanh(rs.getString(2));
            baoHanh.setTenKH(rs.getString(3));
            baoHanh.setNgayNhanMay(rs.getString(4));
            baoHanh.setNgayTraMay(rs.getString(5));
            baoHanh.setLyDo(rs.getString(6));
            baoHanh.setCachXuLy(rs.getString(8));
            baoHanh.setIMEI(rs.getString(10));
            baoHanh.setSoDienThoai(rs.getString(11));
        }
        cn.Disconnect();
        return baoHanh;
    }

    public String getMaBH() {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql = "select top 1 MaBH from BAOHANH order by MaBH desc";
        Statement st = null;
        ResultSet rs = null;
        String id = null;
        int soTang2 = 0;
        String traVe = "BH";
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            id = rs.getString(1);
            String soTang = id.substring(2, id.length());
            soTang2 = Integer.parseInt(soTang);
            if (soTang2 < 9) {
                traVe = "BH0";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return traVe + (soTang2 + 1);
    }

 
    public ArrayList<BaoHanh> getdsBaoHanhDaSua() throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql = "select MaBH,LanBaoHanh,TenKH,NgayNhanMay,NgayTraMay,LyDo,TinhTrangSua,"+
        "CachXuLy,TinhTrang,IMEI,DienThoai from BAOHANH where TinhTrangSua = N'Đã sửa' and TinhTrang = N'Chưa trả'";
        Statement st = cn.con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<BaoHanh> list = new ArrayList<BaoHanh>();
        BaoHanh baoHanh;
        while (rs.next()) {
            baoHanh = new BaoHanh();
            baoHanh.setMaBH(rs.getString(1));
            baoHanh.setLanBaoHanh(rs.getString(2));
            baoHanh.setTenKH(rs.getString(3));
            baoHanh.setIMEI(rs.getString(10));
            baoHanh.setNgayNhanMay(rs.getString(4));
            baoHanh.setNgayTraMay(rs.getString(5));
            baoHanh.setLyDo(rs.getString(6));
            baoHanh.setTinhTrangSua(rs.getString(7));
            baoHanh.setCachXuLy(rs.getString(8));
            baoHanh.setTinhTrang(rs.getString(9));
            baoHanh.setSoDienThoai(rs.getString(11));
            list.add(baoHanh);
        }
        return list;
    }
//    public static void main(String[] args) throws SQLException {
//        BaoHanhDAO b = new BaoHanhDAO();
//        System.out.println(b.getdsBaoHanhDaSua());
//    }

    public ArrayList<BaoHanh> getdsBaoHanhDangSua() throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql = "select MaBH,LanBaoHanh,TenKH,NgayNhanMay,NgayTraMay,LyDo,TinhTrangSua,"+
        "CachXuLy,TinhTrang,IMEI,DienThoai from BAOHANH where TinhTrangSua = N'Đang sửa' and TinhTrang = N'Chưa trả'";
        Statement st = cn.con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<BaoHanh> list = new ArrayList<BaoHanh>();
        BaoHanh baoHanh;
        while (rs.next()) {
            baoHanh = new BaoHanh();
            baoHanh.setMaBH(rs.getString(1));
            baoHanh.setLanBaoHanh(rs.getString(2));
            baoHanh.setTenKH(rs.getString(3));
            baoHanh.setIMEI(rs.getString(10));
            baoHanh.setNgayNhanMay(rs.getString(4));
            baoHanh.setNgayTraMay(rs.getString(5));
            baoHanh.setLyDo(rs.getString(6));
            baoHanh.setTinhTrangSua(rs.getString(7));
            baoHanh.setCachXuLy(rs.getString(8));
            baoHanh.setTinhTrang(rs.getString(9));
            baoHanh.setSoDienThoai(rs.getString(11));
            list.add(baoHanh);
        }
        return list;
    }

    public ArrayList<BaoHanh> getThongTinBaoHanh(String maBH) throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        String sql = "select MaBH,LanBaoHanh,TenKH,NgayNhanMay,NgayTraMay,LyDo,TinhTrangSua,"+
        "CachXuLy,TinhTrang,IMEI,DienThoai from BAOHANH where MaBh='"+maBH+"'";
        Statement st = cn.con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<BaoHanh> list = new ArrayList<BaoHanh>();
        BaoHanh baoHanh;
        while (rs.next()) {
            baoHanh = new BaoHanh();
            baoHanh.setMaBH(rs.getString(1));
            baoHanh.setLanBaoHanh(rs.getString(2));
            baoHanh.setTenKH(rs.getString(3));
            baoHanh.setIMEI(rs.getString(10));
            baoHanh.setNgayNhanMay(rs.getString(4));
            baoHanh.setNgayTraMay(rs.getString(5));
            baoHanh.setLyDo(rs.getString(6));
            baoHanh.setTinhTrangSua(rs.getString(7));
            baoHanh.setCachXuLy(rs.getString(8));
            baoHanh.setTinhTrang(rs.getString(9));
            baoHanh.setSoDienThoai(rs.getString(11));
            list.add(baoHanh);
        }
        return list;
    }  
    public String getLanBH(String maSP) {
        // TODO Auto-generated method stub
    	cn.Connect();
        String sql = "select top 1 LanBaoHanh from BAOHANH where IMEI = '"+maSP +"' order by LanBaoHanh DESC";
        Statement st = null;
        ResultSet rs = null;
        String id = null; 
        String id2= null;
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            id = rs.getString(1);
            int lan = Integer.parseInt(id)+1;
             id2 = Integer.toString(lan);
            System.out.println(id2);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id2;
    }
    public void themTiepBaoHanh(String maBH, String lanBaoHanh, String tenKH,
            String ngayNhanMay, String ngayTraMay, String lyDo,
            String cachXuLy, String iMEI, String soDienThoai)
            throws SQLException {
        // TODO Auto-generated method stub
        cn.Connect();
        try {
            String sql = "insert into BaoHanh values(?,?,?,?,NULL,?,N'Đang sửa',?,N'Chưa trả',?,?)";
            preSt= cn.con.prepareStatement(sql);
            preSt.setString(1 , maBH);
            preSt.setString(2 , lanBaoHanh);
            preSt.setString(3 , tenKH);
            preSt.setString(4 , ngayNhanMay);
            preSt.setString(5 , lyDo);
            preSt.setString(6 , cachXuLy);
            preSt.setString(7 , iMEI);
            preSt.setString(8 , soDienThoai);
            preSt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            if(preSt != null){
                preSt.close();
            }
            cn.Disconnect();
        }
    }

	public static void main(String[] args) {
		BaoHanhDAO b = new BaoHanhDAO();
		String maSP = "SPXYAI01";
		b.getLanBH(maSP);
	}

}
