package com.zzt.DAO.impl;

import com.zzt.DAO.BaseDAo;
import com.zzt.DAO.Interface1.ProductDAO;
import com.zzt.pro.product;

import java.util.List;

public class ProductImpl  extends BaseDAo implements ProductDAO {
    @Override
    public List<product> getAllProduct() {
        return null;
    }

    @Override
    public product getProductByID(int id) {
        String  sql="select  product_id id,product_name name,product_price price,product_summary summary,product_sales sales, product_catagory catagory,product_location location,product_images images ,shop from product  where  product_id=?";
        product product = queryOneList(product.class, sql, id);
        return  product;
    }

    @Override
    public void updateProduct(product product) {
        String sql="update  product set product_name=?,product_price=?,product_summary=?,product_sales=?,product_catagory=?,product_location=?,product_images=? where   product_id=? ";
        upDateOne(sql,product.getName(),product.getPrice(),product.getSummary(),product.getSales(),product.getCatagory(),product.getLocation(),product.getImages(),product.getId());
    }

    @Override
    public void addProduct(product product) {
        String  sql ="insert  into product values(?,?,?,?,?,?,?,?,?)";
        upDateOne(sql,product.getId(),product.getName(),product.getPrice(),product.getSummary(),product.getSales(),product.getCatagory(),product.getLocation(),product.getImages(),product.getShop());
    }

    @Override
    public product getDeleteProductByID(int id) {
        String  sql="select  product_id id,product_name name,product_price price,product_summary summary,product_sales sales, product_catagory catagory,product_location location,product_images images ,shop from product_delete  where  product_id=?";
       return   queryOneList(product.class,sql,id);
    }

    @Override
    public void delete(int id) {
        String  sql="delete  from product_delete where product_id=?";
        upDateOne(sql,id);
    }

    @Override
    public void ReProduct(product product) {
        String sql="insert into product_delete values(?,?,?,?,?,?,?,?,?) ";
        upDateOne(sql,product.getId(),product.getName(),product.getPrice(),product.getSummary(),product.getSales(),product.getCatagory(),product.getLocation(),product.getImages(),product.getShop());
    }
}
