package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class inventoryPage extends SeleniumUtility{
	
	// Declaration
	@FindBy(id = "shopping_cart_container")
	private WebElement cartContainerBtn;
	
	@FindBy(className = "product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLnk;
	
	
	// Initialization
	public inventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	// Utilization
	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}


	public WebElement getSortDropDown() {
		return sortDropDown;
	}


	public WebElement getMenuBtn() {
		return menuBtn;
	}


	public WebElement getLogoutLnk() {
		return logoutLnk;
	}


	
	//Business Library
	
	/**
	 * This method will click on dynamic product
	 * @param driver
	 * @param productName
	 */
	public void clickOnAProduct(WebDriver driver, String productName)
	{
		driver.findElement(By.xpath("//div[.='"+productName+"']")).click();
	}
	
	
	

	/**
	 * This method will click on cart container button
	 */
	public void clickOnCartContainer()
	{
		cartContainerBtn.click();
	}
	
	
	/**
	 * This method will logout of Application
	 */
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLnk.click();
	}
	
	
	/**
	 * This method will sort thr lowest price product and click on it
	 * @param driver
	 * @param sortoption
	 * @param productName
	 */
	public void clickOnLowestPriceProduct(WebDriver driver, String sortoption, String productName)
	{
		handleDropDown(sortDropDown, sortoption);
		driver.findElement(By.xpath("//div[.='"+productName+"']")).click();
	}

}
