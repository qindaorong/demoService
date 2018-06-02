package com.qindaorong.demo.client.dto;

/**
 * Created by qindaorong on 2018/5/8.
 */
public enum TestError {

	DTO_LIST_IS_EMPTY("400000","citys is empty"),
    NOT_FOUND("400001", "dbchanges not found");

	private String code;
	private String message;

	TestError(String code,String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
