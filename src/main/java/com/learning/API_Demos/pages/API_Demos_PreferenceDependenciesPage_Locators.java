package com.learning.API_Demos.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class API_Demos_PreferenceDependenciesPage_Locators {

	// Concatenate Driver
	public API_Demos_PreferenceDependenciesPage_Locators(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	/* @iOSXCUITFindBy */
	@AndroidFindBy(id = "android:id/checkbox")
	public WebElement wifiCheckBox;

	@AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	public WebElement wifiSettings;

	@AndroidFindBy(className  = "android.widget.EditText")
	public WebElement wifiSettingsTextBox;
	
	@AndroidFindBy(className  = "android.widget.Button")
	public List<WebElement> buttons;

	
}
