define(['jquery'], function($){
	
	var GROUP_SIZE = 3, PAGE_EVENT_NAME_PREFIX = "evtLoadPage";
	var CLS = {
		PREV : "prev",
		NEXT : "next",
		ACTIVE : "active",
		NULL : null
	};
		
	var _empty = function($holder) {
		$holder.empty();
		$holder.append("<ul/>");
	}
	var _geneLinkItem = function(pager, itemCls, itemTxt) {
		var $ul = pager.$holder.find("ul");
		var $li = $("<li/>").appendTo($ul);
		if(itemCls) {
			$li.addClass(itemCls);
		}
		var $a = $("<a/>").text(itemTxt);
		$a.appendTo($li);
		if($li.hasClass(CLS.PREV)) {
			$li.click(function(){
				pager.setPrevPageGroup();
			});
		} else if($li.hasClass(CLS.NEXT)){
			$li.click(function(){
				pager.setNextPageGroup();
			});
		} else {
			$li.click(function(){
				$ul.find("li").removeClass(CLS.ACTIVE);
				$(this).addClass(CLS.ACTIVE);
				pager.curPage = itemTxt;
				$(this).trigger(pager.pageEvent, itemTxt);
			});
		}
	}
	
	var _genePrevLink = function(pager) {
		_geneLinkItem(pager, CLS.PREV, "← Previous");
	}
	
	var _geneNextLink = function(pager) {
		_geneLinkItem(pager, CLS.NEXT, "Next → ");
	}
	
	var Pager = function($holder){
		this.$holder = $holder;
		this.id = $holder.attr("id");
		this.curPage = 1;
		this.totalCnt = 0;
		this.pageSize = 0;
		this.curGroupPageStart = 1;
		this.pageEvent = PAGE_EVENT_NAME_PREFIX + "-" + this.id;
		_empty(this.$holder);
		//添加分页样式
		this.$holder.addClass("pagination pagination-centered");
	}
	
	/**
	 * 初始化分页条
	 * @param totalCnt
	 * @param pageSize
	 */
	Pager.prototype.init = function(totalCnt, pageSize){
		
		//上一组分页
		_genePrevLink(this);
		//初始化默认只有一页
		_geneLinkItem(this, CLS.ACTIVE, "1");
		//下一组分页
		_geneNextLink(this);
	}
	
	Pager.prototype.setPrevPageGroup = function(){
		var oldCurGroupPageStart = this.curGroupPageStart;
		this.setPageGroup(this.totalCnt, this.pageSize, this.curGroupPageStart - GROUP_SIZE);
		//加载分组第一页,如果分页组发生变化,则重新加载分组第一页
		if(oldCurGroupPageStart != this.curGroupPageStart) {
			$(this.$holder).trigger(this.pageEvent, this.curGroupPageStart);
		}
	}
	
	Pager.prototype.setNextPageGroup = function(){
		var oldCurGroupPageStart = this.curGroupPageStart;
		this.setPageGroup(this.totalCnt, this.pageSize, this.curGroupPageStart + GROUP_SIZE);
		//加载分组第一页,如果分页组发生变化,则重新加载分组第一页
		if(oldCurGroupPageStart != this.curGroupPageStart) {
			$(this.$holder).trigger(this.pageEvent, this.curGroupPageStart);
		}
	}
	
	/**
	 * 设置分页组
	 * @param totalCnt
	 * @param pageSize
	 * @param activePage
	 */
	Pager.prototype.setPageGroup = function(totalCnt, pageSize, activePage) {
		
		//计算总页数
		var totalPage = totalCnt % pageSize == 0 ?
				parseInt(totalCnt / pageSize) : parseInt(totalCnt / pageSize) + 1;
		//计算总共可以分几组显示
		var totalPageGroup = totalPage % GROUP_SIZE == 0 ? 
				parseInt(totalPage / GROUP_SIZE) : parseInt(totalPage / GROUP_SIZE) + 1;
		//若起始页参数不存在, 则默认当前页
		activePage = activePage ? activePage : this.curPage;
		activePage = activePage <= 0 ? 1 : activePage;
		
		//计算开始页数应该在第几组, 得到起始的页码
		var groupStartPage = ((activePage % GROUP_SIZE == 0)?
				(parseInt(activePage / GROUP_SIZE) - 1) : (parseInt(activePage / GROUP_SIZE))) * GROUP_SIZE + 1;
		if(groupStartPage > totalPage) {
			return;
		}
		$.extend(this, {
				curPage : activePage, 
				totalCnt : totalCnt, 
				pageSize : pageSize,
				curGroupPageStart : groupStartPage
			});
		
		_empty(this.$holder);
		//上一组分页
		_genePrevLink(this);
		for(var i = groupStartPage; i < groupStartPage + GROUP_SIZE && i <= totalPage; i++){
			var cls = (i == activePage) ? CLS.ACTIVE : CLS.NULL;
			_geneLinkItem(this, cls, i);
		}
		//下一组分页
		_geneNextLink(this);
	}
	
	return Pager;
});