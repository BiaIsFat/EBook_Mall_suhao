<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
window.onload=function(){
	var dis=${requestScope.currentchapter.id};
	if(dis==1){
		document.getElementById("pre").color="grey";
		document.getElementById("pre").innerText="第一章";
	}
	document.getElementById("colbut").onclick=function(){
		var xmlHttp=new XMLHttpRequest();
		xmlHttp.onreadystatechange=function(){
			if (xmlHttp.readyState==4 && xmlhttp.status==200){
				document.getElementById("colbut").innerText="已加";
			}
		};
		xmlHttp.open("get","./BookServlet?option=collectBook&book_id=${sessionScope.book.id}","ture/false");
		xmlHttp.send();
	}
};
	
	

</script>
<body>
	<div id="head">
		<div id="logo_div">
			<img id="logo_img" src="./images/qd.jpg"/>
		</div>
	</div>
	<div id="mid"></div>
	<div id="wrap_body">
		<div id="chapter_body" class="red">
			<div id="left">
				<ul>
					<li class="page_left">
						<a id="colbut"href="#">添加</a>
					</li>
					<li class="page_left">
						<a href="BookServlet?option=readBook&book_id=${sessionScope.book.id}">书页</a>
					</li>
				</ul>
			</div>
			<div id="chapter_body_wrap">
				<div id="book_info">
					<div id="book_img_div">
						<img id="book_img" src="${sessionScope.book.img}" />
					</div>
					<h2>${sessionScope.book.name}</h2>
					<h4>${sesssionScope.bok.author.name}著</h4>
					<div id="book_info_div">
						<ul>
							<li class="_li"><p>${sessionScope.book.type }</p><span>类型</span></li>
							<li class="_li"><p>${sessionScope.book.date}</p><span>日期</span></li>
							<li class="_li"><p>222</p><span>收藏</span></li>
						</ul>
					</div>
				</div>
				<div id="chapter">
					<div id="chapter_name_div"><h3>第${requestScope.currentchapter.id}章 ${requestScope.currentchapter.name}</h3></div>
					<div id="chapter_body">${requestScope.currentchapter.context}</div>
				</div>
			</div>
			<div id="right">
				<ul>
					<li class="page_li">
						<a id="pre" href="BookServlet?option=readChapter&chapter_id=${requestScope.currentchapter.id-1}">上一章</a>
					</li>
					<li class="page_li">
						<a id="next" href="BookServlet?option=readChapter&chapter_id=${requestScope.currentchapter.id+1}">下一章</a>
					</li>
				</ul>
			</div>
		</div>
		
		
	</div>
</body>
<style type="text/css">
	#head{
		position: relative;
		z-index: 104;
		height: 60px;
		margin-bottom: 16px;
		border:1px solid #C0C0C0;
		background:
		rgba(255,255,255,.4);
	}
	#logo_div{
		width:200px;
		height:63px;
		margin:0 0 0 100px;
		float:left;
	}
	#logo_img{
		width:150px;
		height:63px;
	}
	#mid{
		position: relative;
		z-index: 1;
		width: 800px;
		height: 22px;
		margin: 0 auto 21px;
	}
	#wrap_body {
		position: relative;
		z-index: 100;
		width: 1200px;
		height:3000px;
		margin: 0 auto;
		bakground-color:rgba(245,234,204,.8);
	}
	#chapter_body{
		    font-size: 18px;
		    font-family: 'Microsoft YaHei',PingFangSC-Regular,HelveticaNeue-Light,'Helvetica Neue Light',sans-serif;
			color:
	}
	.red{
		font-size: 18px;
		width: 800px;
		margin: 0 auto;
	}
	#chapter_body_wrap{
		padding: 60px 64px;
		width:750px;
		height:3000px;
		border:1px solid #C0C0C0;
	}
	#left{
		position: fixed;
		width: 60px;
		z-index: 102;
		top: 119px;
		left: 15%;
		height:200px;
		
		margin: 0;
    	margin-left: 0px;
		padding: 0
	}
	#book_info{
		width:770px;
		height:800px;
		text-align:center;
		
		
	}
	#book_img_div{
		width: 128px;
		height: 168px;
		margin: 64px auto 24px;
	border: 1px solid #efece5;
	}
	
	#book_img{
		width: 125px;
		height: 165px;
	}
	#book_info_div{
		    width: 500px;
    		margin: 0 auto 48px;
	}
	._li{
		width:100px;
		font-size: 14px;
   		float: left;
		list-style: none outside none;
		margin:0 50px 0 0;
	}
	p{
		font: 18px/26px PingFangSC-Regular,HelveticaNeue-Light,'Helvetica Neue Light','Microsoft YaHei',sans-serif;
    	margin-bottom: 5px;
    	white-space: nowrap;

	}
	._li span{
		font: 12px/16px PingFangSC-Regular,'-apple-system',Simsun;
		display: block;
		color: #999;
		color:
		rgba(0,0,0,.4);
	}
	em{
		font: 18px/30px Arial;
		display: inline-block;
		margin-bottom: 2px;
	}
	#chapter{
		width:770px;
		height:2980px;
		background-color:grey;
		margin:20px 0 0 0;
		
	}
	#chapter_name_div{
		position: relative;
		z-index: 5;
		margin-bottom: 12px;	
	}
	#chapter_name_div h3{
		font: 24px/32px PingFangSC-Regular,HelveticaNeue-Light,'Helvetica Neue Light','Microsoft YaHei',sans-serif;
		overflow: hidden;
		height: 32px;
		margin-bottom: 12px;
	}
	#right{
		z-index: 101;
		right: 9%;
		bottom: 0;
		position: fixed;
		width: 60px;
		height:160px;
		text-align:center;
		margin: 0;margin-right: 0px;
		padding: 0;
		
	}
	.page_left{
		width:60px;
		height:80px;
		list-style:none;
		text-align:center;
		line-height:80px;
		margin:-10px 0 0 -40px;
		border:1px solid #C0C0C0;
	}
	.page_left a{
		text-decoration:none;
		color:#a6a6a6;
	}
	.page_left a:hover{
		color:#be2c23;
	}
	.page_li{
		width:60px;
		height:80px;
		list-style:none;
		text-align:center;
		line-height:80px;
		margin:-10px 0 0 -40px;
		border:1px solid #C0C0C0;
	}
	.page_li a{
		text-decoration:none;
		color:#a6a6a6;
	}
	.page_li a:hover{
		color:#be2c23;
	}
	
</style>
</html>