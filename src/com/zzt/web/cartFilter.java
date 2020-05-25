package com.zzt.web;

import com.zzt.DAO.Interface1.CartItemDAO;
import com.zzt.pro.Cart;
import com.zzt.pro.Client;
import com.zzt.service.impl.cartItemServiceImpl;
import com.zzt.service.interface2.cartItemService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "cartFilter")
public class cartFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        Client client =(Client) request.getSession().getAttribute("client");
       if(client!=null){
           Integer id = client.getId();
           cartItemService cartItemService=new cartItemServiceImpl();
           Cart cart = cartItemService.queryCart(id);
           request.getSession().setAttribute("cart1",cart);
           chain.doFilter(request,resp);
       }
       else{
           chain.doFilter(request,resp);
       }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
