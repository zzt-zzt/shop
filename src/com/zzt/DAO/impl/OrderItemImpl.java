package com.zzt.DAO.impl;

import com.zzt.DAO.BaseDAo;
import com.zzt.DAO.Interface1.OrderItemDAO;
import com.zzt.pro.OrderItem;

public class OrderItemImpl  extends BaseDAo implements OrderItemDAO {
    @Override
    public OrderItem savaOrderItem(OrderItem orderItem) {
        String sql="insert into orderItem values(?,?,?,?,?,?,?,?)";
        upDateOne(sql,orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotaoPrice(),orderItem.getPhoto(),orderItem.getOrderId(),orderItem.getShopId());
        return  orderItem;
    }
}
