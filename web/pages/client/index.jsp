<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <meta charset="UTF-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="/pages/commont/baseUrl.jsp"%>
    <script type="text/javascript">
        $(function () {
            var btn = $(".btn");

            $(".btn").click(function () {
                var index = $(".btn").index(this);
                $(".container").animate({left:-520*index},1000);
            });
            //给确定跳转绑定单击事件
            $("#bttn").click(function () {
                //获取跳到第几页的属性值
                 var  pageNo = $("#pn_input").val();
                 if(pageNo>${requestScope.page.pageTotal}){
                     $("#pn_input").val(${requestScope.page.pageTotal})
                     alert("当前页码不存在");

                /* location.href="pageServlet?action=page&pageNo="+pageNo;*/

                 }
                 else if(pageNo<1){ $("#pn_input").val(1);
                     alert("当前页码不存在");

                 }else{
                     if(${ empty requestScope.search}){
                         location.href="pageServlet?action=page&catagory=${requestScope.catagory}&pageNo="+pageNo;
                     }else{
location.href="pageServlet?action=page&catagory=${requestScope.catagory}&search=${requestScope.search}&pageNo="+pageNo;
                     }

                 }

            })
            $()


        })
    </script>
    <title>lce电商平台</title>
     <style>
         #show{
             width: 1190px;
             height:750px;
             margin: 10px auto;
             border:1px orange solid;
         }
     </style>
</head>
<body>
      <!--顶部盒子-->
      <div class="head">
          <div id="head">
              <div class="head-left">
                  <img src="static/jpg/hea.png" >
              </div>
              <div class="head-center">
                  <div id="head-center-search">
                      <form action="pageServlet?action=page" method="post">
                          <input type="text" id="head-center-input" name="search" value="${requestScope.search}">
                          <div id="head-center-button"><input  id="select-btn" type="submit" value="搜索" ></div>
                      </form>


                  </div>

              </div>
              <div class="head-right">
                  <div id="head-rignt-weclome">
                      <c:if test="${ sessionScope.client!=null}">
                      <span>欢迎<span  style="color: red" class="um_span">${sessionScope.client.clientName}</span>
                  <a href="pages/order/order.jsp">我的订单</a>
                          <a href="pages/cart/cart.jsp">购物车</a>
                  <a href="loginAndRegist?action=delete">注销</a>
                     </c:if>
                     <c:if test="${ sessionScope.manager!=null}">
                               <span>欢迎<span class="um_span">${sessionScope.manager.managerName}</span>
                  <a href="pageServlet?action=pageHoutai">后台管理</a>
                          <a href="pages/order/order.jsp">订单管理</a>
                  <a href="loginAndRegist?action=delete">注销</a>
                             </c:if>
                      <c:if test="${ sessionScope.manager==null&& sessionScope.client==null}">
                                   <a href="pages/user/login.jsp">您尚未登录</a>
                                    <a href="pages/cart/cart.jsp">购物车</a>
                                   </c:if>


          </div>
          </div>
      </div>
      <div class="center">
          <div id="center-left">
              <div id="prodect-catagory">篮球鞋</div>
                  <div class="prodect-catagory"><a  href="pageServlet?action=page&catagory=1.1">安踏</a></div>
              <div class="prodect-catagory"><a href="pageServlet?action=page&catagory=1.2" >李宁</a></div>
              <div class="prodect-catagory"><a href="pageServlet?action=page&catagory=1.3">匹克</a></div>
              <div class="prodect-catagory"><a href="pageServlet?action=page&catagory=1.4" >耐克</a></div>
              <div class="prodect-catagory"><a href="pageServlet?action=page&catagory=1.5">鸿星尔克</a></div>
              <div class="prodect-catagory"><a href="pageServlet?action=page&catagory=1.6" >阿迪达斯</a></div>
              <div class="prodect-catagory"><a href="pageServlet?action=page&catagory=1.7">361</a></div>
              <div class="prodect-catagory"><a href="pageServlet?action=page&catagory=1.8" >乔丹</a></div>



          </div>
          <div id="center-center1">
              <div class="container">
                  <img src="static/jpg/11%20(2).jpg"><img src="static/jpg/11%20(1).jpg"><img src="static/jpg/3.jpg"><img src="static/jpg/2.jpg"><img src="static/jpg/1.jpg">
              </div>
              <div class="btn-list">
                  <div class="btn"></div>
                  <div class="btn"></div>
                  <div class="btn"></div>
                  <div class="btn"></div>
                  <div class="btn"></div>

              </div>
          </div>
          <div id="center-center2"><img src="static/jpg/6.jpg"></div>
          <div id="center-right">
              <div id="center-right-on">
                  <c:if test="${sessionScope.client!=null||sessionScope.manager!=null}">
                      <img src="${ not empty sessionScope.client?sessionScope.client.clientPhoto:sessionScope.manager.managerPhoto}" id="touxiang">
                  </c:if>
                  <c:if test="${empty sessionScope.manager and empty sessionScope.client}">
                  <img src="static/jpg/defalut.jpg" id="touxiang">
                  </c:if>
              </div>
              <c:if test="${sessionScope.client==null&&sessionScope.manager==null}">
                  <div id="center-right-under">
                      <div class="login"><a class="center-btn" href="pages/user/login.jsp" >登录</a> </div>
                      <div class="login" ><a class="center-btn" href="pages/user/client-regist.jsp">用户注册</a></div>
                      <div class="login"><a class="center-btn" href="pages/user/shopper-regist.jsp">商家注册</a></div>
                  </div>
              </c:if>
              <c:if test="${sessionScope.client!=null}">
                  <div class="login"><a class="center-btn" href="pages/cart/cart.jsp" >购物车</a> </div>
                  <div class="login" ><a class="center-btn" href="#">订单</a></div>
                  <div class="login" ><a class="center-btn" href="pages/user/client-update-regist.jsp">修改信息</a></div>
                <%--  <div class="login"><a class="center-btn" href="#">商家注册</a></div>--%>
              </c:if>
              <c:if test="${sessionScope.manager!=null}">
                  <div class="login"><a class="center-btn" href="pageServlet?action=pageHoutai" >后台管理</a> </div>
                  <div class="login" ><a class="center-btn" href="#">订单管理</a></div>
                  <div class="login" ><a class="center-btn" href="pages/user/shopper-update-regist.jsp">修改信息</a></div>
              </c:if>


          </div>
          <c:if test="${sessionScope.manager==null}">
      </div>
          <div id="show">
              <c:forEach items="${requestScope.page.pageItem}" var="page">
              <a href="productServlet?action=showProduct&productId=${page.id}">
                  <div class="showProduct">

                      <img class="product-image" src=${page.images}></img><!--商品图片-->
                      <div class="product-price">
                          <span class="product-price-fuhao">￥</span><!--￥符号-->
                          <div class="product-price1">${page.price}</div><!--价钱-->
                          <img class="product-price-baoyou" src="static/jpg/baoyou.jpg"></img><!--包邮图片-->
                          <div class="product-price-sales">${page.sales}<span>人付款</span></div><!--多少人付款-->
                      </div>
                      <div class="product-describe">${page.summary}</div><!--商品描述-->
                      <div class="product-location"><span class="location">${page.location}</span></div>
                      <button class="add-cart">加入购物车</button><!--加入购物车按钮-->

                  </div>
                  </c:forEach>
          </div>
          <div id="footer">
              <div id="page-nav">
                  <div id="page_nav">
                      <c:if test="${requestScope.page.pageNo>1}"><a href="pageServlet?action=page&pageNo=1&search=${requestScope.search}&catagory=${requestScope.catagory}">首页</a>
                          <a href="pageServlet?action=page&pageNo=${requestScope.page.pageNo-1}&search=${requestScope.search}&catagory=${requestScope.catagory}">上一页</a></c:if>
                      <c:choose>
                          <c:when test="${requestScope.page.pageNo<=5}">
                              <C:forEach   begin="1" end="${requestScope.page.pageTotal}" var="i">
                                  <%--判断显示得页面--%>
                                  <c:if test="${requestScope.page.pageNo==i}">
                                      [${i}]
                                  </c:if>
                                  <c:if test="${requestScope.page.pageNo!=i}">
                                      <a href="pageServlet?action=page&pageNo=${i}&search=${requestScope.search}&catagory=${requestScope.catagory}">${i}</a>
                                  </c:if>
                              </C:forEach>
                          </c:when>
                          <C:when test="${requestScope.page.pageTotal>5}">
                              <c:choose>
                                  <c:when test="${requestScope.page.pageNo<=3}">
                                      <c:forEach begin="1" end="5">
                                          <%--判断显示得页面--%>
                                          <c:if test="${requestScope.page.pageNo==i}">
                                              [${i}]
                                          </c:if>
                                          <c:if test="${requestScope.page.pageNo!=i}">
                                              <a href="pageServlet?action=page&pageNo=${i}&search=${requestScope.search}&catagory=${requestScope.catagory}">${i}</a>
                                          </c:if>
                                      </c:forEach>
                                  </c:when>
                                  <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                                      <c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}">
                                          <%--判断显示得页面--%>
                                          <c:if test="${requestScope.page.pageNo==i}">
                                              [${i}]
                                          </c:if>
                                          <c:if test="${requestScope.page.pageNo!=i}">
                                              <a href="pageServlet?action=page&pageNo=${i}&search=${requestScope.search}&catagory=${requestScope.catagory}">${i}</a>
                                          </c:if>
                                      </c:forEach>
                                  </c:when>
                                  <c:otherwise>
                                      <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}">
                                          <%--判断显示得页面--%>
                                          <c:if test="${requestScope.page.pageNo==i}">
                                              [${i}]
                                          </c:if>
                                          <c:if test="${requestScope.page.pageNo!=i}">
                                              <a href="pageServlet?action=page&pageNo=${i}&search=${requestScope.search}&catagory=${requestScope.catagory}">${i}</a>
                                          </c:if>
                                      </c:forEach>
                                  </c:otherwise>
                              </c:choose>
                          </C:when>
                      </c:choose>
                      <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}"><a href="pageServlet?action=page&pageNo=${requestScope.page.pageNo+1}&search=${requestScope.search}&catagory=${requestScope.catagory}">下一页</a>
                          <a href="pageServlet?action=page&pageNo=${requestScope.page.pageTotal}&search=${requestScope.search}&catagory=${requestScope.catagory}">末页</a></c:if>
                      共${requestScope.page.pageTotal}页，${requestScope.page.pageCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
                      <input type="button" id="bttn" value="确定">
                  </div>
              </div>
          </div>
          </c:if>


      </div>



     
</body>
</html>