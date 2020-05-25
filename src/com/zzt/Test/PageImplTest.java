package com.zzt.Test;

import com.zzt.DAO.Interface1.PageDAO;
import com.zzt.DAO.impl.PageImpl;
import com.zzt.pro.product;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PageImplTest {
  PageDAO pageDAO=new PageImpl();
    @Test
    public void getPageCount() {
      int pageCount = pageDAO.getPageCount();
      System.out.println(pageCount);
    }
    @Test
    public void testReturn() {
        System.out.println(pageDAO.returnProductBysearch("汤普森",0,4));
    }


  @Test
  public void testGetPageCount() {
    int i = pageDAO.getPageCountBysearch("安踏");
    System.out.println(i);
  }

    @Test
    public void countHoutai() {
    }

    @Test
    public void shopProduct() {
      List<product> products = pageDAO.shopProduct(1, 0, 4);
      System.out.println(products);
    }
}