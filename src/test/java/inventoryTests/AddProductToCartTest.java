package inventoryTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;
import objectRepository.cartPage;
import objectRepository.inventoryItemPage;
import objectRepository.inventoryPage;

public class AddProductToCartTest {
	@Test
	public void tc_01_AddProductToCartTest() throws Throwable
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
			    
			    String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 1, 2); //Run Time Data
				
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
				ip.clickOnAProduct(driver, PRODUCTNAME);				
				
				
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
