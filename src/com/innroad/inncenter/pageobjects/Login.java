package com.innroad.inncenter.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.ILogin;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.*;

public class Login implements ILogin {

	private static Logger loginLogger = Logger.getLogger("Login");

	@Override
	public void login(WebDriver driver, String url, String Clientcode, String UserID, String Password)
			throws InterruptedException {

		WebElementsLogin wl = new WebElementsLogin(driver);
		// driver.get(url);
		driver.get(TestCore.envURL); // Overriding test-data url value with jenkins build parameter
		loginLogger.info("Entered application URL");
		wl.clientCode.sendKeys(Clientcode);
		loginLogger.info("Entered client code");
		wl.userID.sendKeys(UserID);
		loginLogger.info("Entered used id");
		wl.password.sendKeys(Password);
		loginLogger.info("Entered password");
		Wait.wait2Second();
//		Assert.assertEquals("x", "y");
		wl.Login.click();
		loginLogger.info("Clicked on login button");
		
		Wait.WaitForElement(driver, OR.New_Reservation_Button);
		Wait.waitUntilPresenceOfElementLocated(OR.New_Reservation_Button);
//		Wait.explicit_wait_absenceofelement("//div[@class='dvLoading']");
//		Wait.waitUntilPresenceOfElementLocated("//small[.='Items Per Page']");
//		Wait.wait10Second();
	}

	@Override
	public void BE_login(WebDriver driver, String URL) throws InterruptedException {

		WebElementsLogin wl = new WebElementsLogin(driver);
		driver.get(URL);
		Wait.wait5Second();

	}

}
