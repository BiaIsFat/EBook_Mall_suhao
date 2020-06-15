<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="title">
		<div id="head">
			<ul id="myoption">
				<li class="_li"><a class="1" href="myinforservlet">返回首页</a></li>
				<li class="_li"><a class="1" href="myinforservlet">个人中心</a></li>
				<li class="_li"><a class="2" href="mycollectservlet">我的书架</a></li>
				<li class="_li"><a class="3" href="mymessageservlet">我的消息</a></li>
			
			</ul>
		</div>
	</div>
	<br>

	<style type="text/css">
	#title{
		width:1333px;
		height:70px;
		background: #3e3d43;
	}
	#head{
		opstion:absolute;
		width:900px;
		height:70px;
		
		margin:0 150px 0 150px;
	}
	._li a{
		width:200px;
		height:68px;
		color:white;
		text-align:center;
	}
	._li a:link{
		text-decoration:none
	}
	._li a:hover{
		background-color:#be2c23;
		display:block;
	}
	._li{
		
		float:left;
		width:200px;
		height:68px;
		list-style:none;
		margin:1px 0 1px 0;
		line-height:68px;
	}
	</style>

</body>
</html>