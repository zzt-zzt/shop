<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@include file="/pages/commont/baseUrl.jsp"%>
    <style>
        .manager-product-tip1{
            width: 1400px;
            height: 100px;
            border: 1px red solid;
            margin:0px auto
        }
    </style>
</head>
<body>
<div class="head-logo"><div id="head-logo"><img   src="static/jpg/hea.png"></div>
    <span style="font-size: 50px;margin: 40px 10px 0 ;float: left">修改商品</span>
    <a class="cart-head" href="#">返回首页</a>
    <!--<a class="cart-head" href="#">商品管理</a>-->
    <a class="cart-head" href="#">订单管理</a>
</div>
<div class="manger-product">
    <div class="manager-product-tip1">

        <div class="manager-tip">商品图片</div>
        <div class="manager-tip">商品名称</div>
        <div class="manager-tip1">商品简介</div>
        <div class="manager-tip">商品价格</div>
        <div class="manager-tip">商品销量</div>
        <div class="manager-tip">商品地址</div>
        <div class="manager-tip">商品分类</div>

        <div class="manager-tip">操作</div>

    </div>
    <!--<div style="width: 1200px;height: 100px;background-color: aquamarine"></div>-->
    <div class="manger-product-info">

        <img class="manager-photo" src="${requestScope.product.images}">
        <form action="productServlet?action=updateProduct&pageNo=${requestScope.pageNo}" method="post">
            <input type="hidden" name="id" value="${requestScope.product.id}">
        <div class="manager-name2"><input name="name" class="update" type="text" value="${requestScope.product.name}"></div>
        <div class="manager-decribe1"><input  name="summary" class="decribe"type="text" value=" ${requestScope.product.summary}"></div>
        <div class="manager-product-price2"><input name="price" class="update" type="text" value="${requestScope.product.price}"></div>
        <div class="manager-product-price2"><input name="sales" class="update" type="text" value="${requestScope.product.sales}"></div>
        <div class="manager-product-price2"><input name="location"  class="update" type="text" value="${requestScope.product.location}"></div>
        <div class="manager-product-price2"><input  name="catagory" class="update" type="text" value="${requestScope.product.catagory}"></div>

        <div class="manager-method2">
           <input type="submit" id="queren" value="确认修改"></input>
    </div>
        </form>
</div>
</body>
</html>