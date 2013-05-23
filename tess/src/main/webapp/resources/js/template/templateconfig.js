
define(['jquery', 'bootStrap', 'utils', 'pager'], function($, bs, utils, Pager){
	
	/*常量 */
	var PAGE_SIZE = 5;
	var STATUS_CD = {
			ENABLED : 1,
			DISABLED : 2
	};
	var RESULE_CODE = {
			SUCCESS : "0",
			FAILED : "1"
	};
	
	/*局部变量区*/ 
	var $tCaseTemplate = $("#tbCaseTemplate"), 
		$pgCaseTemplate = $("#pgCaseTemplate"),
		$tTask = $("#tbTask");
	var pager;
	
	/* 事件函数 */
	function _initEvents() {
		utils.initPopups($("#btnAddCaseTemplate"), _addCaseTemplateCommit);
		utils.initPopups($("#btnModifyTemplateXml"), _modifyTemplateXmlCommit);
		
		$tCaseTemplate.find("tr").click(function(){
			$("#tbCaseTemplate tr").removeClass("success");
			$(this).attr("class", "success");
		});
		
		$tCaseTemplate.find("tr").dblclick(function(){
			var param = {
					templateId : $(this).attr("data-templateid"),
					manageCd : $($($(this).children()).get(1)).text()
			};
			console.info("双击了" + param.templateId);
			$("#btnModifyTemplateXml").attr("data-templateId", param.templateId);
			$.getJSON("casetemplate/findTemplateName", param, _showTemplateName);
			$.getJSON("casetemplate/templateContent", param, _showTemplateContent);
			$.getJSON("task/taskList/" , param, _showTaskList)
			.fail(utils.jqxhrFail("加载场景任务列表出错."));
		});
		
		$("#tbTask").find("tr").click(function(){
			$("#tbTask tr").removeClass("success");
			$(this).attr("class", "success");
		});
		
		pager = new Pager($pgCaseTemplate);
		$pgCaseTemplate.bind(pager.pageEvent, function(evt, data){
			_loadTemplates(data);
		});
	}
	
	/**
	 * 将任务数据展示到表格中.
	 * @param data 用例模板数据
	 */
	function _showTaskList(data){
		console.debug("showTaskList");
		//先清空表格,行数不变
		utils.cleanTableContent($tTask);
		
		$.each(data.result, function(i, rowData){
			var $row = $tTask.find("tbody tr").eq(i);
			//给当前<tr>元素加入自定义属性保存taskId
			$row.attr("data-taskId",rowData.taskId);
			$row.find("td").eq(0).html(i+1);
			_setTaskRow($row, rowData);
		});
	}
	
	/**
	 * 展示场景任务表格一行数据
	 * @param $row 用行对象,由jquery选择器选中.
	 * @param data 填充到行的行数据
	 */
	function _setTaskRow($row, data){
		$row.find("td").eq(1).html(data.taskId);
		$row.find("td").eq(2).html(data.taskName);
		_taskRowEdit($row.find("td").eq(3));
	}
	
	/**
	 * 任务表,行编辑按钮
	 */
	function _taskRowEdit($td){
		$td.empty();
		$moveUpLink = $("<a class=\"#\" title=\"上移\"><i class=\"icon-arrow-up\"></i></a>");
		$moveDownLink = $("<a class=\"#\" title=\"下移\"><i class=\"icon-arrow-down\"></i></a>");
		$delLink = $("<a class=\"#\" title=\"删除\"><i class=\"icon-remove\"></i></a>");
		$td.append([$moveUpLink, $moveDownLink, $delLink]);
		utils.wrapPopup($delLink, "#alert", "jsp/common/popup-alert.jsp");
		utils.initPopups($delLink, _deleteTaskCommit);
	}
	
	/**
	 * 响应删除场景任务提交
	 */
	function _deleteTaskCommit(){
		$("#alert").find(".btn-primary").attr("id", "delTaskCommit");
		$("#alert").find("p").text("确定删除此用例的任务吗?");
		$("#delTaskCommit").click(function(){
			var param = {
					taskId : $("#tbTask tr[class='success']").attr("data-taskId")
			};
			_deleteTask(param);
			$("body").trigger("evtModalDismiss");
		});
	}
	
	/**
	 * 删除场景任务
	 * @param data为任务编号
	 */
	function _deleteTask(data){
		$.getJSON("task/delete", data, function(r){
			}).fail(utils.jqxhrFail("删除任务出错"));
	}
	
	/**
	 * 响应增加用例模板提交
	 */
	function _addCaseTemplateCommit() {
		$("#addCommit").click(function(){
			//使得点击提交时先清空上一次留下的验证失败信息
			$("font").text("");
			var param = {
				templateName : $("#templateName").val(),
				manageCd : $("#caseCd").val()
			};
			_addCaseTemplate(param);
			//关闭窗口在_addCaseTemplate里面
		});
	}
	
	
	/* 响应删除确认按钮 */
	function _deleteCaseTemplateCommit(){
		$("#alert").find(".btn-primary").attr("id", "deleteCommit");
		$("#alert").find("p").text("删除场景模板将会把关联的任务,检查点一起删除,确定删除吗?");
		$("#deleteCommit").click(function(){
			var templateId = $("tr[class='success']").attr("data-templateId");
			var param = {
					templateId : templateId
			};
			_deleteCaseTemplate(param);
			$("body").trigger("evtModalDismiss");
		});
	}
	
	/* 响应修改确认按钮 */
	function _modifyCaseTemplateCommit(){
		var templateId = $("tr[class='success']").attr("data-templateId");
		var data = {
			templateId : templateId
		};
		$.getJSON("casetemplate/detail", data, _displayTemplate);
		$("#modifyCommit").click(function(){
			var templateId = $("tr[class='success']").attr("data-templateId");
			var statusCd=$("#statusCd").val();
			var param = {
				templateId : templateId,
				templateName : $("#templateName").val(),
				manageCd : $("#manageCd").val(),
				statusCd : $("#statusCd").val()
			};
			_modifyCaseTemplate(param);
		});
	}
	
	/**
	 * 在模板详情的标题上显示模板名称
	 * @param 
	 */
	function _showTemplateName(data){
		$("h2").text('['+data.templateName+']模板详情');
		$(".page-title").text(data.templateName+'-报文');
	}
	
	/**
	 * 修改模板详情
	 */
	function _modifyTemplateXmlCommit(){
		var param = {
				templateId : $("#btnModifyTemplateXml").attr("data-templateId"),
				templateContent : ""
		};
		$.getJSON("casetemplate/templateContent", param, _showTemplateXml);
		$("#contentXml").find(".btn-primary").click(function(){
			console.info("xml被修改提交");
			param.templateContent = $("textarea").val();
			console.info(param.templateContent);
			_modifyTemplateXml(param);
		});
		
	}
	
	/**
	 * 响应修改模板详情的提交按钮
	 */
	function _modifyTemplateXml(data){
		$.post("casetemplate/modifyTemplateContent", data, function(r){
			if(r.code == RESULE_CODE.SUCCESS) {
				$(".tip").show("slow");
				setTimeout(function(){
					$("body").trigger("evtModalDismiss");
				}, 3000);
			}
			
		}).fail(utils.jqxhrFail("修改模板详情出错."));
	}
	
	/**
	 * 在弹出的修改模板详情框中显示XML文档
	 */
	function _showTemplateXml(data){
		var temp = data.templateContent;
		$("textArea").text(temp);
	}
	
	/**
	 * 显示模板详情
	 */
	function _showTemplateContent(data){
		var temp = data.templateContent;
		$("#templateXml").find("pre").text(temp);
		console.info(temp);
		prettyPrint();
	}
	
	/**
	 * 显示用例模板状态
	 */
	function _renderTemplateStatus(status) {
		if(status == STATUS_CD.ENABLED) {
			return "<span class=\"label label-success\">启用</span>";
		}
		if(status == STATUS_CD.DISABLED) {
			return "<span class=\"label label-important\">不启用</span>";
		}
	}
	
	/**
	 * 行编辑按钮
	 */
	function _rowEdit($td){
		$td.empty();
		$editLink = $("<a class=\"#\" title=\"修改\"><i class=\"icon-edit\"></i></a>");
		$delLink = $("<a class=\"#\" title=\"删除\"><i class=\"icon-remove\"></i></a>");
		$td.append([$editLink, $delLink]);
		utils.wrapPopup($editLink, "#modifyCase", "jsp/template/popup-modifyCaseTemplate.jsp");
		utils.wrapPopup($delLink, "#alert", "jsp/common/popup-alert.jsp");
		utils.initPopups($editLink, _modifyCaseTemplateCommit);
		utils.initPopups($delLink, _deleteCaseTemplateCommit);
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
		_rowEdit($row.find("td").eq(3));	
		
	}
	
	/**
	 * 将用例模板数据展示到表格中.
	 * @param data 用例模板数据
	 */
	function _showTemplateList(data) {
		
		//先清空表格,行数不变
		utils.cleanTableContent($tCaseTemplate);
		
		$.each(data.result, function(i, rowData){
			var $row = $tCaseTemplate.find("tbody tr").eq(i);
			//给当前<tr>元素加入自定义属性保存templateId
			$row.attr("data-templateId",rowData.templateId);
			_setCaseTemplateRow($row, rowData);
		});
		pager.setPageGroup(data.totalCount, PAGE_SIZE, pager.curPage);
	}
	
	/**
	 * 页面初始化的时候, 默认加载第一页模板数据
	 */
	function _loadTemplates(pageNo) {
		pageNo = pageNo ? pageNo : 1;
		$.getJSON("casetemplate/list/" + pageNo, _showTemplateList)
			.fail(utils.jqxhrFail("加载用例模板列表出错."));
	}
	
	/**
	 * 弹出修改页面时, 显示指定模板数据
	 */
	function _displayTemplate(data){
		for(var key in data) {
			$("#modifyCase #" + key).val(data[key]);
		}
	}
	
	/**
	 * 修改一个用例模板
	 */
	function _modifyCaseTemplate(data){
		var result = {
			code : 	RESULE_CODE.FAILED
		};
		$.getJSON("casetemplate/modify", data, function(r){
			if(r.code == RESULE_CODE.SUCCESS) {
				$(".tip").show("slow");
				setTimeout(function(){
					$("body").trigger("evtModalDismiss");
				}, 3000);
			}
		}).fail(utils.jqxhrFail("修改用例模板出错"));
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
			arr = r.msg.split("|");
			for (var i=0; arr.length>i; i++){
				if (arr[i].indexOf("templateName") > -1){
					$("#templateName").next().next("font").text(arr[i].split("@")[1]);
				}
				else
					$("#caseCd").next().next("font").text(arr[i].split("@")[1]);
			}
			if(r.code == RESULE_CODE.SUCCESS)
				$("body").trigger("evtModalDismiss");
			
			//TODO 提示新增成功.
		}).fail(utils.jqxhrFail("增加用例模板出错."));
	}
	
	return {
		initialize : function() {
			_initEvents();
			_loadTemplates();
		}
	};
});