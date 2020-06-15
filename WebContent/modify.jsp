<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,dao.*,javabean.*"%>
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
/*系统-栏目-添加*/
function system_category_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*系统-栏目-编辑*/
function system_category_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*系统-栏目-删除*/
function system_category_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
$(function(){
	function fun1()
	{
		var flag=$("input[name='id']").val();
		if (!(/(^[1-9]\d*$)/.test(flag)))
			{
			 $(":submit:first").prop("disabled",true);
			}
		else if(flag==""){
			$(":submit:first").prop("disabled",true);
		}
		else{
			 $(":submit:first").prop("disabled",false);
			}	
	}
})


$('.table-sort').dataTable({
	"aaSorting": [[ 0, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[1,2,3,4]}// 制定列不参与排序
	]
});
</script>
<base=href="<%=basepath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span>
		公告管理
		<span class="c-gray en">&gt;</span>
		公告
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
		<div class="Hui-article">
		<article class="cl pd-20">
		<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="25">
							<th width="100">公告ID</th>
							<th width="200">公告内容</th>
							<th width="100">公告时间</th>
							<th width="80">操作</th>
						</tr>
					</thead>
					<tbody>           
                             <%
                                String board_id=request.getParameter("board_id");
                                String board_context=request.getParameter("board_context");
                                String board_time=request.getParameter("board_time");
                             %>
                              <form action="<%=basepath %>Managerservlet?option=modifyboard" method="post"> 
                              <tr class="text-c">
                              <td>
                              <td><input type ="tetx" name="board_id" value="<%=board_id%>" readonly/></td>
                        	  <td><input type ="tetx" name="context" value="<%=board_context%>"/></td>
                        	  <td><input type ="tetx" name="board_time" value="<%=board_time %>" disabled/></td>
                        	  <td><button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 修改公告</button></td>
							  </td>
                        	  </tr>
                        	  </form>
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>	
</body>
</html>