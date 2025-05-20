package inventoryTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;
import objectRepository.cartPage;
import objectRepository.inventoryItemPage;
import objectRepository.inventoryPage;

public class AddLowestPriceProductTestWithBaseClass extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public void tc_02_AddLowestPriceProductTest() throws Throwable
	
	{
			    
	    //Read Data from Excel
	    
	    String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 3); //Run Time Data
	    String sortoption = fUtil.readDataFromExcelFile("Products", 4, 2);
	    
				
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
		
		
		Assert.assertEquals(ProductIncart, PRODUCTNAME);
		Assert.assertTrue(ProductIncart.equals(PRODUCTNAME));
		System.out.println(ProductIncart);
		/*
		 * if(ProductIncart.equals(PRODUCTNAME)) { System.out.println("PASS");
		 * System.out.println(ProductIncart); } else { System.out.println("FAIL"); }
		 */
		
	}
}
