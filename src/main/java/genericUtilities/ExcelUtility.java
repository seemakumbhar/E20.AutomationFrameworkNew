package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods to file operation
 */

public class ExcelUtility {
	
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
