<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path +"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>"/>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title></title>
    <!-- <script data-main="resources/js-build/template/templateApp" src="assets/require/require.js"></script> -->
    <script data-main="resources/js/template/templateApp" src="assets/require/require.js"></script>
	<link href="assets/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="assets/bootstrap/bootstrap-responsive.css" rel="stylesheet"/>
    <link href="resources/css/tester.css" rel="stylesheet"/>
    <jsp:include page="/jsp/references/prettify/ref-prettify.jsp" />
</head>
<body onload="prettyPrint()">
	<!-- 导航条 -->
	<jsp:include page="/jsp/navbar/navbar.jsp" >
	    <jsp:param name="active" value="templateconfig"  />
	</jsp:include>
	<div class="container">
		<div class="box span12">
		    <div class="box-header">
		        <h2><i class="icon-th-list"></i>
		            <span class="break"></span> 测试用例模板
		        </h2>
		
		        <div class="box-icon">
		            <a href="" class="btn-minimize">
		                <i class="icon-chevron-down"></i>
		            </a>
		        </div>
		    </div>
		    <div class="box-content">
		        <div class="row">
		            <form class="form-search span5">
		                <input type="text" class="input-medium search-query" id="search" placeholder="按模板名称搜索.."/>
		
		                <div class="btn-group">
		                    <button class="btn btn-primary">所有状态</button>
		                    <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
		                        <span class="caret"/>
		                    </button>
		                    <ul class="dropdown-menu">
		                        <li><a href="#">所有状态</a></li>
		                        <li><a href="#">启用</a></li>
		                        <li><a href="#">不启用</a></li>
		                    </ul>
		                </div>
		                <button type="submit" class="btn btn-primary"><i class="icon-search icon-white"></i> 搜索
		                </button>
		               </form>
		            <div class="pull-right">
		                <div class="btn-group">
		                    <button id="btnAddCaseTemplate" class="btn btn-primary" data-uiType="popup"
		                    	data-popupUrl="jsp/template/popup-addCaseTemplate.jsp">
		                    	<i class="icon-plus-sign icon-white"></i> 新增
		                    </button>
		                </div>
		            </div>
		        </div>
		        <table id="tbCaseTemplate" class="table table-striped table-bordered table-condensed table-hover">
		            <thead>
		            <tr>
		                <th class="span1">状态</th>
		                <th class="span1">用例编号</th>
		                <th class="span5">用例名称</th>
		                <th class="span1">操作</th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr>
		                <td><span class="label label-success">启用</span></td>
		                <td>CASE001</td>
		                <td>接入类订单</td>
		                <td><a class="#" title="修改" data-toggle="modal" data-target="#newOrEditCase"><i class="icon-edit"></i></a>
		                    <a class="#" title="删除" data-toggle="modal" data-target="#alert"><i class="icon-remove"></i></a></td>
		            </tr>
		            <tr class="success">
		                <td><span class="label label-important">不启用</span></td>
		                <td>CASE002</td>
		                <td>裸机订单</td>
		                <td><a class="#" title="修改" data-toggle="modal" data-target="#newOrEditCase"><i class="icon-edit"></i></a>
		                    <a class="#" title="删除" data-toggle="modal" data-target="#alert"><i class="icon-remove"></i></a></td>
		            </tr>
		            <tr>
		                <td><span class="label label-success">启用</span></td>
		                <td>CASE003</td>
		                <td>靓号套餐</td>
		                <td><a class="#" title="修改" data-toggle="modal" data-target="#newOrEditCase"><i class="icon-edit"></i></a>
		                    <a class="#" title="删除" data-toggle="modal" data-target="#alert"><i class="icon-remove"></i></a></td>
		            </tr>
		            <tr>
		                <td><span class="label label-success">启用</span></td>
		                <td>CASE004</td>
		                <td>接入类订单</td>
		                <td><a class="#" title="修改" data-toggle="modal" data-target="#newOrEditCase"><i class="icon-edit"></i></a>
		                    <a class="#" title="删除" data-toggle="modal" data-target="#alert"><i class="icon-remove"></i></a></td>
		            </tr>
		            <tr>
		                <td><span class="label label-success">启用</span></td>
		                <td>CASE005</td>
		                <td>裸机订单</td>
		                <td>
		                    <a class="#" title="修改" data-toggle="modal" data-target="#newOrEditCase"><i class="icon-edit"></i></a>
		                    <a class="#" title="删除" data-toggle="modal" data-target="#alert"><i class="icon-remove"></i></a></td>
		            </tr>
		            </tbody>
		        </table>
		        <div id="pgCaseTemplate" class="pagination pagination-centered">
		            <ul>
		                <li class="prev">
		                    <a href="#">← Previous</a>
		                </li>
		                <li class="active">
		                    <a href="#">1</a>
		                </li>
		                <li>
		                    <a href="#">2</a>
		                </li>
		                <li>
		                    <a href="#">3</a>
		                </li>
		                <li>
		                    <a href="#">4</a>
		                </li>
		                <li class="next">
		                    <a href="#">Next → </a>
		                </li>
		            </ul>
		        </div>
		    </div>
		</div>
		<div class="box span12">
		    <div class="box-header">
		        <h2><i class="icon-comment"></i>
		            <span class="break"></span> [接入类订单]模板详情
		        </h2>
		
		        <div class="box-icon">
		            <a href="" class="btn-minimize">
		                <i class="icon-chevron-down"></i>
		            </a>
		        </div>
		    </div>
		    <div class="box-content">
		        <div class="tabbable tabs-left">
		            <ul class="nav nav-tabs">
		                <li class="active"><a href="#templateXml" data-toggle="tab">报文内容</a></li>
		                <li><a href="#templateTask" data-toggle="tab">场景任务</a></li>
		                <li><a href="#templateCheckPoint" data-toggle="tab">场景检查点</a></li>
		            </ul>
		            <div class="tab-content">
		                <div class="tab-pane active" id="templateXml">
		                    <div class="bs-docs-example">
		                        <div class="page-title">接入类订单报文</div>
		                        <div class="clearfix">
		                            <div class="pull-right">
		                                <button id="btnModifyTemplateXml" class="btn btn-small" data-toggle="modal" data-target="#contentXml"
		                                	data-uitype="popup" data-popupurl="jsp/template/popup-contentxml.jsp">
		                                    <i class="icon-edit"></i> 修改
		                                </button>
		                            </div>
		                        </div>
		                        <pre class="prettyprint linenums" style="height: 200px;overflow: auto;" >
		                    &lt;root class="111"&gt;
		                        &lt;a1&gt;1&lt;/a1&gt;
		                        &lt;b1&gt;&lt;c&gt;11111&lt;/c&gt;&lt;/b1&gt;
		                    &lt;/root&gt;
		                </pre>
		                    </div>
		                </div>
		                <div class="tab-pane" id="templateTask">
		                    <div class="alert alert-info">
		                        <strong>Tip!</strong> 执行过程中任何一个环节失败了,后面的任务将不会被执行!
		                    </div>
		                    <table class="table table-striped table-bordered table-condensed table-hover">
		                        <thead>
		                        <tr>
		                            <th class="span1">次序</th>
		                            <th class="span1">任务编号</th>
		                            <th class="span5">任务名称</th>
		                            <th class="span1">操作</th>
		                        </tr>
		                        </thead>
		                        <tbody>
		                        <tr>
		                            <td><span class="label label-success">1</span></td>
		                            <td>TASK001</td>
		                            <td>订单下发</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        <tr class="success">
		                            <td><span class="label label-success">2</span></td>
		                            <td>TASK002</td>
		                            <td>串号回填</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td><span class="label label-success">3</span></td>
		                            <td>TASK003</td>
		                            <td>写卡</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td><span class="label label-success">4</span></td>
		                            <td>TASK004</td>
		                            <td>省内报竣</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td><span class="label label-success">5</span></td>
		                            <td>TASK005</td>
		                            <td>终端发货</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        </tbody>
		                    </table>
		                    <div class="pull-right">
		                        <button class="btn btn-small" data-target="#addTask" data-toggle="modal"><i
		                                class="icon-plus-sign"></i> 新增
		                        </button>
		                    </div>
		                </div>
		                <div class="tab-pane" id="templateCheckPoint">
		                    <table class="table table-striped table-bordered table-condensed table-hover">
		                        <thead>
		                        <tr>
		                            <th class="span1">任务编号</th>
		                            <th class="span1">检查次序</th>
		                            <th class="span5">检查内容</th>
		                            <th class="span1">轮询间隔</th>
		                            <th class="span1">超时(秒)</th>
		                            <th class="span1">操作</th>
		                        </tr>
		                        </thead>
		                        <tbody>
		                        <tr>
		                            <td>TASK001</td>
		                            <td><span class="label label-success">1</span></td>
		                            <td>是否接口调用返回成功</td>
		                            <td>0</td>
		                            <td>0</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        <tr class="success">
		                            <td>TASK001</td>
		                            <td><span class="label label-success">2</span></td>
		                            <td>是否在DEP_TRANS_MSG生成记录</td>
		                            <td>0</td>
		                            <td>0</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td>TASK001</td>
		                            <td><span class="label label-success">3</span></td>
		                            <td>是否成功生成购物车</td>
		                            <td>5</td>
		                            <td>60</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td>TASK001</td>
		                            <td><span class="label label-success">4</span></td>
		                            <td>是否生成送营销资源消息</td>
		                            <td>0</td>
		                            <td>0</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td>TASK001</td>
		                            <td><span class="label label-success">5</span></td>
		                            <td>是否生成送终端公司的消息</td>
		                            <td>0</td>
		                            <td>0</td>
		                            <td>
		                                <a class="#" title="上移"><i class="icon-arrow-up"></i></a>
		                                <a class="#" title="下移"><i class="icon-arrow-down"></i></a>
		                                <a class="#" title="删除"><i class="icon-remove"></i></a>
		                            </td>
		                        </tr>
		                        </tbody>
		                    </table>
		                    <div class="pull-right">
		                        <button class="btn btn-small" data-toggle="modal" data-target="#addCheckpoint"><i
		                                class="icon-plus-sign"></i> 新增
		                        </button>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</div>
</body>
</html>