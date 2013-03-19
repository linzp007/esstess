<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 新增检查点 -->
<div class="modal hide fade" id="addCheckpoint">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">x</button>
        <h3>新增检查点</h3>
    </div>
    <div class="modal-body">
        <form class="form-horizontal">
            <div class="control-group">
                <label class="control-label">选择检查项</label>

                <div class="controls">
                    <select class="input-medium">
                        <option>是否接口调用返回成功</option>
                        <option>是否成功生成购物车</option>
                        <option>是否在DEP_TRANS_MSG生成记录</option>
                        <option>是否生成送营销资源消息</option>
                    </select>

                    <div class="alert alert-info">
                        <strong>检查项描述</strong>: 订单下发接口调用的响应报文是否成功.
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">超时时间</label>

                    <div class="controls">
                        <input type="text" class="input-mini"/>
                        <div class="alert alert-info help-inline">
                            超过超时时间仍未得到<br/>期望的成功结果认为是失败
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label">轮询间隔</label>

                    <div class="controls">
                        <input type="text" class="input-mini"/>
                        <div class="alert alert-info help-inline">
                            隔指定的时间检查一次
                        </div>
                    </div>
                </div>
            </div>
        </form>

    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal">取消</button>
        <button class="btn btn-primary">提交</button>
    </div>
</div>