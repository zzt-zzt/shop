<%--
  Created by IntelliJ IDEA.
  User: 张泽涛
  Date: 2020/5/15
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="footer">
    <div id="page-nav">
        <div id="page_nav">
            <c:if test="${requestScope.page.pageNo>1}"><a href="pageServlet?action=page&pageNo=1">首页</a>
                <a href="pageServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a></c:if>
            <c:choose>
                <c:when test="${requestScope.page.pageNo<=5}">
                    <C:forEach   begin="1" end="${requestScope.page.pageTotal}" var="i">
                        <%--判断显示得页面--%>
                        <c:if test="${requestScope.page.pageNo==i}">
                            [${i}]
                        </c:if>
                        <c:if test="${requestScope.page.pageNo!=i}">
                            <a href="pageServlet?action=page&pageNo=${i}">${i}</a>
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
                                    <a href="pageServlet?action=page&pageNo=${i}">${i}</a>
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
                                    <a href="pageServlet?action=page&pageNo=${i}">${i}</a>
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
                                    <a href="pageServlet?action=page&pageNo=${i}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </C:when>
            </c:choose>
            <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}"><a href="pageServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
                <a href="pageServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a></c:if>
            共${requestScope.page.pageTotal}页，${requestScope.page.pageCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
            <input type="button" id="bttn" value="确定">
        </div>
    </div>
</div>
