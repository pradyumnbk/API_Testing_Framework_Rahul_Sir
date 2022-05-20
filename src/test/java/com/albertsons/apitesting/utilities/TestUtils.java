package com.albertsons.apitesting.utilities;

import org.json.JSONObject;

import com.albertsons.TestListners.ExtentListeners;

public class TestUtils {

	public static boolean jsonHasKey(String json,String key) {
		JSONObject jsonObject=new JSONObject(json);
		ExtentListeners.testReport.get().info("validating the presence of key "+key);
		return jsonObject.has(key);
	}
	
	public static String getJsonKeyValue(String json,String key) {
		JSONObject jsonObject=new JSONObject(json);
		ExtentListeners.testReport.get().info("validating the presence of value "+key);
		return jsonObject.get(key).toString();
	}
}
