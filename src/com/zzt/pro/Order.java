package com.zzt.pro;

import java.util.Date;

public class Order {
          private String OrderId;
          private Date  createTime;
          private  double OrderPrice=0;
          //0未发货 1 已发货 2 已签收
          private  int OrderStatus;
          private  int clientId;

    public Order() {
    }

    public Order(String orderId, Date createTime, double orderPrice, int orderStatus, int clientId) {
        OrderId = orderId;
        this.createTime = createTime;
        OrderPrice = orderPrice;
        OrderStatus = orderStatus;
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderId='" + OrderId + '\'' +
                ", createTime=" + createTime +
                ", OrderPrice=" + OrderPrice +
                ", OrderStatus=" + OrderStatus +
                ", clientId=" + clientId +
                '}';
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getOrderPrice() {
        return OrderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        OrderPrice = orderPrice;
    }

    public int getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        OrderStatus = orderStatus;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
