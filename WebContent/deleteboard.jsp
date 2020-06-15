<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,dao.*,javabean.*"%>
    <%
    String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    %>
<!DOCTYPE html>
<html>
<head>
<%
   String option=(String)request.getAttribute("option");
   String m=(String)request.getAttribute("m");
%>
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
		<div class="text-c">
		        <form action="<%=basepath %>Managerservlet?option=searchboard" method="post">
                <input type="text" name="board_id" id="" placeholder=" 公告id" style="width:250px" class="input-text">
				<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查找公告</button>
				 <% 
                     if(m!=null)
                     {
                   %>
                     <div style="color:#F00">
                     <%out.print(m);%>
                     </div>
                     <%  	 
                     }
                     %>  
               </form> 
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
				<a class="btn btn-primary radius" onclick="system_category_add('添加资讯','addboard.jsp')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加公告</a></span>
				</div>
				</span>
		</div>
		<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="25">
							<input type="checkbox" name="" value=""></th>
							<th width="80">公告ID</th>
							<th width="120">公告内容</th>
							<th width="75">公告时间</th>
							<th width="120">操作</th>
						</tr>
					</thead>
					<tbody>           
                        <% 
                         if(option.equals("searchboard"))
                         {
                          
                         %>
                       <%
                              Board board=(Board)request.getAttribute("board");
                       %>
                              
                              <tr class="text-c">
                              <td><input type="checkbox" name="" value=""></td>
                              <td><%=board.getId()%></td>
                        	  <td><%=board.getContext()%></td>
                        	  <td><%=board.getDate() %></td>
                        	  <td class="f-14 td-manage">
							  <a style="text-decoration:none" class="ml-5" onClick='window.location.href="<%=basepath%>delete.jsp?option=modifyboard&board_id=<%=board.getId()%>&board_context=<%=board.getContext()%>&board_time=<%=board.getDate() %>"' href="javascript:;" title="修改"><i class="Hui-iconfont">&#xe6df;</i></a>
							  </td>
                        	  </tr>
                        	 
                      
                         <% 
                          }
                       %>
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>	
</body>
</html>