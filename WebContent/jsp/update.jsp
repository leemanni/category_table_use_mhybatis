<%@page import="com.leemanni.vo.CategoryVO"%>
<%@page import="com.leemanni.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="com.leemanni.vo.CategoryVO">
	<jsp:setProperty property="*" name="vo"/>
</jsp:useBean>
<%
	CategoryService service = CategoryService.getInstance();
	CategoryVO original = service.selectByIdx(vo.getIdx());
	service.update(vo);
	
	
	out.println("<script>");
	out.println("alert(' "+ original.getCategory() +"를 "+ vo.getCategory()+" 로   수정 완료')");
	out.println("location.href='list.jsp'");
	out.println("</script>");
%>
</body>
</html>