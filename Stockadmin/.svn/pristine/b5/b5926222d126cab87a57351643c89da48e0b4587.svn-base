<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Staff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%@ include file="include.jsp" %>	


  </head>
  
  <body>
	<form  class="form-horizontal dataform"  id="form" action="staff/add.do" method="post" >
		staffNumber<input name="staffNumber">  <br>
		staffName<input name="staffName"><br>
	staffGender	<input name="staffGender"><br>
		staffPhone<input name="staffPhone"><br>
	staffEmail	<input name="staffEmail"><br>
     staffQq <input name="staffQq"><br>
     staffBirthday<input name="staffBirthday" class="datetime" data-date-format="yyyy-mm-dd" ><br>
   
     
	</form>
	
     <button onclick="formajax()" >测试</button>
	
	
	<div></div>  
	<table  id="table">
	
	</table>

	
	
</body>
<script type="text/javascript">

$(function($){
	 
	$(".datetime").each(function (i){
		
		$(this).datetimepicker({language: 'zh-CN',
		        weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0});
		
	})
	
	
})



  function formajax(){
	  $("#form").ajaxForm({dataType:"json",success:function (data){
		
		  
		 var table=  $("#table");
		  
		 var tem="";
		 
		  for(var i=0;i<data.length;i++){
			  
			  
			  tem+=" <tr> <td>"+data[i].staffId+"</td>"+
			  "<td>"+data[i].staffNumber+"</td>"+
			  "<td>"+data[i].staffName+"</td> "+
			  "<td>"+data[i].staffGender+"</td>"+
			  " <td>"+data[i].staffPhone+"</td>"+
			  " <td>"+data[i].staffEmail+"</td>"+
			  " <td>"+data[i].staffQq+"</td>"+
			  " <td>"+data[i].staffBirthday+"</td>"+
			  "</tr>";
			  
		  }
		  
		  table.empty();
		  
		  table.append(tem);
		  
	  }
      }).submit();
	  
	  
  }


 function ajaxsubmit(){
	 
	 var inputs= $("input");
	 
	 var data={};
	 	for(var i=0;i<inputs.length;i++){
	 		
	 		var name=inputs[i].name;
	 		var value=inputs[i].value;
	 		
	 		data[name]=value;
	 	
	 	}
	 
alert(data);
	 	
	 $.ajax({ url: "staff/add.do",
		 data :data,
		 dataType:"json",
		 type:"post",
		 success: function(data){
			 
			 
			 alert(data);
		
		}});
	 
	
 }
 
 function find(){

	 
	  alert("1111");
	 
	 var inputs= $("input");
	 
/* 
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].name=="staffEmail"){
			alert(inputs[i].value);
		}
	} */
 
 
	 var input= inputs.eq(4);
	
	alert("1 "+ input.val());
	
	alert("2 "+ input[0].value);
	
	
	input =	$("input[name='staffEmail']");
	
	alert("3 "+ input.val());
	
 }
 

</script>



</html>
