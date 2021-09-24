<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		<!-- 대입문, 제어문 -->
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>		<!-- 서식 -->
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 	<!-- 함수 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 기능 카테고리 게시판</title>
<script src="https://kit.fontawesome.com/27afa53023.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src=".././javascript/formCheck.js"></script>
</head>
<body>
	<h1>Category Board</h1>
	<form class="form_main" action="insert.jsp" method="post" >
		<input class="category_main" type="text" name="category">
		<input type="submit" value="메인 카테고리 만들기">
	</form>
	<hr size="3">
	<c:forEach var="vo" items="${categoryList.list }">
		<form class="sub_form" action="reply.jsp" method="post">
			<input type="text" name="idx" value="${vo.idx}" size="1"/>
			<input type="text" name="gup" value="${vo.gup}" size="1"/>
			<input type="text" name="lev" value="${vo.lev}" size="1"/>
			<input type="text" name="seq" value="${vo.seq}" size="1"/>
			<c:if test="${vo.lev > 0}">
				<c:forEach var="i" begin="1" end="${vo.lev}" step="1">
					&nbsp&nbsp&nbsp
				</c:forEach>
				<i class="fas fa-arrow-right"></i>
			</c:if>
			${vo.category }
			<input class="sub_category" type="text" name="category" placeholder="add sub category"/>
			<input type="submit" value="+" >
			<a class="delete" onclick="location.href='delete.jsp?idx=${vo.idx}'">
				<i class="fas fa-trash-alt"></i>
			</a>
			<a class="report">
				<i class="fas fa-exclamation-circle"></i>
			</a>
			<a class="update">
				<i class="far fa-edit"></i>
			</a>
		</form>
	</c:forEach>
	
</body>
</html>