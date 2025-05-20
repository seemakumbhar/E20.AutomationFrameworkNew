package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class consists of generic methods related to file operations
 * @author Seema
 */

public class FileUtility {
	
	/**
	 * This method will read data from property file and return the value to caller
	 * @throws Throwable 
	 * @return value
	 * @param key
	 */
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
//*******************************************************************************************************	
	
	/**
	 * This method will read data from excel file and return value to caller
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @return value
	 * @throws Throwable
	 */
	
	public String readDataFromExcelFile(String sheetname, int rowNo, int celNo) throws Throwable
	{
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.getRow(rowNo);
		Cell cl = rw.getCell(celNo);
		String value = cl.getStringCellValue();
		return value;
	}


}
