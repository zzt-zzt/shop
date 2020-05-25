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
    <span style="font-size: 50px;margin: 40px 10px 0 ;float: left">商品下架区</span>
    <a class="cart-head" href="#">返回首页</a>
    <a class="cart-head" href="pageServlet?action=pageHoutai">管理商品</a>
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

        <c:forEach items="${requestScope.page1.pageItem}" var="houtai">
            <div class="manger-product-info">
                <img class="manager-photo" src="${houtai.images}">
                <div class="manager-name">${houtai.name}</div>
                <div class="manager-decribe">${houtai.summary}</div>
                <div class="manager-product-price">${houtai.price}</div>
                <div class="manager-product-price">${houtai.sales}</div>
                <div class="manager-product-price1">${houtai.location}</div>
                <div class="manager-product-price">${houtai.catagory}</div>

                <div class="manager-method">
                    <a class="delete" href="productServlet?action=addAndDelete&id=${houtai.id}">重新上架</a></div>
            </div>
        </c:forEach>
    <script type="text/javascript">
    $(function () {
        $("#bttn").click(function () {
            //获取跳到第几页的属性值
            var  pageNo = $("#pn_input").val();
            if(pageNo>${requestScope.page1.pageTotal}){
                $("#pn_input").val(${requestScope.page1.pageTotal})
                alert("当前页码不存在");

                /* location.href="pageServlet?action=page&pageNo="+pageNo;*/

            }
            else if(pageNo<1){ $("#pn_input").val(1);
                alert("当前页码不存在");

            }else{
                location.href="pageServlet?action=showdeleteProduct&pageNo="+pageNo;
            }

        })
    })
</script>
    <div class="manger-product-add">
    </div>

</div>

<div id="footer">
    <div id="page-nav">
        <div id="page_nav">
            <c:if test="${requestScope.page1.pageNo>1}"><a href="pageServlet?action=showdeleteProduct">首页</a>
                <a href="pageServlet?action=showdeleteProduct&pageNo=${requestScope.page1.pageNo-1}">上一页</a></c:if>
            <c:choose>
                <c:when test="${requestScope.page1.pageNo<=5}">
                    <C:forEach   begin="1" end="${requestScope.page1.pageTotal}" var="i">
                        <%--判断显示得页面--%>
                        <c:if test="${requestScope.page1.pageNo==i}">
                            [${i}]
                        </c:if>
                        <c:if test="${requestScope.page1.pageNo!=i}">
                            <a href="pageServlet?action=showdeleteProduct&pageNo=${i}">${i}</a>
                        </c:if>
                    </C:forEach>
                </c:when>
                <C:when test="${requestScope.page1.pageTotal>5}">
                    <c:choose>
                        <c:when test="${requestScope.page1.pageNo<=3}">
                            <c:forEach begin="1" end="5">
                                <%--判断显示得页面--%>
                                <c:if test="${requestScope.page1.pageNo==i}">
                                    [${i}]
                                </c:if>
                                <c:if test="${requestScope.page1.pageNo!=i}">
                                    <a href="pageServlet?action=showdeleteProduct&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <c:when test="${requestScope.page1.pageNo>requestScope.page1.pageTotal-3}">
                            <c:forEach begin="${requestScope.page1.pageTotal-4}" end="${requestScope.page1.pageTotal}">
                                <%--判断显示得页面--%>
                                <c:if test="${requestScope.page1.pageNo==i}">
                                    [${i}]
                                </c:if>
                                <c:if test="${requestScope.page1.pageNo!=i}">
                                    <a href="pageServlet?action=showdeleteProduct&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach begin="${requestScope.page1.pageNo-2}" end="${requestScope.page1.pageNo+2}">
                                <%--判断显示得页面--%>
                                <c:if test="${requestScope.page1.pageNo==i}">
                                    [${i}]
                                </c:if>
                                <c:if test="${requestScope.page1.pageNo!=i}">
                                    <a href="pageServlet?action=showdeleteProduct&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </C:when>
            </c:choose>
            <c:if test="${requestScope.page1.pageNo<requestScope.page1.pageTotal}"><a href="pageServlet?action=showdeleteProduct&pageNo=${requestScope.page1.pageNo+1}">下一页</a>
                <a href="pageServlet?action=showdeleteProduct&pageNo=${requestScope.page1.pageTotal}">末页</a></c:if>
            共${requestScope.page1.pageTotal}页，${requestScope.page1.pageCount}条记录 到第<input value="${requestScope.page1.pageNo}" name="pn" id="pn_input"/>页
            <input type="button" id="bttn" value="确定">
        </div>
    </div>
</div>
</body>
</html>