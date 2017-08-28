package com.innroad.inncenter.Intialize;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.*;

import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Utils.excel_reader;
import com.relevantcodes.extentreports.ExtentReports;

public abstract class testCore {

    //	path variables
    public static String extentReportsPath;
    public static String testDataPath;
    public static String configFilesPath;
    public static ExtentReports extent;


    public static Properties config = new Properties();

    public static excel_reader excel = null;
    public static WebDriver driver = null;
    public static Logger app_logs = Logger.getLogger("testcore");
    public static String appURL;

    @BeforeSuite
    @Parameters("env")
    public void init(String env) throws IOException {
        setupPath();
//		This statement will move old reports present in the 'reports' directory to 'reports\old' directory
        Utility.archiveExtentReports(extentReportsPath);

        appURL = env.replaceAll("\"", "");

        extent.addSystemInfo("Selenium-WebDriver Version", "2.53.1");

        if (appURL.contains("central-park")) {

            extent.addSystemInfo("Environment", "DEVELOPMENT");

        } else if (appURL.contains("app.innroad")) {

            extent.addSystemInfo("Environment", "Production");

        }
        extent.addSystemInfo("Env-URL", appURL);
        extent.loadConfig(new File("extent-config.xml"));
        PropertyConfigurator.configure("Log4j.properties");

    }

    @BeforeMethod
    @Parameters("browser")
    public void initMethod(String browser) throws IOException {

        String chrome_win64 = "Drivers\\windows\\googlechrome\\64bit\\chromedriver.exe";
        String chrome_mac64 = "Drivers/osx/googlechrome/64bit/chromedriver";
        String chrome_linux64 = "Drivers/linux/googlechrome/64bit/chromedriver";
        String firefox_win64 = "Drivers\\windows\\marionette\\64bit\\geckodriver.exe";
        String firefox_linux64 = "Drivers/linux/marionette/64bit/geckodriver";
        String firefox_mac64 = "Drivers/osx/marionette/64bit/geckodriver";

        if (driver == null) {


            if (System.getProperty("os.name").contains("Mac") && System.getProperty("os.arch").contains("64")) {
                if (browser.equals("firefox")) {
                    System.setProperty("webdriver.gecko.driver", firefox_mac64);
                    driver = new FirefoxDriver();
                    app_logs.info("Firefox driver initialized");
                    driver.manage().window().maximize();
                    app_logs.info("window Maximize");
                } else if (browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", chrome_mac64);
                    driver = new ChromeDriver();
                    app_logs.info("chrome driver initialized");
                    driver.manage().window().maximize();
                    app_logs.info("window Maximize");
                } else if (browser.equals("phone")) {
                    System.setProperty("webdriver.chrome.driver", chrome_mac64);
                    driver = new ChromeDriver();
                    app_logs.info("chrome driver initialized");
                    driver.manage().window().setSize(new Dimension(412, 732));
                    app_logs.info("window phone screen size");
                } else if (browser.equals("tablet")) {
                    System.setProperty("webdriver.chrome.driver", chrome_mac64);
                    driver = new ChromeDriver();
                    app_logs.info("chrome driver initialized");
                    driver.manage().window().setSize(new Dimension(768, 1024));
                    app_logs.info("window Tablet screen size");
                }

            }
            if (System.getProperty("os.name").contains("Linux") && System.getProperty("os.arch").contains("64")) {
                if (browser.equals("firefox")) {
                    System.setProperty("webdriver.gecko.driver", firefox_linux64);
                    driver = new FirefoxDriver();
                    app_logs.info("Firefox driver initialized");
                    driver.manage().window().maximize();
                    app_logs.info("window Maximize");

                } else if (browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", chrome_linux64);
                    driver = new ChromeDriver();
                    app_logs.info("chrome driver initialized");
                    driver.manage().window().maximize();
                    app_logs.info("window Maximize");
                } else if (browser.equals("phone")) {
                    System.setProperty("webdriver.chrome.driver", chrome_linux64);
                    driver = new ChromeDriver();
                    app_logs.info("chrome driver initialized");
                    driver.manage().window().setSize(new Dimension(412, 732));
                    app_logs.info("window phone screen size");
                } else if (browser.equals("tablet")) {
                    System.setProperty("webdriver.chrome.driver", chrome_linux64);
                    driver = new ChromeDriver();
                    app_logs.info("chrome driver initialized");
                    driver.manage().window().setSize(new Dimension(768, 1024));
                    app_logs.info("window Tablet screen size");
                }

            } else if (System.getProperty("os.name").contains("Windows") && System.getProperty("os.arch").contains("64")) {
                if (browser.equals("firefox")) {
                    System.setProperty("webdriver.gecko.driver", firefox_win64);
                    driver = new FirefoxDriver();
                    app_logs.info("Firefox driver initialized");
                    driver.manage().window().maximize();
                    app_logs.info("window Maximize");
                } else if (browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", chrome_win64);
                    driver = new ChromeDriver();
                    app_logs.info("chrome driver initialized");
                    driver.manage().window().maximize();
                    app_logs.info("window Maximize");

                } else if (browser.equals("phone")) {
                    System.setProperty("webdriver.chrome.driver", chrome_win64);
                    driver = new ChromeDriver();
                    app_logs.info("chrome driver initialized");
                    driver.manage().window().setSize(new Dimension(412, 732));
                    app_logs.info("window phone screen size");

                } else if (browser.equals("tablet")) {
                    System.setProperty("webdriver.chrome.driver", chrome_win64);
                    driver = new ChromeDriver();
                    app_logs.info("chrome driver initialized");
                    driver.manage().window().setSize(new Dimension(768, 1024));
                    app_logs.info("window Tablet screen size");

                }
            }

            driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

        }

    }


    @AfterSuite
    public void testQuitDriver() {

        //code for sending mails
        //testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
        //mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, "Test Report", "Please find the attached report", TestConfig.reportPath, "Reports.zip");
        extent.flush();


    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
        driver = null;
    }

    private void setupPath() throws IOException {
        if (System.getProperty("os.name").contains("Mac") || System.getProperty("os.name").contains("Linux") && System.getProperty("os.arch").contains("64")) {
            extentReportsPath = System.getProperty("user.dir") + "/extent-reports";
            testDataPath = System.getProperty("user.dir") + "/test-data";
            configFilesPath = System.getProperty("user.dir") + "/config-files";
            extent = new ExtentReports(extentReportsPath + "/Sanity_Execution_Report_" + Utility.getTimeStamp() + ".html", false);
            excel = new excel_reader(testDataPath + "/TestData.xlsx");
            app_logs.info("Excel file loaded");
        } else if (System.getProperty("os.name").contains("Windows") && System.getProperty("os.arch").contains("64")) {
            extentReportsPath = System.getProperty("user.dir") + "\\extent-reports";
            testDataPath = System.getProperty("user.dir") + "\\test-data";
            configFilesPath = System.getProperty("user.dir") + "\\config-files";
            extent = new ExtentReports(extentReportsPath + "\\Sanity_Execution_Report_" + Utility.getTimeStamp() + ".html", false);
            excel = new excel_reader(testDataPath + "\\TestData.xlsx");
            app_logs.info("Excel file loaded");
        }


    }


}


