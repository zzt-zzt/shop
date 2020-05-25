package com.zzt.web;

import com.zzt.Utils.WebUtils;
import com.zzt.pro.*;
import com.zzt.service.impl.OrderServiceImpl;
import com.zzt.service.impl.cartItemServiceImpl;
import com.zzt.service.interface2.OrderService;
import com.zzt.service.interface2.cartItemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class orderServlet  extends  BaseServlet{
    OrderService orderService=new OrderServiceImpl();
    cartItemService cartItemService=new cartItemServiceImpl();
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先判断是否登录
    Client     client =(Client) request.getSession().getAttribute("client");
    if(client==null){
        //没登陆就叫他去登陆
        request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        return;
    }else{
        Integer id = client.getId();
        Cart cart = cartItemService.queryCart(id);
        Order order = orderService.saveOrder(cart, id);
        orderService.removeAndGetMoney(order,cart);
        //清楚购物车
        cartItemService.clearCart(id);
        request.getSession().removeAttribute("cart1");
        request.setAttribute("order",order);
        request.getRequestDispatcher("/pages/order/orderId.jsp").forward(request,response);
    }


    }
}
