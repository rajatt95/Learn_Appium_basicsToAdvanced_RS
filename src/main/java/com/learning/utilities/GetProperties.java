package com.learning.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {

	public static String getPropertyValue(String propertiesFileName, String keyName) {
		FileInputStream fis = null;

		// FileName - ".\\src\\main\\resources\\properties\\"+"global"+".properties";
		String fileWithCompletePath = Constants.Properties_Files_Location + propertiesFileName
				+ Constants.Properties_Files_Extension;

		try {
			fis = new FileInputStream(fileWithCompletePath);
		} catch (FileNotFoundException fileNotFound_Exception) {
			fileNotFound_Exception.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException io_Exception) {
			io_Exception.printStackTrace();
		}
		
		System.out.println(keyName + " : " + properties.get(keyName));
		return properties.get(keyName).toString();
	}
}
