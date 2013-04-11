
define(['jquery', 'bootStrap', 'utils'], function($, bs, utils){
	
	/*常量 */
	var PAGE_SIZE = 5;
	
	/*局部变量区*/ 
	var $tCaseTemplate = $("#tbCaseTemplate"), 
		$ctPager = $("#pgCaseTemplate");
	
	/* 事件函数 */
	function _initEvents() {
		console.info(13);
		utils.initPopups();
		$("#btnAddCaseTemplate").data("loadedCallback", _addCaseTemplateCommit);
		$(".icon-remove").data("loadedCallback", _deleteCaseTemplateCommit);
		$(".icon-remove").click(function(){
			var temp = $(this).parent().parent().parent().attr("data-templateid");
			console.info(temp+"准备删除这个id");
		});
		$("#tbCaseTemplate tr").click(function(){
			$("#tbCaseTemplate tr").removeClass("success");
			$(this).attr("class", "success");
		});	
		
		
		
		
		
	}
	
	function _addCaseTemplateCommit() {
		$("#addCommit").click(function(){
			var param = {
				templateName : $("#templateName").val(),
				manageCd : $("#caseCd").val()
			};
			_addCaseTemplate(param);
			//关闭窗口
			$("body").trigger("evtModalDismiss");
		});
	}
	
	
	/* 响应删除确认按钮 */
	function _deleteCaseTemplateCommit(){
		$("#deleteCommit").click(function(){
			var templateId = $("tr[class='success']").attr("data-templateid");
			var param = {
					templateId : templateId
			};
			console.info(param);
			_deleteCaseTemplate(param);
			$("body").trigger("evtModalDismiss");
		});
	}
	
	/**
	 * 显示用例模板状态
	 */
	function _renderTemplateStatus(status) {
		if(status == 1) {
			return "<span class=\"label label-success\">启用</span>";
		}
		if(status == 0) {
			return "<span class=\"label label-important\">启用</span>";
		}
	}
	
	/**
	 * 行编辑按钮
	 */
	function _rowEdit(){
		
		return "<a class=\"#\" title=\"修改\" data-toggle=\"modal\" data-target=\"#newOrEditCase\"><i class=\"icon-edit\"></i></a>"
		   +"<a class=\"#\" title=\"删除\" data-toggle=\"modal\" data-target=\"#alert\"><i  class=\"icon-remove\" data-uiType=\"popup\" " +
		   		" data-popupUrl=\"jsp/common/popup-alert.jsp\" ></i></a>";
		  
		
		
	}
	
	/**
	 * 展示用例模板表格一行数据
	 * @param $row 用行对象,由jquery选择器选中.
	 * @param data 填充到行的行数据
	 */
	function _setCaseTemplateRow($row, data) {
		$row.find("td").eq(0).html(_renderTemplateStatus(data.statusCd));
		$row.find("td").eq(1).html(data.manageCd);
		$row.find("td").eq(2).html(data.templateName);
		$row.find("td").eq(3).html(_rowEdit());	
		
	}
	
	/**
	 * 将用例模板数据展示到表格中.
	 * @param data 用例模板数据
	 */
	function _showTemplateList(data) {
		
		utils.initPager($ctPager, data.totalCount, PAGE_SIZE);
		
		//先清空表格,行数不变
		utils.cleanTableContent($tCaseTemplate);
		
		$.each(data.result, function(i, rowData){
			var $row = $tCaseTemplate.find("tbody tr").eq(i);
			//给当前<tr>元素加入自定义属性保存templateId
			$row.attr("data-templateId",rowData.templateId);
			_setCaseTemplateRow($row, rowData);
			
		});
		
		
		_initEvents();
		
		
		
		
		
	}
	
	/**
	 * 页面初始化的时候, 默认加载第一页模板数据
	 */
	function _loadTemplates() {
		$.getJSON("casetemplate/list/1", _showTemplateList)
			.fail(utils.jqxhrFail("加载用例模板列表出错."));
	}
	
	/**
	 * 删除一个用例模板
	 */
	function _deleteCaseTemplate(data){
		$.getJSON("casetemplate/delete", data, function(r){
			
		}).fail(utils.jqxhrFail("删除用例模板出错"));
	}
	
	/**
	 * 增加一个用例模板
	 */
	function _addCaseTemplate(data) {
		$.getJSON("casetemplate/add", data, function(r){
			//TODO 提示新增成功.
		}).fail(utils.jqxhrFail("增加用例模板出错."));
	}
	
	return {
		initialize : function() {
			//_initEvents();
			console.info("页面初始化");
			_loadTemplates();
		}
	};
});