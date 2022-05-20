package com.albertsons.APITestingFramework.testcases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.albertsons.Api.CreateCustomerApi;
import com.albertsons.Api.DeleteCustomerApi;
import com.albertsons.ApiFramework.setup.BaseTest;
import com.albertsons.TestListners.ExtentListeners;
import com.albertsons.apitesting.utilities.DataUtils;
import com.albertsons.apitesting.utilities.TestUtils;

import io.restassured.response.Response;

import java.util.Hashtable;
@Listeners(ExtentListeners.class)
public class DeleteCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtils.class,dataProvider = "data")
	public void deleteCustomer(Hashtable<String, String > data) {
		
		Response response=DeleteCustomerApi.sendDeleteRequestToDeleteCreateCustomerApiWithValidId(data);
		System.out.println(response.asString());
		//1st way: here we are asserting id
		 /*String actualId = response.jsonPath().get("id").toString();
		 String expectedId = data.get("id");
		 Assert.assertEquals(actualId, expectedId,"Id not matched");*/
		
		/*JSONObject jsonObject=new JSONObject(response.asString());
		System.out.println(jsonObject.has("id"));
		Assert.assertTrue(jsonObject.has("id"),"id key is not present in json response");*/
		
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "id"),"id key is not present in json response");
		//2nd way of asserting Id
		String actualId=TestUtils.getJsonKeyValue(response.asString(), "id");
		ExtentListeners.testReport.get().info(data.toString());
		String expectedId = data.get("id");
		Assert.assertEquals(actualId, expectedId);
		Assert.assertEquals(response.statusCode(), 200);
	}
}
