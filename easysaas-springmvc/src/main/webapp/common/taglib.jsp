<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="<%=path %>/statics/style/easyui/gray/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=path %>/statics/style/easyui/icon.css"/>
<link rel="stylesheet" type="text/css" href="<%=path %>/statics/style/default.css"/>
<script type="text/javascript" src="<%=path%>/statics/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/statics/script/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/statics/script/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/statics/script/platform.js?ver=4"></script>
