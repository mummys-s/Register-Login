<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑用户</title>
</head>
<body>
<form action="<c:url value='/edit?pid=${person.pid}'/>" method="post">
	电话：<input type="text" name="ptel" value="${person.ptel }" /><br/>
	姓名：<input type="text" name="pname" value="${person.pname }" /><br/>
	密码：<input type="text" name="ppassword" value="${person.ppassword }" /><br/>
	<input type="submit" value="提交">
</form>
</body>
</html>