package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_TapeChart;

public class OpenExistingReser extends TestCore{
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("loginLoad", excel))
				throw new SkipException("Skipping the test");

			}
	 
	 @Test(dataProvider="getData")
	 public void loginLoad(String url,String ClientCode, String Username, String Password ) throws InterruptedException, IOException
		{
		 String ReservationName="Tax Exemption";
		 Login LOGIN = new Login();
		 LOGIN.login(driver,url, ClientCode, Username, Password);
	     Wait.explicit_wait_xpath("//small[.='Items Per Page']");
	     double waittime = 0.12;
	     Navigation nav= new Navigation();
  	     nav.TapeChart(driver);
  	     long startTime = System.currentTimeMillis();
  	     driver.findElement(By.xpath("//div[.='"+ReservationName+"']")).click();
  	     Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
	     long endTime   = System.currentTimeMillis();
		 Wait.waitforloadpage(startTime,endTime,waittime);
		
		}
				
     @DataProvider
				public Object [][] getData(){
					
					//return test data from the sheetname provided
					
					return Utility.getData("loginLoad",excel);
				}
}
