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
var Imgone=document.getElementsByClassName("recom_img");
Imgone.onmouseover = function () {
	Imgone.style.width="150px";
	Imgone.style.height="200px";
	Imgone.style.transition="0.8s ease";
}
Imgone.onmouseout = function () {
	Imgone.style.width="";    //不需要设置大小，空的话会回到原来大小
	Imgone.style.height="";
	Imgone.style.transition="0.8s ease";
}
	
</script>
<body>
	<center><jsp:include page="mycontrol.jsp" flush="true"></jsp:include></center>
	<div id="bg">
		<div id="left">
		
		</div>
		<div id="body">
			<form id="form1" action="searchinbooksheft">
				<input id="input1" type="text" name="bookname" placeholder="在书架内搜">
				<input id="but1" type="button" value="搜图书"/>
			</form>
			<div id="recommend1">
				<a id="recommend_a" href="#">良心推荐</a>
			</div>
			<div id="recommend2">
				<ul>
				<li class="re_li"><a href=""><img class="recom_img"src="./images/ssyy.jpg"/></a><center><a class="a_name" href="">书名</a></center></li> 
					<li class="re_li"><a href=""><img  class="recom_img"src="./images/ssyy.jpg"/></a><center><a  class="a_name"href="">书名</a></center></li>
					<li class="re_li"><a href=""><img  class="recom_img"src="./images/ssyy.jpg"/></a><center><a  class="a_name"href="">书名</a></center></li>
					<li class="re_li"><a href=""><img  class="recom_img"src="./images/ssyy.jpg"/></a><center><a  class="a_name"href="">书名</a></center></li>
					<li class="re_li"><a href=""><img  class="recom_img"src="./images/ssyy.jpg"/></a><center><a  class="a_name"href="">书名</a></center></li>
					<li class="re_li"><a href=""><img  class="recom_img"src="./images/ssyy.jpg"/></a><center><a  class="a_name"href="">书名</a></center></li>
				</ul>
			</div>
			<div id="shefttitle">
				书架
			</div>
			<div id="sheft">
				<table id="tablesheft">
					<th width="400">书名/最新章节</th> <th width="90">更新时间</th> <th width="80">作者</th> <th width="70">阅读进度</th>
					<tbody id="tbody">
						<c:forEach var="book" items="${requestScope.list}">
							<script type="text/javascript">
							var $book_tr=$("<tr background="red"><a class='tr_a' href="">${list[1]}</a><td>${list[1]}</td><td>${list[1]}</td><td>${list[1]}</td><td>阅读进度</td></tr>");
							$("#tbody").append($book_tr);
							</script>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
	</div>
	
	<style type="text/css">
		#bg{
			width:908px;
			height:900px;
			
			position:relative;
			margin:15px 230px 0 215px;
		}
		#left{
			width:154px;
			height:214px;
			position:absolute;
			background-color:grey;
			margin:0 0 0 0;
		}
		#body{
			width:738px;
			height:818px;
			position:relative;
			
			margin:0 0 0 170px;
		}
		#form1{
			position:absolute;
			top:10px;
		}
		#input1{
			width:314px;
			height:30px;
		}
		#but1{
			background: #bf2c24;
			color:#f2f2f2;
			font-size:16px;
			font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;
			font-weight:bold;
			border-radius:3px;
			height:37px;
			position:absolute;
			margin:0 0 0 -3px;
			-webkit-transition:all linear 0.30s;
			-moz-transition:all linear 0.30s;
			transition:all linear 0.30s;

		}
		#recommend1{
			width:738px;
			height:35px;
			
			position:absolute;
			margin:55px 0 0 0;
			border: 1px solid #e0deda;
    		border-bottom-color: rgb(224, 222, 218);
    		border-bottom-style: solid;
    		border-bottom-width: 1px;
    		border-top:0;
    		border-left:0;
    		border-right:0;
		}
		
		#recommend_a{
			text-decoration:none;
			border: 1px solid #e0deda;
    		border-bottom-color: rgb(224, 222, 218);
    		border-bottom-style: solid;
    		border-bottom-width: 1px;
			border-bottom: 0;
			border-radius: 4px 4px 0 0;
			font-weight: 600;
			margin:5px 0 -5px; 0;
			padding: 5px 19px 1px;
			color:#3e3d43;
		}
		#recommend2{
			width:738px;
			height:200px;
			
			position:absolute;
			margin:90px 0 0 0;
			font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;
			border: 1px solid #e0deda;
			border-bottom-color: rgb(224, 222, 218);
    		border-bottom-style: solid;
    		border-bottom-width: 1px;
			
			
		}
		.a_name{
			text-decoration:none;
			color:grey;
		}
		.a_name:hover{
			color:#bf2c24;
		}
		.recom_img{
			width:106px;
			height:142px;
		}
		.re_li{
			float:left;
			width:106px;
			height:142px;
			list-style:none;
			position:relative;
			margin:0 8px 0 0;
			border: 1px solid #e0deda;
			border-bottom-color: rgb(224, 222, 218);
    		border-bottom-style: solid;
    		border-bottom-width: 1px;
    		text-align:center;
		}
		.re_name{
			position:absolute;
			margin:120px 0 0 30px;
			text-align:center;
		}
		#shefttitle{
			width:738px;
			height:35px;
			background-color:yellow;
			position:absolute;
			margin:305px 0 0 0;
		}
		#sheft{
			width:738px;
			height:400px;
			background-color:white;
			position:absolute;
			margin:340px 0 0 0;
		
		}
	</style>
</body>
</html>