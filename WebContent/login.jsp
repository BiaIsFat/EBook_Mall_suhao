<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css" href="./css/login.css">
</head>
<script type="text/javascript">
	$(function(){
		$("#login_a").click(function(){
			if($("#account").val()==''){
				$("#account_div").css("border","1px solid #FF3955");
				return false;
			}
			else if($("#pass").val()==''){
				$("#pass_div").css("border","1px solid #FF3955");
				return false;
			}
			else{
				document.form1.action="UserServlet?option=login";
				document.form1.submit();
				return true;
			}
		})
		$("#account").keyup(function(){
			$("#account_div").css("border","1px solid #C0C0C0");
		})
		$("#pass").keyup(function(){
			$("#pass_div").css("border","1px solid #C0C0C0");
		})
	})
</script>
<body>
	<div id="all">
		<div id="head">
			<div id="logo_div">
				<a href="" id="logo_a"><img id="logo_img" src="./images/qd.jpg" /></a>
			</div>
		</div>
		<div id="body">
			<div id="top_body"></div>
			<div id="left_body">
				<img id="left_img" src="./images/login_img.jpg" />
			</div>
			<div id="right_body">
				<div id="login_div">
					<div id="login_head">
						<font>账号登录</font>
					</div>
					<div id="error_div">${login_error} </div>
					<form name="form1"  method="post">
					<div id="input_div">
						
							<div id="account_div">
								<img src="./images/user.gif" id="account_img" /> <input
									id="account" type="text" name="user_tel" placeholder="请输入你的账号" />
							</div>
							<div id="pass_div">
								<img src="./images/lock.gif" id="pass_img" /> <input id="pass"
									type="password" name="user_pass" placeholder="密码" />
							</div>
							<div id="confirm">
								<a href="">登入即代表通过用户服务协议</a>
							</div>
					</div>
					<a id="login_a" href="#">登录</a>
					<div id="gosignup">
						<a href="" id="forgetpass">忘记密码</a> <a id="signup"
							href="signup.jsp">去注册</a>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<style type="text/css">
		#all {
			width: 1330px;
			height: 900px;
		}
		
		#head {
			width: 1330px;
			heigth: 100px;
			border-bottom: 1px solid #C0C0C0;
		}
		
		#logo_div {
			width: 215px;
			height: 100px;
			line-height: 100px;
			margin: 0 0 0 80px;
		}
		
		#logo_a {
			width: 215px;
			height: 55px;
			margin: 22px 0 0 0;
		}
		
		#logo_img {
			width: 215px;
			height: 55px;
			margin: 22px 0 0 0;
		}
		
		#body {
			width: 1200px;
			height: 800px;
			position: relative;
			left: 80px;
		}
		
		#top_body {
			width: 1200px;
			height: 100px;
			position: absolute;
			top: 0;
		}
		
		#left_body {
			width: 720px;
			height: 400px;
			position: absolute;
			left: 0;
			top: 100px;
		}
		
		#left_img {
			width: 550px;
			height: 400px;
			margin: 0 0 0 170px;
		}
		
		#right_body {
			width: 400px;
			height: 400px;
			position: absolute;
			right: 80px;
			top: 100px;
			text-align: center;
			border: 1px solid #C0C0C0;
		}
		
		#login_div {
			width: 350px;
			height: 390px;
			text-align: center;
			margin: 0 0 0 30px;
		}
		
		#login_head {
			width: 350px;
			height: 50px;
			margin: 0 25px 0 0px;
			text-align: center;
		}
		
		font {
			font-size: 30px;
		}
		
		#error_div {
			width: 400px;
			height: 30px;
			margin:0 0 0 -25px;
		}
		
		#input_div {
			width: 350px;
			height: 120px;
			position: relative;
		}
		
		#account_div {
			width: 350px;
			height: 45px;
			position: absolute;
			border: 1px solid #C0C0C0;
		}
		
		#account_img {
			width: 20px;
			height: 20px;
			position: absolute;
			margin: 5px 0 0 -10px;
			top: 5px;
		}
		
		#pass_div {
			width: 350px;
			height: 45px;
			position: absolute;
			margin: 60px 0 0 0;
			border: 1px solid #C0C0C0;
		}
		
		#pass_img {
			width: 20px;
			height: 20px;
			position: absolute;
			margin: 10px 0 0 -10px;
		}
		
		#account {
			width: 280px;
			height: 40px;
			border: 0;
			margin: 0 0px 0 20px;
		}
		
		#pass {
			width: 280px;
			height: 40px;
			margin: 0 0px 0 20px;
			border: 0;
		}
		
		#login_a {
			text-decoration: none;
			/* 			display:inline-block;  */
			width: 300px;
			height: 30px;
			border: 1px solid #c00;
			color: white;
			background: #BF2C24;
			border-radius: 3px;
			text-align: center;
			line-height: 30px;
			float: left;
			position: relative;
			margin: 30px 0 0 25px;
		}
		
		#login_a:hover {
			background-color: #C00000;
		}
		
		#confirm {
			width: 300px;
			heigth: 15px;
			align-text: center;
			position: absolute;
			top: 120px;
			left: 20px;
		}
		
		#confirm a {
			text-decoration: none;
			color: black;
		}
		
		#confirm a:hover {
			color: #BF2C24;
		}
		
		#gosignup {
			width: 300px;
			height: 20px;
			text-align: center;
			margin: 0 0 0 20px;
		}
		
		#gosignup a {
			text-decoration: none;
			color: black;
		}
		
		#gosignup a:hover {
			color: #BF2C24;
		}
		
		#signup {
			margin: 0 0 0 100px;
		}
</style>
</body>
</html>