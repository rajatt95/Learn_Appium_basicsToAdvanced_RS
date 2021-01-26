
package com.learning.testcases.GenApp;

import java.net.MalformedURLException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.learning.base.TestBase_Install_App_EveryTime;

public class TC_SkipTest extends TestBase_Install_App_EveryTime {

	@Test
	public void Sprint_MobileTesting() throws MalformedURLException {

		throw new SkipException("Skipping this test case intentionally");
	}

}