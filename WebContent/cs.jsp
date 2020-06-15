<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AuthorServlet?option=authorLogin"  method="post">
		<input type="text" name="author_tel"/>
		<input type="text" name="author_pass"/>
		<input type="submit"/>
	</form>
</body>
</html>