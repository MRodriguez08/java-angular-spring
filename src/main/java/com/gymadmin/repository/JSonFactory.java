package com.gymadmin.repository;

import org.json.simple.JSONObject;

public class JSonFactory {
	
	private JSonFactory() {}

	@SuppressWarnings("unchecked")
	public static JSONObject createSimpleMessage(String msg){
		JSONObject message = new JSONObject();
		message.put("message", msg);
		return message;
	}
	
}
