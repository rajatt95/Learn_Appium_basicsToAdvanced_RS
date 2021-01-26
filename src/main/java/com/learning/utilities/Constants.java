package com.learning.utilities;

public class Constants {

	public static final String APPIUM_Server_URL = "http://127.0.0.1:4723/wd/hub";

	public static final String APP_Location = ".\\src\\main\\resources\\apps\\";

	public static final String Automation_Name = "uiautomator2";
	public static final String New_Command_TimeOut = "15";

	public static final String reportingPath = ".\\target\\surefire-reports\\html\\";

	public static final String ExtentReportPath = ".\\target\\surefire-reports\\ExtentReports\\htmlreport.html";

	// Commands
	public static final String StartEmulator_File = ".\\src\\main\\resources\\startEmulator.bat";
	public static final String Command_KillNodes = "taskkill /f /im node.exe";

	// Properties Files
	public static final String Properties_Files_Location = ".\\src\\main\\resources\\properties\\";
	public static final String Properties_Files_Extension = ".properties";

	public static final String Properties_File_Global = "global";
	public static final String Properties_File_Device = "android_device";

	public static final String Properties_File_Env = "environment";

	public static final int implicitWait = 10;

	public static final String Jenkins_Parameter_DeviceName = "DeviceName";
}
