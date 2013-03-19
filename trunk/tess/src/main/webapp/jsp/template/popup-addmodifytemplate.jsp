<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-2-13
  Time: 下午8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 模板新增,修改对话框 -->
<div class="modal hide fade" id="newOrEditCase">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">x</button>
        <h3>新增用例模板</h3>
    </div>
    <div class="modal-body">
        <form class="form-horizontal">
            <div class="control-group">
                <label class="control-label">用例名称</label>

                <div class="controls">
                    <input type="text" class="input-medium"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">用例编号</label>

                <div class="controls">
                    <input type="text" class="input-medium"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">状态</label>

                <div class="controls">
                    <select class="input-small">
                        <option>启用</option>
                        <option>不启用</option>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">备注</label>

                <div class="controls">
                    <textarea rows="3"></textarea>
                </div>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal">取消</button>
        <button class="btn btn-primary">提交</button>
    </div>
</div>