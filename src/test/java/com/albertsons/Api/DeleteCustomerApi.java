package com.albertsons.Api;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.albertsons.ApiFramework.setup.BaseTest;
import io.restassured.response.Response;

public class DeleteCustomerApi extends BaseTest{

	public static Response sendDeleteRequestToDeleteCreateCustomerApiWithValidId(Hashtable<String, String> data) {
		Response response = given()
				.log().all()
				.auth()
				.basic(prop.getProperty("ValidSecretKey"), "")
				.when()
				.delete(prop.getProperty("CustomerApiEndpoint")+"/"+data.get("id"))
				.then()
				.log().all()
				.extract()
				.response();
		return response;
	}

}
