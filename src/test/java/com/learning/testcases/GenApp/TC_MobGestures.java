
package com.learning.testcases.GenApp;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learning.GenApp.pages.GenApp_CheckOutPage;
import com.learning.GenApp.pages.GenApp_FormPage;
import com.learning.base.TestBase_Install_App_EveryTime;
import com.learning.utilities.Utilities;
import com.learning.utilities.Properties_Keys;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC_MobGestures extends TestBase_Install_App_EveryTime {

	@Test
	public void Sprint_AmountValidation() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities(Properties_Keys.Global_Key_GenStore_App);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		formsPage_searchForItems(driver);

		productsPage_select_itemsAndValidatePrice(driver);

		checkOutPage_do_Gestures_TapAndLongPress(driver);

	}

	private static void checkOutPage_do_Gestures_TapAndLongPress(AndroidDriver<AndroidElement> driver) {

		GenApp_CheckOutPage checkOutPage = new GenApp_CheckOutPage(driver);
		String amount_1 = checkOutPage.productPrice.get(0).getText();
		double amount_1_value = getAmount(amount_1);

		String amount_2 = checkOutPage.productPrice.get(1).getText();
		double amount_2_value = getAmount(amount_2);

		double expectedTotalAmountValue = amount_1_value + amount_2_value;
		System.out.println("expectedTotalAmountValue: " + expectedTotalAmountValue);

		String actualTotalAmount = checkOutPage.totalAmountLabel.getText();
		actualTotalAmount = actualTotalAmount.substring(1);
		double actualTotalAmountValue = Double.parseDouble(actualTotalAmount);
		System.out.println("actualTotalAmountValue: " + actualTotalAmountValue);
		Assert.assertEquals(actualTotalAmountValue, expectedTotalAmountValue, "Validation for amount of items");

		// Mobile Gestures

		TouchAction touchAction = new TouchAction(driver);
		WebElement checkBox = checkOutPage.getCheckBox();
		touchAction.tap(tapOptions().withElement(element(checkBox))).perform();

		WebElement termsAndConditions = checkOutPage.getTermsAndConditions();

		touchAction.longPress(longPressOptions().withElement(element(termsAndConditions)).withDuration(ofSeconds(2)))
				.release().perform();

		checkOutPage.termsAndConditions_CloseBtn.click();
		checkOutPage.proceedBtn.click();

		holdScript(5);
	}

	private static void productsPage_select_itemsAndValidatePrice(AndroidDriver<AndroidElement> driver) {

		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		holdScript(2);

		/*
		 * GenApp_ProductsPage productsPage = new GenApp_ProductsPage(driver);
		 * System.out.println("productsPage.addToCart: " + productsPage.addToCart);
		 * productsPage.addToCart.get(0).click(); productsPage.addToCart.get(0).click();
		 * productsPage.btnCart.click(); holdScript(2);
		 */
	}

	private static void formsPage_searchForItems(AndroidDriver<AndroidElement> driver) {
		GenApp_FormPage formPage = new GenApp_FormPage(driver);

		// Both ways are recommended
		// formPage.nameField.sendKeys("Hello");
		formPage.getNameField().sendKeys("Hello");

		formPage.femaleOption.click();
		formPage.country.click();

		Utilities commonFunctions = new Utilities(driver);
		commonFunctions.scrollToText("Australia");

		WebElement australia = commonFunctions.getElementWithDynamicXpathWhileScroll("Australia");
		australia.click();

		formPage.letsShop.click();
	}

	public static double getAmount(String value) {
		value = value.substring(1);
		return Double.parseDouble(value);

	}
}
