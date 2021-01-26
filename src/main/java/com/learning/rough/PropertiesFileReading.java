package com.learning.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.learning.utilities.Constants;
import com.learning.utilities.GetProperties;
import com.learning.utilities.Properties_Keys;

public class PropertiesFileReading {
	public static void main(String[] args) {

		GetProperties.getPropertyValue(Constants.Properties_File_Global, Properties_Keys.Global_Key_GenStore_App);
		GetProperties.getPropertyValue(Constants.Properties_File_Env, Properties_Keys.Env_Key_Dev);
		GetProperties.getPropertyValue(Constants.Properties_File_Env, Properties_Keys.Env_Key_Stg);
		GetProperties.getPropertyValue(Constants.Properties_File_Env, Properties_Keys.Env_Key_Int);

	}
}
