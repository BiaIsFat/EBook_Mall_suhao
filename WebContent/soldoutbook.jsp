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
<title>下架图书审核</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	    <section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 图书管理 <span class="c-gray en">&gt;</span> 下架图书 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
		<div class="pd-20 text-c">
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort">
					<thead>
					<tr class="text-c">
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
							<th width="100">图书ID</th>
							<th width="100">用户ID</th>
							<th width="100">图书名称</th>
							<th width="150">图书简介</th>
							<th width="150">图书类型</th>
							<th width="150">上架时间</th>
							<th width="150">图书状态</th>
							<th width="80">下架</th>
					</tr>
					</thead>
					    <tbody>
					  
					  <% 
                         if(option.equals("allsoldoutbook"))
                         {
                          
                         %>
                       <%
                          
                          List<Book> alllist= (List)request.getAttribute("alllist");
                          for(Book book:alllist)
                          {
                       %>
                              <tr class="text-c">
                              <td><%=book.getId()%></td>
                        	  <td><%=book.getAuthor().getId()%></td>
                        	  <td><%=book.getName()%></td>
                        	  <td><%=book.getDes()%></td>
                        	  <td><%=book.getType() %></td>
                        	  <td><%=book.getDate() %></td>
                        	  <td><%=book.getState() %></td>
                        	  <td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" onClick='window.location.href="<%=basepath%>Managerservlet?option=soldoutbook&book_id=<%=book.getId()%>"' href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a></td>
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