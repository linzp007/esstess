<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-2-13
  Time: 下午8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 新增任务 -->
<div class="modal hide fade">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">x</button>
        <h3>新增用例模版</h3>
    </div>
    <div class="modal-body">
        <form class="form-horizontal">
            <div class="control-group">
            	<label class="control-label" >模版名称</label>
            	<div class="controls">
            		<input type="text" id="templateName" >
            	</div>
            	
            </div>
            <div class="control-group">
            	<label class="control-label" >用例编号</label>
            	<div class="controls">
            		<input type="text" id="caseCd" >
            	</div>
           	</div>
        </form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal">取消</button>
        <button id="addCommit" class="btn btn-primary">提交</button>
    </div>
</div>