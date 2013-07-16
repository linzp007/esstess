<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-2-13
  Time: 下午8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 新增任务 -->
<div class="modal hide fade" id="addTask">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">x</button>
        <h3>新增任务</h3>
    </div>
    <div class="modal-body">
        <form class="form-horizontal">
            <div class="control-group">
                <label class="control-label">选择任务</label>

                <div class="controls">
                    <select id="task" class="input-medium">
                        <option>订单下发</option>
                        <option>串号回填</option>
                        <option>写卡</option>
                        <option>省内报竣</option>
                    </select>
                </div>
            </div>
            <div class="alert alert-info">
                <p><strong>任务描述</strong>: 取模板报文,给绑定占位符生成序列并替换, 然后调订单下发接口.</p>
            </div>
        </form>

    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal">取消</button>
        <button id="addTaskCommit" class="btn btn-primary">提交</button>
    </div>
</div>