<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path +"/";
%>
<%--

     运行用例
     @author linzp
     @Date 2013.02.13
--%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>"/>
    <title></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title></title>
    <jsp:include page="/jsp/references/bootstrap/ref-bootstrap.jsp" />
    <link href="resources/css/tester.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="/jsp/navbar/navbar.jsp">
    <jsp:param name="active" value="runcase"  />
</jsp:include>
<div class="container">
    <div class="hero-unit myhero-unit">
        <div class="logo">
            <img src="resources/images/Logo.png"/>
        </div>
        <div class="row">
            <div class="pull-left">
                <div class="span2">
                    <img src="resources/images/hehe.png"/>
                </div>
                <div class="popover right show">
                    <div class="arrow"></div>
                    <div class="popover-title"><strong>欧了!</strong></div>
                    <div class="popover-content">
                        <p class="text-error"> 走吧, 回去睡觉了...</p>
                    </div>
                </div>
            </div>
            <div class="pull-right sink">
                <div class="popover left show">
                    <div class="arrow"></div>
                    <div class="popover-title"><strong>纳尼?</strong></div>
                    <div class="popover-content">
                        <p class="text-error"> 这么快? 这不科学...</p>
                    </div>
                </div>
                <div class="span2">
                    <img src="resources/images/atonishing.png"/>
                </div>
            </div>
        </div>
        <div class="startbtn">
            <div class="row">
                <div class="span2">
                    <button class="btn btn-danger btn-large span2"><i class="icon-hand-right icon-white"></i>
                        <strong>跑一个!</strong></button>
                </div>
                <div class="alert alert-info span4">
                    <strong> Total Cases:</strong>35 &nbsp;&nbsp;&nbsp;<a href="#" class="btn-link">查看测试报告</a>
                    <br/>
                    <span class="text-info">
                <strong> Running:</strong>5</span>
                <span class="text-info">
                <strong> Waiting:</strong>14</span><br/>
                <span class="text-success">
                <strong> Succeed:</strong>10</span>
                <span class="text-error">
                <strong> Failed:</strong>5</span>
                <span class="text-warning">
                <strong> Suspend:</strong>1</span>
                </div>
            </div>
        </div>
    </div>
    <div class="alert alert-info">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Tip!</strong> 服务都由前台发起,所以执行过程中请不要关闭该页面.
    </div>
    <div>
        <div class="btn-group pull-right" data-toggle="buttons-radio">
            <button class="btn btn-mini btn-info">全部挂起</button>
            <button class="btn btn-mini btn-info">全部执行</button>
        </div>
    </div>
    <section class="row">
        <div class="span12">
            <span class="label label-info"><strong>接入类订单</strong></span>

            <div class="wizard">
                <ul class="steps">
                    <li data-target="#alert" data-toggle="modal" data-backdrop="static" class="complete">
                        <span class="badge badge-success">1</span>订单下发<span
                            class="chevron"></span></li>
                    <li data-target="#step2" class="complete"><span class="badge badge-success">2</span>串号回填<span class="chevron"></span></li>
                    <li data-target="#step3" class="active"><span class="badge badge-info">3</span>写卡<span class="chevron"></span></li>
                    <li data-target="#step4"><span class="badge">4</span>省内报竣<span class="chevron"></span></li>
                    <li data-target="#step5"><span class="badge">5</span>发货反馈<span class="chevron"></span></li>
                </ul>
                <div class="actions">
                    <div class="btn-group" data-toggle="buttons-radio">
                        <button class="btn btn-info btn-mini">挂起</button>
                        <button class="btn btn-info btn-mini">执行</button>
                    </div>
                </div>
            </div>
            <span class="label label-info"><strong>裸机订单</strong></span>

            <div class="wizard">
                <ul class="steps">
                    <li data-target="#step1" class="complete">
                        <span class="badge badge-success">1</span>订单下发<span
                            class="chevron"></span></li>
                    <li data-target="#step2" class="complete"><span class="badge badge-success">2</span>串号回填<span class="chevron"></span></li>
                    <li data-target="#step4" class="active"><span class="badge badge-info">3</span>省内报竣<span class="chevron"></span></li>
                    <li data-target="#step5"><span class="badge">4</span>发货反馈<span class="chevron"></span></li>
                </ul>
                <div class="actions">
                    <div class="btn-group" data-toggle="buttons-radio">
                        <button class="btn btn-info btn-mini">挂起</button>
                        <button class="btn btn-info btn-mini">执行</button>
                    </div>
                </div>
            </div>
            <span class="label label-info"><strong>靓号订单</strong></span>

            <div class="wizard">
                <ul class="steps">
                    <li data-target="#step1" class="failed">
                        <span class="badge badge-important">1</span>订单下发<span
                            class="chevron"></span></li>
                    <li data-target="#step2"><span class="badge">2</span>串号回填<span class="chevron"></span></li>
                    <li data-target="#step3"><span class="badge">3</span>写卡<span class="chevron"></span></li>
                    <li data-target="#step4"><span class="badge">4</span>省内报竣<span class="chevron"></span></li>
                </ul>
                <div class="actions">
                    <div class="btn-group" data-toggle="buttons-radio">
                    <button class="btn btn-info btn-mini">挂起</button>
                    <button class="btn btn-info btn-mini">执行</button>
                    </div>
                </div>
            </div>
            <span class="label label-info"><strong>云卡批开订单</strong></span>
            <div class="wizard">
                <ul class="steps">
                    <li data-target="#step1" class="complete">
                        <span class="badge badge-success">1</span>订单下发<span
                            class="chevron"></span></li>
                </ul>
                <div class="actions">
                    <div class="btn-group" data-toggle="buttons-radio">
                        <button class="btn btn-info btn-mini">挂起</button>
                        <button class="btn btn-info btn-mini">执行</button>
                    </div>
                </div>
            </div>
            <span class="label label-info"><strong>功能类订购</strong></span>

            <div class="wizard">
                <ul class="steps">
                    <li data-target="#step1">
                        <span class="badge">1</span>订单下发<span
                            class="chevron"></span></li>
                    <li data-target="#step2"><span class="badge">2</span>省内报竣<span class="chevron"></span></li>
                </ul>
                <div class="actions">
                    <div class="btn-group" data-toggle="buttons-radio">
                        <button class="btn btn-info btn-mini">挂起</button>
                        <button class="btn btn-info btn-mini">执行</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

</body>
</html>