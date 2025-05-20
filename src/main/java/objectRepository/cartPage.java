package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
	
	@FindBy(className = "inventory_item_name")
	private WebElement itemInfo;
	
	@FindBy(xpath = "//button[.='Remove']")
	private WebElement removeBtn;
	
	/*
	 * @FindBy(className = "inventory_item_price") private WebElement price;
	 * 
	 * @FindBy(id = "checkout") private WebElement checkout;
	 */
	
	
	public cartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getItemInfo() {
		return itemInfo;
	}


	public WebElement getRemoveBtn() {
		return removeBtn;
	}


	/*
	 * public WebElement getPrice() { return price; }
	 * 
	 * 
	 * public WebElement getCheckout() { return checkout; }
	 */
	
	
	//Business Library
	
	public String captureItemName()
	{
		return itemInfo.getText();
	}
	
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}
	
	

}
