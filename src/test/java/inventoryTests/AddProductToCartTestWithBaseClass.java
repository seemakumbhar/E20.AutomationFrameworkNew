package inventoryTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;
import objectRepository.cartPage;
import objectRepository.inventoryItemPage;
import objectRepository.inventoryPage;

@Listeners(genericUtilities.ListenersImplementation.class)

public class AddProductToCartTestWithBaseClass extends BaseClass {
	@Test(groups = "SmokeSuite")
	public void tc_01_AddProductToCartTest() throws Throwable
	{
	  
		//Read Data from Excel    
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 1, 2); //Run Time Data
		
		
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
		
		Assert.assertEquals(ProductIncart, PRODUCTNAME);
		Assert.assertTrue(ProductIncart.equals(PRODUCTNAME));
		System.out.println(ProductIncart);
		
		/*
		 * if(ProductIncart.equals(PRODUCTNAME)) { System.out.println("PASS");
		 * System.out.println(ProductIncart); } else { System.out.println("FAIL"); }
		 */
		
	}
	
	@Test
	public void sampleTest()
	{
		//Assert.fail();
		System.out.println("Sample");
	}

}
