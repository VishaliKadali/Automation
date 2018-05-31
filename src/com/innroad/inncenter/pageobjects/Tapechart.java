package com.innroad.inncenter.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.innroad.inncenter.interfaces.ITapeChart;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_TapeChart;

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
		
		Elements_TapeChart TapeChart = new Elements_TapeChart(driver);
		
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
		}
		
	}
	
	public void click_Unassigned(WebDriver driver) throws InterruptedException
	{
		Elements_TapeChart TapeChart = new Elements_TapeChart(driver);
//		WebElement ElementClick = driver.findElement(By.xpath(OR.Click_Unassigned_Tapechart));
	
	/*	Actions action = new Actions(driver);
		action.moveToElement(ElementClick).click(ElementClick).build().perform();
		action.moveToElement(ElementClick).click(ElementClick).build().perform();*/
		
		if(TestCore.targetBrowser.equalsIgnoreCase("firefox")){
			
			WebElement ElementClick = driver.findElement(By.xpath(OR.Click_Unassigned_Tapechart));
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", ElementClick);
			jse.executeScript("window.scrollBy(0,-400)", "");
			
			Actions action = new Actions(driver);
			action.moveToElement(ElementClick).click(ElementClick).build().perform();
//			action.moveToElement(ElementClick).click(ElementClick).build().perform();
			
		}else if(TestCore.targetBrowser.equalsIgnoreCase("chrome")){
			
			WebElement ElementClick = driver.findElement(By.xpath(OR.Click_Unassigned_Tapechart));
			
			Actions action = new Actions(driver);
			action.moveToElement(ElementClick).click(ElementClick).build().perform();
			action.moveToElement(ElementClick).click(ElementClick).build().perform();
		}
		
		//TapeChart.Click_Unassigned_Tapechart.click();
//		Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
		Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
	}
	
	public void Verify_BlackOutRoom(WebDriver driver) throws InterruptedException{
		
		Elements_TapeChart TapeChart = new Elements_TapeChart(driver);
		TapeChart.ReservationsLink.click();
		Wait.wait2Second();
		TapeChart.Tape_Chart.click();
		Wait.wait2Second();
		String blackout = TapeChart.BlackOutCell.get(0).getText();
		assertEquals(blackout, "B", "Vlaue does not match");
		TapeChart.NewQuote.click();
		Wait.wait2Second();
		TapeChart.DatePickerIcon.get(5).click();
		Wait.wait2Second();
		TapeChart.SelectDate.click();
		TapeChart.Quote_SearchButton.click();
		Wait.wait2Second();
		TapeChart.BookButton.get(0).click();
		Wait.wait2Second();
		assertEquals(TapeChart.BlackOutAlert.getText(), "Blackouts Alert!",
				"Blackout alert box does not display");
		TapeChart.Blackout_OkButton.click();
		Wait.wait2Second();
	}
	
}
