<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	//进来时判断是否 已度过，已收藏过，目录和评论
</script>
<body>
	<div id="all" style="width:1333px;height:10000px;background-color:grey">
		<div id="advertise" style="width:1333px;height:260px;background-color:black;position:absolute;">
			<img style="width:1333px;height:260px;"src="images/timg1.jpg"/>;
		</div>
		<div id="bg">
			<div id="bookimage">
				<img id="img"style="width:145px;
				height:192px;"
				src=${sessionScope.book.img}/>
			</div>
			<div id="bookinfo">
				<h1>
					<em style="width:127px;height:37px;">${sessionScope.book.name }</em>
					<span><a style="font-size:15px;">${sessionScope.book.author.name}</a></span>
				</h1>
				<p >${sessionScope.book.des}</p>
				<p style="width:474px;height:36px;position:absolute;bottom:20px;">
				<a title="阅读至${requestScope.chapter_id}章"id="readbut" href="BookServlet?option=readChapter&chapter_id=${requestScope.chapter_id}" class="a">开始阅读</a>&nbsp;
				<a id="colbut" href="BookServlet?option=collectBook&book_id=${sessionScope.book.id}"  class="a">加入书架</a>&nbsp;
				<a href="dsas" class="a">打赏</a>
				
				<!--<input type="button" class="b" value="继续阅读"/>
				<input type="button" class="b" value="加入书架"/>
				<input type="button" class="b" value="打赏"/>-->
				</p>
			</div>
		</div>
		<div id="log">
			<ul>
				<li class="log1"><a id="1" href="test01servlet?currentlink=1">评论</a></li>
				<li class="log1"><a id="2" href="test01servlet?currentlink=2">目录</a></li>
			</ul>
		</div>
	</div>
	<style type="text/css">
		#bg{
			width:990px;
			height:232px;
			  position: relative;
			  left: 180px;
			  top:100px;
			  background-color:white;
		}
		#bookimage{
			width:145px;
			height:192px;
			background-color:blue;	
			float:left;
			margin:20px 20px 0 20px;
		}
		#bookinfo{
			width:474px;
			height:192px;
			background-color:white;
			float:left;
			margin:20px 20px 0 20px;
		}
		.a{
			text-decoration:none;
			display:inline-block; // display:block;
			width:100px;
			height:30px;
			border:1px solid #c00;
			color:white;
			background:#be2c23;
			border-radius:3px;
			text-align:center;
			line-height:30px;
			float:left;
			position:relative;
			margin:0 10px 0 0;
		}
			
		
		#log{
			width:990px;
			height:42px;
			line-height:42px;
			background-color:white;
			position:absolute;
			margin:150px 0 0 180px;
		}
		
		a:link{
			text-decoration:none
		}
		.log1{
			float:left;width:150px;
			height:42px;
			line-height:42px;
			list-style:none;
			text-align:center;
			margin:-14px 0 0 0;
			
		}
		.log1 a{
			color:#a6a6a6;
			font-family:#FZZCYSK;
			font-size:20px;
		}
		.log1 a:hover{
			color:#be2c23;
		}
}
	</style>
</body>
</html>