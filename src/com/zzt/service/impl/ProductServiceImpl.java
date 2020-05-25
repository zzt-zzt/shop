package com.zzt.service.impl;

import com.zzt.DAO.Interface1.ProductDAO;
import com.zzt.DAO.impl.ProductImpl;
import com.zzt.pro.product;
import com.zzt.service.interface2.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDAO productDAO=new ProductImpl();
    @Override
    public product getProductById(int id) {
         return  productDAO.getProductByID(id);
    }

    @Override
    public void updateProduct(product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void addProduct(product product) {
        productDAO.addProduct(product);
    }

    @Override
    public void reProduct(product product) {
        productDAO.ReProduct(product);
    }

    @Override
    public product getDeleteProductByID(int id) {
        return productDAO.getDeleteProductByID(id);
    }

    @Override
    public void delete(int id) {
        productDAO.delete(id);
    }
}
