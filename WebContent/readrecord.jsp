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
<!--  
<script type="text/javascript" src="js/jquery3.4.1.js"></script>
<script type="text/javascript">
-->
<script type="text/javascript" src="css/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="css/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="css/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
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
<title>查看阅读记录</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	    <section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 查看阅读记录 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
		<div class="pd-20 text-c">
			<div class="text-c">
			    <form action="<%=basepath %>Managerservlet?option=readrecord" method="post">
				<input type="text" name="user_id" id="" placeholder="请输入id" style="width:250px" class="input-text" onkeyup="fun1()"/>
				<button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索 </button>
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
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort">
					<thead>
					<tr class="text-c">
							<th width="100">用户ID</th>
							<th width="100">图书ID</th>
							<th width="100">章节ID</th>
							<th width="150">阅读时间</th>
					</tr>
					</thead>
					    <tbody>
					  
					  <% 
                         if(option.equals("allreadrecord"))
                         {
                          
                         %>
                       <%
                          List<Read> alllist= (List)request.getAttribute("alllist");
                          for(Read read:alllist)
                          {
                       %>
                              
                              <tr class="text-c">
                              <td><%=read.getUser().getId()%></td>
                        	  <td><%=read.getChapter().getBook().getId() %></td>
                        	  <td><%=read.getChapter().getId()%></td>
                        	  <td><%=read.getTime() %></td>
                        	  </tr>
                        	  
                       <% 
                          }
                       %>
                         <% 
                          }
                       %>
                       
                       
                        <% 
                         if(option.equals("readrecord"))
                         {
                          
                         %>
                       <%
                          List<Read> list= (List)request.getAttribute("list");
                          for(Read read:list)
                          {
                       %>
                              
                              <tr class="text-c">
                              <td><%=read.getUser().getId()%></td>
                        	  <td><%=read.getChapter().getBook().getId() %></td>
                        	  <td><%=read.getChapter().getId()%></td>
                        	  <td><%=read.getTime() %></td>
                        	  </tr>
                        	 
                       <% 
                          }
                       %>
                         <% 
                          }
                       %>
					
					</tbody>
			    </table>
		</div>

</section>

</body>
</html>