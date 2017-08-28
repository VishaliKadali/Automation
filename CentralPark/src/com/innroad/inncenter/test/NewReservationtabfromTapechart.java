package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_Reservation;
import com.innroad.inncenter.WebElements.Elements_TapeChart;

public class NewReservationtabfromTapechart extends testCore{
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("loginLoad", excel))
				throw new SkipException("Skipping the test");

			}
	 
	 @Test(dataProvider="getData")
	 public void loginLoad(String url,String ClientCode, String Username, String Password) throws InterruptedException, IOException
		{
		 
		 Login LOGIN = new Login();
		 LOGIN.login(driver,url, ClientCode, Username, Password);
	     Wait.explicit_wait_xpath("//small[.='Items Per Page']");
	     double waittime = 0.12;
	     Navigation nav= new Navigation();
    	 nav.TapeChart(driver);
    	 Elements_TapeChart TapeChart = new Elements_TapeChart(driver);
 		Wait.wait5Second();
 		WebElement ElementClick = driver.findElement(By.xpath(OR.Click_Unassigned_Tapechart));
 		long startTime = System.currentTimeMillis();
 		Actions action = new Actions(driver);
 		action.moveToElement(ElementClick).click(ElementClick).build().perform();
 		//TapeChart.Click_Unassigned_Tapechart.click();
 		Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
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