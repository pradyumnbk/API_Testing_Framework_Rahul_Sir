package com.albertsons.APITestingFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.albertsons.Api.CreateCustomerApi;
import com.albertsons.ApiFramework.setup.BaseTest;
import com.albertsons.TestListners.ExtentListeners;
import com.albertsons.apitesting.utilities.DataUtils;
import io.restassured.response.Response;

import java.util.Hashtable;
@Listeners(ExtentListeners.class)
public class CreateCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtils.class,dataProvider = "data")
	public void validateCreateCustomerApiWithValidSecretKey(Hashtable<String, String > data) {
		
		Response response=CreateCustomerApi.sendPostRequestToCreateCustomerApiWithValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		System.out.println(response.asString());
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "data")
	public void validateCreateCustomerApiWithInvalidSecretKey(Hashtable<String, String> data) {
		
		Response response=CreateCustomerApi.sendPostRequestToCreateCustomerApiWithInvalidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());//It is used for logging in extent report
		System.out.println(response.asString());
		Assert.assertEquals(response.statusCode(), 401);
	}
	
}
