package com.zzt.pro;

public class product {
    private  Integer id; //商品编号
    private  String name;//商品名称
    private   double price;//商品价格
    private  String summary;//商品简介
    private  int sales;//商品销量
    private  double catagory;//商品类别
    private  String location;//商品地址
    private  String images;//商品图片
    private  Integer shop;//属于哪个商家销售的

    public product() {
    }

    public product(Integer id, String name, double price, String summary, int sales, double catagory, String location, String images, Integer shop) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.summary = summary;
        this.sales = sales;
        this.catagory = catagory;
        this.location = location;
        this.images = images;
        this.shop = shop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public double getCatagory() {
        return catagory;
    }

    public void setCatagory(double catagory) {
        this.catagory = catagory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getShop() {
        return shop;
    }

    public void setShop(Integer shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", summary='" + summary + '\'' +
                ", sales=" + sales +
                ", catagory=" + catagory +
                ", location='" + location + '\'' +
                ", images='" + images + '\'' +
                ", shop=" + shop +
                '}';
    }
}
