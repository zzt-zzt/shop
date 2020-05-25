package com.zzt.DAO.impl;

import com.zzt.DAO.BaseDAo;
import com.zzt.DAO.Interface1.OrderDAO;
import com.zzt.pro.Order;

public class OrderImpl extends BaseDAo implements OrderDAO {
    @Override
    public Order savaOrder(Order order) {
        String sql="insert into orders values(?,?,?,?,?)";
        upDateOne(sql,order.getOrderId(),order.getCreateTime(),order.getOrderPrice(),order.getOrderStatus(),order.getClientId());
        return  order;
    }
}
