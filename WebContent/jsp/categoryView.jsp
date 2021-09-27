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
		<input class="category_main" type="text" name="category" placeholder="add main category">
		<input type="submit" value="메인 카테고리 만들기">
	</form>
	<hr size="3">
	
	<c:forEach var="vo" items="${categoryList.list }">
		<c:set var="formName" value="form${vo.idx}"/>
		<form class="sub_form" action="reply.jsp" method="post" name="${formName}">
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
			
			<c:if test="${vo.deleteCheck == 'YES'}">
				<span>삭제한 카테고리 입니다.</span>
				<a class="re_category" onclick="undoRemove(${formName})">
					<i class="fas fa-redo-alt"></i>
				</a>
			</c:if>
			<c:if test="${vo.deleteCheck != 'YES'}">
				<c:if test="${vo.deleteReport <= 10 }">
					${vo.category }
					<input class="sub_category" type="text" name="category" placeholder="add sub category"/>
					<input type="submit" value="+" >
					<a class="delete" onclick="mySubmitDelete(${formName})">
						<i class="fas fa-trash-alt"></i>
					</a>
					<a class="report" onclick="report(${formName})">
						<i class="fas fa-exclamation-circle"></i>
					</a>
					<a class="update" onclick="update(${formName})">
						<i class="far fa-edit"></i>
					</a>
				</c:if>
				
				<c:if test="${vo.deleteReport > 10 }">
					<span>경고를 많이 받아서 삭제된 카테고리 입니다.</span>
				</c:if>
			</c:if>
		</form>
	</c:forEach>
	
</body>
</html>