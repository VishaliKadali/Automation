package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;

public class loginLoad extends TestCore {
	
	

	@BeforeTest
	public void checkRunMode() {
		PropertyConfigurator.configure("Log4j.properties");

		if (!Utility.isExecutable("NavigationFlow", excel))
			throw new SkipException("Skipping the test");

	}

	@Test(dataProvider = "getData")
	public void loginLoad(String url, String ClientCode, String Username, String Password)
			throws InterruptedException, IOException {	
		Login LOGIN = new Login();
		long startTime = System.currentTimeMillis();
		LOGIN.login(driver, url, ClientCode, Username, Password);
		Wait.explicit_wait_xpath("//small[.='Items Per Page']");
		long endTime = System.currentTimeMillis();
		double waittime = 0.12;
		Wait.waitforloadpage(startTime, endTime, waittime);
	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided

		return Utility.getData("loginLoad", excel);
	}

}
