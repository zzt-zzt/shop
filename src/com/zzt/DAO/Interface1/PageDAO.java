package com.zzt.DAO.Interface1;

import com.zzt.pro.product;

import java.util.List;

public interface PageDAO {
    //获取总记录数
    public int getPageCount();
    //获取后台商家它管理的商品的数量；
    public int countHoutai(int shop);
    //查看下架区的商品数量
    public int countXiajia(int shop);
    //获取每页的数据(用limit)
    public List<product> returnProduct(int pageBegin,int pageSize);
    //实现收索并分页的查询
    //商家后台获取商品 根据商家的id值
    public List<product>  shopProduct(int shop,int pageBegin,int pageSize);
    public List<product> returnProductBysearch(String  key,int pageBegin, int pageSize);
    //如果使用搜索功能下查询到的每页数据
    public int getPageCountBysearch(String key);
    //直接点(安踏 李宁 )那里的超链接 查询数据 相当于把篮球鞋的品种分类把
    public  List<product> returnProductByCatagory( double catagory,int pageBegin, int pageSize);
    //直接点(安踏 李宁 )那里的超链接 查询总记录数
    public int getPageCountByCatagory(double catagory);
   //根据商品id删除商品
    public void deleteProduct(int id);
    //查询下架区商品
    public List<product> selectProduct(int shop,int pageBegin,int pageSize);
}
