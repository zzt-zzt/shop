package com.zzt.service.interface2;

import com.zzt.pro.Cart;
import com.zzt.pro.cartItem;

public interface cartItemService {

    public Cart queryCart(int id);
    public  void addCart(Cart cart);
    public void uodateCart(Cart cart);
    public Cart deleteCartProduct(int productId,int clientId);
    public Cart  updateProduct(int productId,int count,int clientId);
    public cartItem updateCartItem(int productId,int count,int clientId);
    public  Cart uodateCookieCart(int productId,int count);
    //清空购物车
    public  void  clearCart(int clientId);
}
