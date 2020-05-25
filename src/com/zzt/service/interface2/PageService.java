package com.zzt.service.interface2;

import com.zzt.pro.Page;
import com.zzt.pro.product;

import java.util.List;

public interface PageService {
    public Page getPage(int pageNo, int pageSize);
    public Page getPageHoutai(int shop,int pageNo,int pageSize);
    public Page PageBySearch(int pageNo,int pageSize,String  key);
    //查询分类
    public Page PageByCatagory(double catagory,int pageNo,int pageSize);
    //更据商品id删除商品
    public void deteProduct(int id);
    //查询下架区的商品
    public Page selectDeleteProduct(int shop,int pageNo,int pageSize);
}
