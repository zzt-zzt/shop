<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <%@include file="/pages/commont/baseUrl.jsp"%>

    <script type="text/javascript">
        $(function () {
            $("#code1").click(function () {
                this.src="http://localhost:8080/lce/kaptcha.jpg?d="+new Date();
            });
                $(".login-summit").click(function () {
                    var clientPassword=$("#clientPassword").val();
                    var passowrdPatt=/\w{5,12}$/;
                    if(!passowrdPatt.test(clientPassword)){
                        $("#error-info").text("用户密码不合法！");
                        return false;
                    };
                    var repassword=$("#repwd").val();
                    if(repassword!=clientPassword){
                        $("#error-info").text("确认密码与用户密码不一致！");
                        return false;
                    };
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
                    var code=$("#code").val();
                    if (code == null || code == "") {
//4 提示用户
                        $("#error-info").text(" 验证码不能为空！");
                        return false;
                    }

                    $("#error-info").text("");
                });
            $(".regist-clientName").blur(function () {
                var c=this.value;
                $.getJSON("loginAndRegist","action=usernameExit&name="+c,function (data) {

                           if(data.result==0){
                               $("#error-info").text(" 用户名已被注册");
                           }else if(data.result==1){
                               $("#error-info").text(" 用户名可用");
                           }
                    });
            })
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
        <div class="login-center-left"><img   id=login-weclome" src="static/jpg/regist.jpg"></div>
        <div class="regist-center-right"><!--登录窗口-->
           <div class="regsit-center-head">
              <span id="span1">LCE 用户注册</span>
               <span id="error-info">
                   ${ empty requestScope.codeNot?"":"验证码不正确"}
               </span>
           </div>
            <div class="form1">
                <form method="post" enctype="multipart/form-data"  action="http://localhost:8080/lce/loginAndRegist?action=clientRegist">
                    <label>用户名称：</label><input type="text" class="regist-clientName" name="clientName" id="clientName" value="${empty requestScope.clientName?"":requestScope.clientName}"><br />
                    <label>用户密码：</label><input type="password" class="regist-password" name="clientPassword" id="clientPassword" ><br />
                    <label>确认密码：</label><input type="password" class="regist-password" name="repwd" id="repwd"><br />
                    <label>联系电话：</label><input type="text" class="regist-phone" name="clientPhone" id="clientPhone" value="${empty requestScope.clientPhone?"":requestScope.clientPhone}"><br />
                    <label>个性签名：</label><input type="text" class="regist-签名" name="clientSignature" id="clientSignature" value="${empty requestScope.clientSignture?"":requestScope.clientSignture}"><br />
                    <label>上传头像：</label>
                    <input type="file" class="photo" required="required" name="clientPhoto" id="clientPhoto" ><br/>
                    <label>验证码：</label>
                    <input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
                    <img alt="" src="http://localhost:8080/lce/kaptcha.jpg"  style="width: 100px; height: 31px;" id="code1"  >
                    <br />
                    <input type="submit" class="login-summit" value="注册"> <br />
                </form>

            </div>

        </div>
    </div>
</div>
</body>
</html>