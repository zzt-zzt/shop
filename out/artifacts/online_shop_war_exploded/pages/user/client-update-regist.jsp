<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>用户修改信息</title>
    <%@include file="/pages/commont/baseUrl.jsp"%>

    <script type="text/javascript">
        $(function () {

                $(".login-summit").click(function () {
                    var clientPassword=$("#clientPassword").val();
                    var passowrdPatt=/\w{5,12}$/;
                    if(!passowrdPatt.test(clientPassword)){
                        $("#error-info").text("用户密码不合法！");
                        return false;
                    };
                   /* var repassword=$("#repwd").val();
                    if(repassword!=clientPassword){
                        $("#error-info").text("确认密码与用户密码不一致！");
                        return false;
                    };*/
                    var clientPhone=$("#clientPhone").val();
                    var PhonePatt=/^1[3456789]\d{9}$/;
                    if(!PhonePatt.test(clientPhone)){
                        $("#error-info").text("电话号码不合法！");
                        return false;
                    };
                    var clientSignature=$("#clientSignature").val();
                    if(clientSignature==null||clientSignature==""){
                        $("#error-info").text(" 个性签名不能为空！");
                        return false;
                    }

                    var  photo=$("#clientPhoto").val();
                    if(photo==null){
                        $("#error-info").text(" 上传照片为空！");
                        return false;
                    };
                });
            $(".regist-clientName").change(function () {
                var c=this.value;

                $.getJSON("loginAndRegist","action=usernameExit&name="+c,function (data) {

                    if(data.result==0){
                        $("#error-info").text(" 用户名已被注册");
                    }else if(data.result==1){
                        $("#error-info").text(" 用户名可用");
                    }
                })
            });
        })
    </script>
    <style>
        .regist-clientName{
            width: 200px;
            height: 32px;
            margin: 6px auto;
            border: 0 none;
            border: 1px #e3e3e3 solid;
        }
    </style>
</head>
<body>
<div class="head-logo"><div id="head-logo"><img   src="static/jpg/hea.png"></div></div>
<div class="login-cente">
    <div id="login-center">
        <div class="login-center-left"></div>
        <div class="regist-center-right"><!--登录窗口-->
           <div class="regsit-center-head">
              <span id="span1">修改用户信息</span>
               <span id="error-info">

               </span>
           </div>
            <div class="form1">
                <form method="post" enctype="multipart/form-data"  action="http://localhost:8080/lce/loginAndRegist?action=clientUpdate">
                    <label>修改名称：</label><input type="text" class="regist-clientName" name="clientName" id="clientName" value="${sessionScope.client.clientName}"><br />
                    <label>修改密码：</label><input type="password" class="regist-password" name="clientPassword" id="clientPassword" value="${sessionScope.client.clientPassword}"><br />
                    <label>确认密码：</label><input type="password" class="regist-password" name="repwd" id="repwd"><br />
                    <label>联系电话：</label><input type="text" class="regist-phone" name="clientPhone" id="clientPhone" value="${sessionScope.client.clientPhone}"><br />
                    <label>个性签名：</label><input type="text" class="regist-签名" name="clientSignature" id="clientSignature" value="${sessionScope.client.clientSignature}"><br />
                    <label>上传头像：</label>
                    <input type="file" class="photo"  name="clientPhoto" id="clientPhoto" ><br/>
                    <input type="submit" class="login-summit" value="确认修改"> <br />
                </form>

            </div>

        </div>
    </div>
</div>
</body>
</html>