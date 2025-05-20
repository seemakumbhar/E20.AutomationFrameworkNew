package inventoryTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;
import objectRepository.cartPage;
import objectRepository.inventoryItemPage;
import objectRepository.inventoryPage;

public class AddLowestPriceProductTest {
	
	@Test
	public void tc_02_AddLowestPriceProductTest() throws Throwable
	
	{
		
		//Create Object for all Utilities
		
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		
		//Read common Data
	    
	    String URL = fUtil.readDataFromPropertyFile("url");
	    String USERNAME = fUtil.readDataFromPropertyFile("username");
	    String PASSWORD = fUtil.readDataFromPropertyFile("password");
	    
	    //Read Data from Excel
	    
	    String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 3); //Run Time Data
	    String sortoption = fUtil.readDataFromExcelFile("Products", 4, 2);
	    
		
		//Launch the browser
		WebDriver driver=new EdgeDriver();
		sUtil.maximizeWindow(driver);	
		sUtil.addImplicitlyWait(driver);
		
		//Load the URL
		driver.get(URL);
		
		//Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);   //Applying Business Logic
		
		
		//Click on a product
		inventoryPage ip = new inventoryPage(driver);
		ip.clickOnLowestPriceProduct(driver, sortoption, PRODUCTNAME);			
		
		
		//Click on add to cart
		inventoryItemPage iip = new inventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		//Capture screenshot
		/*
		 * String screenshotName="addProductToCart-"+jUtil.getSystemDate(); String
		 * path=sUtil.captureScreenShot(driver, screenshotName);
		 * System.out.println(path);
		 */
		
		
		//Navigate to Cart
		ip.clickOnCartContainer();
		
		//Validate product in Cart
		cartPage cp = new cartPage(driver);
		String ProductIncart = cp.captureItemName();
		if(ProductIncart.equals(PRODUCTNAME))
		{
			System.out.println("PASS");
			System.out.println(ProductIncart);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout of Application
		ip.logoutOfApp();
		
	}

}
