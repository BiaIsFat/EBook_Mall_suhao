<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
                <!-- 360安全游览器使用webkit极速核 -->
    <meta name="renderer" content="webkit"/>
    <!-- IE使用它支持的最高模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="小说阅读,精彩小说尽在创世小说.创世小说提供玄幻小说,武侠小说,原创小说,网游小说,都市小说,言情小说,职场小说,历史小说,军事小说,网游小说,科幻小说,恐怖小说,首发小说最新章节免费小说阅读小说下载txt,精彩尽在创世小说!2013年热门小说:无敌唤灵,无红色权力,无限曙光,余罪,兵临天下,盛唐风月,武帝,大官人,勇闯天涯,机甲天王"/>
    <meta name="keywords" content="小说,小说网,言情小说,职场小说,玄幻小说,武侠小说,都市小说,历史小说,网络小说,小说下载,小说txt,小说全文阅读,原创网络文学"/>
    <link rel="shortcut icon" type="image/x-icon" href="https://img1.write.qq.com/writer/p1/contentv2/aa_ico.ico"/>
    <title>作品管理</title>
    <link rel="stylesheet" type="text/css" href="https://sta1.write.qq.com/writer/1219190341/css/merge/contentv2_base.css" /><script type="text/javascript" src="https://sta1.write.qq.com/writer/1219190341/js/merge/contentv2_base.js"></script>    <!-- prevent dom xss -->
    <script type="text/javascript" src="https://js.aq.qq.com/js/aq_common.js"></script>
<meta name="__hash__" content="d15e80a100ccf3f87bc9f6fa960f333b_b91e60e1d6d19bf8878acf773ae0b223" /></head>
<body>
<div id="warnTipBox" class="warningWrap" style="display:none;">
    <div class="pageCenter">
      <p><span class="icon alert"></span><span id="warnTip"></span></p>
      <a id="warnTipCloseBtn" class="icon close" href="javascript:" title="关闭"></a></div>
</div>
    <div class="mainWrap pageCenter cf">       
        <div id="leftNav" class="mainLeft fl" style="visibility: hidden;">
            <div class="sideBar" id="main-bar">
                  <ul>
                      <li >
                        <a href="/portal/dashboard"><span class="home"></span>专区首页</a>
                      </li>
                    <li class="act">
                        <a href="/portal/dashboard/books"><span class="works"></span>作品管理</a>
                    </li>                                 
                     </ul>
            </div>
        </div>
        
<link rel="stylesheet" type="text/css" href="https://sta1.write.qq.com/writer/1219190341/css/merge/contentv2_book_manage.css" /><link rel="stylesheet" type="text/css" href="https://sta1.write.qq.com/writer/1219190341/css/merge/contentv2_timing_plugin.css" />
<div class="mainRight pb0 fl">
    <div class="crumbsWrap">
        <b></b>
        <i class="before"><a href="/booknovels/novels.html"><span>作品管理</span></a></i>
        <em class="diff"></em>
        <i class="current"><span>作品创建</span></i> 
    </div>
    <div id="success_title"><center><h1>章节创建</h1></center></div>
    <div id="success_body">
    	<h3>章节创建成功</h3>
    	<p>注意：严禁上传任何情色、低俗、涉政等违法违规内容。一旦查实，视情节严重程度全书屏蔽整改起步并取消福利，直至报警处理。</p>
   		<center class="stepbut">
   			<a href="addchapter.jsp" class="_button">继续上传章节</a>
   		</center>
    </div>
    
    
</div>
  
 <script type="text/javascript">
	document.form1.action="AuthorServlet?option=addBook";
	document.form1.submit();
	return true;
</script>         
<script src="https://qidian.gtimg.com/lbf/1.0.2/LBF.js?max_age=31536000"></script>
<script type="text/javascript">
    LBF.config({
        "comboSuffix":"?v=20160101",
        // "paths":{"site":"http://127.0.0.1/zj/js"},
        "vars":{
            "theme":"https://qidian.gtimg.com/lbf/1.0.2/ui/theme/default"
        },
        "combo":false,
        "debug":false
    });
</script>
<script type="text/javascript" src=https://sta1.write.qq.com/writer/1219190341/js/build/tinymce/tinymce.min.js>;</script><script type="text/javascript" src="https://sta1.write.qq.com/writer/1219190341/js/merge/contentv2_chapterJp.js"></script><script type="text/javascript" src="https://sta1.write.qq.com/writer/1219190341/js/merge/contentv2_chapterDrafts.js"></script><script type="text/javascript">
    $(function () {
            _tinymce = tinymce;
        var bookId = "15719740505510604",
            isVipNovel = "-1",
            newVolumeName = "",
            chapterTmpUrl = "/booknovels/chaptertmp/CBID/15719740505510604.html",
            isGuide = 1,
            isGuideChapter = "1", //1显示  0隐藏
            isCreateChapter = "1", //1写新章节  0默认显示最新一章章节
            fineLayoutType = "-1";

            var imgSrc = "https://img1.write.qq.com";
            CS.page.tinymce.create_chapter.init(bookId,imgSrc);
        //分卷组件
        CS.page.bookManage.volume.init(bookId, isVipNovel, newVolumeName);
        //草稿页
        CS.page.bookManage.chapterDraft.init(bookId, isGuide, isGuideChapter, isCreateChapter, chapterTmpUrl,_tinymce,fineLayoutType);
       //角色
        CS.page.bookManage.roleMange.init(bookId);//角色管理
    });
</script>
    </div>
<script type="text/javascript" src="https://sta1.write.qq.com/writer/1219190341/js/merge/contentv2_help_connectkefu.js"></script>
<form  name="myfrom" id="toucao_myform" method="post" action="https://support.qq.com/product/1924" target="_blank">
    <input type="hidden" name="nickname" value="作者名称">
    <input type="hidden" name="avatar" value="https://ccstatic-1252317822.file.myqcloud.com/writer/p1/contentv2/photo_default.png">
    <input type="hidden" name="openid" value="15719726104436301">
<input type="hidden" name="__hash__" value="d15e80a100ccf3f87bc9f6fa960f333b_b91e60e1d6d19bf8878acf773ae0b223" /></form>

<script type="text/javascript" src="https://sta1.write.qq.com/writer/1219190341/js/merge/contentv2_layout.js"></script><script type="text/javascript">
    $(function(){
        var systemTip = "";        
        //模板页
        CS.page.layout.main.init(systemTip);
        
        //被其他站点以iframe方式嵌入后的处理
        CS.embed.init();
    });
</script>

</body>
<script type="text/javascript">
	function fun1(){
		document.form1.action="AuthorServlet?option=addBook";
		document.form1.submit();
	}
	
	
</script>
<style type="text/css">
	#success_title{
		border-bottom: 1px solid #D4EBD0;
		height: 70px;
		font: 16px/70px "PingFangSC-Regular", "HelveticaNeue-Light", "Helvetica Neue Light", "Microsoft YaHei", "sans-serif";
		text-align: center;
		color:#BFDEAB;
		background-color:#F4FFF2;
		border-top: 1px solid #D4EBD0;
		margin-top: -1px;
		
	}
	#success_body{
		width: 450px;
		margin: 100px auto 0;
		padding-left: 0;
		font: 16px/70px "PingFangSC-Regular", "HelveticaNeue-Light", "Helvetica Neue Light", "Microsoft YaHei", "sans-serif";
	    font-size: 16px;
		text-align: center;
		color:
		#BFDEAB;
	}
	#success_body h3{
		font-size:30px;
	}
	#success_body p{
		color:red;
		font-weight: bold;
		width: 394px;
		margin: 0 auto;
		text-align: center;
	}
	
	._button{
		display: inline-block;
		width: 180px;
		height: 36px;
		margin: 0 10px;
		font: 14px/36px "PingFangSC-Regular", "HelveticaNeue-Light", "Helvetica Neue Light", "Microsoft YaHei", "sans-serif";
		position: relative;
		border: 1px solid
		#1FA9FF;
		border-radius: 2px;
		text-align: center;
		color:
		#FFF;
		background:
		#1FA9FF;
		outline: none;
		text-decoration: none;
		color: #333;
		transition: background .3s, color .3s;
	}
</style>
</html>
