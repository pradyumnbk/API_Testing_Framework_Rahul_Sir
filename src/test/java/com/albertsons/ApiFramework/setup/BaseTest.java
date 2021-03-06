package com.albertsons.ApiFramework.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.albertsons.apitesting.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {
	public static  Properties prop=new Properties();
	private FileInputStream fis;
	public static ExcelReader reader=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	
	@BeforeSuite
	public void setUp() {
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestAssured.baseURI=prop.getProperty("baseURI");
		RestAssured.basePath=prop.getProperty("basePath");
	}

	@AfterSuite
	public void tearDown() {

	}
}
