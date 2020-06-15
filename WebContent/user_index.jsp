<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	name:${sessionScope.user.name}
	<a href="BookServlet?option=readBook&book_id=01">01</a>
</body>
</html>