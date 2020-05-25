package com.zzt.service.interface2;

import com.zzt.pro.product;

import java.util.List;

public interface ProductService {
    public product  getProductById(int id);
    //跟新商品
    public  void updateProduct(product product);
    //增加商品
    public void addProduct(product product);
    //将要下架的商品放到下架区
    public void reProduct(product product);
   //删除下架区域
    public void delete(int id);
    //查询下架商品
    public product getDeleteProductByID(int id);
}
