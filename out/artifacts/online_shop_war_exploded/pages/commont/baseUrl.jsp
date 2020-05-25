<%--
  Created by IntelliJ IDEA.
  User: 张泽涛
  Date: 2020/5/13
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>

    <%

        String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
        request.setAttribute("path",path);
    %>
    <base href="${requestScope.path}">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript"    src="static/script/jquery-1.7.2.js"></script>


