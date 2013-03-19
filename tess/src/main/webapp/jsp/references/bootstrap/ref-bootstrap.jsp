<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<link href="<%=basePath%>/assets/bootstrap/bootstrap.css" rel="stylesheet"/>
<link href="<%=basePath%>/assets/bootstrap/bootstrap-responsive.css" rel="stylesheet"/>
<script src="<%=basePath%>/assets/bootstrap/bootstrap.js"></script>