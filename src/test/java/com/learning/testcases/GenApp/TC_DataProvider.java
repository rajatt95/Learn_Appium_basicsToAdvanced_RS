
package com.learning.testcases.GenApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learning.GenApp.pages.GenApp_FormPage;
import com.learning.base.TestBase_Install_App_EveryTime;
import com.learning.utilities.Properties_Keys;
import com.learning.utilities.TestData;
import com.learning.utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC_DataProvider extends TestBase_Install_App_EveryTime {

	@Test(dataProvider = "getDataForNameField", dataProviderClass = TestData.class)
	public void Sprint_AmountValidation(String name) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities(Properties_Keys.Global_Key_GenStore_App);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		GenApp_FormPage formPage = new GenApp_FormPage(driver);

		// Both ways are recommended
		// formPage.nameField.sendKeys("Hello");
		formPage.getNameField().sendKeys(name);

		formPage.femaleOption.click();
		formPage.country.click();

		Utilities commonFunctions = new Utilities(driver);
		commonFunctions.scrollToText("Australia");

		WebElement australia = commonFunctions.getElementWithDynamicXpathWhileScroll("Australia");
		australia.click();

		formPage.letsShop.click();

	}

}
