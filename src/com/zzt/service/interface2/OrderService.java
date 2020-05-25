package com.zzt.service.interface2;

import com.zzt.pro.Cart;
import com.zzt.pro.Order;

public interface OrderService {
    //获取购物车信息和顾客的信息
    public Order saveOrder(Cart cart,Integer id);
    //扣掉用户的前(增加商家的钱）
    public void  removeAndGetMoney(Order order,Cart cart);
}
