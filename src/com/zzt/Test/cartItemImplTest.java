package com.zzt.Test;

import com.zzt.DAO.Interface1.CartItemDAO;
import com.zzt.DAO.impl.cartItemImpl;
import com.zzt.pro.Cart;
import com.zzt.pro.cartItem;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class cartItemImplTest {
    CartItemDAO cartItemDAO=new cartItemImpl();

    @Test
    public void updateCartItem() {
        Cart cart = cartItemDAO.queryCart(2);
        System.out.println(cart);
    }




    @Test
    public void queryCartItem() {
    }

    @Test
    public void queryCart() {
        Cart s = cartItemDAO.queryCart(22);
        System.out.println(s);
    }

    @Test
    public void addCart() {
        Map<Integer,cartItem> cartItems=new HashMap<>();
        cartItem cartItem=new cartItem(12,"匹克闪现态极篮球鞋男鞋路威官方旗舰店耐磨防滑男实战运动球鞋男","product/1.3.3.jpg",2,499.0,998.00,12,"bzztzzt");
        cartItems.put(1,cartItem);
        /*cartItemDAO.addCart(new Cart(1,1,1,cartItems));*/
    }

    @Test
    public void update() {
    }
}