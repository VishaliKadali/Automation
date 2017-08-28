package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;

public class TapechartInitialLoad  extends testCore {
	
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("BasicSearch", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}
	 
	 @Test(dataProvider="getData", groups="Somke")
		public void tapechartInitialLoad(String url,String ClientCode, String Username, String Password,String PropertyName) throws InterruptedException, IOException
		{
		 
		 Login LOGIN = new Login();
    	 LOGIN.login(driver,url, ClientCode, Username, Password);
    	 
    	 Navigation nav = new Navigation();
    	 long startTime = System.currentTimeMillis();
    	 nav.TapeChart(driver);
    	 long endTime   = System.currentTimeMillis();
    	 long totalTime = endTime - startTime;
     	System.out.println(totalTime);
		 
		}
	 
	
	 @DataProvider
		public Object [][] getData(){
			//return test data from the sheetname provided
			
			return Utility.getData("TapechartInitialLoad",excel);
		}


}
