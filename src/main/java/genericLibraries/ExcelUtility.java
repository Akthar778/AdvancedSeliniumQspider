package genericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	public String ReadingsingleData(String sheetname, int rolwcolum,int columnumber) throws EncryptedDocumentException, IOException, InvalidFormatException {
		File file = new File("localTime");
		//where we (localTime) take this from screenShot class
		
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetname).getRow(rolwcolum).getCell(columnumber).toString();
	}
	@DataProvider(name ="testdata")
	public Object[][] readingMultipleData() throws EncryptedDocumentException, IOException, InvalidFormatException{
		
		File file = new File("src/main/resources/multipledata.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][]data= new Object[rowCount][cellCount];
		for (int row=0;row<rowCount;row++) {
			Row actualRow = sheet.getRow(row);
			//int cell=0;
			for(int cell=0;cell<actualRow.getLastCellNum();cell++) {
				data[row][cell]=actualRow.getCell(cell).toString();
			}
		}		
		return data; 	
	}
}
