package com.zzt.DAO.impl;

import com.zzt.DAO.BaseDAo;
import com.zzt.DAO.Interface1.CartItemDAO;
import com.zzt.pro.Cart;
import com.zzt.pro.cartItem;

public class cartItemImpl extends BaseDAo implements CartItemDAO {
    @Override
    public void updateCartItem(cartItem cartItem) {
        String  sql="update cartitem  set cartItem_product_count=? and cartItem_product_allPrice=?";
        upDateOne(sql,cartItem.getProductcount(),cartItem.getProductallprice());
    }


    @Override
    public cartItem queryCartItem(int id) {
        String  sql="select cartItem_shop_id shopid,cartItem_shop_name shopname,cartItem_product_photo productphoto,cartItem_product_id  proudctid,cartItem_product_info productinfo,cartItem_product_count productcount,cartItem_product_price productprice,cartItem_product_allPrice productallprice from cartitem where cartItem_product_id=?";
        return queryOneList(cartItem.class, sql, id);
    }

    @Override
    public Cart queryCart(int id) {
       String sql="select cart_id cartId,cart_totalCount totalCount,cart_totalPrice totalPrice,cart_cartItem  cartItems from cart where cart_id=?";
        Cart cart = queryOneList(Cart.class, sql, id);
        return  cart;
    }

    @Override
    public void delete(int clientId) {
        String sql="delete from cart where cart_id=?";
        upDateOne(sql,clientId);
    }

    @Override
    public void addCart(Cart cart) {
        String  sql="insert into cart values(?,?,?,?)";
        upDateOne(sql,cart.getCartId(),cart.getTotalCount(),cart.getTotalPrice(),cart.getCartItems());
    }

    @Override
    public void update(Cart cart) {
        String sql="update cart set cart_totalCount=?,cart_totalPrice=?,cart_cartItem =?";
        upDateOne(sql,cart.getTotalCount(),cart.getTotalPrice(),cart.getCartItems());
    }
}
