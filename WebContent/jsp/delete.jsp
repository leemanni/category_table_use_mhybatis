<%@page import="java.util.ArrayList"%>
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
	//out.println(original);
	//service.delete(vo.getIdx());
	//service.deleteCheck(vo.getIdx());
	//service.deleteRemain(vo.getIdx());
	
	ArrayList<CategoryVO> deleteList= service.getDeleteList(vo);
	for(int i = 0 ; i < deleteList.size(); i++){
		service.delete(deleteList.get(i).getIdx());
		try{
			if(deleteList.get(i).getSeq()+1 != deleteList.get(i+1).getSeq() ){
				break;
			}
		}catch(IndexOutOfBoundsException e){}
	}
	service.resetReq(original.getGup());
	out.println("<script>");
	out.println("alert(' "+ original.getCategory() +" 카테고리 삭제 완료')");
	out.println("location.href='list.jsp'");
	out.println("</script>");
%>
</body>
</html>