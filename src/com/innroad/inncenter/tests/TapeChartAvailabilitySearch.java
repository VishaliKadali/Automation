package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class TapeChartAvailabilitySearch extends TestCore{
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("loginLoad", excel))
				throw new SkipException("Skipping the test");

			}
	 
	 @Test(dataProvider="getData")
	 public void loginLoad(String url,String ClientCode, String Username, String Password, String TapeChartAdults, String TapeChartChildrens, String PromoCode ) throws InterruptedException, IOException
		{
		 
		 Login LOGIN = new Login();
		 LOGIN.login(driver,url, ClientCode, Username, Password);
	     Wait.explicit_wait_xpath("//small[.='Items Per Page']");
	     double waittime = 0.12;
	     Navigation nav= new Navigation();
   	    nav.TapeChart(driver);
   	     Elements_TapeChart TapeChart = new Elements_TapeChart(driver);
		Wait.wait5Second();
		TapeChart.Select_Arrival_Date.click();
		TapeChart.Click_Today.click();
		Wait.wait5Second();
		driver.findElement(By.xpath("html/body/div[11]/div[1]/table/tbody/tr[6]/td[1]")).click();
		TapeChart.Enter_Adults_Tapehchart.sendKeys(TapeChartAdults);
		TapeChart.Enter_Children_Tapechart.sendKeys(TapeChartChildrens);
		TapeChart.Click_Tapechart_Rateplan.click();
		Wait.wait5Second();
		TapeChart.Select_Rack_Rate.click();
		Wait.wait3Second();
		TapeChart.Enter_promoCode_Tapechart.sendKeys(PromoCode);
		long startTime = System.currentTimeMillis();
		TapeChart.Click_Search_TapeChart.click();
	    Wait.explicit_wait_xpath("//div[.='# Rooms Available']");
	    long endTime   = System.currentTimeMillis();
		 Wait.waitforloadpage(startTime,endTime,waittime);
		
		}
				
      @DataProvider
				public Object [][] getData(){
					
					//return test data from the sheetname provided
					
					return Utility.getData("TapeChartAvailabilitySearch",excel);
				}
}