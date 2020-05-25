package com.zzt.pro;

public class OrderItem {
     private  Integer id;
     private  String name;
     private  int count;
     private  double price;
     private  double totaoPrice;
     private  String photo;
     private  String orderId;
     private  int shopId;

    public OrderItem() {
    }


    public OrderItem(Integer id, String name, int count, double price, double totaoPrice, String photo, String orderId, int shopId) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totaoPrice = totaoPrice;
        this.photo = photo;
        this.orderId = orderId;
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totaoPrice=" + totaoPrice +
                ", photo='" + photo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", shopId=" + shopId +
                '}';
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotaoPrice() {
        return totaoPrice;
    }

    public void setTotaoPrice(double totaoPrice) {
        this.totaoPrice = totaoPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
