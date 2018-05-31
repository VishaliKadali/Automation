package com.innroad.inncenter.testcore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.utils.excel_reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestCore {

	// Setting path variables
	public static String extentReportsPath = System.getProperty("user.dir") + "\\extent-reports";
	public static String testDataPath = System.getProperty("user.dir") + "\\test-data";
	public static String configFilesPath = System.getProperty("user.dir") + "\\config-files";

	public static final ExtentReports extent = new ExtentReports(extentReportsPath + "\\InnCenterRegression_Execution_Report_" + Utility.getTimeStamp() + ".html", false);

	public static ExtentTest test;
	
	public static Properties config = new Properties();
	public static WebDriver driver = null;
	public static excel_reader excel = null;
	public static Logger app_logs = Logger.getLogger("Testcore");

	// It is used to store jenkins build parameter
	public static String envURL; 
	
	public static String targetBrowser;
	
	// public static monitoringMail mail = new monitoringMail();
	
	@BeforeSuite
	@Parameters("env")
	public void init(@Optional("https://training.innroad.com/login.html") String env) throws IOException {

		// This statement will move old extent reports present in the 'extent-reports' directory to 'extent-reports\archived' directory
		Utility.archiveExtentReports(extentReportsPath);

		extent.loadConfig(new File("extent-config.xml"));
		
		envURL = env.replaceAll("\"", "");

		System.out.println("##################################################################################");
		System.out.println("EXECUTING Automation REGRESSION SUITE ON: " + envURL + " - ENVIRONMENT.");
		System.out.println("##################################################################################");

		extent.addSystemInfo("Selenium-WebDriver Version", "2.53.1");
		
		String envName=envURL.substring(envURL.indexOf('/')+2, envURL.indexOf('.')).toUpperCase();
		
		switch(envName) {
			case "SPEED": 		extent.addSystemInfo("Environment", "SPEED-DEV");
								break;
			case "NG": 			extent.addSystemInfo("Environment", "NG-DEV");
								break;
			case "TRAINING":	extent.addSystemInfo("Environment", "TRAINING"); 
								break;
			case "APP": 		extent.addSystemInfo("Environment", "PRODUCTION");
								break;
			case "DEMO": 		extent.addSystemInfo("Environment", "DEMO");
								break;
			default: 			extent.addSystemInfo("Environment", "INVAILD, Please check the url");
		}
		
		extent.addSystemInfo("Env-URL", envURL);


		if (driver == null) {

			PropertyConfigurator.configure("Log4j.properties");
			
			// Load the config Properties file
			FileInputStream fis = new FileInputStream(configFilesPath + "\\config");
			config.load(fis);
			app_logs.info("Config property file loaded");

			// Load the Excel file
			excel = new excel_reader(testDataPath + "\\TestData.xlsx");
			app_logs.info("Excel file loaded");

			// Initialize the WebDriver	
			
			targetBrowser=config.getProperty("browser").toUpperCase();
			
			switch(targetBrowser){
				case "FIREFOX": //System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
								driver = new FirefoxDriver();
								break;
				case "IE":		System.setProperty("webdriver.ie.driver", ".\\Drivers\\IEDriverServer.exe");
								driver = new InternetExplorerDriver();
								break;
				case "CHROME":	System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
								driver = new ChromeDriver();
								break;
				default:	    app_logs.info("Please check the brower name in config file ");
				
			}
			
			
			app_logs.info(targetBrowser + " driver is initialized");
			driver.manage().window().maximize();
			app_logs.info("Browser window is maximized");
			
//			Setting default web driver timeout to 30 SECONDS
			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
			
		}

	}

	@AfterSuite
	public void closeDriverInstance() {

		//sending mail
		// testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
		// mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,"Test Report", "Please find the attached report",TestConfig.reportPath, "Reports.zip");
		extent.flush();
		//driver.close();

	}

}

