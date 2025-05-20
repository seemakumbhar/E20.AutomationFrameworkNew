package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class inventoryItemPage {
	
	@FindBy(id = "add-to-cart")
	private WebElement addTocartBtn;
	
	/*
	 * @FindBy(className = "inventory_details_price") private WebElement price;
	 * 
	 * @FindBy(id = "remove") private WebElement remove;
	 */
	
	
	public inventoryItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getAddTocartBtn() {
		return addTocartBtn;
	}

	/*
	 * public WebElement getPrice() { return price; }
	 * 
	 * 
	 * public WebElement getRemove() { return remove; }
	 */
	
	//Business Library
	
	/**
	 * This method will click on add to cart button
	 */
	
	public void clickOnAddToCartBtn()
	{
		addTocartBtn.click();
	}
	
	
	

}
