<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <script type="text/javascript" src="./js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript">
   $(document).ready(function () {        
       $("#btn").click(function (){
    $.ajax({
      url:"Stockselect/test3.do",
      method:"get",
      dataType: "json",
     success:function(data){
    
     
     alert(data.sindex[2].nowpri);  //获取后台list
   
    
},

 error: function () { alert("error"); }


});

})})
  </script>
    <input id="btn" type="button" value="查询"/>
  </body>
</html>
