package com.zzt.Test;

import com.zzt.DAO.Interface1.ProductDAO;
import com.zzt.DAO.impl.ProductImpl;
import com.zzt.pro.product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductImplTest {
    ProductDAO productDAO=new ProductImpl();

    @Test
    public void getAllProduct() {
        product S = productDAO.getProductByID(11);
        System.out.println(S);
    }

    @Test
    public void getProductByID() {
    }

    @Test
    public void updateProduct() {

    }


    @Test
    public void testGetProductByID() {
        product s = productDAO.getProductByID(11);
        System.out.println(s);
    }
}