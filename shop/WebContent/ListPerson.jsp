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
<c:forEach items="${pd.beanList }" var="cstm">

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
<center>
第${pd.pc }页/共${pd.tp }页
<a href="<c:url value='/list?pc=1'/>">首页</a>
<c:if test="${pd.pc > 1 }">
	<a href="<c:url value='/list?pc=${pd.pc-1 }'/>">上一页</a>
</c:if>

<c:choose>
	<c:when test="${pd.tp <= 10 }">
		<c:set var="begin" value="1"/>
		<c:set var="end" value="${pd.tp }"/>
	</c:when>
	<c:otherwise>
		<c:set var="begin" value="${pd.pc-5 }"/>
		<c:set var="end" value="${pd.pc+4 }"/>
		<c:if test="${begin < 1 }">
			<c:set var="begin" value="1"/>
			<c:set var="end" value="10"/>
		</c:if>
		<c:if test="${end > pd.tp }">
			<c:set var="begin" value="${pd.tp - 9 }"/>
			<c:set var="end" value="${pd.tp }"/>
		</c:if>
	</c:otherwise>
</c:choose>

<c:forEach  var="i" begin="${begin }" end="${end }">
	<c:choose>
		<c:when test="${i eq pd.pc }">
			${i }
		</c:when>
		<c:otherwise>
			<a href="<c:url value='/list?pc=${i }'/>">${i }</a>
		</c:otherwise>
	</c:choose> 
</c:forEach>


<c:if test="${pd.pc < pd.tp }">
	<a href="<c:url value='/list?pc=${pd.pc+1 }'/>">下一页</a>
</c:if>
<a href="<c:url value='/list?pc=${pd.tp }'/>">尾页</a>
</center>
</body>
</html>