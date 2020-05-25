<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>登录</title>
    <%@include file="/pages/commont/baseUrl.jsp"%>
    <script type="text/javascript">
        $(function () {
            $(".spanClient").click(function () {
                this.style.background="red";
                  $(".form").css("display","");
                $(".spanManager").css("background-color","white");
                  $(".formHiden").css("display","none");

            })
            $(".spanManager").click(function () {
                this.style.background="red";
                $(".spanClient").css("background-color","white");
                   $(".form").css("display","none");
                $(".formHiden").css("display","");
            });
        })
    </script>
</head>
<body>
<div class="head-logo"><div id="head-logo"><img   src="static/jpg/hea.png"></div></div>
         <div class="login-cente">
             <div id="login-center">
                 <div class="login-center-left"><img   id=login-weclome" src="static/jpg/weclome1.jpg"></div>
                 <div class="login-center-right"><!--登录窗口-->
                     <div class="login-head">
                         <div></div>
                         <div class="spanClient">lce用户登录</div>
                         <div class="spanManager">商家登录</div>
                        <%-- <a id="loginToRegist" href="client-regist.jsp">用户注册</a>
                         <a id="loginToRegist1" href="shopper-regist.jsp">商家注册</a>--%>
                     </div>
                         <div class="login-tip"><svg id="svg" xmlns="http://www.w3.org/2000/svg" class="icon" viewBox="0 0 1024 1024" width="30px" height="30px" t="1589023275176" p-id="1402" version="1.1"><path fill="#ffee91" d="M 589.9 797.3 c 27.1 0 48.9 -21.8 48.9 -48.9 v -41 C 757 658.1 834 542.7 834.2 414.6 C 834.2 239.2 692 97 516.6 97 S 199.1 239.2 199.1 414.6 c 0 128.2 77.1 243.8 195.4 293.1 v 40.8 c 0 27.1 21.8 48.9 48.9 48.9" p-id="1403" /><path fill="#f9d151" d="M 701.3 156.6 c 37.4 52.1 59.6 115.7 59.6 184.7 c -0.1 122.8 -71 234 -181 286.4 c -8.7 4.1 -14.4 12.6 -14.4 22.2 v 49.7 c 0 13.5 -10.9 24.4 -24.4 24.4 H 394.5 v 24.4 c 0 27 21.9 48.9 48.9 48.9 H 590 c 27 0 48.9 -21.9 48.9 -48.9 v -41 C 757 658.1 834 542.7 834.2 414.6 c 0 -106.4 -52.5 -200.4 -132.9 -258 Z" p-id="1404" /><path fill="#ffffff" d="M 516.2 235.5 c -13.5 0.2 -24.2 11.3 -24 24.8 v 9.8 c -32.4 7.5 -57 36.7 -57 71.3 v 24.4 c 0 40.2 33.1 73.3 73.3 73.3 h 16.3 c 14 0 24.4 10.5 24.4 24.4 v 24.4 c 0 14 -10.5 24.4 -24.4 24.4 h -16.3 c -14 0 -24.4 -10.5 -24.4 -24.4 c 0.2 -13.5 -10.6 -24.6 -24.1 -24.8 c -13.5 -0.2 -24.6 10.6 -24.8 24.1 v 0.7 c 0 34.6 24.6 63.8 57 71.3 v 9.8 c -0.2 13.5 10.6 24.6 24.1 24.8 c 13.5 0.2 24.6 -10.6 24.8 -24.1 v -10.5 c 32.4 -7.5 57 -36.7 57 -71.3 v -24.4 c 0 -40.2 -33.1 -73.3 -73.3 -73.3 h -16.3 c -14 0 -24.4 -10.5 -24.4 -24.4 v -24.4 c 0 -14 10.5 -24.4 24.4 -24.4 h 16.3 c 14 0 24.4 10.5 24.4 24.4 c -0.2 13.5 10.6 24.6 24.1 24.8 c 13.5 0.2 24.6 -10.6 24.8 -24.1 v -0.7 c 0 -34.6 -24.6 -63.8 -57 -71.3 v -9.8 c 0.2 -13.5 -10.6 -24.6 -24.1 -24.8 h -0.8 Z" p-id="1405" /><path fill="#444852" d="M 427.1 870.6 c -13.5 -0.2 -24.6 10.6 -24.8 24.1 c -0.2 13.5 10.6 24.6 24.1 24.8 H 467.8 v 8.1 c 0 13.5 10.9 24.4 24.4 24.4 h 48.9 c 13.5 0 24.4 -10.9 24.4 -24.4 v -8.1 h 40.7 c 13.5 0.2 24.6 -10.6 24.8 -24.1 c 0.2 -13.5 -10.6 -24.6 -24.1 -24.8 H 427.1 Z M 516.6 72.6 c -188.6 0 -342 153.4 -342 342 c 0 132 77.3 249.9 195.4 306.5 v 27.3 c 0 40.2 33.1 73.3 73.3 73.3 h 65.1 c 13.5 0.2 24.6 -10.6 24.8 -24.1 c 0.2 -13.5 -10.6 -24.6 -24.1 -24.8 h -65.8 c -14 0 -24.4 -10.5 -24.4 -24.4 v -40.8 c 0 -9.9 -5.9 -18.8 -15 -22.6 c -109.3 -45.4 -180.4 -152 -180.4 -270.4 c 0 -162.2 130.9 -293.1 293.1 -293.1 c 162.2 0 293.1 130.9 293.1 293.1 c -0.1 118.3 -71.2 224.8 -180.4 270.3 c -9.1 3.8 -15 12.7 -15 22.6 v 41 c 0 14 -10.5 24.4 -24.4 24.4 c -13.5 -0.2 -24.6 10.6 -24.8 24.1 c -0.2 13.5 10.6 24.6 24.1 24.8 h 0.7 c 40.2 0 73.3 -33.1 73.3 -73.3 v -27.6 c 118 -56.6 195.3 -174.4 195.4 -306.2 c 0 -188.7 -153.4 -342.1 -342 -342.1 Z" p-id="1406" /></svg>
<!--                              <span id="login-tip">        请输入用户名和密码    </span>-->
                             <div id="login-tip"><%=request.getAttribute("login-tip")==null?"请输入用户名和密码":request.getAttribute("login-tip")%>  </div>
                         </div >
                     <div class="bigcontent">
                       <div class="form">
                           <form method="post" action="loginAndRegist?action=clientLogin">
                               <label>用户名称：</label><input type="text" class="login-username" name="name" id="1name" value="${ sessionScope.client.clientName}"><br />
                               <label>用户密码：</label><input type="password" class="login-password" name="password" id="1password" value="${sessionScope.client.clientPassword}" ><br />
                               <input type="checkbox" name="remember" checked="checked" value="remember">记住我
                               <input type="submit" class="login-summit" value="登录"> <br />
                           </form>
                       </div>
                         <div class="formHiden" style="display: none">
                             <form method="post" action="loginAndRegist?action=managerLogin">
                                 <label>商家名称：</label><input type="text" class="login-username" name="name" id="2name" value="${sessionScope.manager.managerName}"><br />
                                 <label>商家密码：</label><input type="password" class="login-password" name="password" id="2password" value="${sessionScope.manager.managerPassword}"><br />
                                 <input type="checkbox" name="remember" checked="checked" value="remember">记住我
                                 <input type="submit" class="login-summit" value="登录"> <br />
                             </form>
                         </div>
                     </div>

                 </div>
             </div>
         </div>
</body>
</html>