package model.bo;

import java.util.ArrayList;

import model.bean.SanPham2;
import model.dao.ProductDAO;

import common.MyException;

public class ProductBO {

   public ArrayList<SanPham2> getArrSanPham(String tenHang) throws MyException {
      // TODO Auto-generated method stub
      return new ProductDAO().getArrSanPham(tenHang);
   }

}
