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
	 * @param startPage 分页条一次显示10个页码,startPage表示起始的页码
	 */
	exports.initPager = function($pager, totalCnt, pageSize, startPage) {
		console.info("totalCnt:" + totalCnt + " pageSize:" + pageSize);
		var totalPage = parseInt(totalCnt / pageSize) + 1;
		//如果总页数超过10页,则最多显示10页
		var maxShowPage = totalPage > 10 ? 10 : totalPage;
		//新清空分页条
		var $ul = $pager.find("ul");
		$ul.empty();
		//上一页
		$ul.append("<li class=\"prev\"><a href=\"#\">← Previous</a></li>");
		//下一页
		$ul.append("<li class=\"prev\"><a href=\"#\">← Previous</a></li>");
	}
	
	/**
	 * 初始化弹出窗口
	 */
	exports.initPopups = function() {
		$("[data-uiType='popup']").click(function(){
			var url = $(this).attr("data-popupUrl");
			console.debug("url:" + url);
			var loadedCallback = $(this).data("loadedCallback");
			//页面下方创建一个DIV容器
			var $popWrap = $("<div id='popWrap'/>").appendTo("body");
			//加载弹出窗口页面
			$popWrap.load(url, function(){
				$popWrap.children("div").modal();
				//通过页面加载回调函数来初始化事件
				loadedCallback.call();
				console.info("页面已经加载");
			}).on('hide', function(){
				$("body").find("#popWrap, .modal-backdrop").remove();
			});
		});
		//通过捕获自定义事件evtModalDismiss来关闭弹出窗口
		$("body").bind("evtModalDismiss", function(){
			$("#popWrap").modal("hide");
			$("body").find("#popWrap, .modal-backdrop").remove();
		});
	}
	
	return exports;
	
});