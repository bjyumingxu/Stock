<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<title>用户管理</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->

<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui/css/style.css" />
<link href="easyui-1.4.4/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link href="easyui-1.4.4/themes/icon.css" rel="stylesheet" type="text/css" /> 
<style type="text/css">
.page-container{ padding:20px}    
.breadcrumb{background-color:#f5f5f5; padding:0 20px}
@media (max-width: 767px) {
	.breadcrumb{ padding:0 15px}
}
.bg-1{ background-color:#f5fafe}
h4{line-height:30px}
.bk-gray{ border:none}
.mt-10{margin-top:5px ;height:30px ;font-size:18px;}
.mt-20{margin-top:0px ;height:30px ;font-size:20px;}
.pd-5{padding:5px}.pd-10{padding:10px}.pd-15{padding:15px}.pd-20{padding:20px}.pd-30{padding:30px}.pd-40{padding:40px}
.bk-gray{border:solid 1px #eee}
.Hui-iconfont{position:absolute;top:9px;right:10px;line-height: 20px;cursor:pointer; color:#000; opacity:0.2;_color:#666}
.btn-secondary{color:#fff;background-color:#3bb4f2; border-color:#3bb4f2}
.radius{border-radius:4px}
.text-l{text-align:left}.text-r{text-align:right}.text-c{text-align:center}
.btn-success{color:#fff;background-color:#5eb95e; border-color:#5eb95e}
.btn-warning{color:#fff;background-color:#f37b1d; border-color:#f37b1d}
.btn-primary{color:#fff;background-color:#5a98de; border-color:#5a98de}
.btn,.btn.size-M{ padding:4px 12px}
.input-text.size-MINI,.btn.size-MINI{font-size:12px; height:23px;padding:1px 2px;line-height:1.42857}/*迷你*/
.r,.f-r{float:right!important;_display:inline}
.l,.f-l{float:left!important;_display:inline}
.en{font-family:Arial!important}
.cl:after,.clearfix:after{content:"\20";display:block;height:0;clear:both;visibility:hidden}.cl,.clearfix{zoom:1}
</style>
</head>
<body class="easyui-layout ">
    <div region="north" border="true" split="true" style="overflow: hidden; height: 135px;">
        <div class="top-bg">
        
        <nav class="breadcrumb mt-10"><i class="Hui-iconfont">&#xe67f;</i> 首页 
        <span class="c-gray en">&gt;</span>  用户中心 <span class="c-gray en">&gt;</span> 用户管理 
        
        </nav>
		<div class="page-container">
	
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">
			<a href="javascript:;" onclick="user_edit()" class="btn btn-secondary radius">
			<i class="Hui-iconfont">&#xe603;</i>编辑用户</a>

			<a href="javascript:;" onclick="user_delete()" class="btn btn-warning radius">
			<i class="Hui-iconfont">&#xe6e2;</i>删除用户</a> 
			
			<a href="javascript:;"	onclick="user_add('添加用户','member-add.jsp','','510')"class="btn btn-primary radius">
			<i class="Hui-iconfont">&#xe600;</i>添加用户</a></span> 
			
			<span class="r text-c"><input type="text" class="input-text" style="width:250px ;font-size:18px" placeholder="请输入股票名称或代码...." id="" name="">
		<button type="submit" class="btn btn-success radius" style="font-size:18px" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button></span>
		</div>
</div>
        </div>
    </div>
  
    <div id="mainPanle" region="center" style="overflow: hidden;"class=" laydate_box laydate_box *  datagrid combo-p  datagrid * ">
    
       <table id="datatable" style="height:95%" >
       </table>
    
    </div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function($) {
	$('#datatable').datagrid({
				//fit:true,
				url: 'user/findalluser.do',
				fitColumns:true, //下面滚动条
				nowrap:false, //显示单个单元格全显示
				border:false, //边框
				idField:'userId', //分页记住所勾选的
				fitColumns:true,
				pagination:true,
				singleSelect:true,//是否单选 
	 	        pageSize: 5,//每页显示的记录条数，默认为10 
		        pageList: [5,10,15,20,30],//可以设置每页记录条数的列表 
	 	        rownumbers:true,//行号 
				columns:[[//多级表头 列数
					          {field: 'userId', checkbox: true},
							  {title:'用户名',field:'userName',width:80},	 
							  {title:'手机号',field:'userTel',width:80},
							  {title:'邮箱',field:'userEmail',width:100},
							  {title:'性别',field:'userSex',width:40},
							  {title:'账户状态',field:'userAccount',width:80},
							  {title:'加入时间',field:'recordDate',width:80},							  
							  {title:'备注',field:'userHobby',width:100},
						]]
			});
});
function user_delete(){
  var row=$('#datatable').datagrid('getSelected');
  alert(row.userName);
  alert(row.userId);
  
	$.ajax({
		url : "user/deletebyid.do?id="+row.userId,
		dataType : "json",
		type : "post",
		success : alert("删除成功!"),
		
	});
}
/*用户-添加*/
function user_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-编辑*/
function user_edit(){
	var row=$('#datatable').datagrid('getSelected');
		layer.open({
		type: 2,
		area: ['700px', '530px'],
		title: '编辑用户',
		fix: false, //不固定
		maxmin: true,
		content: 'member-edit.jsp?id='+row.userId +'&userName='+row.userName+'&userTel='+row.userTel+'&userHobby='+row.userHobby+'&userSex='+row.userSex+'&userEmail='+row.userEmail                                                                                        
		}); 
}
</script>
</body>
</html>