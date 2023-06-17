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

public class ReadingMultipleDataFromExcel {
	public Object[][] readingMultipleData() throws EncryptedDocumentException, IOException, InvalidFormatException{

		File file = new File("src/main/resources/datas.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("sheet1");
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
	@DataProvider(name ="testdata")
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InvalidFormatException {
		ReadingMultipleDataFromExcel d = new ReadingMultipleDataFromExcel();

		Object [][] obj = d.readingMultipleData();
		for (int i = 0; i < obj.length; i++) {
			for (int j = 0; j < obj[i].length; j++) {
				System.out.println(obj[i][j]);
			}
		}
				

	}

}
