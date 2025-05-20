package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.LoginPage;
import objectRepository.inventoryPage;

/**
 * This class consisits of Basic configuration annotations of TestNG
 * @author seema
 */

public class BaseClass {
	public JavaUtility jUtil=new JavaUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public FileUtility fUtil=new FileUtility();
	
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig1()
	{
		System.out.println("--------Database Connection successful------");
		
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String PValue*/) throws Throwable
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		driver = new FirefoxDriver();
		
		// For Cross browser execution - "Run time Polymorphism - driver"
		
		/*
		 * if(PValue.equals("edge")) { driver=new EdgeDriver(); } else
		 * if(PValue.equals("firefox")) { driver=new FirefoxDriver(); } else {
		 * driver=new EdgeDriver(); }
		 */
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		driver.get(URL);
		
		//For Listeners
		sdriver=driver;
		
		System.out.println("--------Browser Launch successful------");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("--------Login to App successful------");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		inventoryPage ip = new inventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("--------Logout of App successful------");
		
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("--------Browser closure successful------");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig1()
	{
		System.out.println("--------Database Connection closure successful------");
		
	}

}
