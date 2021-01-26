package com.learning.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.learning.utilities.Constants;
import com.learning.utilities.GetProperties;
import com.learning.utilities.Properties_Keys;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TestBase_Install_App_EveryTime {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	/*
	 * @BeforeMethod public static void startServer() {
	 * 
	 * service = AppiumDriverLocalService.buildDefaultService(); service.start(); }
	 */

	public static void captureScreenshot(String testCaseName) {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(srcFile, new File(Constants.reportingPath + testCaseName + "_" + screenshotName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	@BeforeMethod
	public AppiumDriverLocalService startAppiumServer() {
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	@BeforeTest
	public void killAllNodes() {
		try {
			Runtime.getRuntime().exec(Constants.Command_KillNodes);
			holdScript(3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void startEmulator() {
		try {
			System.out.println("***************************************");
			System.out.println("Starting Emulator programatically");
			System.out.println("***************************************");
			Runtime.getRuntime().exec(Constants.StartEmulator_File);
			holdScript(6);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public static void stopServer() {
		System.out.println("Success");
		service.stop();
	}

	/** This is installing the app in the mobile everytime when we run the script */
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws MalformedURLException {

		String appNameFromPropertiesFile = GetProperties.getPropertyValue(Constants.Properties_File_Global, appName);
		File file = new File(Constants.APP_Location, appNameFromPropertiesFile);
		DesiredCapabilities capabilities = setCapabilities(file);
		driver = new AndroidDriver<AndroidElement>(new URL(Constants.APPIUM_Server_URL), capabilities);
		System.out.println("Started");
		return driver;
	}

	private static String handleDeviceNameValue() {

		String deviceName = "";

		String deviceNameFromJenkinsIfAny = Constants.Jenkins_Parameter_DeviceName;
		if (System.getenv(deviceNameFromJenkinsIfAny) != null && !System.getenv(deviceNameFromJenkinsIfAny).isEmpty()) {
			// browser value from Jenkins
			deviceName = System.getenv(deviceNameFromJenkinsIfAny);
			System.out.println("Device name is taken from Jenkins");
		} else {
			System.out.println("Device name is not taken from Jenkins");
			// browser value from config.properties file
			deviceName = "Rajat_Emulator";
			// GetProperties.getPropertyValue(Constants.Properties_File_Device,
			// Properties_Keys.Device_NAME);
		}

		// Setting the value of browser parameter in config.properties file
		System.setProperty(Properties_Keys.Device_NAME, deviceName);
		return System.getProperty(Properties_Keys.Device_NAME);
	}

	private static DesiredCapabilities setCapabilities(File file) {
		System.out.println("--------------------------------");
		// String deviceUDID =
		// GetProperties.getPropertyValue(Constants.Properties_File_Device,
		// Properties_Keys.Device_UDID);
		/*
		 * String deviceName =
		 * GetProperties.getPropertyValue(Constants.Properties_File_Device,
		 * Properties_Keys.Device_NAME);
		 */

		String deviceName = handleDeviceNameValue();

		String deviceAutomationName = GetProperties.getPropertyValue(Constants.Properties_File_Device,
				Properties_Keys.Device_Automation_Name);
		String deviceNewCommandTimeOut = GetProperties.getPropertyValue(Constants.Properties_File_Device,
				Properties_Keys.Device_NewCommandTimeOut);

		/*
		 * if (deviceUDID.contains("emulator")) { // startEmulator();
		 * System.out.println("Running on Emulator"); }
		 */

		System.out.println("--------------------------------");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, deviceAutomationName);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, deviceNewCommandTimeOut);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		// capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
		// Giving the location of app
		capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

		return capabilities;
	}

	public static void holdScript(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
