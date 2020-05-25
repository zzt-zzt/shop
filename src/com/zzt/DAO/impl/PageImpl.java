package com.zzt.DAO.impl;

import com.zzt.DAO.BaseDAo;
import com.zzt.DAO.Interface1.PageDAO;
import com.zzt.pro.product;

import java.util.List;

public class PageImpl  extends BaseDAo implements PageDAO {

    @Override
    public int getPageCount() {
         String sql="select count(*) from product";
         Number count=(Number) queryForOne(sql);
        return  count.intValue();
    }

    @Override
    public int countHoutai(int shop) {
        String sql="select count(*) from product where shop=?";
        Number count=(Number) queryForOne(sql,shop);
        return  count.intValue();
    }

    @Override
    public List<product> returnProduct(int pageBegin, int pageSize) {
       String  sql="select product_id id,product_name name,product_price price,product_summary summary,product_sales sales, product_catagory catagory,product_location location,product_images images from product limit ?,?";
         return queryAll(product.class,sql,pageBegin,pageSize);

    }

    @Override
    public List<product> selectProduct(int shop, int pageBegin, int pageSize) {
        String  sql="select product_id id,product_name name,product_price price,product_summary summary,product_sales sales, product_catagory catagory,product_location location,product_images images  from product_delete where shop=? limit ?,?";
        return queryAll(product.class,sql,shop,pageBegin,pageSize);
    }

    @Override
    public int countXiajia(int shop) {
        String sql="select count(*) from product_delete where shop=?";
        Number count=(Number) queryForOne(sql,shop);
        return  count.intValue();

    }

    @Override
    public List<product> shopProduct(int shop, int pageBegin, int pageSize) {
        String  sql="select product_id id,product_name name,product_price price,product_summary summary,product_sales sales, product_catagory catagory,product_location location,product_images images  from product where shop=? limit ?,?";
        return queryAll(product.class,sql,shop,pageBegin,pageSize);

    }


    @Override
    public List<product> returnProductBysearch( String key,int pageBegin, int pageSize) {
        String  sql="select product_id id,product_name name,product_price price,product_summary summary,product_sales sales, product_catagory catagory,product_location location,product_images images  from product  where product_name like \"%\"?\"%\" or product_summary like \"%\"?\"%\" limit ?,?";
        return queryAll(product.class,sql,key,key,pageBegin,pageSize);
    }

    @Override
    public int getPageCountBysearch(String key) {
        String  sql="select count(*) from product where product_name like \"%\"?\"%\" or product_summary like \"%\"?\"%\" ";
      Number  number =(Number) queryForOne(sql, key, key);
      return number.intValue();
    }

    @Override
    public List<product> returnProductByCatagory(double catagory, int pageBegin, int pageSize) {
        String sql="select  product_id id,product_name name,product_price price,product_summary summary,product_sales sales, product_catagory catagory,product_location location,product_images images  from product  where  product_catagory =? limit ?,?";
       return queryAll(product.class,sql, catagory, pageBegin, pageSize);
    }

    @Override
    public int getPageCountByCatagory(double catagory) {
        String  sql="select count(*) from product where product_catagory =? ";
        Number  number =(Number) queryForOne(sql, catagory);
        return number.intValue();
    }

    @Override
    public void deleteProduct(int id) {
        String  sql="delete from product where product_id=?";
        upDateOne(sql,id);
    }

}
