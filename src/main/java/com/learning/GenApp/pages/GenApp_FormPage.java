package com.learning.GenApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GenApp_FormPage {

	// Concatenate Driver
	public GenApp_FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	/* @iOSXCUITFindBy */
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(uiAutomator = "text(\"Female\")")
	public WebElement femaleOption;

	@AndroidFindBy(id = "android:id/text1")
	public WebElement country;

	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShop;



	public WebElement getNameField() {
		System.out.println("Trying to get name field");
		return nameField;
	}

}
