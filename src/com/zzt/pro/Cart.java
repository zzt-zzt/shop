package com.zzt.pro;

import java.util.List;
import java.util.Map;

public class Cart {
    private  Integer cartId;
    private  Integer totalCount;//总商品数
    private  double totalPrice;//总金额
    private String cartItems;


    public Cart() {
    }

    public Cart(Integer cartId, Integer totalCount, double totalPrice, String cartItems) {
        this.cartId = cartId;
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.cartItems = cartItems;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCartItems() {
        return cartItems;
    }

    public void setCartItems(String cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", cartItems='" + cartItems + '\'' +
                '}';
    }
}
