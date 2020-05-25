<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="/pages/commont/baseUrl.jsp"%>
    <meta charset="UTF-8">
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var summary=$(this).parent().parent().find("div").eq(1).text();
                return confirm("确定要下架["+summary+"]?")

            })

        })
    </script>
    <title>商品管理</title>
</head>
<body>
<div class="head-logo"><div id="head-logo"><img   src="static/jpg/hea.png"></div>
    <span style="font-size: 50px;margin: 40px 10px 0 ;float: left">管理商品</span>
    <a class="cart-head" href="#">返回首页</a>
    <a class="cart-head" href="pageServlet?action=showdeleteProduct">下架区</a>
    <a class="cart-head" href="#">订单管理</a>
</div>
<div class="manger-product">
    <div class="manager-product-tip">

        <div class="manager-tip">商品图片</div>
        <div class="manager-tip">商品名称</div>
        <div class="manager-tip1">商品简介</div>
        <div class="manager-tip">商品价格</div>
        <div class="manager-tip">商品销量</div>
        <div class="manager-tip">商品地址</div>
        <div class="manager-tip">商品分类</div>

        <div class="manager-tip">操作</div>

    </div>

        <c:forEach items="${requestScope.page.pageItem}" var="houtai">
            <div class="manger-product-info">
                <img class="manager-photo" src="${houtai.images}">
                <div class="manager-name">${houtai.name}</div>
                <div class="manager-decribe">${houtai.summary}</div>
                <div class="manager-product-price">${houtai.price}</div>
                <div class="manager-product-price">${houtai.sales}</div>
                <div class="manager-product-price1">${houtai.location}</div>
                <div class="manager-product-price">${houtai.catagory}</div>

                <div class="manager-method">
                    <a href="productServlet?action=retuenProduct&id=${houtai.id}&pageNo=${requestScope.page.pageNo}"> 修改商品</a>
                    <a class="delete" href="pageServlet?action=deleteProduct&productId=${houtai.id}&pageNo=${requestScope.page.pageNo}">下架商品</a></div>
            </div>
        </c:forEach>
    <script type="text/javascript">
    $(function () {
        $(".delete").click(function () {
            var summary=$(this).parent().parent().find("div").eq(1).text();
            return confirm("确定要下架["+summary+"]?")

        });
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
                location.href="pageServlet?action=pageHoutai&pageNo="+pageNo;
            }

        })
    })
</script>
    <div class="manger-product-add">
        <div class="manager-method1">
            <a href="productServlet?action=change&total=${requestScope.page.pageTotal}" style="color: #ff4400"> 添加商品</a>
    </div>
    </div>

</div>

<div id="footer">
    <div id="page-nav">
        <div id="page_nav">
            <c:if test="${requestScope.page.pageNo>1}"><a href="pageServlet?action=pageHoutai">首页</a>
                <a href="pageServlet?action=pageHoutai&pageNo=${requestScope.page.pageNo-1}">上一页</a></c:if>
            <c:choose>
                <c:when test="${requestScope.page.pageNo<=5}">
                    <C:forEach   begin="1" end="${requestScope.page.pageTotal}" var="i">
                        <%--判断显示得页面--%>
                        <c:if test="${requestScope.page.pageNo==i}">
                            [${i}]
                        </c:if>
                        <c:if test="${requestScope.page.pageNo!=i}">
                            <a href="pageServlet?action=pageHoutai&pageNo=${i}">${i}</a>
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
                                    <a href="pageServlet?action=pageHoutai&pageNo=${i}">${i}</a>
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
                                    <a href="pageServlet?action=pageHoutai&pageNo=${i}">${i}</a>
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
                                    <a href="pageServlet?action=pageHoutai&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </C:when>
            </c:choose>
            <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}"><a href="pageServlet?action=pageHoutai&pageNo=${requestScope.page.pageNo+1}">下一页</a>
                <a href="pageServlet?action=pageHoutai&pageNo=${requestScope.page.pageTotal}">末页</a></c:if>
            共${requestScope.page.pageTotal}页，${requestScope.page.pageCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
            <input type="button" id="bttn" value="确定">
        </div>
    </div>
</div>
</body>
</html>