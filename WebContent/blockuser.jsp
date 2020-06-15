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
<title>拉黑用户</title>
</head>
<body>


<jsp:include page="index.jsp"></jsp:include>
	    <section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户管理 <span class="c-gray en">&gt;</span> 拉黑用户 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
		<div class="pd-20 text-c">
			<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量拉黑</a></span></div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort">
					<thead>
					<tr class="text-c">
					        <th width="25"><input type="checkbox" name="" value=""></th>
							<th width="200">用户ID</th>
							<th width="250">用户姓名</th>
							<th width="200">用户密码</th>
							<th width="80">用户电话</th>
							<th width="80">用户地址</th>
							<th width="80">用户余额</th>
							<th width="80">用户VIP</th>
							<th width="80">拉黑操作</th>
					</tr>
					</thead> 
					<tbody>
                            
                          	<% 
                         if(option.equals("allillegaluser"))
                         {
                          
                         %>
                       <%
                          List<User> alllist= (List)request.getAttribute("alllist");
                          for(User user:alllist)
                          {
                       %>
                              
                              <tr class="text-c">
                              <td><input type="checkbox" name="" value=""></td>
                              <td><%=user.getId()%></td>
                        	  <td><%=user.getName()%></td>
                        	  <td><%=user.getPass() %></td>
                        	  <td><%=user.getTel() %></td>
                        	  <td><%=user.getAddr() %></td>
                        	  <td><%=user.getBalan() %></td>
                        	  <td><%=user.getIsVip() %></td>
                        	  <td class="f-14 td-manage">
							  <a style="text-decoration:none" class="ml-5" onClick='window.location.href="<%=basepath%>Managerservlet?option=excuteuser&user_id=<%=user.getId()%>"' href="javascript:;" title="拉黑"><i class="Hui-iconfont">&#xe6df;</i></a>
							  <a style="text-decoration:none" class="ml-5" onClick='window.location.href="<%=basepath%>Managerservlet?option=privateletteruser&user_id=<%=user.getId()%>"' href="javascript:;" title="私信"><i class="Hui-iconfont">&#xe6de;</i></a></td>
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
        </div>
</section>
</body>
</html>