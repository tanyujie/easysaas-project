<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>在线客服后台管理系统</title>


</head>

<body>
<div class="con">
  <div id="showMsg" class="tishi"></div>
  <div class="btn">
	  <form  name="form1" id="form1" action="<%=path%>/login" method="post">
		    <div class="info">
		    	用户名：<input type="text" id="loginName"  name="loginName" class="username" />&nbsp;&nbsp;&nbsp;
		    	密&nbsp;码：<input type="password" id="password" name="password" class="password"/>
		    </div>
		    <div class="but">
		    	<img id="loginBtn" src="<%=path%>/statics/image/login/but-login.jpg" onmouseover="this.src='<%=path%>/statics/image/login/but-login-hover.jpg'" onmouseout="this.src='<%=path%>/statics/image/login/but-login.jpg'"/>
		    	<img id="resetBtn" src="<%=path%>/statics/image/login/but-reset.jpg" onmouseover="this.src='<%=path%>/statics/image/login/but-reset-hover.jpg'" onmouseout="this.src='<%=path%>/statics/image/login/but-reset.jpg'"/>
		    </div>
	   </form>
  </div>
</div>
<div class="foot"></div>
</body>
</html>