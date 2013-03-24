define(['jquery'], function($){
	
	var exports = {};
	
	/**
	 * 清空表格.行数不变,单元格内容清空
	 * @param $t
	 */
	exports.cleanTableContent = function($t) {
		$t.find("td").html("<br/>");
	}
	
	/**
	 * 处理jquery ajax 后台调用异常
	 * @param jqxhr
	 * @param textStatus
	 * @param error
	 */
	exports.jqxhrFail = function(selfMsg) {
		return function(jqxhr, textStatus, error) {
			var err = textStatus + ', ' + error;
			alert(selfMsg + " : " +err);
		}
	}
	
	/**
	 * 初始化分页条
	 * @param $pager 分页条对象
	 * @param totalCnt 总记录数
	 * @param pageSize 每页记录数
	 */
	exports.initPager = function($pager, totalCnt, pageSize) {
		var totalPage = parseInt(totalCnt / pageSize) + 1;
		//如果总页数超过10页,则最多显示10页
		var maxShowPage = totalPage > 10 ? 10 : totalPage;
		
	}
	
	return exports;
	
});