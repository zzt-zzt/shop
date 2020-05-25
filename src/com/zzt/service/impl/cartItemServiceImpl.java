package com.zzt.service.impl;

import com.zzt.DAO.Interface1.CartItemDAO;
import com.zzt.DAO.impl.cartItemImpl;
import com.zzt.Utils.gsonUtils;
import com.zzt.pro.Cart;
import com.zzt.pro.cartItem;
import com.zzt.service.interface2.cartItemService;

import java.util.Map;

public class cartItemServiceImpl implements cartItemService {
       CartItemDAO cartItemDAO=new cartItemImpl();


    @Override
    public void addCart(Cart cart) {
        cartItemDAO.addCart(cart);
    }

    @Override
    public void uodateCart(Cart cart) {
        cartItemDAO.update(cart);
    }

    @Override
    public Cart deleteCartProduct(int productId, int clientId) {
        //根据顾客id获取购物车数据
        Cart cart = queryCart(clientId);
        String cartItems = cart.getCartItems();
        Map<Integer, cartItem> integercartItemMap = gsonUtils.StringToMap(cartItems);
        cartItem cartItem = integercartItemMap.get(productId);
        System.out.println(cart.getTotalPrice());
        System.out.println(cartItem.getProductallprice());
        cart.setTotalCount(cart.getTotalCount()-cartItem.getProductcount());
        cart.setTotalPrice(cart.getTotalPrice()-cartItem.getProductallprice());
        System.out.println(cart.getTotalPrice());
        integercartItemMap.remove(productId);
        String s = gsonUtils.mapToString(integercartItemMap);
        uodateCart(new Cart(cart.getCartId(),cart.getTotalCount(),cart.getTotalPrice(),s));
        return  queryCart(clientId);
    }

    @Override
    public void clearCart(int clientId) {
        cartItemDAO.delete(clientId);
    }

    @Override
    public Cart updateProduct(int productId, int count,int clientId) {
        //根据顾客id获取购物车数据
        Cart cart = queryCart(clientId);
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
        uodateCart(new Cart(cart.getCartId(),cart.getTotalCount(),cart.getTotalPrice(),s));
        return  queryCart(clientId);

    }

    @Override
    public Cart uodateCookieCart(int productId, int count) {
        return  null;
    }

    @Override
    public cartItem updateCartItem(int productId, int count, int clientId) {
        Cart cart = queryCart(clientId);
        String cartItems = cart.getCartItems();
        Map<Integer, cartItem> integercartItemMap = gsonUtils.StringToMap(cartItems);
        cartItem cartItem = integercartItemMap.get(productId);
        cartItem.setProductcount(count);
        cartItem.setProductallprice(cartItem.getProductprice()*count);
        return cartItem;
    }

    @Override
    public Cart queryCart(int id) {
       return  cartItemDAO.queryCart(id);

    }

}
