<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示用户信息</title>

</head>
<body>
<h3 align="center">客户列表</h3>
<table border="1" width="70%" align="center">
	<tr>
		<th>客户姓名</th>
		<th>密码</th>
		<th>电话</th>
		<th>操作</th>
	</tr>
<c:forEach items="${requestScope.personlist }" var="cstm">

<%-- <%=request.getAttribute("personlist") %> --%>
	<tr>
		<td>${cstm.pname }</td>
		<td>${cstm.ppassword }</td>
		<td>${cstm.ptel }</td>
		<td>
			<a href="<c:url value='/load?pid=${cstm.pid }'/>">编辑</a>
			<a href="<c:url value='/delete?pid=${cstm.pid }'/>">删除</a>
		</td>
	</tr>
</c:forEach>
</table>
<br/>
</body>
</html>