<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.zzt.pro.cartItem" %>
<%@ page import="com.zzt.Utils.WebUtils" %>
<%@ page import="com.zzt.Utils.CookieUtils" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="com.zzt.Utils.gsonUtils" %>
<%@ page import="com.zzt.pro.Cart" %>
<%@ page import="java.util.Map" %>

<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/commont/baseUrl.jsp"%>
    <script type="text/javascript">
        $(function () {

            var count=$(".xiema").val();
          $(".xiema").change(function () {
              var id=$(this).parent().parent().find("input:first").val();
              var sh=$(this);
              var count1=$(this).val();
                var patt=/^[1-9]*[1-9][1-9]*$/;
                if(!patt.test(count1)){
                    $(this).val(count);
                    alert("请输入正确的数量");
                    return false;

                }
              $.getJSON("cartServlet","action=updateCartItem&id=${sessionScope.client.id}&count="+count1+"&productId="+id,function (book) {
                         sh.parent().parent().find(".div2").eq(1).text(book.productallprice);

              });
              $.getJSON("cartServlet","action=updateCartProduct&id=${sessionScope.client.id}&count="+count1+"&productId="+id,function (data) {

                  $(".b_price").text(data.totalPrice);
                  $(".b_count").text(data.totalCount);

              });



            });
            var count2=$(".xiema1").val();
            $(".xiema1").change(function () {
                var th=$(this);
                var id = $(this).parent().parent().find("input:first").val();
                var sh = $(this);
                var count1 = $(this).val();
                var patt = /^[1-9]*[1-9][1-9]*$/;
                if (!patt.test(count1)) {
                    $(this).val(count2);
                    alert("请输入正确的数量");
                    return false;

                }
                $.getJSON("cartServlet","action=updateCookie&count="+count1+"&productId="+id,function (data) {
                    $(".b_price").text(data.totalPrice);
                    $(".b_count").text(data.totalCount);
                });
                $.getJSON("cartServlet","action=updateCookieCartItem&count="+count1+"&productId="+id,function (book) {
                    th.parent().parent().find(".div2").eq(1).text(book.productallprice);
                });
            });





        })
    </script>
</head>
<body>
<div class="head-logo"><div id="head-logo"><img   src="static/jpg/hea.png"></div>
     <span style="font-size: 50px;margin: 40px 10px 0 ;float: left">购物车</span>
    <a class="cart-head" href="#">返回首页</a>
    <a class="cart-head" href="#">我的订单</a>
</div>
<div class="cart-center">
           <div class="cart-center-head">
               <div class="cart-center-tip"><span id="tip-product">全部商品</span></div>
               <div class="div1">单价</div>
               <div class="div1">数量</div>
               <div class="div1">总额</div>
               <div class="div1">操作</div>
           </div>


    <c:if test="${sessionScope.client==null}">
        <%
            Cookie cookie = CookieUtils.returnCookie(request, "cart");
            request.setAttribute("cook",cookie);
            if(cookie!=null){
                String value = URLDecoder.decode(cookie.getValue(),"UTF-8");
                Cart cart = gsonUtils.stringToGson(value, Cart.class);
                request.setAttribute("cart",cart);
                String cartItem = cart.getCartItems();
                Map<Integer, cartItem> cartItems = gsonUtils.StringToMap(cartItem);
                request.setAttribute("cartItem",cartItems);

            }
        %>
         <c:if test="${cook!=null}">
             <C:forEach items="${cartItem}" var="entry">
                 <div class="cart-center-prouuct">
                     <div class="cart-shop"><span class="shop-name">${entry.value.shopname}</span></div>
                     <div class="cart-center-product1">
                         <input type="hidden" value="${entry.value.proudctid}">
                         <div class="checkbox"><input type="checkbox" class="checkbox1"></div>
                         <img class="product-photo" src="${entry.value.productphoto}"></img><!--图片商品-->
                         <div class="product-describe1">${entry.value.productinfo}</div><!--商品描述-->
                         <div class="div2"><a href="cartServlet?action=delete&id=${entry.value.proudctid}">移出购物车</a></div>
                         <div class="div2">${entry.value.productallprice}</div>
                         <div class="div3">
                             <input   name="shuliang" class="xiema1" value="${entry.value. productcount}" type="text"></div><%--数量--%>
                         <div class="div2">${entry.value.productprice}</div>
                     </div>

                 </div>
             </C:forEach>
             <div class="cart-clear">
                 <span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount}</span>件商品</span>
                 <span class="cart_span">总金额<span class="b_price">${cart.totalPrice}</span>元</span>
                 <span class="cart_span"><a class="clearAll1"  href="cartServlet?action=clearCookie">清空购物车</a></span>
                 <span class="cart_span"><a   href="orderServlet?action=createOrder">去结账</a></span>
             </div>
         </c:if>
        <c:if test="${cook==null}">
            <div class="cart-clear">
                <a href="index.jsp">亲，你还未选购商品！</a>
            </div>
        </c:if>

    </c:if>
    <c:if test="${not empty sessionScope.client}">
        <c:if test="${empty sessionScope.cart1 }">
    <div class="cart-clear">
        <a href="index.jsp">亲，你还未选购商品！</a>
    </div>
        </c:if>
        <c:if test="${not empty sessionScope.cart1 }">
            <%
                Cart cart1 = (Cart)request.getSession().getAttribute("cart1");
                String cartItems = cart1.getCartItems();
                Map<Integer, cartItem> cartItem = gsonUtils.StringToMap(cartItems);
                request.setAttribute("cartItem",cartItem);

            %>
            <C:forEach items="${cartItem}" var="entry">

                <div class="cart-center-prouuct"><input type="hidden" value="${entry.value.proudctid}">
                    <div class="cart-shop"><span class="shop-name">${entry.value.shopname}</span></div>
                    <div class="cart-center-product1">
                        <input type="hidden" value="${entry.value.proudctid}">
                        <div class="checkbox"><input type="checkbox" class="checkbox1"></div>
                        <img class="product-photo" src="${entry.value.productphoto}"></img><!--图片商品-->
                        <div class="product-describe1">${entry.value.productinfo}</div><!--商品描述-->
                        <div class="div2"><a href="cartServlet?action=deleteCartProduct&id=${sessionScope.client.id}&productId=${entry.value.proudctid}">移出购物车</a></div>
                        <div class="div2">${entry.value.productallprice}</div><%--总价--%>
                        <div class="div3">
                           <input   name="shuliang" class="xiema" value="${entry.value. productcount}" type="text"></div><%--数量--%>
                        <div class="div2">${entry.value.productprice}</div><%--单价--%>
                    </div>

                </div>
            </C:forEach>
            <div class="cart-clear">
                <span class="cart_span">购物车中共有<span class="b_count">${cart1.totalCount}</span>件商品</span>
                <span class="cart_span">总金额<span class="b_price">${cart1.totalPrice}</span>元</span>
                <span class="cart_span"><a class="clearAll" href="cartServlet?action=clearCart">清空购物车</a></span>
                <span class="cart_span"><a   href="orderServlet?action=createOrder">去结账</a></span>
            </div>
        </c:if>

    </c:if>











</div>
</body>
</html>