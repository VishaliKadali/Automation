package com.innroad.inncenter.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innroad.inncenter.testcore.TestCore;

public class Wait {

	public static void wait2Second() throws InterruptedException {
		Thread.sleep(5000);
	}

	public static void wait3Second() throws InterruptedException {
		Thread.sleep(3000);
	}

	public static void wait5Second() throws InterruptedException {
		Thread.sleep(6000);
	}

	public static void wait10Second() throws InterruptedException {
		Thread.sleep(11000);
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
}
