package com.innroad.inncenter.Intialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Utils.excel_reader;
import com.innroad.inncenter.test.NavigationFlow;
import com.relevantcodes.extentreports.ExtentReports;

public class testCore {

	// path variables
	public static String extentReportsPath = System.getProperty("user.dir") + "\\extent-reports";
	public static String testDataPath = System.getProperty("user.dir") + "\\test-data";
	public static String configFilesPath = System.getProperty("user.dir") + "\\config-files";

	// public static final ExtentReports extent = new
	// ExtentReports(".\\extent-reports\\reports.html", false);
	public static final ExtentReports extent = new ExtentReports(
			extentReportsPath + "\\InnCenterRegression_Execution_Report_" + Utility.getTimeStamp() + ".html", false);

	public static Properties config = new Properties();
	public static WebDriver driver = null;
	public static excel_reader excel = null;
	public static Logger app_logs = Logger.getLogger("testcore");
	public static String appURL; // it is used to store jenkins build parameter

	// public static monitoringMail mail = new monitoringMail();

	@BeforeSuite
	@Parameters("env")
	public void init(String env) throws IOException {

		// This statement will move old reports present in the 'reports'
		// directory to 'reports\old' directory
		Utility.archiveExtentReports(extentReportsPath);

		appURL = env.replaceAll("\"", "");

		extent.addSystemInfo("Selenium-WebDriver Version", "2.53.1");

		if (appURL.contains("speed.dev")) {

			extent.addSystemInfo("Environment", "SPEED-DEV");

		} else if (appURL.contains("ng.dev")) {

			extent.addSystemInfo("Environment", "NG-DEV");

		} else if (appURL.contains("training")) {

			extent.addSystemInfo("Environment", "TRAINING");

		} else if (appURL.contains("app")) {

			extent.addSystemInfo("Environment", "PRODUCTION");

		} else if (appURL.contains("demo")) {

			extent.addSystemInfo("Environment", "DEMO");
		}

		extent.addSystemInfo("Env-URL", appURL);
		extent.loadConfig(new File("extent-config.xml"));

		if (driver == null) {

			PropertyConfigurator.configure("Log4j.properties");
			// Load the Config Properties file

			// FileInputStream fis = new
			// FileInputStream(System.getProperty("user.dir")+"\\src\\com\\innroad\\inncenter\\properties\\config");
			FileInputStream fis = new FileInputStream(configFilesPath + "\\config");
			config.load(fis);
			app_logs.info("Config property file loaded");

			/*
			 * //Load the Object Properties file fis = new
			 * FileInputStream(System.getProperty("user.dir")+
			 * "\\src\\com\\way2automation\\twitter\\config\\OR.properties");
			 * object.load(fis); app_logs.debug("Object property file loaded");
			 * 
			 * ///fis = new FileInputStream(System.getProperty("user.dir")+
			 * "\\src\\com\\innroad\\inncenter\\properties\\OR.java"); or1=new
			 * OR(); app_logs.debug("Object property file loaded : " +
			 * or1.clientCode);
			 */
			// load the Excel file
			// excel = new
			// excel_reader(System.getProperty("user.dir")+"\\src\\com\\innroad\\inncenter\\testdata\\TestData.xlsx");
			excel = new excel_reader(testDataPath + "\\TestData.xlsx");
			app_logs.info("Excel file loaded");
			
			// Initialize the WebDriver
			if (config.getProperty("browser").equals("firefox")) {

				driver = new FirefoxDriver();
				app_logs.info("Firefox driver initialized");
				driver.manage().window().maximize();
				app_logs.info("window Maximize");

			} else if (config.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver", ".\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				app_logs.info("IE driver initialized");
				driver.manage().window().maximize();
				app_logs.info("window Maximize");

			} else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				app_logs.info("chrome driver initialized");
				driver.manage().window().maximize();
				app_logs.info("window Maximize");

			}

			// driver.get(config.getProperty("url"));
			app_logs.info("Entered URL");
			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

		}

	}

	@AfterSuite
	public void testQuitDriver() {

		// code for sending mails
		// testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
		// mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
		// "Test Report", "Please find the attached report",
		// TestConfig.reportPath, "Reports.zip");
		extent.flush();
		driver.quit();

	}

}

/*
 * public void loadconfig() throws IOException { FileInputStream fis = new
 * FileInputStream(System.getProperty("user.dir")+
 * "\\src\\com\\innroad\\inncenter\\properties\\config"); config.load(fis);
 * app_logs.info("Config property file loaded");
 * if(config.getProperty("browser").equals("firefox")){
 * 
 * driver = new FirefoxDriver(); app_logs.info("Firefox driver initialized");
 * driver.manage().window().maximize(); app_logs.info("window Maximize");
 * 
 * }else if(config.getProperty("browser").equals("ie")){
 * 
 * 
 * System.setProperty("webdriver.ie.driver",
 * "U:\\InnRoad_DataDriven_FrameWork\\Drivers\\IEDriverServer.exe"); driver =
 * new InternetExplorerDriver(); app_logs.info("IE driver initialized");
 * driver.manage().window().maximize(); app_logs.info("window Maximize");
 * 
 * }else if(config.getProperty("browser").equals("chrome")){
 * System.setProperty("webdriver.chrome.driver",
 * "U:\\InnRoad_DataDriven_FrameWork\\Drivers\\chromedriver.exe"); driver = new
 * ChromeDriver(); app_logs.info("chrome driver initialized");
 * driver.manage().window().maximize(); app_logs.info("window Maximize");
 * 
 * } driver.get(config.getProperty("url")); app_logs.info("Entered URL");
 * driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS); }
 */
