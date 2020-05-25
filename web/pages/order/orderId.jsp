<%--
  Created by IntelliJ IDEA.
  User: 张泽涛
  Date: 2020/5/25
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/pages/commont/baseUrl.jsp"%>
    <title>生成订单</title>
</head>
<body>
<div class="head-logo"><div id="head-logo"><img   src="static/jpg/hea.png"></div>
    <span style="font-size: 50px;margin: 40px 10px 0 ;float: left">购物车</span>
    <a class="cart-head" href="#">返回首页</a>
    <a class="cart-head" href="#">我的订单</a>
</div>
<div  class="BigOrder">
      <div class="ordid">本次订单号为${requestScope.order.orderId}
                      <a href="#">查询订单</a></div>
    <div class="ordid">共消费${requestScope.order.orderPrice}元</div>

</div>
</body>
</html>
