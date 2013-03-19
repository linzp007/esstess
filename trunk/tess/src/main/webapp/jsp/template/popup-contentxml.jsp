<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-2-13
  Time: 下午8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 新填入报文或者修改报文 -->
<div class="modal hide fade" id="contentXml">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">x</button>
        <h3>报文内容</h3>
    </div>
    <div class="modal-body">
        <div class="alert alert-info"><strong>Tip:</strong>
            <ul>
                <li> 先格式化好之后再贴入下面的文本框;</li>
                <li> 注意使用绑定占位符如{extCustOrderId},以便生成订单的时候,生成相应的序列或ID</li>
            </ul>
        </div>
        <form class="form-inline">
            <div class="control-group">
                <label class="control-label">报文模板</label>

                <div class="controls">
                    <textarea rows="7" class="input-block-level"></textarea>
                </div>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal">取消</button>
        <button class="btn btn-primary">提交</button>
    </div>
</div>
