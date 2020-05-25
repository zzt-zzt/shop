package com.zzt.DAO.Interface1;

import com.zzt.pro.Cart;
import com.zzt.pro.cartItem;

public interface CartItemDAO {
    //更新商品的数量及总额
    public void updateCartItem(cartItem cartItem);
    //根据id查询商品
    public cartItem queryCartItem(int id);
    //根据id查询购物车
Cart queryCart(int id);
//添加购物车
    public void addCart(Cart cart);
    //跟新购物车
    public void update(Cart cart);
    //删除购物车
    public void delete (int clientId);
}
