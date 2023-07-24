<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 목록</h1>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>내용</th>
        </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.id}</td>
                <td>${item.writer}</td>
                <td>${item.title}</td>
                <td>${item.content}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>