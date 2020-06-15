<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(function(){
		var list=$(".li_t a");
		var currentlink=${requestScope.currentlink};
		for(var i=0;i<list.length;i++){
			if(list[i].getAttribute("id")==currentlink){
				var current_a=list[i];
				current_a.style.cssText = "color:#0066FF";
				break;
			}
		}
		$(document).scroll(function() {
	        var scroH = $(document).scrollTop();  //滚动高度 
	        if(scroH >65){  //距离顶部大于100px时
	 			$("#head").css("box-shadow","0 1px 0 0 #D0D0D0");
	        }else{
	        	$("#head").css("box-shadow","0 1px 0 0 white");
	        }
	        
	       // if (contentH = (scroH + viewH)){  //滚动条滑到底部啦
	             
	       // }  
	 
	    });
	})
</script>
<body>
	<div style="width:1340px; height:200px;background:white;">
		<div id="head">
			<div id="brand">
				<img src="images/author_b.jpg" style="width:35px;height:35px; position:absolute;margin:15px 0 0 0"/>
				<p style="position:absolute;margin:15px 0 0 40px;font-size:25px">作家专区</p>
			</div>
		</div>
		<div id="allbody">
			<div id="left_tool">
				<ul>
					<li class="li_t"><a id="1"href="my_authorservlet?currentlink=1">我的首页</a></li>
					<li class="li_t"><a id="2"href="bookmanagerservlet?currentlink=2">作品管理</a></li>
					<li class="li_t"><a id="3"href="author_messageservlet?currentlink=3">消息记录</a></li>
					<li class="li_t"><a id="4"href="author_rewardservlet?currentlink=4">收入管理</a></li>
				</ul>
			</div>
			
		</div>
	
	</div>
	<style type="text/css">
		#head{
			width:1030px;
			height:68px;
			background-color:white;
			top:0;
			left:160px;
			position:fixed;
			z-index: 100;
			
		}
		#brand{
			width:20opx;
			height:68px;
			margin:10px 0 0 0;
			
		}
		#allbody{
			width:1030px;
			height:800px;
			position:relative;
			z-index: 50;
			margin:50px 0 0 160px;
			
		}
		#left_tool{
			text-align:center;
			width:130px;
			height:200px;
			background-color:white;
			margin:25px 0 0 0;
			position:fixed;
			z-index: 51;
		
		}
		.li_t{
			background-color:white;
			width:180px;
			height:50px;
			list-style:none;
			text-align:left;
			margin:0px 20px 0px -40px;
		}
		a{
			width:130px;
			line-height:50px;
			color:#A0A0A0;
			line_height:80px;
		}
		a:link{
		
			text-decoration:none
		}
		a:hover{
		
			color:#0066FF;
			
		}
		
	</style>
</body>
</html>