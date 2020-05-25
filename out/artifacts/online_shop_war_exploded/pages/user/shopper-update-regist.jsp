<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>商家修改信息</title>
    <%@include file="/pages/commont/baseUrl.jsp"%>

    <script type="text/javascript">
       $(function () {
           $(".login-summit").click(function () {

               var managerPassword=$("#managerPassword").val();
               var passowrdPatt=/\w{5,12}$/;
               if(!passowrdPatt.test(managerPassword)){
                   $("#error-info").text("用户密码不合法！");
                   return false;
               };
               var repassword=$("#rep").val();
               if(repassword!=managerPassword){
                   $("#error-info").text("确认密码与用户密码不一致！");
                   return false;
               };
               var managerPhone=$("#managerPhone").val();
               var PhonePatt=/^1[3456789]\d{9}$/;
               if(!PhonePatt.test(managerPhone)){
                   $("#error-info").text("电话号码不合法！");
                   return false;
               };
               var managerSignature=$("#managerSignature").val();
               if(managerSignature==null||managerSignature==""){
                   $("#error-info").text(" 个性签名不能为空！");
                   return false;
               };

               $("#error-info").text("");
           });
           $(".regist-username").change(function () {
               var c=this.value;
               $.getJSON("loginAndRegist","action=managerExit&name="+c,function (data) {

                   if(data.result==0){
                       $("#error-info").text(" 用户名已被注册");
                   }else if(data.result==1){
                       $("#error-info").text(" 用户名可用");
                   }
               });
           })

       })
    </script>
</head>
<body>

<div class="head-logo"><div id="head-logo"><img   src="static/jpg/hea.png"></div></div>
<div class="login-cente">
    <div id="login-center">
        <div class="login-center-left"></div>
        <div class="regist-center-right"><!--登录窗口-->
           <div class="regsit-center-head">
              <span id="span1">商家修改信息</span>
               <span id="error-info"></span>
           </div>
            <div class="form1" >
                <form  action="loginAndRegist?action=managerUpdate" method="post" enctype="multipart/form-data" >
                    <label>商家名称：</label><input type="text" class="regist-username" name="managerName" id="managerName" value="${sessionScope.manager.managerName}"><br />
                    <label>商家密码：</label><input type="password" class="regist-password" name="managerPassword" id="managerPassword" value="${sessionScope.manager.managerPassword}"><br />
                    <label>确认密码：</label><input type="password" class="regist-password" name="rep" id="rep"><br />
                    <label>联系电话：</label><input type="text" class="regist-phone" name="managerPhone" id="managerPhone" value="${sessionScope.manager.managerPhone}"><br />
                    <label>个性签名：</label><input type="text" class="regist-签名" name="managerSignature" value="${sessionScope.manager.managerSignature}" id="managerSignature" ><br />
                    <label>上传头像：</label>
                    <input type="file" class="photo"  name="managerPhoto" id="managerPhoto"><br/>
                    <input type="submit" class="login-summit" value="注册"> <br />
                </form>

            </div>

        </div>
    </div>
</div>
</body>
</html>