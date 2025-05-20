package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation of ITestListener Interface of TestNG
 * @author seema
 */

public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		//Capture the method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# "+ methodName+ " -> Test Script Execution Started #");
		
		//Create Test in Extent Report
		test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//Capture the method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# "+ methodName+ " -> Test Script PASS #");
	
		//Log the status as PASS in extent report
		test.log(Status.PASS, methodName+ " -> Test Script PASS");
	
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//Capture the method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# "+ methodName+ " ->  Test Script FAIL #");
	
		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the status as FAIL in extent reports
		test.log(Status.FAIL, methodName+ " ->  Test Script FAIL ");
		
		//Log the exception in extent report
		test.log(Status.WARNING, result.getThrowable());
		
		//capture Screenshot
		JavaUtility j=new JavaUtility();
		SeleniumUtility s= new SeleniumUtility();
		
		//Configure Screenshot name
		String screenshotName=methodName + " - "+j.getSystemDate();
		
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//attach the screenshot to extent report
			test.addScreenCaptureFromPath(path);
		
		}catch (IOException e){
			
				//TODO Auto-generated catch block
				e.printStackTrace();
			
			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		//Capture the method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# "+ methodName+ " ->  Test Script SKIP #");
	
		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the ststus as SKIP in extent reports
		test.log(Status.SKIP, methodName+ " ->  Test Script SKIP");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("# Suite Execution Started #");
		
		//Basic Configuration of Extent Reports
		 ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+ new JavaUtility().getSystemDate()+".html");
		 esr.config().setDocumentTitle("Swag Labs Execution Reports");
		 esr.config().setTheme(Theme.DARK);
		 esr.config().setReportName("Automation Framework Execution");
		 
		 //Report Generation
		 report = new ExtentReports();
		 report.attachReporter(esr);
		 report.setSystemInfo("Base Browser", "MicroSoft Edge");
		 report.setSystemInfo("Base Platform", "Windows");
		 report.setSystemInfo("Base Environment", "Testing");
		 report.setSystemInfo("Reporter Name", "Seema");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("# Suite Execution Finished #");
		
		//Report Generation Extent Report
		report.flush();
	}
	

}
