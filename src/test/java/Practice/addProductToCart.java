package Practice;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class addProductToCart {

	public static void main(String[] args) throws Throwable {
		
		//Read common Data
	    FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	    Properties p = new Properties();
	    p.load(fis);
	    String URL = p.getProperty("url");
	    String USERNAME = p.getProperty("username");
	    String PASSWORD = p.getProperty("password");
	    
	    //Read Data from Excel
	    FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
	    Workbook wb = WorkbookFactory.create(fise);
	    Sheet sh = wb.getSheet("Products");
	    Row rw = sh.getRow(1);
	    Cell cl = rw.getCell(2);
	    String PRODUCTNAME = cl.getStringCellValue();  //Run Time Data
		
		//Launch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load the URL
		driver.get(URL);
		
		//Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//Click on a product
		WebElement ele = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']"));
		String productname = ele.getText();
		ele.click();
		
		
		//Click on add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Validate the product in Cart
		String productIncart = driver.findElement(By.className("inventory_item_name")).getText();
		if(productIncart.equals(productname))
		{
			System.out.println("PASS");
			System.out.println(productIncart);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		//driver.findElement(By.linkText("Logout")).click();
		

	}

}
