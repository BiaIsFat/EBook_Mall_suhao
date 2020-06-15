<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="css/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="css/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="css/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,4]}// 制定列不参与排序
	]
});
</script>
<base=href="<%=basepath%>">
<meta charset="UTF-8">
<title>下架图书</title>
</head>
<body>


<jsp:include page="index.jsp"></jsp:include>
	    <section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 图书管理 <span class="c-gray en">&gt;</span> 下架图书 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
		<div class="pd-20 text-c">
			<div class="text-c">
				<input type="text" name="" id="" placeholder="请输入图书id" style="width:250px" class="input-text">
				<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量下架</a></span></div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort">
					<thead>
					<tr class="text-c">
					        <th width="25"><input type="checkbox" name="" value=""></th>
							<th width="100">图书ID</th>
							<th width="100">作者ID</th>
							<th width="100">图书名称</th>
							<th width="150">图书简介</th>
							<th width="80">图书类型</th>
							<th width="100">上架时间</th>
							<th width="50">图书状态</th>
					</tr>
					</thead> 
					<tbody>
                            <!--  把循环输出的内容放到这就行了
                            <tr class="text-c">
                            <td><input type="checkbox" name="" value=""></td>
                            <td>            </td>
                            <td>            </td>
                            <td>            </td>
                            <td class="f-14 td-manage"><a style="text-decoration:none" onClick="article_stop(this,'10001')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>
                            </tr>
                            -->
                    </tbody>
			    </table>
		</div>

</section>
</body>
</html>