package com.gitsck.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class TuLin {
	
	//状态码
	private long code;
	//回复文本值
	private String text;
	
	@JSONField(name = "code")
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	@JSONField(name = "text")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	

}
