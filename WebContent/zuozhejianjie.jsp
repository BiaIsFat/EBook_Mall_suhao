<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>的主页</title>
    <link rel="icon" type="image/x-icon" href="//qidian.gtimg.com/qdp/img/favicon.c443c.ico">
    
<link rel="stylesheet" data-ignore="true" href="//qidian.gtimg.com/c/=/qdp/iconfont/symbols.105e2.css,/qdp/css/common.e2d8e.css,/qdp/css/mainHeader.4b741.css,/qdp/css/authorHome/index.704f1.css,/qdp/icon/common/sprite.5ece2.css,/qdp/font/index.6b94b.css" />

    <script>document.domain ='qidian.com';</script>
    <script>var speedTimer = [], speedZero = new Date().getTime();</script>
</head>
<body class="author">
		<div class="personal-mheader">
        <div class="mheader-wrapper">
            <ul class="mheader-nav fr">
                <li class="mheader-nav-li line"></li>
                <li class="mheader-nav-li">
                    <a href="/bookcase" class="mheader-nav-a mheader-shelf-a"><i class="iconfont icon-book"
                    ></i>我的书架</a>
                </li>
            </ul>
        </div>
    </div>
        <div class="">
    <div class="author-header" data-l1="2">
        <div class="author-header-wrapper">
            
            <div class="header-msg">
                
                <a href="/user/224803800" class="header-msg-tosingle" target="_blank">个人主页</a>
                
                <h3>这里输出作者名称<a class="header-msg-level icon icon-god-5" href="/author/light/9006388" title="level5" target="_blank">level2</a></h3>
                <div class="header-msg-desc"></div>
                <div class="header-msg-data">
                <span class="mr12">输出作品总数<strong class="header-msg-strong"></strong></span>
                <span class="ml12 mr12">这里输出作者简介，如果没有输出这个作者有点<strong class="header-msg-strong"></strong></span>
                <span class="ml12 mr12"><strong class="header-msg-strong"></strong></div></span>
            </div>
        </div>
    </div>
    <div class="author-content-wrapper" data-l1="2">
       
        <div class="author-content">
            <h2 class="author-title">火热连载</h2>
            <ul class="author-hot" data-l2="9">   
            </ul>
            <h2 class="author-title">全部作品(3)</h2>
            <ul class="author-work" data-l2="9">
                <li class="author-work-line"></li>          
            </ul>
        </div>
        <div class="go-top dn">
            <div class="go-top-wrap">
                <a href="#" class="icon-go-top bTips" title="返回顶部" ><i class="iconfont icon-backtop"></i></a>
            </div>
        </div>
    </div>
        </div>
</body>
</html>