package com.ailk.tess.dto;

public class CaseTaskDto {
	private int caseTaskId;
	private int templateId;
	private int taskId;
	private String statusCd;
	
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getStatusCd() {
		return statusCd;
	}
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	public int getCaseTaskId() {
		return caseTaskId;
	}
	public void setCaseTaskId(int caseTaskId) {
		this.caseTaskId = caseTaskId;
	}
}
