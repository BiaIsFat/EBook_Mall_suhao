<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(function(){
		$("#signup_a").click(function(){
			if($("#tel").val()==''){
				$("#tel").css("border","1px solid #FF3955");
				$("#tel_error p").text("电话号码为空")
				return false;
			}
			else if($("#pass").val()==''){
				$("#pass").css("border","1px solid #FF3955");
				$("#pass_error p").text("密码为空")
				return false;
			}
			else if($("#confirm_pass").val()==''){
				$("#confirm_pass").css("border","1px solid #FF3955");
				$("#confirm_pass_error p").text("确认密码为空")
				return false;
			}
			if($("#pass").val()!=$("#confirm_pass").val()){
				$("#confirm_pass").css("border","1px solid #FF3955");
				$("#confirm_pass_error p").text("两个密码不一致");
				return false;		
			}else{
				document.form1.action="UserServlet?option=signUp";
				document.form1.submit();
			}
			
		})
		$("#tel").focus(function(){
			$("#tel").css("border","1px solid #C0C0C0");
			$("#tel_error p").text("");
		})
		$("#pass").focus(function(){
			$("#pass").css("border","1px solid #C0C0C0");
			$("#pass_error p").text("");
		})
		$("#confirm_pass").focus(function(){
			$("#confirm_pass").css("border","1px solid #C0C0C0");
			$("#confirm_pass_error p").text("");
		})
		$("#checkbox").click(function(){
			if($("#checkbox").prop("checked")==true){
				$("#signup_a").attr("disabled",true);		
			}else{
				$("#signup_a").attr("disabled",false);
			}
		})
	})
</script>
<body>
	<div id="all">
		<div id="head">
			<div id="logo_div">
				<a href="" id="logo_a"><img id="logo_img" src="./images/qd.jpg" /></a>
			</div>
			<div id="signup_title">
				<span id="signup_sapn">用户注册</span>
			</div>
		</div>
		<div id="body">
			<div id="option_info">
				<div id="signup_head">注册信息</div>
			</div>
			<div id="wrap_body">
				<div id="blank_div"></div>
				<div id="right_div">
					<form name="form1" action="UserServlet?option=signUp" method="post">
						<div id="tel_div">
							<div class="_div">手机号</div>
							<div class="input_div">
								<input id="tel" type="text" name="user_tel" />
							</div>
						</div>
						<div id="tel_error">
							<p></p>
						</div>
						<div id="pass_div">
							<div class="_div">密码</div>
							<div class="input_div">
								<input id="pass" type="password" name="user_pass" />
							</div>
						</div>
						<div id="pass_error">
							<p></p>
						</div>
						<div id="confirm_pass_div">
							<div class="_div">确认密码</div>
							<div class="input_div">
								<input id="confirm_pass" type="password" />
							</div>
						</div>
						<div id="confirm_pass_error">
							<p></p>
						</div>
						<div id="agree">
							<input id="checkbox" type="checkbox" checked /><a href=""
								id="confirm">我已阅读并同意隐私协议</a>
						</div>
					<a href="UserServlet?option=signUp" id="signup_a">立即注册</a>
					</form>
				</div>
			</div>
		</div>
		<style type="text/css">
		#all {
			width: 1330px;
			height: 700px;
		}
		
		#head {
			width: 1330px;
			heigth: 100px;
			border-bottom: 1px solid #C0C0C0;
			position: relative;
		}
		
		#logo_div {
			width: 215px;
			height: 100px;
			line-height: 100px;
			float: left;
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
		
		#signup_title {
			width: 200px;
			height: 40px;
			float: left;
			margin: 35px 0 0 20px;
			border-left: 1px solid #C0C0C0;
		}
		
		#signup_sapn {
			width: 150px;
			height: 40px;
			text-align: center;
			font-size: 30px;
			margin: 0 0 0 20px;
		}
		
		#body {
			width: 1200px;
			height: 600px;
			margin: 100px 0 0 80px;
		}
		
		#option_info {
			width: 1200px;
			height: 100px;
			text-align: center;
			position: relative;
			border-bottom: 1px solid #C0C0C0;
		}
		
		#signup_head {
			width: 150px;
			heigth: 40px;
			bottom: 0px;
			position: absolute;
			left: 40%;
			border-bottom: 3px solid #BF2C24;
			padding-bottom: 5px;
			font-size: 20px;
		}
		
		#wrap_body {
			width: 1200px;
			height: 500px;
			position: relative;
		}
		
		#blank_div {
			position: absolute;
			width: 350px;
			height: 500px;
			left: 0;
			top: 35px;
			float: left;
		}
		
		#right_div {
			width: 800px;
			height: 500px;
			position: absolute;
			left: 350px;
			top: 35px;
			float: left;
		}
		
		#tel_div {
			width: 380px;
			height: 43px;
		}
		
		#tel {
			width: 300px;
			height: 37px;
			border: 1px solid #C0C0C0;
		}
		
		#pass_div {
			width: 380px;
			height: 43px;
		}
		
		#pass {
			width: 300px;
			height: 37px;
			border: 1px solid #C0C0C0;
		}
		
		#confirm_pass_div {
			width: 380px;
			height: 43px;
		}
		
		#confirm_pass {
			width: 300px;
			height: 37px;
			border: 1px solid #C0C0C0;
		}
		
		#tel_error {
			width: 300px;
			height: 30px;
		}
		
		#pass_error {
			width: 300px;
			height: 30px;
		}
		
		#confirm_pass_error {
			width: 300px;
			height: 30px;
		}
		
		p {
			text-align: center;
			color: red;
		}
		
		#agree {
			width: 380px;
			height: 17px;
			text-align: center;
		}
		
		#signup_a {
			text-decoration: none;
			/* 			display:inline-block;  */
			width: 300px;
			height: 35px;
			border: 1px solid #c00;
			color: white;
			background: #BF2C24;
			border-radius: 3px;
			text-align: center;
			line-height: 30px;
			float: left;
			position: relative;
			margin: 30px 0 0 50px;
		}
		
		._div {
			width: 60px;
			height: 43px;
			float: left;
		}
		
		.input_div {
			width: 300px;
			height: 43px;
			float: left;
		}
		
		#confirm {
			text-decoration: none;
			color: black;
		}
		
		#confirm:hover {
			color: #BF2C24;
		}
</style>
</body>
</html>