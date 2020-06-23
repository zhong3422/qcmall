package com.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {

	private int code;
	
	private String msg;
	
	private Map<String, Object> data=new HashMap<String, Object>();
	
	public Msg() {
		// TODO Auto-generated constructor stub
		code=200;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public Msg addData(String key,Object value) {
		this.data.put(key, value);
		return this;
	}
	
}
