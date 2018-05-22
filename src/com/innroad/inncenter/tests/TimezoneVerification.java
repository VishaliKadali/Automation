package com.innroad.inncenter.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Create_Reservation;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.WebElementsLogin;
import com.relevantcodes.extentreports.LogStatus;

public class TimezoneVerification extends TestCore{

	
//	1.login
//	2.navigate to setup and change timezone and publish
//	3.navigate to admin and change timezone and publish
//	4.logout
//	5.login
//	6.create reservation and verify toaster message
	
//	7.Repeat step-2 - 6 for 10 times
	

	 @Test(dataProvider="getData")
	 public void Create_Reservation(String url, String ClientCode, String Username, String Password,
				String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
				String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
				String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
				String Account, String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber,
				String ExpiryDate, String BillingNotes, String PropertyName, String Nights, String Adults, String Children,
				String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber,
				String Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
				String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData
				
				) throws InterruptedException, IOException
		{
		 test = extent.startTest("Timezone", "Timezone").assignCategory("Reservations")
					.assignCategory("Regression");

			String testName = test.getTest().getName().toUpperCase();
           for(int i=0; i<=32; i++)
           {
            app_logs.info("current count "+i);
		    Reservation res = new Reservation();
		    String seloption1;
		    String seloption2;
			try {
				Login LOGIN = new Login();
				LOGIN.login(driver, url, ClientCode, Username, Password);
			    app_logs.info("Logged into the application");
			} catch (Exception e) {
				Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
			}
	    	 
	    	 Navigation Nav= new Navigation();
	    	 Nav.Setup(driver);
	    	 Nav.Properties(driver);
	    	 
//	    	 click on property
	    	 driver.findElement(By.xpath("//*[@id='MainContent_dgPropertyList']/tbody//a")).click();
	    	 
//			 click on options
	    	 driver.findElement(By.id("MainContent_btnPropertyAdvance")).click();
	    	 
//	    	 Time zone drop-down object
	    	 WebElement  propTimeZone=driver.findElement(By.id("MainContent_drpTimeZone"));
	    	 Utility.ScrollToElement(propTimeZone);
	    	 Wait.wait2Second();
//	    	 Select object
	    	 Select obj1=new Select(propTimeZone);
	    	 obj1.selectByIndex(i);
	    	 Wait.wait2Second();
	    	 seloption1=obj1.getFirstSelectedOption().getText();
	 
//	    	 Click on publish button
	    	 driver.findElement(By.id("MainContent_btnPublish")).click();
	    	 Wait.wait2Second();
	    	 
	    	
//	    	 Navigate to admin module
	    	 Nav.Admin(driver);
	    	 
//	    	 Navigate to Client Info
	    	 Nav.Clientinfo(driver);
	    	 
//	    	 Click on client link
	    	 driver.findElement(By.xpath("//*[@id='MainContent_dgClientList']/tbody//a")).click();
	    	 
//	    	 Click on Options tab
	    	 driver.findElement(By.id("MainContent_btnClientOption")).click();
	    	 driver.navigate().refresh();
	    	 Wait.wait2Second();
//	    	 Time zone drop-down object
	    	 WebElement  clientTimeZone=driver.findElement(By.id("MainContent_drpTimeZone"));
	    	 
//	    	 Select object
	    	 Select obj2=new Select(clientTimeZone);
	    	 
	    	 obj2.selectByIndex(i);
	    	 Wait.wait2Second();
	    	 seloption2= obj2.getFirstSelectedOption().getText();
//	    	 Click on done button
	    	 driver.findElement(By.xpath("//input[@value='Save']")).click();
	    	 Wait.wait2Second();
	    	 app_logs.info("seloption in property "+seloption1+"client"+seloption2);
	    	 
	    	 
	    	 
//	    	 Click on user-initials 
	    	 driver.findElement(By.id("Span1")).click();
	    	 driver.findElement(By.xpath("//ul[@class='user_des_hide']//a[text()='Logout']")).click();
	    	 WebElementsLogin wl = new WebElementsLogin(driver);
	    	 Wait.explicit_wait_visibilityof_webelement(wl.userID);
	    	
	    	 try {
					Login LOGIN = new Login();
					LOGIN.login(driver, url, ClientCode, Username, Password);
					app_logs.info("Logged into the application");
				} catch (Exception e) {
					Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
				}
	    
	    	 
	    	 try {
	    		 Wait.wait2Second();
	 			res.clickNewReservationButton(driver);
	 			app_logs.info("Clicked new Reservation button");
	 		} catch (Exception e) {
	 			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewReservation");
	 		} catch (Error e) {
	 			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewReservation");
	 		}
	    	 
	    	 
	    	 try {

	 			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	 			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
	 					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
     			res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign,
	 					RoomClassName, RoomNumber);
	 			Wait.wait1Second();
//	 			driver.findElement(By.xpath("//a[text()='Guest Info']")).click();
//	 			Wait.wait2Second();
//	 			 Utility.ScrollToElement(driver.findElement(By.xpath("(//input[contains(@data-bind,'UseMailingInfo')])[1]")));
//		    	 Wait.wait2Second();
//	 			driver.findElement(By.xpath("(//input[contains(@data-bind,'UseMailingInfo')])[1]")).click();
	 			Wait.wait2Second();
	 			res.saveReservation(driver);
	 		
	 			test.log(LogStatus.PASS, "Entered required fields and saved the reservation for timezone"+seloption1);
	 			app_logs.info("Entered required fields and saved the reservation");
	 		} catch (Exception e) {
	 			Utility.captureScreenShot(seloption1, driver);
	 			 test.log(LogStatus.FAIL, "seloption in property "+seloption1+" client "+seloption2+" "+e+" " + "," +" <br> <b> Exception Details: </b>" + 
		                    "<br> <b> Attaching screenshot below : </b>" + test.addScreenCapture(Utility.captureScreenShot(testName + "_" + seloption1.replace(":", "") + "_" + Utility.getTimeStamp(), driver)));
	 			app_logs.error(" seloption in property "+seloption1+"client"+seloption2+e+"");
	 		}

	    	 
//	    	 Click on user-initials 
	    	 driver.findElement(By.id("name1")).click();
	    	 driver.findElement(By.xpath("//ul[@class='user_des_hide']//a[text()='Logout']")).click();
	    	 Wait.explicit_wait_visibilityof_webelement(wl.userID);
	    	 
	
	    	 
		}
		}
	 
	 @DataProvider
		public Object [][] getData(){
			return Utility.getData("Timezone",excel);
		}
}
