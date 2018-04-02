package com.innroad.inncenter.test;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Implementation.ReservationSearch;
import com.innroad.inncenter.Implementation.Tax;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.WebElements.Elements_Tax;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class Tax_And_TaxExempt extends testCore{

	//Before Test
	@BeforeTest
	public void checkRunMode(){
		PropertyConfigurator.configure("Log4j.properties");

		if(!Utility.isExecutable("TaxAndTaxExempt", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");	
	}



	// Create New Room Class
	@Test(dataProvider="getData", groups="Somke")
	public void taxAndTaxExempt(String url,String ClientCode, String Username, String Password,String MarketSegment,String Referral,String FirstName,String LastName,String Line1, String City, String State, String Country,String Postalcode,String Phonenumber, String PaymentMethod,String AccountNumber,String ExpiryDate,String BillingNotes,String Nights,String Adults,String Children,String CheckorUncheckAssign,String RoomClassName,String taxName,String displayName,String description,String value,String category,String taxLedgerAccount,String amount){
		
		Reservation res = new Reservation();
		String reservation = null;
		
		try{
			ExtentTest test = extent.startTest("taxAndTaxExempt", "taxAndTaxExempt")
					.assignCategory("taxAndTaxExempt")
					.assignCategory("Smoke");

			System.out.println("Executing: " + test.getTest().getName()+ " test.");

			// Login to InnCenter
			try{
				Login LOGIN = new Login();
				LOGIN.login(driver,url, ClientCode, Username, Password);
				test.log(LogStatus.PASS, "System successfully logged in the site");
			}catch(Exception e){
				System.out.println(e);
				test.log(LogStatus.FAIL, "System fail to login");
			}
			
			
			// Clicking on New Reservation
						try{
							res.clickNewReservationButton(driver);
							test.log(LogStatus.PASS, "Successfully clicked on New Reservation");
							System.out.println("successfully clicked on new reservation");
						}catch(Exception e){
							System.out.println("************* Failed to click new reservation **************");
							e.printStackTrace();
						}

						// fill the marketing info
						try{
							res.marketingInfo(driver, test,MarketSegment, Referral);
						
							System.out.println("successfully filled the market info");
						}catch(Exception e){
							System.out.println("************* Failed to fill the market info **************");
							e.printStackTrace();
						}
						
						


						// fill the contact info
						try{
							res.contactInformation(driver, test, FirstName, LastName, Line1, City, Country, State, Postalcode, Phonenumber);
						
							System.out.println("successfully filled the contact info");
						}catch(Exception e){
							System.out.println("************* Failed to fill the contact info **************");
							e.printStackTrace();
						}
						
						
						// Fill the payment info
						try{
							res.billingInformation(driver, test,PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
							System.out.println("successfully filled the payment info");
						}catch(Exception e){
							System.out.println("************* Failed to fill the payment info **************");
							e.printStackTrace();
						}
						
						
						//Fill the room details
						
						try{
							res.roomAssignment(driver, test, Nights, Adults, Children,  CheckorUncheckAssign, RoomClassName);
							System.out.println("successfully filled the room info");
						}catch(Exception e){
							System.out.println("************* Failed to fill the room info **************");
							e.printStackTrace();
						}
						
						//Validating tax exempt
						try{
							res.saveReservation(driver,test);
							reservation=res.GetReservationnumber(driver,test);
							res.vaidatePaymentDetails(driver, test);
							res.clickGuestInfo(driver,test);
							res.validateTaxExempt(driver, test);
							res.saveReservation(driver, test);
							res.click_Folio(driver, test);
							res.taxDetails(driver, test);
							
							
						}catch(Exception e){
							System.out.println("************* Failed to save reservation **************");
							e.printStackTrace();
						}
						
						try
						{
							Navigation Nav= new Navigation();
							Nav.Setup(driver);
							Assert.assertTrue("Fail to navigate Setup",Utility.return_element_status_after_explicit_wait(OR.Setup_Menu_Title));
							test.log(LogStatus.PASS, "Navigate Setup");
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Fail to navigate Setup"); 
						}	
						
						
						try
						{
							Navigation Nav= new Navigation();
							Nav.TaxesAfterCloseReservation(driver);
							Assert.assertTrue("Fail to navigate Taxes",Utility.return_element_status_after_explicit_wait(OR.Tax_Items_Title));
							test.log(LogStatus.PASS, "Navigate Taxes");
							Elements_Tax tax = new Elements_Tax(driver);
							tax.TaxNewItem.click();
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Fail to navigate Taxes"); 
						}
						
						try{
							Tax tax = new Tax();
							tax.createTax(driver, test, taxName, displayName, description, value, category, taxLedgerAccount);
							ReservationSearch resSearch = new ReservationSearch();
							resSearch.basicSearch_WithResNumber(driver,reservation);
							resSearch.uncheck_TaxExempt(driver, test);
							res.click_Folio(driver, test);
							res.saveReservation(driver, test);
							resSearch.addIncidentals(driver, test, taxLedgerAccount, amount);
							res.saveReservation(driver, test);
						}catch(Exception e){
							e.printStackTrace();
							test.log(LogStatus.FAIL, "Fail to create Tax"); 
						}	
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Data provider to read the data from excel
		@DataProvider
		public Object [][] getData(){

			//return test data from the sheetname provided

			return Utility.getData("Taxes and Tax Exempt",excel);
		}




}
