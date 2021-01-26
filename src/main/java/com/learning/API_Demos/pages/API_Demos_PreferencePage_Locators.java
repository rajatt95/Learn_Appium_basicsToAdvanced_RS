package com.learning.API_Demos.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class API_Demos_PreferencePage_Locators {

	// Concatenate Driver
	public API_Demos_PreferencePage_Locators(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	/* @iOSXCUITFindBy */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement preferenceDependencies;

}
