package com.zzt.service.impl;

import com.google.gson.Gson;
import com.zzt.DAO.Interface1.*;
import com.zzt.DAO.impl.*;
import com.zzt.Utils.gsonUtils;
import com.zzt.pro.*;
import com.zzt.service.interface2.OrderService;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    ClientDAO clientDAO=new ClientImpl();
    ManagerDAO managerDAO=new ManagerImpl();
    OrderDAO orderDAO=new OrderImpl();
    OrderItemDAO orderItemDAO=new OrderItemImpl();
    ProductDAO productDAO=new ProductImpl();
    @Override
    public Order saveOrder(Cart cart, Integer id) {
        //获取订单号，订单号不可重复
        String orderId=System.currentTimeMillis()+""+id;
       Order order= orderDAO.savaOrder(new Order(orderId,new Date(),cart.getTotalPrice(),0,id));
        String cartItems = cart.getCartItems();
        //获取到购物车里的每一个项
        Map<Integer, cartItem> cartItem = gsonUtils.StringToMap(cartItems);
        for(Map.Entry<Integer,cartItem> entry:cartItem.entrySet()){
            //保存订单项信息
            com.zzt.pro.cartItem cartItem1=entry.getValue();
            orderItemDAO.savaOrderItem(new OrderItem(null,cartItem1.getProductinfo(),cartItem1.getProductcount(),cartItem1.getProductprice(),cartItem1.getProductallprice(),cartItem1.getProductphoto(),orderId,cartItem1.getShopid()));
            //修改销售量
            product product=productDAO.getProductByID(cartItem1.getProudctid());
            product.setSales(product.getSales()+cartItem1.getProductcount());
        }

return  order;

    }

    @Override
    public void removeAndGetMoney(Order order,Cart cart) {
        Map<Integer,Double> map=new HashMap<>();
        //获取订单的总金额
        double orderPrice = order.getOrderPrice();
        //获取用户id;
        int clientId = order.getClientId();
        //从用户里面扣钱
        clientDAO.updateClientMoney(clientId,orderPrice);
        System.out.println(clientDAO.queryMoney(clientId));
        String cartItems = cart.getCartItems();
        Map<Integer, cartItem> cartItem = gsonUtils.StringToMap(cartItems);
        for(Map.Entry<Integer,cartItem>entry:cartItem.entrySet()){
            cartItem cartItem1 = entry.getValue();
            if(map.containsKey(cartItem1.getShopid())){
                map.put(cartItem1.getShopid(),map.get(cartItem1.getProductallprice())+cartItem1.getProductallprice());
            }else {
                map.put(cartItem1.getShopid(),cartItem1.getProductallprice());
            }
        }
        //给商家价钱
        for(Map.Entry<Integer,Double>entry:map.entrySet()){
            managerDAO.addMoney(entry.getValue(),entry.getKey());
        }
    }
}
