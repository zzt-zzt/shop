package com.zzt.web;

import com.zzt.Utils.CookieUtils;
import com.zzt.Utils.WebUtils;
import com.zzt.Utils.gsonUtils;
import com.zzt.pro.*;
import com.zzt.service.impl.ManagerServiceImpl;
import com.zzt.service.impl.ProductServiceImpl;
import com.zzt.service.impl.cartItemServiceImpl;
import com.zzt.service.interface2.ManagerService;
import com.zzt.service.interface2.ProductService;
import com.zzt.service.interface2.cartItemService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

public class CartServlet extends BaseServlet {
    ManagerService managerService=new ManagerServiceImpl();
    ProductService productService=new ProductServiceImpl();
    cartItemService  cartItemService=new cartItemServiceImpl();

    protected void cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer,cartItem> map=new HashMap<>();
       int product_info =WebUtils.parseInt(request.getParameter("product_info"),1);
        product product= productService.getProductById(product_info);
        Manager manager = managerService.queryManger(product.getShop());
        int shuliang = WebUtils.parseInt(request.getParameter("shuliang"), 1);
        double allPrice=shuliang*product.getPrice();
        cartItem cartItem=new cartItem(product.getId(),product.getSummary(),product.getImages(),shuliang,product.getPrice(),allPrice,product.getShop(),manager.getManagerName());
        //先判断用户是否登录
        Client client = (Client)request.getSession().getAttribute("client");
        if(client==null){
            //用户没登录 把商品信息存到cookie中
            //判断cookie是否存在
            Cookie cookie = CookieUtils.returnCookie(request, "cart");
            if(cookie==null){
                map.put(product_info,cartItem);
                String s1 = gsonUtils.mapToString(map);
                map.clear();
                String s=gsonUtils.beanToString(new Cart(null,shuliang,allPrice,s1));
             CookieUtils.addCookie1("cart",s,7*24*60*60,response,request);
                response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
            }
            else{
                //cook!=null
                String value = URLDecoder.decode(cookie.getValue(),"UTF-8");;
                Cart cart = gsonUtils.stringToGson(value, Cart.class);
               String  carts=cart.getCartItems();
                Map<Integer, cartItem> cartItems = gsonUtils.StringToMap(carts);
                //判断是否里面本省就存在这件商品
            cartItem cartItem1 = cartItems.get(product_info);
            if(cartItem1==null){
                //不存在
                cartItems.put(product_info,cartItem);
            }
            else{
                //存在
                cartItem1.setProductcount(cartItem1.getProductcount()+shuliang);
                cartItem1.setProductallprice(cartItem1.getProductallprice()+allPrice);
               cartItems.put(product_info,cartItem1);
            }
              cart.setTotalCount(cart.getTotalCount()+shuliang);
              cart.setTotalPrice(cart.getTotalPrice()+allPrice);
                String s1 = gsonUtils.mapToString(cartItems);
                cart.setCartItems(s1);

                System.out.println(cart);
                System.out.println(cart.getCartItems());
                String s = gsonUtils.beanToString(cart);
                CookieUtils.addCookie1("cart",s,7*24*60*60,response,request);
               response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
            }

        }else{
            //用户存在
            Cookie cookie = CookieUtils.returnCookie(request, "cart");
            Integer id = client.getId();
            Cart cart = cartItemService.queryCart(id);
            if(cart==null){
                map.put(product_info,cartItem);
              String s=  gsonUtils.mapToString(map);
               cartItemService.addCart(new Cart(id,shuliang,allPrice,s));
            }else{
                //购物车不为null
                //判断购物车里面是否有这件商品
                String s = cart.getCartItems();
                Map<Integer, cartItem> cartItems = gsonUtils.StringToMap(s);
               cartItem cartItem1 = cartItems.get(product_info);
               if(cartItem1==null){
                   cartItems.put(product_info,cartItem);
                   String s1 = gsonUtils.mapToString(cartItems);
                   cartItemService.uodateCart(new Cart(id,cart.getTotalCount()+shuliang,cart.getTotalPrice()+allPrice,s1));
               }
                else{
                    //购物车里面已经有这件商品
                   cartItem1.setProductcount(cartItem1.getProductcount()+shuliang);
                   cartItem1.setProductallprice(cartItem1.getProductallprice()+allPrice);
                   cartItems.put(product_info,cartItem1);
                   String s1 = gsonUtils.mapToString(cartItems);
                   cartItemService.uodateCart(new Cart(id,cart.getTotalCount()+shuliang,cart.getTotalPrice()+allPrice,s1));


               }
            }




            Cart cart1 = cartItemService.queryCart(id);
            System.out.println(cart1);
            request.getSession().setAttribute("cart1",cart1);
          response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
        }

    }
//判断购物车cookie是否存在
    protected void judgeCooike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = CookieUtils.returnCookie(request, "cart");
        Client client=(Client)request.getSession().getAttribute("client");
        List<Integer> list=new ArrayList<>();
        int count=0;
        double price=0;
        int id=client.getId();
        Cart cart=cartItemService.queryCart(id);
        if(cookie==null){
            if(cart!=null){
                request.getSession().setAttribute("cart1",cart);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }else{
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }


        }else{
            String decode = URLDecoder.decode(cookie.getValue(), "utf-8");
            Cart cart2 = gsonUtils.stringToGson(decode, Cart.class);
           if(cart==null){
               cart2.setCartId(id);
               System.out.println(cart2);
               cartItemService.addCart(cart2);
           }else {
               String cartItems1 = cart2.getCartItems();
               Map<Integer, cartItem> cartItem = gsonUtils.StringToMap(cartItems1);
               String cartItems2 = cart.getCartItems();
               Map<Integer, cartItem> itemMap = gsonUtils.StringToMap(cartItems2);
               Set<Integer> keySet = cartItem.keySet();
               for (Integer s : keySet) {
                   if (itemMap.containsKey(s)) {
                       list.add(s);
                       int productcount = cartItem.get(s).getProductcount();
                       double productallprice = cartItem.get(s).getProductallprice();
                       cartItem cartItem1 = itemMap.get(s);
                       cartItem1.setProductallprice(cartItem1.getProductallprice() + productallprice);
                       cartItem1.setProductcount(cartItem1.getProductcount() + productcount);
                       itemMap.put(s, cartItem1);
                   }
               }
               for (Integer l : list) {
                    count+=cartItem.get(l).getProductcount();
                    price+=cartItem.get(l).getProductallprice();
                    cartItem.remove(l);
               }
               itemMap.putAll(cartItem);
               String s = gsonUtils.mapToString(itemMap);
               cartItemService.uodateCart(new Cart(id,cart.getTotalCount()+count,cart.getTotalPrice()+price,s));
           }
           Cart cart1= cartItemService.queryCart(id);
            request.getSession().setAttribute("cart1",cart1);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 1);
        Cookie cookie = CookieUtils.returnCookie(request, "cart");
        if(cookie!=null){
            String decode = URLDecoder.decode(cookie.getValue(), "utf-8");
            Cart cart = gsonUtils.stringToGson(decode, Cart.class);
            String cartItems = cart.getCartItems();
            Map<Integer, cartItem> integercartItemMap = gsonUtils.StringToMap(cartItems);
            cartItem cartItem = integercartItemMap.get(id);
            cart.setTotalPrice(cart.getTotalPrice()-cartItem.getProductallprice());
            cart.setTotalCount(cart.getTotalCount()-cartItem.getProductcount());
            integercartItemMap.remove(id);
            String s = gsonUtils.mapToString(integercartItemMap);
            Cart cart1=new Cart(cart.getCartId(),cart.getTotalCount(),cart.getTotalPrice(),s);
            String s1 = gsonUtils.beanToString(cart1);
            CookieUtils.addCookie1("cart",s1,7*24*60*60,response,request);
            request.getRequestDispatcher("/pages/cart/cart.jsp").forward(request,response);



        }
    }
    protected void deleteCartProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId=WebUtils.parseInt(request.getParameter("productId"),1);
        int clientId= WebUtils.parseInt(request.getParameter("id"),1);
        Cart cart = cartItemService.deleteCartProduct(productId, clientId);
        request.getSession().setAttribute("cart1",cart);
        request.getRequestDispatcher("/pages/cart/cart.jsp").forward(request,response);


    }
    protected void updateCartProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId=WebUtils.parseInt(request.getParameter("productId"),1);
        int clientId= WebUtils.parseInt(request.getParameter("id"),1);
        int count=WebUtils.parseInt(request.getParameter("count"),1);
        Cart cart = cartItemService.updateProduct(productId, count, clientId);
        String s = gsonUtils.beanToString(cart);
        request.getSession().setAttribute("cart1",cart);
        response.getWriter().print(s);
    }
    protected void updateCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId=WebUtils.parseInt(request.getParameter("productId"),1);
        int clientId= WebUtils.parseInt(request.getParameter("id"),1);
        int count=WebUtils.parseInt(request.getParameter("count"),1);
        cartItem cartItem = cartItemService.updateCartItem(productId, count, clientId);
        String s=gsonUtils.beanToString(cartItem);
        response.getWriter().print(s);
    }
    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId=WebUtils.parseInt(request.getParameter("productId"),1);
        int count=WebUtils.parseInt(request.getParameter("count"),1);
        Cookie cookie = CookieUtils.returnCookie(request, "cart");
        String decode = URLDecoder.decode(cookie.getValue(), "utf-8");
        Cart cart = gsonUtils.stringToGson(decode, Cart.class);
        String cartItems = cart.getCartItems();
        Map<Integer, cartItem> integercartItemMap = gsonUtils.StringToMap(cartItems);
        cartItem cartItem = integercartItemMap.get(productId);
        cart.setTotalPrice(cart.getTotalPrice()-cartItem.getProductallprice());
        cart.setTotalCount(cart.getTotalCount()-cartItem.getProductcount());
        cartItem.setProductcount(count);
        cartItem.setProductallprice(cartItem.getProductprice()*count);
        cart.setTotalCount(cart.getTotalCount()+count);
        cart.setTotalPrice(cart.getTotalPrice()+cartItem.getProductallprice());
        integercartItemMap.put(productId,cartItem);
        String s = gsonUtils.mapToString(integercartItemMap);
        String s1 = gsonUtils.beanToString(new Cart(null, cart.getTotalCount(), cart.getTotalPrice(), s));
        CookieUtils.addCookie1("cart",s1,7*24*60*60,response,request);
        response.getWriter().print(s1);
    }
    protected void updateCookieCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId=WebUtils.parseInt(request.getParameter("productId"),1);
        int count=WebUtils.parseInt(request.getParameter("count"),1);
        Cookie cookie = CookieUtils.returnCookie(request, "cart");
        String decode = URLDecoder.decode(cookie.getValue(), "utf-8");
        Cart cart = gsonUtils.stringToGson(decode, Cart.class);
        String cartItems = cart.getCartItems();
        Map<Integer, cartItem> integercartItemMap = gsonUtils.StringToMap(cartItems);
        cartItem cartItem = integercartItemMap.get(productId);
        cartItem.setProductcount(count);
        cartItem.setProductallprice(cartItem.getProductprice()*count);
        String s = gsonUtils.beanToString(cartItem);
        response.getWriter().print(s);
    }

       //登陆后清空购物车
       protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           Client client = (Client)request.getSession().getAttribute("client");
           Integer id = client.getId();
           cartItemService.clearCart(id);
           request.getSession().removeAttribute("cart1");
           request.getRequestDispatcher("/pages/cart/cart.jsp").forward(request,response);
       }
    //cookie清空购物车
    protected void clearCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = CookieUtils.returnCookie(request, "cart");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");


    }





}

