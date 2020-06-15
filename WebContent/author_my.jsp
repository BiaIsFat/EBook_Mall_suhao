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
	$(function(){
		$("#allbody").append($("#authorpart"));
	
	})
</script>
<body>
	<jsp:include page="author_tool.jsp"></jsp:include>
	<div id="authorpart">
		<div id="infotitle">
			<h2 class="titlefont">个人信息</h2>
		</div>
		<div id="info">
			<div id="info_left">
				<div id="author_img_div">
					<img  src="author_b.jpg" id="author_img"/>
				</div>
				<div id="author_name"><strong>ss</strong>
				</div>
			</div>
			<div id="info_right">
				<ul id="ul1" style="margin:0;text-align:left;padding:0;">
					<li class="info_li">
						<small class="font">创作天数</small><span class="number">天数</span>
					</li>
					<li class="info_li">
						<small class="font">作品粉丝</small><span class="number">个数</span>
					</li>
					<li class="info_li" id="info_li1">
						<small class="font">累计打赏</small><span class="number">打赏额</span>
					</li>
				</ul>
			</div>
		</div>
		<div id="worktitle">
			<p><h2 class="titlefont">最新作品</h2></p>
		</div>
		<div id="new_work">
			<ul>
				<li class="book_li">
					<div class="div_img"><center><img class="book_img"src=""></center></div>
					<div class="book_info">
						<div class="book_name">作品名称<br></div>
						<div class="chapter_name"><a class="chapter_a" href="">最新的更新章节</a></div>
						<p>更新时间</p>
						<p>收藏:总数</p>
						<div class="write_div"><a class="write_a" href="">去写作</a></div>
					</div>
				</li>
			</ul>
		</div>
		<div id="recordtitle">
			<p><h2 class="titlefont">记录</h2></p>
		</div>
		<
	</div>
	<style type="text/css">
		#authorpart{
			width:850px;
			height:800px;
			position:absolute;
			z-index:1; 
			margin:0 0 0 180px;
			background-color:white;
		}
		#infotitle{
			width:850px;
			height:52px;
			position:relative;
			z-index:10; 
			background-color:white;
			margin:20px 0 0 0px;
			border-bottom: 1px solid grey   ;
   			
		}
		.titlefont{
			display:inline-block;
			 border-bottom: 3px solid black  ;
   			 padding-bottom: 13px;/* 向下平移20像素单位长度 */
   			 margin:5px 0 0 0;
		}
		#info{
			width:850px;
			height:65px;
			position:relative;
			background-color:white;
			top:20px;
		}
		#info_left{
			width:410px;
			height:65px;
			position:absolute;
			background-color:white;
		}
		#author_img_div{
			width:70px;
			height:65px;
			background-color:pink;
		}
		
		#author_img{
			width:65px;
			height:70px;
			
		}
		#author_name{
			width:336px;
			height:54px;
			margin:-60px 0 0 80px;
			font-size:25px;
			line-height:54px;
		}
		#info_right{
			width:420px;
			height:65px;
			position:absolute;
			background-color:white;
			right:0;
		}
		.info_li{
			width:122px;
			height:63px;
			list-style:none;
			float:left;
			text-align:left;
			border-right:1px solid #A0A0A0;
			padding-left: 12px;/* 向下平移20像素单位长度 */
		}
		#info_li1{
			border-right:0;
		
		}
		.number{
			width:100px;
			height:45px;
			float:left;
			line-height:45px;
			margin:10px 0 0 0;
			
		}
		.font{
			color:#A0A0A0;
		}
		#worktitle{
			width:850px;
			height:52px;
			position:relative;
			z-index:10; 
			background-color:white;
			margin:65px 0 0 0px;
			border-bottom: 1px solid grey   ;
   			
		}
		#new_work{
			width:850px;
			height:180px;
			background-color:white;
		}
		.book_li{
			width:850px;
			height:170px;
			list-style:none;
			postion:relative;
			
			margin:20px 0 0 -40px;
		}
		.div_img{
			width:108px;
			height:145px;
			border:1px solid #D0D0D0;
			display:table-cell;
			position:absolute;
   			text-align:center;vertical-align:middle
		}
		.book_img{
		width:100px;
		height:136px;
		border:1px solid #D0D0D0;
		_margin-top: expression_r(( 108 - this.height ) / 2);
		}
		.book_info{
			width:710px;
			height:145px;
			
			position:absolute;
			margin:0 0 0 140px;
		}
		.book_name{
			width:710px;
			height:38px;
		
			position:absolute;
			font-size:25px;
			line-height:38px;
		}
		.chapter_name{
			width:713px;
			height:25px;
			line-height:25px;
			
			margin:40px 0 0 0;
		}
		.chapter_a{
			height:25px;
			line-height:25px;
			text-decoration:none;
		}
		.chapter_a:hover{
			color:#3333FF;
		}
		.write_div{
			width:180px;
			height:33px;
			position:absolute;
			text-align:right;
			right:0;
			bottom:0;
			background-color:white;
		}
		.write_a{
			text-decoration:none;
			display:inline-block;
			width:100px;
			height:30px;
			border:1px solid white;
			color:white;
			background-color:#0066FF;
			border-radius:3px;
			text-align:center;
			line-height:30px;
			bottom:0;
			right:0;
		}
		#recordtitle{
			width:850px;
			height:52px;
			position:relative;
			z-index:10; 
			background-color:white;
			margin:-10px 0 0 0px;
			border-bottom: 1px solid grey   ;
		}
	</style>
</body>
</html>