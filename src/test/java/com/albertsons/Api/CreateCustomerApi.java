package com.albertsons.Api;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.albertsons.ApiFramework.setup.BaseTest;

import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateCustomerApi extends BaseTest{

	public static Response sendPostRequestToCreateCustomerApiWithValidAuthKey(Hashtable<String, String> data) {
		Response response = given()
				.log().all()
				.auth()
				.basic(prop.getProperty("ValidSecretKey"), "")
				.formParam("name", data.get("name"))
				.formParam("email", data.get("email"))
				.formParam("description",data.get("description"))
				.config(config.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.when()
				.post(prop.getProperty("CustomerApiEndpoint"))
				.then()
				.log().all()
				.contentType(ContentType.JSON)
				.extract()
				.response();
		return response;
	}

	public static Response sendPostRequestToCreateCustomerApiWithInvalidAuthKey(Hashtable<String, String> data) {
		Response response = given()
				.log().all()
				.auth()
				.basic(prop.getProperty("InvalidSecretKey"), "")
				.formParam("name", data.get("name"))
				.formParam("email", data.get("email"))
				.formParam("description",data.get("description"))
				.config(config.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.when()
				.post(prop.getProperty("CustomerApiEndpoint"))
				.then()
				.log().all()
				.contentType(ContentType.JSON)
				.extract()
				.response();
		return response;
	}
}
