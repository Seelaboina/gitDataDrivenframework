package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.PageClasses.CustomerPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil{
String inputpath ="./FileInput/Customer.xlsx";
String outputpath ="./FileOutPut/DataDrivenResults.xlsx";
String TCSheet = "CustomerData";
ExtentReports reports ;
ExtentTest logger;
@Test
public void startTest() throws Throwable
{
	//define path of HMTM
	reports = new ExtentReports("./target/ExtentReports/customer.html");
	
	//creat object for excel file utill class
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	// count noof row in sheet
	int rc = xl.rowCount(TCSheet);
	Reporter.log("No of rows are: : " +rc, true);
	//itteate all rows
	for(int i=1; i<=rc; i++)
	{
		logger = reports.startTest("Customer");
		logger.assignAuthor("Niranjan");
		//read all cells
		String cname=xl.getCellData(TCSheet, i, 0);
		String Address=xl.getCellData(TCSheet, i, 1);
		String City=xl.getCellData(TCSheet, i, 2);
		String Country=xl.getCellData(TCSheet, i, 3);
		String Cperson=xl.getCellData(TCSheet, i, 4);
		String Phnumber=xl.getCellData(TCSheet, i, 5);
		String Email=xl.getCellData(TCSheet, i, 6);
		String Mnumber = xl.getCellData(TCSheet, i, 7);
		String Notes=xl.getCellData(TCSheet, i, 8);
		CustomerPage cus = PageFactory.initElements(driver, CustomerPage.class);
		boolean res = cus.add_Customer(cname, Address, City, Country, Cperson, Phnumber, Email, Mnumber, Notes);
		logger.log(LogStatus.INFO, cname+ "--- "+ Address+ "--- "+ City+ "--- "+Country+ "--- "+Cperson+ "--- "+Phnumber+ "--- "+Email+ "--- "+Mnumber+ "--- "+Notes);
		if(res)
		{
			//if res is true write as pass into status cell
			xl.setCellData(TCSheet, i, 9, "pass", outputpath);
			logger.log(LogStatus.PASS, "Customer Add Success");
		}
		else
		{
			//if res is true write as fail into status cell
			xl.setCellData(TCSheet, i, 9, "Fail", outputpath);
			logger.log(LogStatus.FAIL, "Customer Add Failed");
		}
		reports.endTest(logger);
		reports.flush();
	}
}

}
