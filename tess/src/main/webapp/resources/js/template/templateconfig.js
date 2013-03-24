
define(['jquery', 'bootStrap'], function($){
	
	function loadTemplates() {
		
	}
	
	function initialize(msg){
		alert("initialize config page, msg:" +msg);
	}
	
	function addCaseTemplate() {
		var caseTemplate = {
				templateId : 234,
				templateName :'哈哈',
				manageCd : '##11##',
				statusCd : 2
		};
		$.getJSON("casetemplate/add", caseTemplate, function(r){
			alert(1);
			alert(r.msg);
		});
	}
	
	return {
		initialize : initialize,
		addCaseTemplate : addCaseTemplate
	};
});