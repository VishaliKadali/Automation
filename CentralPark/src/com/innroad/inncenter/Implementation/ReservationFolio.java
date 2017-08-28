package com.innroad.inncenter.Implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.Interface.IReservationFolio;
import com.innroad.inncenter.Interface.INavigation;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_Reservation;

public class ReservationFolio implements IReservationFolio {
	
	public String GetPaymentMethod;
	public String giftCardnumber;

	
	public void paymentMethod(WebDriver driver, String PaymentType, String CardName,String CCNumber,
			String CCExpiry, String CCVCode, String Authorizationtype,String ChangeAmount,String ChangeAmountValue, String traceData) throws InterruptedException {
		
		Elements_Reservation ReservationFolio = new Elements_Reservation(driver);
		
		ReservationFolio.Click_Pay_Button.click();
	
		TestPaymentPopup(driver,PaymentType, CardName,CCNumber,
			CCExpiry, CCVCode, Authorizationtype,ChangeAmount,ChangeAmountValue,traceData);
		
		
		
	}
	
	public void TestPaymentPopup(WebDriver driver, String PaymentType, String CardName,String CCNumber,
			String CCExpiry, String CCVCode, String Authorizationtype,String ChangeAmount,String ChangeAmountValue, String traceData) throws InterruptedException
	{
		Elements_Reservation ReservationFolio = new Elements_Reservation(driver);
		
		Wait.explicit_wait_xpath(OR.Verify_Payment_Details_poup);
		Wait.wait10Second();
		
		if(PaymentType.equalsIgnoreCase("Cash"))
		{
			new Select (ReservationFolio.Select_Paymnet_Method).selectByVisibleText(PaymentType);
			Wait.wait3Second();
			if(ChangeAmount.equalsIgnoreCase("Yes"))
			{
				//ReservationFolio.Change_Amount.clear();
				//Wait.wait3Second();
				//ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);
				ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"),ChangeAmountValue);
				
			}
			else
			{
				System.out.println("Processed complete amount");
			}
			ReservationFolio.Click_ADD_Button.click();
			Wait.explicit_wait_xpath(OR.Verify_Guest_Ledger);
			Wait.wait3Second();
			try
			{
			GetPaymentMethod=ReservationFolio.Get_Payment_Method.getText();
			System.out.println(GetPaymentMethod + " "+GetPaymentMethod);
			}
			catch(Exception e)
			{
				System.out.println("Payment verification failed");
			}
			try
			{
			if(GetPaymentMethod.equals(PaymentType))
			{
				System.out.println("Paymnet Success");
			}
			else
			{
				System.out.println("Paymnet Failed");
			}
			}
			catch(Exception e)
			{
				System.out.println("Payment verification failed");
			}
			ReservationFolio.Click_Continue.click();
			Wait.wait15Second();
			try
			{
			Wait.explicit_wait_xpath(OR.Verify_Line_item);
			String GetBalance=ReservationFolio.Verify_Balance_Zero.getText();
			System.out.println(GetBalance + " "+GetBalance);
			String RemoveCurreny[]=GetBalance.split(" ");
			System.out.println(RemoveCurreny[1]);
			if(ChangeAmount.equalsIgnoreCase("NO"))
			{
			if(RemoveCurreny[1].equals("0.00"));
			}
			else
			{
				System.out.println("Selected Changed Value");
			}
			}
			catch(Exception e)
			{
				
			}
			
			
		}
		else if(PaymentType.equalsIgnoreCase("MC"))
		{
			new Select (ReservationFolio.Select_Paymnet_Method).selectByVisibleText(PaymentType);
			Wait.wait3Second();
			ReservationFolio.Click_Card_info.click();
			Wait.explicit_wait_xpath(OR.Verify_payment_info_popup);
			Wait.wait3Second();
			ReservationFolio.Enter_Card_Name.sendKeys(CardName);
			ReservationFolio.Enter_Account_Number_Folio.sendKeys(CCNumber);
			ReservationFolio.Enter_CC_Expiry.sendKeys(CCExpiry);
			ReservationFolio.Enter_CVVCode.sendKeys(CCVCode);
			ReservationFolio.Click_OK.click();
			Wait.wait10Second();
			new Select (ReservationFolio.Select_Authorization_type).selectByVisibleText(Authorizationtype);
			if(ChangeAmount.equalsIgnoreCase("Yes"))
			{
				/*ReservationFolio.Change_Amount.clear();
				Wait.wait3Second();
				ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);*/
				ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"),ChangeAmountValue);
			}
			else
			{
				System.out.println("Processed complete amount");
			}
			ReservationFolio.Click_Process.click();
			Wait.wait3Second();
			Wait.explicit_wait_xpath(OR.Verify_MC_Grid);
			String GetPaymentMethod=ReservationFolio.GetMC_Payment_Method.getText();
			System.out.println(GetPaymentMethod + " "+GetPaymentMethod);
			if(GetPaymentMethod.equals(PaymentType))
			{
				System.out.println("Paymnet Success");
			}
			else
			{
				System.out.println("Paymnet Failed");
			}
			ReservationFolio.Click_Continue.click();
			Wait.wait3Second();
			Wait.explicit_wait_xpath(OR.GetAddedLine_MC);
			String GetMCCard=ReservationFolio.GetAddedLine_MC.getText();
			System.out.println(GetMCCard + " "+GetMCCard);
			if(GetMCCard.equals("Name: MC Account #: XXXX5454 Exp. Date: 08/19"))
			{
				System.out.println("Paymnet Success");
			}
			else
			{
				System.out.println("Paymnet Failed");
			}
			String GetBalance=ReservationFolio.Verify_Balance_Zero.getText();
			System.out.println(GetBalance + " "+GetBalance);
			String RemoveCurreny[]=GetBalance.split(" ");
			System.out.println(RemoveCurreny[1]);
			if(ChangeAmount.equalsIgnoreCase("No"))
			{
			if(RemoveCurreny[1].equals("0.00"));
			}
			else
			{
				System.out.println("Selected Changed Value");
			}
			
		}
		else if(PaymentType.equalsIgnoreCase("Swipe"))
		{
			ReservationFolio.Click_Swipe_Icon.click();
			Wait.explicit_wait_xpath(OR.Verify_Swipe_Popup);
			ReservationFolio.Enter_Track_Data.sendKeys(traceData);
			
			if(ChangeAmount.equalsIgnoreCase("Yes"))
			{
				ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"),ChangeAmountValue);
				
			}
			else
			{
				System.out.println("Processed complete amount");
			}
			Wait.wait3Second();
			new Select (ReservationFolio.Select_Authorization_type).selectByVisibleText(Authorizationtype);
			Wait.wait3Second();
			ReservationFolio.Click_Process.click();
			Wait.wait3Second();
			Wait.explicit_wait_xpath(OR.Verify_MC_Grid);
			String GetPaymentMethod=ReservationFolio.GetMC_Payment_Method.getText();
			System.out.println(GetPaymentMethod + " "+GetPaymentMethod);
			if(GetPaymentMethod.equals("MC"))
			{
				System.out.println("Paymnet Success");
			}
			else
			{
				System.out.println("Paymnet Failed");
			}
			ReservationFolio.Click_Continue.click();
			Wait.wait3Second();
			Wait.explicit_wait_xpath(OR.GetAddedLine_MC);
			String GetMCCard=ReservationFolio.GetAddedLine_MC.getText();
			System.out.println(GetMCCard + " "+GetMCCard);
			if(GetMCCard.equals("Name: TEST CARD/MC Account #: XXXX5454 Exp. Date: 12/23"))
			{
				System.out.println("Paymnet Success");
			}
			else
			{
				System.out.println("Paymnet Failed");
			}
			String GetBalance=ReservationFolio.Verify_Balance_Zero.getText();
			System.out.println(GetBalance + " "+GetBalance);
			String RemoveCurreny[]=GetBalance.split(" ");
			System.out.println(RemoveCurreny[1]);
			if(ChangeAmount.equalsIgnoreCase("NO"))
			{
			if(RemoveCurreny[1].equals("0.00"));
			}
			else
			{
				System.out.println("Selected Changed Value");
			}
			
		}
	}

	
	public void Paytype_CP_Account(WebDriver driver, String ChangeAmount, String ChangeAmountValue) throws InterruptedException {
		Elements_Reservation ReservationFolio = new Elements_Reservation(driver);
		ReservationFolio.Click_Pay_Button.click();
		Wait.explicit_wait_xpath(OR.Verify_Payment_Details_poup);
		Wait.wait10Second();
		new Select (ReservationFolio.Select_Paymnet_Method).selectByIndex(1);
		Wait.wait3Second();	
		if(ChangeAmount.equalsIgnoreCase("Yes"))
		{
			//ReservationFolio.Change_Amount.clear();
			//Wait.wait3Second();
			//ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);
			ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"),ChangeAmountValue);
			
		}
		else
		{
			System.out.println("Processed complete amount");
		}
		ReservationFolio.Click_ADD_Button.click();
		Wait.explicit_wait_xpath(OR.Verify_Guest_Ledger);
		Wait.wait3Second();
		try
		{
		GetPaymentMethod=ReservationFolio.Get_Payment_Method.getText();
		System.out.println(GetPaymentMethod + " "+GetPaymentMethod);
		}
		catch(Exception e)
		{
			System.out.println("Payment verification failed");
		}
		try
		{
		if(GetPaymentMethod.equals("account"))
		{
			System.out.println("Paymnet Success");
		}
		else
		{
			System.out.println("Paymnet Failed");
		}
		}
		catch(Exception e)
		{
			System.out.println("Payment verification failed");
		}
		ReservationFolio.Click_Continue.click();
		Wait.wait15Second();
		try
		{
		Wait.explicit_wait_xpath(OR.Verify_CP_Lineitem);
		String GetBalance=ReservationFolio.Verify_Balance_Zero.getText();
		System.out.println(GetBalance + " "+GetBalance);
		String RemoveCurreny[]=GetBalance.split(" ");
		System.out.println(RemoveCurreny[1]);
		if(ChangeAmount.equalsIgnoreCase("NO"))
		{
		if(RemoveCurreny[1].equals("0.00"));
		}
		else
		{
			System.out.println("Selected Changed Value");
		}
		}
		catch(Exception e)
		{
			
		}
	}
public void HouseAccount(WebDriver driver, String Accounttype, String HouseAccountName, String ChangeAmount, String ChangeAmountValue ) throws InterruptedException
{
	Elements_Reservation ReservationFolio = new Elements_Reservation(driver);
	ReservationFolio.Click_Pay_Button.click();
	Wait.explicit_wait_xpath(OR.Verify_Payment_Details_poup);
	Wait.wait10Second();
	new Select (ReservationFolio.Select_Paymnet_Method).selectByVisibleText(Accounttype);
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
	new Select (ReservationFolio.Select_Paymnet_Method).selectByIndex(1);
	Wait.wait10Second();	
	if(ChangeAmount.equalsIgnoreCase("Yes"))
	{
		//ReservationFolio.Change_Amount.clear();
		//Wait.wait3Second();
		//ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);
		ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"),ChangeAmountValue);
		
	}
	else
	{
		System.out.println("Processed complete amount");
	}
	ReservationFolio.Click_ADD_Button.click();
	Wait.explicit_wait_xpath(OR.Verify_Guest_Ledger);
	Wait.wait3Second();
	try
	{
	GetPaymentMethod=ReservationFolio.Get_Payment_Method.getText();
	System.out.println(GetPaymentMethod + " "+GetPaymentMethod);
	}
	catch(Exception e)
	{
		System.out.println("Payment verification failed");
	}
	try
	{
	if(GetPaymentMethod.equals("account"))
	{
		System.out.println("Paymnet Success");
	}
	else
	{
		System.out.println("Paymnet Failed");
	}
	}
	catch(Exception e)
	{
		System.out.println("Payment verification failed");
	}
	ReservationFolio.Click_Continue.click();
	Wait.wait15Second();
	try
	{
	Wait.explicit_wait_xpath(OR.Verify_CP_Lineitem);
	String GetBalance=ReservationFolio.Verify_Balance_Zero.getText();
	System.out.println(GetBalance + " "+GetBalance);
	String RemoveCurreny[]=GetBalance.split(" ");
	System.out.println(RemoveCurreny[1]);
	if(ChangeAmount.equalsIgnoreCase("NO"))
	{
	if(RemoveCurreny[1].equals("0.00"));
	}
	else
	{
		System.out.println("Selected Changed Value");
	}
	}
	catch(Exception e)
	{
		
	}
}

public void GiftCertificate(WebDriver driver, String Accounttype,String ChangeAmount, String ChangeAmountValue ) throws InterruptedException
{
	Elements_Reservation ReservationFolio = new Elements_Reservation(driver);
	ReservationFolio.Click_Pay_Button.click();
	Wait.explicit_wait_xpath(OR.Verify_Payment_Details_poup);
	Wait.wait10Second();
	new Select (ReservationFolio.Select_Paymnet_Method).selectByVisibleText(Accounttype);
	Wait.wait3Second();	
	Wait.explicit_wait_xpath(OR.Verify_Gift_Account_popup);
	try
	{
	FileReader fr= new FileReader(".\\GiftCertificate.txt");
	BufferedReader br = new BufferedReader(fr);
	
	while((giftCardnumber=br.readLine())!=null)
	{
		ReservationFolio.Enter_Gift_ID.sendKeys(giftCardnumber);
	}
	br.close();
	}
	catch(IOException e)
	{
		System.out.println("File not found");
	}

	ReservationFolio.Click_Go_Gift.click();
	Wait.wait5Second();	
	Wait.explicit_wait_xpath(OR.Verify_Gift_Certificate_Grid);
	Wait.wait10Second();
	ReservationFolio.Select_Gift_Certificate.click();
	Wait.wait5Second();
	ReservationFolio.Click_Select_Gift.click();
	Wait.wait10Second();
	new Select (ReservationFolio.Select_Paymnet_Method).selectByIndex(5);
	Wait.wait10Second();	
	if(ChangeAmount.equalsIgnoreCase("Yes"))
	{
		//ReservationFolio.Change_Amount.clear();
		//Wait.wait3Second();
		//ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);
		ReservationFolio.Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"),ChangeAmountValue);
		
	}
	else
	{
		System.out.println("Processed complete amount");
	}
	ReservationFolio.Click_ADD_Button.click();
	Wait.explicit_wait_xpath(OR.Verify_Guest_Ledger);
	Wait.wait3Second();
	try
	{
	GetPaymentMethod=ReservationFolio.Get_Payment_Method.getText();
	System.out.println(GetPaymentMethod + " "+GetPaymentMethod);
	}
	catch(Exception e)
	{
		System.out.println("Payment verification failed");
	}
	try
	{
	if(GetPaymentMethod.equals("account"))
	{
		System.out.println("Paymnet Success");
	}
	else
	{
		System.out.println("Paymnet Failed");
	}
	}
	catch(Exception e)
	{
		System.out.println("Payment verification failed");
	}
	ReservationFolio.Click_Continue.click();
	Wait.wait15Second();
	try
	{
	Wait.explicit_wait_xpath(OR.Verify_CP_Lineitem);
	String GetBalance=ReservationFolio.Verify_Balance_Zero.getText();
	System.out.println(GetBalance + " "+GetBalance);
	String RemoveCurreny[]=GetBalance.split(" ");
	System.out.println(RemoveCurreny[1]);
	if(ChangeAmount.equalsIgnoreCase("NO"))
	{
	if(RemoveCurreny[1].equals("0.00"));
	}
	else
	{
		System.out.println("Selected Changed Value");
	}
	}
	catch(Exception e)
	{
		
	}
}

}
