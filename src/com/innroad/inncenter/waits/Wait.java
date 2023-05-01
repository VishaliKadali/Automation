package com.innroad.inncenter.waits;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.innroad.inncenter.testcore.TestCore;

public class Wait {

	public static void wait1Second() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	public static void wait2Second() throws InterruptedException {
		Thread.sleep(2000);
	}

	public static void wait3Second() throws InterruptedException {
		Thread.sleep(3000);
	}

	public static void wait5Second() throws InterruptedException {
		Thread.sleep(5000);
	}

	public static void wait10Second() throws InterruptedException {
		Thread.sleep(10000);
	}

	public static void wait15Second() throws InterruptedException {
		Thread.sleep(16000);
	}

	public static void wait25Second() throws InterruptedException {
		Thread.sleep(26000);
	}

	public static void wait40Second() throws InterruptedException {
		Thread.sleep(41000);
	}

	public static void wait60Second() throws InterruptedException {
		Thread.sleep(60000);
	}

	public static void explicit_wait_xpath(String Element) {
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Element)));
	}

	public static void waitUntilPresenceOfElementLocated(String Element) {
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Element)));
	}
	
	
	public static void explicit_wait_absenceofelement(String Element) {
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Element)));
	}

	public static void explicit_wait_visibilityof_webelement (WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 60);
		wait.until(ExpectedConditions.visibilityOf(Element));
		
	}
	
	public static void explicit_wait_10sec (WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Element));
		
	}
	
	public static void timeCal() {
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}

	public static void waitforloadpage(long startTime, long endTime, double waittime) {

		double totalTime = (endTime - startTime);
		// System.out.println(totalTime + " in Millsecs");
		double TotalTimeinsecs = totalTime / 1000;
		double ActualTime = TotalTimeinsecs - waittime;
		// System.out.println(ActualTime + " in secs");
	}
	

	public static void explicit_wait_elementToBeClickable (WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		
	}
	
<<<<<<< HEAD
=======
	public static void explicit_wait_visibilityof_webelement_120 (WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 120);
		wait.until(ExpectedConditions.visibilityOf(Element));
		
	}
	
	public static void explicit_wait_visibilityof_webelement_150 (WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 150);
		wait.until(ExpectedConditions.visibilityOf(Element));
		
	}
	
>>>>>>> feature/AUTOMATION-90
	public static void WaitForElement(WebDriver driver,String locator){
		FluentWait<ChromeDriver> wait = new FluentWait<ChromeDriver>((ChromeDriver) driver);


		new FluentWait<WebDriver>(driver).withTimeout(50, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS).ignoring(ElementNotVisibleException.class);

<<<<<<< HEAD
		wait.withTimeout(60,TimeUnit.SECONDS);
=======
		wait.withTimeout(200,TimeUnit.SECONDS);
>>>>>>> feature/AUTOMATION-90
		wait.pollingEvery(3, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		List<WebElement> targetElements = wait.until(new Function<ChromeDriver, List<WebElement>>()
		{
			int count=driver.findElements(By.xpath(locator)).size();
			public List<WebElement> apply(ChromeDriver driver) {
		
				List<WebElement> elements = driver.findElements(By.xpath(locator));
				int length = elements.size();
				
				if(length>=1||count>0)
				{

					try {
						Thread.sleep(750);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return elements;

				}
				return null;
			}
		});
	}	
}
