<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	<c:forEach var="dto" items="${list }">
		${dto.id } / ${dto.writer } / <a href="view?id=${dto.id }">${dto.title }</a>/<a href="delete?"></a>
	</c:forEach>
	<p><a href="writeForm.jsp">글작성</a></p>
</body>
</html>