<%@page import="com.leemanni.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main category insert</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="vo" class="com.leemanni.vo.CategoryVO">
		<jsp:setProperty property="*" name="vo"/>
	</jsp:useBean>
	<%
		CategoryService.getInstance().reply(vo);
		response.sendRedirect("list.jsp");
	%>
</body>
</html>