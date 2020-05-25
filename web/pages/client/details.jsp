<%--
  Created by IntelliJ IDEA.
  User: 张泽涛
  Date: 2020/5/19
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/pages/commont/baseUrl.jsp"%>
    <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript">
        $(function () {
            var count=$("#shuliang").val();
            $("#shuliang").change(function () {
                var count1=$("#shuliang").val();
                  var patt=/^[0-9]*[1-9][0-9]*$/;
                  if(!patt.test(count1)){
                      $("#shuliang").val(1);
                      alert("请输入正确的数量");
                  }

            });

             $(".tip1:first").click(function () {
                  count++;
                  $("#shuliang").val(count);

             });
            $(".tip1:last").click(function () {
                if(count > 1){
                    count--;
                    $("#shuliang").val(count);
                }else{
                    $("#shuliang").val(1);
                }

            })
        })
    </script>
    <title>商品详情</title>
</head>
<body>
<div class="head-logo"><div id="head-logo"><img   src="static/jpg/hea.png"></div>
    <span style="font-size: 50px;margin: 40px 10px 0 ;float: left">商品详情</span>
    <a class="cart-head" href="#">返回首页</a>
   <%-- <a class="cart-head" href="#">订单管理</a>--%>
    <div class="detail-content">
       <img class="content-left" src="${requestScope.product1.images}" >
        <div class="content-right">
            <form method="post" action="cartServlet?action=cart" >
                <input type="hidden" name="product_info" value="${requestScope.product1.id}">
            <div class="content-right-first">${requestScope.product1.summary}</div>
            <div class="content-right-second">
                <div class="content-right-second-left">价格</div>
                <div class="content-right-second-right">${requestScope.product1.price}</div>
            </div>
            <div class="content-right-third">
                <div class="content-right-third-left">月销量</div>
                <div class="content-right-third-right">${requestScope.product1.sales}</div>
            </div>
            <div class="content-right-fourth">
                <div class="content-right-fourth-left">发货地</div>
                <div class="content-right-fourth-right1">
                    ${requestScope.product1.location}
                </div>
            </div>
            <div class="content-right-firth">
                <div class="content-right-fourth-left">数量</div>
                <div class="content-right-fourth-right">
                    <div class="tip1">+</div>
                    <div class="tip2"><input  id="shuliang" name="shuliang" class="xiema" value="1" type="text"></div>
                    <div class="tip1">--</div>
                </div>
            </div>
            <div class="content-right-last">
                <div></div>
                <input type="submit" class="last" value="加入购物车"></input>
            </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
