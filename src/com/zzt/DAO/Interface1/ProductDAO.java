package com.zzt.DAO.Interface1;

import com.zzt.pro.product;

import java.util.List;

public interface ProductDAO {
    //查询全部商品
    public List<product> getAllProduct();
    //根据商品得id值获取商品
    public product getProductByID(int id);
    //更新商品
    public void updateProduct(product product);
    //增加商品
    public void addProduct(product product);
    //将要下架的商品放在下架区
    public void ReProduct(product product);
    //重新商家时要删除下架区的商品
    public  void  delete(int id);
    //根据商品id查询下架区的商品
    public product getDeleteProductByID(int id);
}
