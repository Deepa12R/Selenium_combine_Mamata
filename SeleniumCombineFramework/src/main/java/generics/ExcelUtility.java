package generics;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class ExcelUtility implements IAutoConstants{
	@DataProvider(name = "testdata")
	/**
	 * This method is used to read multiple data from excel sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public Object[][] readinMutlipleData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		//String sheetname = context.getCurrentXmlTest().getParameter("sheet");
		File file=new File(EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet2");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[rowCount][cellCount];
		for(int row=0;row<rowCount;row++) {
			Row actRow = sheet.getRow(row);
			for(int cell=0;cell<actRow.getPhysicalNumberOfCells();cell++) {
				data[row][cell]=actRow.getCell(cell).toString();
			}
		}
		//workbook.close();
		return data;
	}
}
