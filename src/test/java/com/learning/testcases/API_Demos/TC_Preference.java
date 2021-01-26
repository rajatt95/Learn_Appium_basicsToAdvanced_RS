package com.learning.testcases.API_Demos;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learning.API_Demos.pages.API_Demos_HomePage_Locators;
import com.learning.API_Demos.pages.API_Demos_PreferenceDependenciesPage_Locators;
import com.learning.API_Demos.pages.API_Demos_PreferencePage_Locators;
import com.learning.base.TestBase_Install_App_EveryTime;
import com.learning.utilities.Properties_Keys;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC_Preference extends TestBase_Install_App_EveryTime {

	@Test
	public void Sprint_ApiDemos_PreferenceValidation() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities(Properties_Keys.Global_Key_APIDemos_App);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		API_Demos_HomePage_Locators homePage = new API_Demos_HomePage_Locators(driver);
		homePage.preference.click();

		// driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference
		// dependencies']")).click();
		API_Demos_PreferencePage_Locators preferencePage = new API_Demos_PreferencePage_Locators(driver);
		preferencePage.preferenceDependencies.click();

		// driver.findElementById("android:id/checkbox").click();
		API_Demos_PreferenceDependenciesPage_Locators preferenceDependenciesPage = new API_Demos_PreferenceDependenciesPage_Locators(
				driver);
		preferenceDependenciesPage.wifiCheckBox.click();

		// driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		preferenceDependenciesPage.wifiSettings.click();

		// driver.findElementByClassName("android.widget.EditText").sendKeys("Hello
		// Shera");
		preferenceDependenciesPage.wifiSettingsTextBox.sendKeys("Hello Shera");

		// driver.findElementByXPath("//button[@text='OK']").click();
		// Clicking on the 2nd element
		// driver.findElementsByClassName("android.widget.Button").get(1).click();
		preferenceDependenciesPage.buttons.get(1).click();

		Assert.fail();
	}


}
