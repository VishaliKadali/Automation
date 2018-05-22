package com.innroad.inncenter.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

public class Utility extends TestCore {

	public static boolean isExecutable(String test_name, excel_reader excel) {

		String sheetName = "testcases";
		for (int rowNum = 2; rowNum <= excel.getRowCount(sheetName); rowNum++) {
			if (excel.getCellData(sheetName, "test_name", rowNum).equals(test_name)) {
				if (excel.getCellData(sheetName, "runmode", rowNum).equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
		}
		return false;
	}

	// TestNG Parameterization
	public static Object[][] getData(String sheetName, excel_reader excel) {
		// return test data;
		// read test data from xls

		int rows = excel.getRowCount(sheetName) - 1;
		if (rows <= 0) {
			Object[][] testData = new Object[1][0];
			return testData;

		}
		rows = excel.getRowCount(sheetName); // 3
		int cols = excel.getColumnCount(sheetName);
		Object data[][] = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {
				// System.out.println(rowNum-2 + " data "+ sheetName +", "+
				// colNum+", "+ rowNum);
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;

	}

	/*##########################################################################################################################################################################

	' Method Name:	customDateTimeFormat()
	' Description:  This Utility method returns a current time stamp which is used to generate the unique extent report file for each run
	' Input parameters: NA
	' Return value: Time-stamp in String representation
	' Created By: Surender Avula
	' Created On: 06/05/2017		(MM/DD/YYYY)
	' Modified By | Description of Modification:

	###########################################################################################################################################################################*/


	public static String getTimeStamp() {
		return new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new Date()).replaceAll("[-: ]", "_");
	}

	/*##########################################################################################################################################################################

	' Method Name:	archiveExtentReports()
	' Description:  This Utility method will back up the old reports present in the 'reports' directory to 'reports\old' directory.
	' Input parameters: path
	' Return value: NA
	' Created By: Surender Avula
	' Created On: 06/06/2017		(MM/DD/YYYY)
	' Modified By | Description of Modification:
	  ------------------------------------------
	  07/04/2017:Surender Avula:
	  1.Renamed method name from backUpReportFiles()
	  2.Add path argument to method.
	  3.Modified implementation such that checks for the path argument value, root directory and archived (sub-directory) in project working directly and
	    report accordingly.
	  4.Added comments for better readability
	###########################################################################################################################################################################*/


	public static void archiveExtentReports(String path) {

		// verify that path should not be empty
		if (path != "") {

			// file object creation for 'archived' folder present inside
			// extent-reports
			String archiveFolderName = "archived";
			File archiveFolder = new File(path + "\\" + archiveFolderName);

			try {

				// file object creation for extent-reports folder which is root
				// directory for entent reports
				File reportsRootDir = new File(path);

				// verifying root dir (extent-reports) is present in project
				// working directory or not
				if (reportsRootDir.exists()) {

					// get all the files and sub-directory names
					String[] dirListNames = reportsRootDir.list();

					// check with 'archived' sub-directory is present or not in
					// root dir.
					if (!Arrays.asList(dirListNames).contains(archiveFolderName)) {
						try {
							archiveFolder.mkdir(); // create 'archived' folder
													// if not alread present
						} catch (Exception e) {
							System.out.println("failed to created archive folder , " + e.getMessage());
						}
					}

					// move all the existing (if any) reports to archived folder
					for (String name : dirListNames) {
						File reportFile = new File(reportsRootDir, name);
						if (reportFile.isFile()) {
							reportFile
									.renameTo(new File(archiveFolder.getAbsolutePath() + "\\" + reportFile.getName()));
						}
					}
				} else {
					System.out.println(reportsRootDir.getName()
							+ " folder is not present in project working directory, it should be created by extent-reports library "
							+ "hence please verify extent-reports statements in testCore.java file.");
				}

			} catch (NullPointerException npe) {
				System.out.println(npe.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("Path argument is empty, please pass valid path value.");
		}
	}

	/*##########################################################################################################################################################################

	' Method Name:	captureScreenShot(String, WebDriver)
	' Description:  This Utility method returns screenshot file path
	' Input parameters: String, WebDriver
	' Return value: String
	' Created By: Surender Avula
	' Created On: 06/04/2018	(MM/DD/YYYY)
	' Modified By | Description of Modification:

	###########################################################################################################################################################################*/


	public static String captureScreenShot(String name, WebDriver driver) {
		String screenShotPath = System.getProperty("user.dir") + "\\screenshots\\" + name + ".png";
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenShotPath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenShotPath;
	}

	public static void ScrollToElement(WebElement element) throws InterruptedException {
		((JavascriptExecutor) TestCore.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Wait.wait2Second();
	}

	public static String getScreenhot() throws Exception {
		TakesScreenshot ts = (TakesScreenshot) TestCore.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + getTimeStamp() + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static boolean return_element_status_after_explicit_wait(String Element) {

		boolean element_status;
		try {
			Wait.explicit_wait_xpath(Element);
			element_status = true;
		} catch (Exception e)

		{
			element_status = false;
		}
		return element_status;
	}

	public static void updateReport(Exception e, String logMessage, String testName, String pageElement) {

		String strException = e.toString();

		if (strException.contains("NoSuchElementException")) {

			test.log(LogStatus.FAIL, logMessage + "," + " <br> <b> Exception Details: </b>"
					+ strException.substring(0, strException.indexOf("}") + 1)
					+ "<br> <b> Attaching screenshot below : </b>" + test.addScreenCapture(Utility
							.captureScreenShot(testName + "_" + pageElement + "_" + Utility.getTimeStamp(), driver)));

		} else if (strException.contains("TimeoutException")) {

			test.log(LogStatus.FAIL, logMessage + "," + " <br> <b> Exception Details: </b>"
					+ strException.substring(0, strException.indexOf("Build"))
					+ "<br> <b> Attaching screenshot below : </b>" + test.addScreenCapture(Utility
							.captureScreenShot(testName + "_" + pageElement + "_" + Utility.getTimeStamp(), driver)));
		} else if (strException.contains("StaleElementReferenceException")) {

			test.log(LogStatus.FAIL, logMessage + "," + " <br> <b> Exception Details: </b>"
					+ strException.substring(0, strException.indexOf("(") + 1)
					+ "<br> <b> Attaching screenshot below : </b>" + test.addScreenCapture(Utility
							.captureScreenShot(testName + "_" + pageElement + "_" + Utility.getTimeStamp(), driver)));
		} else {

			test.log(LogStatus.FAIL, logMessage + "," + " <br> <b> Exception Details: </b>" + strException
					+ "<br> <b> Attaching screenshot below : </b>" + test.addScreenCapture(Utility
							.captureScreenShot(testName + "_" + pageElement + "_" + Utility.getTimeStamp(), driver)));
		}

		app_logs.error(logMessage + "\n");

		e.printStackTrace();
		throw new SkipException(e.getMessage());

	}

	public static void updateReport(Error e, String logMessage, String testName, String pageElement) {

		String strError = e.toString();

		if (strError.contains("AssertionError")) {

			test.log(LogStatus.FAIL, logMessage + "," + " <br> <b> Exception Details: </b>" + strError
					+ "<br> <b> Attaching screenshot below : </b>" + test.addScreenCapture(Utility
							.captureScreenShot(testName + "_" + pageElement + "_" + Utility.getTimeStamp(), driver)));

		}

		app_logs.error(logMessage + "\n");

		e.printStackTrace();
		throw new SkipException(e.getMessage());

	}
}
