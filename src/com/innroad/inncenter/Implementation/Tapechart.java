package com.innroad.inncenter.Implementation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.innroad.inncenter.Interface.ITapeChart;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_TapeChart;

public class Tapechart implements ITapeChart {

	
	public void TapeChartSearch(WebDriver driver, String TapeChartAdults, String TapeChartChildrens, String PromoCode) throws InterruptedException {
		
		Elements_TapeChart TapeChart = new Elements_TapeChart(driver);
		Wait.wait5Second();
		TapeChart.Select_Arrival_Date.click();
		TapeChart.Click_Today.click();
		Wait.wait5Second();
		TapeChart.Enter_Adults_Tapehchart.sendKeys(TapeChartAdults);
		TapeChart.Enter_Children_Tapechart.sendKeys(TapeChartChildrens);
		TapeChart.Click_Tapechart_Rateplan.click();
		Wait.wait5Second();
		TapeChart.Select_Rack_Rate.click();
		Wait.wait3Second();
		TapeChart.Enter_promoCode_Tapechart.sendKeys(PromoCode);
		TapeChart.Click_Search_TapeChart.click();
		Wait.wait5Second();
		
		
		
		
		
	}


	public void click_availableRoomClass(WebDriver driver) throws InterruptedException {
		
		/*Elements_TapeChart TapeChart = new Elements_TapeChart(driver);
		
		TapeChart.Click_First_Available.click();
		Wait.wait3Second();
		if(TapeChart.Rules_Broken_popup.isDisplayed())
		{
			Wait.explicit_wait_xpath(OR.Rules_Broken_popup);
			
			TapeChart.Click_Book_icon_Tapechart.click();
		}
		else
		{
			System.out.println("Rules are not broken");
		}*/
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		try
		{
			WebElement availableCell=driver.findElement(By.xpath("//div[@class='tapechartdatecell Available RackRate']"));
			
		 if( availableCell.getText().equals("Available"))
	    	{
			 jse.executeScript("arguments[0].scrollIntoView(true);", availableCell);
			 jse.executeScript("arguments[0].click();", availableCell);
//			 driver.findElement(By.xpath("//div[@class='tapechartdatecell Available RackRate']")).click();
	    	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			try{
				WebElement availableCell1=driver.findElement(By.xpath("//div[@class='tapechartdatecell weekend Available RackRate']"));
				if(availableCell1.getText().equals("Available"))
				{
					jse.executeScript("arguments[0].scrollIntoView(true);", availableCell1);
					jse.executeScript("arguments[0].click();", availableCell1);
//					driver.findElement(By.xpath("//div[@class='tapechartdatecell weekend Available RackRate']")).click();
				}
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
	
	public void click_Unassigned(WebDriver driver) throws InterruptedException
	{
		Elements_TapeChart TapeChart = new Elements_TapeChart(driver);
		Wait.wait5Second();
		
		
		WebElement ElementClick = driver.findElement(By.xpath(OR.Click_Unassigned_Tapechart));
		Actions action = new Actions(driver);
		action.moveToElement(ElementClick).click(ElementClick).build().perform();
		//TapeChart.Click_Unassigned_Tapechart.click();
		Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
		Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
	}

}
