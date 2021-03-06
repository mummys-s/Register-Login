<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="css/regist.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
    function _change(){
    	var ele = document.getElementById("Vcode");
    	ele.src = "<c:url value='/verify'/>?xxx=" + new Date().getTime();
    }
    	
    </script>
</head>
<body>
<div class="wrapper">
        <article>
            <h1><em>Logo</em><span>注册</span></h1>
            <div class="main">
            
                <form action="<c:url value='/register'/>" method="post">
                    <div class="tel">
                        <input type="tel" name="ptel" value="${person.ptel }" placeholder="手机号"><em>由11个字符组成！</em>
                        ${errors.tel }
                    </div>
                    <div class="userName">
                        <input type="text" name="pname" value="${person.pname }" placeholder="用户名"><em>由2-8个字符组成！</em>
                        ${errors.name }
                    </div>
                    <div class="password">
                        <input type="password" name="ppassword" value="${person.ppassword }" placeholder="密码"><em>使用字母、数字、符号两种及以上的组合，8-12个字符</em>
                        ${errors.password }
                    </div>
                    <input type="text" name="verifyCode" value="${person.verifyCode }" placeholder="验证码"/><em>输入四位验证码</em>
                    <br/>
                    <img id="Vcode" src="<c:url value='/verify'/>" broder="2"/>
                    <a href="javascript:_change()">换一张</a>
                    ${errors.verifyCode }
                    <br/>
                    <p style="color: red; font-weight: 900" >${msg }</p>
                    <button>注册</button>
                </form>
            </div>
        </article>
    </div>
</body>
</html>