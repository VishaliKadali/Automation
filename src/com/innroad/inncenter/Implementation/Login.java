package com.innroad.inncenter.Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innroad.inncenter.Interface.ILogin;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.*;

public class Login implements ILogin  {
	

	@Override
	public void login(WebDriver driver,String url,String Clientcode, String UserID, String Password) throws InterruptedException {
		
		WebElementsLogin wl = new WebElementsLogin(driver);
		//driver.get(url);
		driver.get(testCore.appURL);	// Overriding test-data url value with jenkins build parameter		
		wl.clientCode.sendKeys(Clientcode);
		
		wl.userID.sendKeys(UserID);
		wl.password.sendKeys(Password);
		Wait.wait3Second();
		wl.Login.click();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Wait.explicit_wait_absenceofelement("//div[@class='dvLoading']");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//small[.='Items Per Page']")));
	    Wait.wait5Second();
	    }

	@Override
	public void BE_login(WebDriver driver, String URL)throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebElementsLogin wl = new WebElementsLogin(driver);
		driver.get(URL);
		Wait.wait5Second();
		
	}
	
	
	
	
	
	
	

}
