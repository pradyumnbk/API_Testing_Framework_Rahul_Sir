package com.albertsons.apitesting.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.albertsons.ApiFramework.setup.BaseTest;

public class DataUtils extends BaseTest {
	/*
	 * In excel reader class the logic is set like rows start with 1 and column will
	 * start with 0
	 */
	@DataProvider(name = "data",parallel = true)//parallel=true will run all the testdata parallel
	public Object[][] getData(Method m) {
		int rows = reader.getRowCount(prop.getProperty("TestDataSheetName"));
		System.out.println("Total rows are : " + rows);

		String testName = m.getName();
		System.out.println("Test name is : " + testName);

		/*
		 * If we are using Excel reader class then the format coded in excel reader is
		 * row start with 1 and column start with 0
		 */

		// find the test case start row
		int testcaseRowNum = 1;
		for (testcaseRowNum = 1; testcaseRowNum <= rows; testcaseRowNum++) {
			String testcaseName = reader.getCellData(prop.getProperty("TestDataSheetName"), 0, testcaseRowNum);
			if (testcaseName.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("test case starts from row num: " + testcaseRowNum);

		// checking total rows in test case

		int dataStartRowNum = testcaseRowNum + 2;

		int testRows = 0;
		while (!reader.getCellData(prop.getProperty("TestDataSheetName"), 0, dataStartRowNum + testRows).equals("")) {

			testRows++;
		}
		System.out.println("Total rows of data are :" + testRows);

		// Checking total columns in test case data excel sheet
		int colsStartColNum = testcaseRowNum + 1;
		int testCols = 0;

		while (!reader.getCellData(prop.getProperty("TestDataSheetName"), testCols, colsStartColNum).equals("")) {
			testCols++;
		}
		System.out.println("total cols are:" + testCols);

		Object[][] data = new Object[testRows][1];
		// printing data
		int i = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {
			Hashtable<String, String> table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < testCols; cNum++) {
				// System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
				// data[0][0]=excel.getCellData(Constants.DATA_SHEET, cNum, rNum);
				String testData = reader.getCellData(prop.getProperty("TestDataSheetName"), cNum, rNum);// without hash
																										// table
				// implementation
				String colName = reader.getCellData(prop.getProperty("TestDataSheetName"), cNum, colsStartColNum);
				table.put(colName, testData);
			}
			data[i][0] = table;
			i++;
		}
		return data;
	}
}
