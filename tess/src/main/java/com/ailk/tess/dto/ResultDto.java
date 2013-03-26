package com.ailk.tess.dto;

public class ResultDto {
	public final static String CODE_SUCC = "0";
	public final static String FAIL = "1";
	public final static String MSG_SUCC = "SUCC";
	private String code;
	private String msg;
	
	public ResultDto(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
	public static ResultDto defaultResult(){
		return new ResultDto(CODE_SUCC, MSG_SUCC); 
	}

}
