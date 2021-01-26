package com.learning.utilities;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "getDataForNameField")
	public Object[][] getData() {
		// 3 rows, 1 columns
		// 2-D Object Array
		Object[][] data = new Object[3][1];

		// 1st set
		data[0][0] = "Nishant";

		// 2nd set
		data[1][0] = "Rajat";

		// 3rd set
		data[2][0] = "Gautam";

		return data;
	}
}
