<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
                <!-- 360安全游览器使用webkit极速核 -->
    <meta name="renderer" content="webkit"/>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
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
<script type="text/javascript">
		function fun2(){
			document.getElementById("_type").value="vip";
		}
		function fun1(){
			document.form1.action="AuthorServlet?option=addChapter";
			document.form1.submit();
			return true;
		};
	
	
	

</script>
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
                      <!-- 跳转到作家主界面 -->
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
        <i class="current"><span>作品名称</span></i> 
    </div>
    
         <div class="msgBoxTitle">
        <a class="create button" href="/booknovels/chaptertmp/CBID/15719740505510604/addType/1.html"><em class="icon"></em>新建章节</a>
        
                <div class="tabSwitch cf">
            <span class="[bookmodify]"><a href="./workmodify.jsp">作品设置</a></span>
            <span class="act"><a href="">工作台</a></span>
            <span class="[chaptermanage]" id="numero2"><a href="/booknovels/chaptermanage/CBID/15719740505510604.html">已发布章节</a></span>                                                
        </div>
    </div>
    <div class="managerWrap cf">
        <div class="mLeftList fl">
            <div id="draftListWrap" class="leftListWrap">
                <div class="titleBox">
                    <p>共 0 章</p>
                </div>
                <div class="sectionManage">
                    <div class="sectionList" id="sectionList">
                        <!-- 草稿列表 -->
                        <ul id="draftList">
                                                    </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="mRightContent fl">
            <!-- 编辑草稿 start -->
            <div id="editDraftBox" class="midWrap editWrap hidden">
                    <div class="sectionViewWrap">
                    <form name="form1" method="post">
                        <div id="draftBtnBox" class="sectionBtnBox cf">
                            <div class="titleBtn fr">
                                <a id="deleteDraftBtn" class="button white" href="javascript:">删除</a>
                                
                                <a id="saveDraftBtn" class="button white" href="javascript:">保存</a>
                                <a href="#" id="sub_button" onclick="fun1()"><span class="icon "></span>发布</a></div>
                            
                            <!-- end 模拟下拉组件-->
                            <!--原来卷选择框-->
                            <!--<select id="volumeSelect" name="CVIDSelect">-->
                                <!---->
                                        <!--<option data-vipflag="-1" value="42197357429235231">第一卷-->
                                        <!--</option>-->
                                <!---->
                                        <!--<option data-vipflag="-1" value="42197357429235222">作品相关-->
                                        <!--</option>-->
                                <!---->
                            <!--</select>-->
                            <em class="c999">章节类型：</em>
                            <!-- start 章节类型模拟下拉组件-->
                            
                            <div id="chapterTypeBox" class="select-wrap min">
                                <div data-node="selectedItemBox" class="drop-down">
                                    <!-- 选中项 -->
                                    <span id="selectedChapterType" data-node="selectedItem" data-chaptertype=""></span>
                                    <b class="combo-arrow"></b>
                                </div>
                                <div data-node="listBox" class="drop-list-box hidden">
                                    <ul>
                                        <li><a data-chaptertype="-1" href="javascript:">公众章节</a></li>
                                        <li><a data-chaptertype="1" onclick="fun2()" href="javascript:">收费章节</a></li>
                                        
                                    </ul>
                                </div>
                            </div>
                            <!-- end 模拟下拉组件-->
                            <!--原来章节类型选择框-->
                            <!--<select id="chapterTypeSelect" name="chapterTypeSelect">VIP章节-->
                                <!--&lt;!&ndash;vip卷才有一下选择&ndash;&gt;-->
                                <!---->
                                <!--<option value="-1">公众章节</option>-->
                            <!--</select>-->
                        </div>
                         <div class="important-note">
                                <p style="color:red;font-weight:bold;">注意：严禁上传任何情色、低俗、涉政等违法违规内容。一旦查实，视情节严重程度全书屏蔽整改起步并取消福利，直至报警处理。</p>
                            </div>
                        <div id="sectionEdit" class="zwText">
                        	
                            <input id="chapterTitleInput" name="chapter_name" type="text" data-default="此处输入章节号与章节名。示例：“第十章 天降奇缘”"/>
                            <textarea name="chapter_context" id="chapterContentInput" data-default="请输入正文。"></textarea>
                            <input id="_type" type="hidden" name="chapter_type" value="normal">
                            <div class="tinyMCE-wrap" style="display: none;">
                                    <textarea id="textMce">
                                    </textarea>
                                    
                                    
                            </div>
                            </form>
                        </div>
                        <div class="say-area">
                            <p>
                                <textarea id="authorSpeakInput" name="chapterextra" value="" data-default="作者的话（此段不计入字数）"></textarea>
                            </p>
                        </div>
                    </div>
                <input type="hidden" name="__hash__" value="d15e80a100ccf3f87bc9f6fa960f333b_b91e60e1d6d19bf8878acf773ae0b223" /></form>
            </div>
            <!-- 编辑草稿 end -->
        </div>
    </div>
</div>
<img id="previewImg" src="" width="0" height="0" style="position: absolute;">
<!-- start 隐藏的上传图片按钮 cgi是后台php地址 -->
<form class="img-upload-form" action="" method="post" enctype="multipart/form-data">
    <input type="file" id="imgUpload" name="picture" class="clip" accept="image/jpg,image/jpeg,image/png" style="display: none;">
<input type="hidden" name="__hash__" value="d15e80a100ccf3f87bc9f6fa960f333b_b91e60e1d6d19bf8878acf773ae0b223" /></form>
<!-- end 隐藏的上传图片按钮 -->
<!-- 定时发布浮层 -->

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
</html>