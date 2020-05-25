package com.zzt.pro;

import java.math.BigDecimal;

public class cartItem {
    private   Integer proudctid; //商品id；
    private  String productinfo; //商品信息
    private  String productphoto;
    private  int productcount; //商品数量
    private  double productprice;//商品价格
    private  double productallprice; //商品总价
    private  Integer shopid; //商家id；
  private    String shopname; //商家名称

    public cartItem() {
    }

    public cartItem(Integer proudctid, String productinfo, String productphoto, int productcount, double productprice, double productallprice, Integer shopid, String shopname) {
        this.proudctid = proudctid;
        this.productinfo = productinfo;
        this.productphoto = productphoto;
        this.productcount = productcount;
        this.productprice = productprice;
        this.productallprice = productallprice;
        this.shopid = shopid;
        this.shopname = shopname;
    }

    public Integer getProudctid() {
        return proudctid;
    }

    public void setProudctid(Integer proudctid) {
        this.proudctid = proudctid;
    }

    public String getProductinfo() {
        return productinfo;
    }

    public void setProductinfo(String productinfo) {
        this.productinfo = productinfo;
    }

    public String getProductphoto() {
        return productphoto;
    }

    public void setProductphoto(String productphoto) {
        this.productphoto = productphoto;
    }

    public int getProductcount() {
        return productcount;
    }

    public void setProductcount(int productcount) {
        this.productcount = productcount;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public double getProductallprice() {
        return productallprice;
    }

    public void setProductallprice(double productallprice) {
        this.productallprice = productallprice;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    @Override
    public String toString() {
        return "cartItem{" +
                "proudctid=" + proudctid +
                ", productinfo='" + productinfo + '\'' +
                ", productphoto='" + productphoto + '\'' +
                ", productcount=" + productcount +
                ", productprice=" + productprice +
                ", productallprice=" + productallprice +
                ", shopid=" + shopid +
                ", shopname='" + shopname + '\'' +
                '}';
    }
}
