package com.learning.GenApp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GenApp_CheckOutPage {

	// Concatenate Driver
	public GenApp_CheckOutPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	/* @iOSXCUITFindBy */
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productPrice;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement btnCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmountLabel;

	@AndroidFindBy(xpath = "//*[@text='Please read our terms of conditions']")
	private WebElement termsAndConditions;

	public WebElement getTermsAndConditions() {
		return termsAndConditions;
	}

	@AndroidFindBy(id = "android:id/button1")
	public WebElement termsAndConditions_CloseBtn;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	public WebElement proceedBtn;

	
	

	@AndroidFindBy(uiAutomator = "text(\"Send me e-mails on discounts related to selected products in future\")")
	private WebElement checkBox;

	public WebElement getCheckBox() {
		return checkBox;
	}

}
