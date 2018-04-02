package com.innroad.inncenter.Implementation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.Interface.IRateQuote;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_RateQuote;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RateQuote implements IRateQuote {


	public void searchDetails(WebDriver driver,ExtentTest test, String RateQuoteNights,
			String RateQuoteAdults, String RateQuoteChildren,
			String RateQuoteRatePlanList, String RateQuotePromoCode) {
		
		Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		
		RateQuotePage.Click_Arrive_DatePicker.click();
		RateQuotePage.Click_Today.click();
		test.log(LogStatus.PASS, "Clicked on Today in datepicker");
		RateQuotePage.Enter_RateQuoteNights.clear();
		RateQuotePage.Enter_RateQuoteNights.sendKeys(RateQuoteNights);
		test.log(LogStatus.PASS, "Number of Rate Quote nights : "+RateQuoteNights);
		RateQuotePage.Enter_RateQuoteAdults.clear();
		RateQuotePage.Enter_RateQuoteAdults.sendKeys(RateQuoteAdults);
		test.log(LogStatus.PASS, "Number of Rate Quote adults : "+RateQuoteAdults);
		RateQuotePage.Enter_RateQuoteChildren.clear();
		RateQuotePage.Enter_RateQuoteChildren.sendKeys(RateQuoteChildren);
		new Select (RateQuotePage.Select_RateQuoteRatePlanList).selectByVisibleText(RateQuoteRatePlanList);
		test.log(LogStatus.PASS, "Number of Rate Quote children : "+RateQuoteChildren);
		RateQuotePage.Enter_RateQuotePromoCode.sendKeys(RateQuotePromoCode);
		test.log(LogStatus.PASS, "Number of Rate Quote promocode : "+RateQuotePromoCode);		
	}


	public void clearRateQuoteDetails(WebDriver driver,ExtentTest test) {
		
		Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		
		RateQuotePage.Click_clearRateQuote.clear();
		
		
	}

	
	public void SearchRateQuoteDetails(WebDriver driver,ExtentTest test) {
		
      Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		
		RateQuotePage.Click_searchRateQuote.click();
		test.log(LogStatus.PASS, "Click Search");
		Wait.explicit_wait_xpath(OR.Verify_Room_Grid);
	}



	public void clickBookicon(WebDriver driver,ExtentTest test) throws InterruptedException {
		
		
	      Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		 /* String Propertyid= RateQuotePage.Get_Property_Id.getAttribute("propertyid");
		  System.out.println(Propertyid);*/
	      RateQuotePage.Click_First_Book_Icon.click();
	      test.log(LogStatus.PASS, "Click on Book");
	      try
			{
				Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
			}
			catch(Exception e)
			{
				System.out.println("Rules Satisfied");
			}
			Wait.wait5Second();
			if(RateQuotePage.Verify_RulesBroken_Popup.isDisplayed())
			{
				RateQuotePage.Click_Rate_Quote_Book.click();
				test.log(LogStatus.PASS, "Click on Book");
				Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
				Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			}
			else
			{
				System.out.println("Satisfied Rules");
			}
			
		     try
		      {
		    	  Wait.explicit_wait_xpath(OR.Verify_OverBook_popup);
		      }
		      catch(Exception e)
				{
					System.out.println("Rooms are available");
				}
		     Wait.wait5Second();
		     if(RateQuotePage.Verify_OverBook_popup.isDisplayed())
				{
					RateQuotePage.Click_Continue_OverBook_Popup.click();
					test.log(LogStatus.PASS, "Click on Over Book");
					Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
					Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
				}
				else
				{
					System.out.println("Satisfied Rules");
				}
			
	
		
	}

	
	
	public void clickQuoteIcon(WebDriver driver,ExtentTest test) throws InterruptedException {
		
		
	      Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		 /* String Propertyid= RateQuotePage.Get_Property_Id.getAttribute("propertyid");
		  System.out.println(Propertyid);*/
	      RateQuotePage.Click_First_Quote_Icon.click();
	      test.log(LogStatus.PASS, "Click on Quote");
	      try
			{
				Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
			}
			catch(Exception e)
			{
				System.out.println("Rules Satisfied");
			}
			Wait.wait3Second();
			if(RateQuotePage.Verify_RulesBroken_Popup.isDisplayed())
			{
				RateQuotePage.Click_First_Quote_Icon.click();
				 test.log(LogStatus.PASS, "Click on Quote");
				Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
				Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			}
			else
			{
				System.out.println("Satisfied Rules");
			}
			
		     try
		      {
		    	  Wait.explicit_wait_xpath(OR.Verify_OverBook_popup);
		      }
		      catch(Exception e)
				{
					System.out.println("Rooms are available");
				}
		     Wait.wait3Second();
		     if(RateQuotePage.Verify_OverBook_popup.isDisplayed())
				{
					RateQuotePage.Click_Continue_OverBook_Popup.click();
					test.log(LogStatus.PASS, "Click on Over Book");
					Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
					Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
				}
				else
				{
					System.out.println("Satisfied Rules");
				}
		     try{
		    	 
		    	 Select sel = new Select(driver.findElement(By.xpath(OR.Get_QuoteReservation_Status)));
		    	 
		    	 WebElement ele=sel.getFirstSelectedOption();
		    
		    	 String str=ele.getText();
		    	System.out.println(str);
		    	assertTrue(str.equalsIgnoreCase("Quote"));
		    	test.log(LogStatus.PASS, "Reservation status : "+str);
		     }catch(Exception e)
				{
		    	 e.printStackTrace();
					System.out.println("Reservation status is not Quote");
				}
			
	
		
	}

	
}
