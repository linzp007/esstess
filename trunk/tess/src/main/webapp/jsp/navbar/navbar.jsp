<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-2-13
  Time: 下午8:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 导航条 -->
<div class="navbar">
    <div class="navbar-inner">
        <span class="brand">TESS</span>
        <ul class="nav">
            <li class="<c:if test="${param.active == 'runcase'}">active</c:if>">
                <a href="jsp/runcase/runcase.jsp"><i class="icon-play"></i> 测试用例执行</a>
            </li>
            <li class="<c:if test="${param.active == 'templateconfig'}">active</c:if>">
                <a href="jsp/template/templateconfig.jsp"><i class="icon-cog"></i> 订单模板配置</a>
            </li>
            <li class="<c:if test="${param.active == 'checkpoint'}">active</c:if>">
                <a href="jsp/checkpoint/checkpoint.jsp"><i class="icon-warning-sign"></i> 检查点配置</a>
            </li>
            <li class="<c:if test="${param.active == 'taskconfig'}">active</c:if>">
                <a href="jsp/task/taskconfig.jsp"><i class="icon-tasks"></i> 环节配置</a>
            </li>
        </ul>
    </div>
</div>