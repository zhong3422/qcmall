package com.test;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test2 {

	public static void main(String[] args) {
	
		JSONArray jsonArray=new JSONArray();
		jsonArray.put("aa");
		jsonArray.put("bb");
		jsonArray.put("cc");
		jsonArray.put("dd");
//		jsonArray
		System.out.println(jsonArray);
		String string=jsonArray.toString();
		System.out.println(string);
		JSONArray jsonArray2=new JSONArray(string);
		for (Object object : jsonArray2) {
			System.out.println(object);
		}
//		
//		JSONObject jsonObject=new JSONObject();
//		jsonObject.put("path", "aa");
//		jsonObject.put("path", "bb");
//		jsonObject.put("path", "cc");
//		
//		System.out.println(jsonObject);
		
		
	}
	
}
