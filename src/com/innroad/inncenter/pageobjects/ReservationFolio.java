package com.innroad.inncenter.pageobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.interfaces.INavigation;
import com.innroad.inncenter.interfaces.IReservationFolio;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.relevantcodes.extentreports.LogStatus;

public class ReservationFolio implements IReservationFolio {

	public String GetPaymentMethod;
	public String giftCardnumber;
	public static Logger resFolioLogger = Logger.getLogger("ReservationFolio");

	public void paymentMethod(WebDriver driver, String PaymentType, String CardName, String CCNumber, String CCExpiry,
			String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData)
			throws InterruptedException {

		Elements_Reservation ReservationFolio = new Elements_Reservation(driver);

		ReservationFolio.Click_Pay_Button.click();
		resFolioLogger.info("Clicked on Pay button");
		TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount,
				ChangeAmountValue, traceData);

	}

	public void TestPaymentPopup(WebDriver driver, String PaymentType, String CardName, String CCNumber,
			String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue,
			String traceData) throws InterruptedException {
		Elements_Reservation ReservationFolio = new Elements_Reservation(driver);

		Wait.explicit_wait_xpath(OR.Verify_Payment_Details_poup);
		Wait.wait10Second();

		if (PaymentType.equalsIgnoreCase("Cash")) {
			try {
				new Select(ReservationFolio.Select_Paymnet_Method).selectByVisibleText(PaymentType);
				resFolioLogger.info("Payment is processing with CASH mode");
				Wait.wait3Second();
				if (ChangeAmount.equalsIgnoreCase("Yes")) {
					// ReservationFolio.Change_Amount.clear();
					// Wait.wait3Second();
					// ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);
					ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"), ChangeAmountValue);

				} else {
					resFolioLogger.info("Processed complete amount");
				}
				ReservationFolio.Click_ADD_Button.click();
				resFolioLogger.info("Clicked on ADD button");
				Wait.explicit_wait_xpath(OR.Verify_Guest_Ledger);
				Wait.wait3Second();
				try {
					GetPaymentMethod = ReservationFolio.Get_Payment_Method.getText();
					resFolioLogger.info("PaymentMethod: " + " " + GetPaymentMethod);
				} catch (Exception e) {
					TestCore.test.log(LogStatus.FAIL, "Payment verification failed \n"  + e.getMessage() + 
							"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_Verification" + Utility.getTimeStamp(), driver)));
					resFolioLogger.info("Payment verification failed \n");
					e.printStackTrace();
				}
				try {
					if (GetPaymentMethod.equalsIgnoreCase(PaymentType)) {
						resFolioLogger.info("Paymnet is Successful");
					} else {
						resFolioLogger.info("Paymnet is Failed");
					}
				} catch (Exception e) {
					TestCore.test.log(LogStatus.FAIL, "Payment verification failed \n"  + e.getMessage() + 
							"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_Verification" + Utility.getTimeStamp(), driver)));
					resFolioLogger.info("Payment verification failed \n");
					e.printStackTrace();
				}
				ReservationFolio.Click_Continue.click();
				resFolioLogger.info("Clicked on continue button of Payment popup");
				Wait.wait15Second();
				Wait.explicit_wait_xpath(OR.Verify_Line_item);
				String GetBalance = ReservationFolio.Verify_Balance_Zero.getText();
//				resFolioLogger.info("Balance: " + " " + GetBalance);
				String RemoveCurreny[] = GetBalance.split(" ");
				resFolioLogger.info("Pending balance after payment: " + " " + RemoveCurreny[1]);

				if (ChangeAmount.equalsIgnoreCase("NO")) {
					if (RemoveCurreny[1].equals("0.00"))
						;
				} else {
					resFolioLogger.info("Selected Changed Value");
				}
			} catch (Exception e) {
				TestCore.test.log(LogStatus.FAIL, "Exception occured while paying using CASH \n"  + e.getMessage() + 
						"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_ByCash" + Utility.getTimeStamp(), driver)));
				resFolioLogger.info("Exception occured while paying using CASH \n");
				e.printStackTrace();
			}
		} else if (PaymentType.equalsIgnoreCase("MC")) {
			try {

				new Select(ReservationFolio.Select_Paymnet_Method).selectByVisibleText(PaymentType);
				Wait.wait3Second();
				ReservationFolio.Click_Card_info.click();
				resFolioLogger.info("Clicked on card info");
				Wait.explicit_wait_xpath(OR.Verify_payment_info_popup);
				Wait.wait3Second();
				ReservationFolio.Enter_Card_Name.sendKeys(CardName);
				ReservationFolio.Enter_Account_Number_Folio.sendKeys(CCNumber);
				ReservationFolio.Enter_CC_Expiry.sendKeys(CCExpiry);
				ReservationFolio.Enter_CVVCode.sendKeys(CCVCode);
				resFolioLogger.info("Entered Card Details");
				ReservationFolio.Click_OK.click();
				resFolioLogger.info("Clicked on OK button");
				Wait.wait10Second();
				new Select(ReservationFolio.Select_Authorization_type).selectByVisibleText(Authorizationtype);
				resFolioLogger.info("Selected authorization type");
				if (ChangeAmount.equalsIgnoreCase("Yes")) {
					/*
					 * ReservationFolio.Change_Amount.clear();
					 * Wait.wait3Second();
					 * ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue
					 * );
					 */
					ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"), ChangeAmountValue);
				} else {
					resFolioLogger.info("Processed complete amount");
				}
				ReservationFolio.Click_Process.click();
				resFolioLogger.info("Clicked on Process Button");
				Wait.wait3Second();
				Wait.explicit_wait_xpath(OR.Verify_MC_Grid);
				String GetPaymentMethod = ReservationFolio.GetMC_Payment_Method.getText();
				resFolioLogger.info("PaymentMethod: " + " " + GetPaymentMethod);
				if (GetPaymentMethod.equals(PaymentType)) {
					resFolioLogger.info("Paymnet is successful");
				} else {
					resFolioLogger.info("Paymnet is Failed");
				}
				ReservationFolio.Click_Continue.click();
				resFolioLogger.info("Clicked on continue button");
				Wait.wait3Second();
				Wait.explicit_wait_xpath(OR.GetAddedLine_MC);
				String GetMCCard = ReservationFolio.GetAddedLine_MC.getText();
				resFolioLogger.info("Transaction Line Item: " + GetMCCard);
				if (GetMCCard.equalsIgnoreCase("Name: MC Account #: XXXX5454 Exp. Date: 08/21")) {
					resFolioLogger.info("Paymnet is successful");
				} else {
					resFolioLogger.info("Paymnet is Failed");
				}
				String GetBalance = ReservationFolio.Verify_Balance_Zero.getText();
//				resFolioLogger.info("Balance: " + " " + GetBalance);
				String RemoveCurreny[] = GetBalance.split(" ");
				resFolioLogger.info("Pending balance after payment: " + " " + RemoveCurreny[1]);
				if (ChangeAmount.equalsIgnoreCase("No")) {
					if (RemoveCurreny[1].equals("0.00"))
						;
				} else {
					resFolioLogger.info("Selected Changed Value");
				}
			} catch (Exception e) {
				TestCore.test.log(LogStatus.FAIL, "Exception occured while paying using MC \n"  + e.getMessage() + 
						"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_ByMC" + Utility.getTimeStamp(), driver)));
				resFolioLogger.info("Exception occured while paying using MC \n");
				e.printStackTrace();
			}

		} else if (PaymentType.equalsIgnoreCase("Swipe")) {
			try {

				ReservationFolio.Click_Swipe_Icon.click();
				resFolioLogger.info("Clicked on swipe icon");
				Wait.explicit_wait_xpath(OR.Verify_Swipe_Popup);
				ReservationFolio.Enter_Track_Data.sendKeys(traceData);

				if (ChangeAmount.equalsIgnoreCase("Yes")) {
					ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"), ChangeAmountValue);

				} else {
					resFolioLogger.info("Processed complete amount");
				}
				Wait.wait3Second();
				new Select(ReservationFolio.Select_Authorization_type).selectByVisibleText(Authorizationtype);
				Wait.wait3Second();
				ReservationFolio.Click_Process.click();
				resFolioLogger.info("Clicked on Process Button");
				Wait.wait3Second();
				Wait.explicit_wait_xpath(OR.Verify_MC_Grid);
				String GetPaymentMethod = ReservationFolio.GetMC_Payment_Method.getText();
				resFolioLogger.info("PaymentMethod: " + " " + GetPaymentMethod);
				if (GetPaymentMethod.equals("MC")) {
					resFolioLogger.info("Paymnet is successful");
				} else {
					resFolioLogger.info("Paymnet is failed");
				}
				ReservationFolio.Click_Continue.click();
				resFolioLogger.info("Clicked on continue button");
				Wait.wait3Second();
				Wait.explicit_wait_xpath(OR.GetAddedLine_MC);
				String GetMCCard = ReservationFolio.GetAddedLine_MC.getText();
				resFolioLogger.info("CardType: " + " " + GetMCCard);
				if (GetMCCard.equals("Name: TEST CARD/MC Account #: XXXX5454 Exp. Date: 12/23")) {
					resFolioLogger.info("Paymnet is successful");
				} else {
					resFolioLogger.info("Paymnet is failed");
				}
				
				Wait.wait5Second();
				Wait.waitUntilPresenceOfElementLocated(OR.Click_Close);
				driver.findElement(By.xpath(OR.Click_Close)).click();
				resFolioLogger.info("Clicked on CLOSE button of Guest Statement Report");
				
				
				Wait.wait3Second();
				String GetBalance = ReservationFolio.Verify_Balance_Zero.getText();
//				resFolioLogger.info("Balance: " + " " + GetBalance);
				String RemoveCurreny[] = GetBalance.split(" ");
				resFolioLogger.info("Balance: " + RemoveCurreny[1]);
				if (ChangeAmount.equalsIgnoreCase("NO")) {
					if (RemoveCurreny[1].equals("0.00"))
						;
				} else {
					resFolioLogger.info("Selected Changed Value");
				}
			} catch (Exception e) {
				TestCore.test.log(LogStatus.FAIL, "Exception occured while paying using swipe \n"  + e.getMessage() + 
						"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_BySwipe" + Utility.getTimeStamp(), driver)));
				resFolioLogger.error("Exception occured while paying using swipe \n");
				e.printStackTrace();
			}
		}
	}

	public void Paytype_CP_Account(WebDriver driver, String ChangeAmount, String ChangeAmountValue)
			throws InterruptedException {
		Elements_Reservation ReservationFolio = new Elements_Reservation(driver);
		ReservationFolio.Click_Pay_Button.click();
		Wait.explicit_wait_xpath(OR.Verify_Payment_Details_poup);
		Wait.wait10Second();
		new Select(ReservationFolio.Select_Paymnet_Method).selectByIndex(1);
		Wait.wait3Second();
		if (ChangeAmount.equalsIgnoreCase("Yes")) {
			// ReservationFolio.Change_Amount.clear();
			// Wait.wait3Second();
			// ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);
			ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"), ChangeAmountValue);

		} else {
			resFolioLogger.info("Processed complete amount");
		}
		ReservationFolio.Click_ADD_Button.click();
		Wait.explicit_wait_xpath(OR.Verify_Guest_Ledger);
		Wait.wait3Second();
		try {
			GetPaymentMethod = ReservationFolio.Get_Payment_Method.getText();
			resFolioLogger.info("PaymentMethod: " + " " + GetPaymentMethod);
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Payment verification failed \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_Verification" + Utility.getTimeStamp(), driver)));
			resFolioLogger.info("Payment verification failed \n");
			e.printStackTrace();
		}
		try {
			if (GetPaymentMethod.equals("account")) {
				resFolioLogger.info("Paymnet Success");
			} else {
				resFolioLogger.info("Paymnet Failed");
			}
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Payment verification failed \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_Verification" + Utility.getTimeStamp(), driver)));
			resFolioLogger.info("Payment verification failed \n");
			e.printStackTrace();
		}
		ReservationFolio.Click_Continue.click();
		Wait.wait15Second();
		try {
			Wait.explicit_wait_xpath(OR.Verify_CP_Lineitem);
			String GetBalance = ReservationFolio.Verify_Balance_Zero.getText();
//			resFolioLogger.info(GetBalance + " " + GetBalance);
			String RemoveCurreny[] = GetBalance.split(" ");
			resFolioLogger.info("Balance after payment: " + RemoveCurreny[1]);
			if (ChangeAmount.equalsIgnoreCase("NO")) {
				if (RemoveCurreny[1].equals("0.00"))
					;
			} else {
				resFolioLogger.info("Selected Changed Value");
			}
		} catch (Exception e) {

		}
	}

	public void HouseAccount(WebDriver driver, String Accounttype, String HouseAccountName, String ChangeAmount,
			String ChangeAmountValue) throws InterruptedException {
		Elements_Reservation ReservationFolio = new Elements_Reservation(driver);
		ReservationFolio.Click_Pay_Button.click();
		Wait.explicit_wait_xpath(OR.Verify_Payment_Details_poup);
		Wait.wait10Second();
		new Select(ReservationFolio.Select_Paymnet_Method).selectByVisibleText(Accounttype);
		Wait.wait3Second();
		Wait.explicit_wait_xpath(OR.Verify_House_Account_Picker);
		ReservationFolio.Enter_Account_Res_Name.sendKeys(HouseAccountName);
		ReservationFolio.Click_Search_House_Acc.click();
		Wait.wait5Second();
		Wait.explicit_wait_xpath(OR.Verify_House_Account_Grid);
		Wait.wait10Second();
		ReservationFolio.Select_House_Acc.click();
		Wait.wait5Second();
		ReservationFolio.Click_Select_House_acc.click();
		Wait.wait10Second();
		new Select(ReservationFolio.Select_Paymnet_Method).selectByIndex(1);
		Wait.wait10Second();
		if (ChangeAmount.equalsIgnoreCase("Yes")) {
			// ReservationFolio.Change_Amount.clear();
			// Wait.wait3Second();
			// ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);
			ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"), ChangeAmountValue);

		} else {
			resFolioLogger.info("Processed complete amount");
		}
		ReservationFolio.Click_ADD_Button.click();
		Wait.explicit_wait_xpath(OR.Verify_Guest_Ledger);
		Wait.wait3Second();
		try {
			GetPaymentMethod = ReservationFolio.Get_Payment_Method.getText();
			resFolioLogger.info("PaymentMethod: " + " " + GetPaymentMethod);
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Payment verification failed \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_Verification" + Utility.getTimeStamp(), driver)));
			resFolioLogger.info("Payment verification failed \n");
			e.printStackTrace();
		}
		try {
			if (GetPaymentMethod.equals("account")) {
				resFolioLogger.info("Paymnet Success");
			} else {
				resFolioLogger.info("Paymnet Failed");
			}
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Payment verification failed \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_Verification" + Utility.getTimeStamp(), driver)));
			resFolioLogger.info("Payment verification failed \n");
			e.printStackTrace();
		}
		ReservationFolio.Click_Continue.click();
		Wait.wait15Second();
		try {
			Wait.explicit_wait_xpath(OR.Verify_CP_Lineitem);
			String GetBalance = ReservationFolio.Verify_Balance_Zero.getText();
//			resFolioLogger.info("Balance: " + " " + GetBalance);
			String RemoveCurreny[] = GetBalance.split(" ");
			resFolioLogger.info(RemoveCurreny[1]);
			if (ChangeAmount.equalsIgnoreCase("NO")) {
				if (RemoveCurreny[1].equals("0.00"))
					;
			} else {
				resFolioLogger.info("Selected Changed Value");
			}
		} catch (Exception e) {

		}
	}

	public void GiftCertificate(WebDriver driver, String Accounttype, String ChangeAmount, String ChangeAmountValue)
			throws InterruptedException {
		Elements_Reservation ReservationFolio = new Elements_Reservation(driver);
		ReservationFolio.Click_Pay_Button.click();
		Wait.explicit_wait_xpath(OR.Verify_Payment_Details_poup);
		Wait.wait10Second();
		new Select(ReservationFolio.Select_Paymnet_Method).selectByVisibleText(Accounttype);
		Wait.wait3Second();
		Wait.explicit_wait_xpath(OR.Verify_Gift_Account_popup);
		try {
			FileReader fr = new FileReader(".\\GiftCertificate.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((giftCardnumber = br.readLine()) != null) {
				ReservationFolio.Enter_Gift_ID.sendKeys(giftCardnumber);
			}
			br.close();
		} catch (IOException e) {
			resFolioLogger.info("File not found");
		}

		ReservationFolio.Click_Go_Gift.click();
		Wait.wait5Second();
		Wait.explicit_wait_xpath(OR.Verify_Gift_Certificate_Grid);
		Wait.wait10Second();
		ReservationFolio.Select_Gift_Certificate.click();
		Wait.wait5Second();
		ReservationFolio.Click_Select_Gift.click();
		Wait.wait10Second();
		new Select(ReservationFolio.Select_Paymnet_Method).selectByIndex(5);
		Wait.wait10Second();
		if (ChangeAmount.equalsIgnoreCase("Yes")) {
			// ReservationFolio.Change_Amount.clear();
			// Wait.wait3Second();
			// ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);
			ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"), ChangeAmountValue);

		} else {
			resFolioLogger.info("Processed complete amount");
		}
		ReservationFolio.Click_ADD_Button.click();
		Wait.explicit_wait_xpath(OR.Verify_Guest_Ledger);
		Wait.wait3Second();
		try {
			GetPaymentMethod = ReservationFolio.Get_Payment_Method.getText();
			resFolioLogger.info("PaymentMethod: " + GetPaymentMethod);
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Payment verification failed \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_Verification" + Utility.getTimeStamp(), driver)));
			resFolioLogger.info("Payment verification failed \n");
			e.printStackTrace();
		}
		try {
			if (GetPaymentMethod.equalsIgnoreCase("gift certificate")) {
				resFolioLogger.info("Paymnet Success");
			} else {
				resFolioLogger.info("Paymnet Failed");
			}
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Payment verification failed \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Payment_Verification" + Utility.getTimeStamp(), driver)));
			resFolioLogger.info("Payment verification failed \n");
			e.printStackTrace();
		}
		ReservationFolio.Click_Continue.click();
		Wait.wait15Second();
		try {
			Wait.explicit_wait_xpath(OR.Verify_CP_Lineitem);
			String GetBalance = ReservationFolio.Verify_Balance_Zero.getText();
//			resFolioLogger.info(GetBalance + " " + GetBalance);
			String RemoveCurreny[] = GetBalance.split(" ");
			resFolioLogger.info("Balance: " + RemoveCurreny[1]);
			if (ChangeAmount.equalsIgnoreCase("NO")) {
				if (RemoveCurreny[1].equals("0.00"))
					;
			} else {
				resFolioLogger.info("Selected Changed Value");
			}
		} catch (Exception e) {

		}
	}

}
