<%--
  Created by IntelliJ IDEA.
  User: 张泽涛
  Date: 2020/5/16
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/pages/commont/baseUrl.jsp"%>
    <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>添加商品</title>
</head>
<body>
<div class="head-logo"><div id="head-logo"><img   src="static/jpg/hea.png"></div>
    <span style="font-size: 50px;margin: 40px 10px 0 ;float: left">添加商品</span>
    <a class="cart-head" href="#">返回首页</a>
    <a class="cart-head" href="#">订单管理</a>
</div>
<div class="manger-product">
    <div class="manager-product-tip">


        <div class="manager-tip">商品名称</div>
        <div class="manager-tip1">商品简介</div>
        <div class="manager-tip">商品价格</div>
        <div class="manager-tip">商品销量</div>
        <div class="manager-tip">商品地址</div>
        <div class="manager-tip">商品分类</div>
        <div class="manager-tip">商品图片</div>
        <div class="manager-tip">操作</div>

    </div>
    <div class="manger-product-info">
    <table>
    <form action="productServlet?action=addProduct&total=${requestScope.total}" method="post" enctype="multipart/form-data">

       <div class="manager-name2"><input name="name" class="update" type="text" ></div>
     <div class="manager-decribe1"><input  name="summary" class="decribe"type="text" ></div>
       <div class="manager-product-price2"><input name="price" class="update" type="text" ></div>
       <div class="manager-product-price2"><input name="sales" class="update" type="text" ></div>
      <div class="manager-product-price2"><input name="location"  class="update" type="text"></div>
        <div class="manager-product-price2"><input  name="catagory" class="update" type="text" ></div>
        <div class="manager-photo"><input  name="images" class="update" type="file" required="required"></div>


        <div class="manager-method2">
            <input type="submit" id="queren" value="确认上架"></input>
        </div>
    </form>
    </table>
    </div>
</div>
</body>
</html>
