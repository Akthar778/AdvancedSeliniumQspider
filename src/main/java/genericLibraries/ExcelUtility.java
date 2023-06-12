package genericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String ReadingsingleData(String sheetname, int rolwcolum,int columnumber) throws EncryptedDocumentException, IOException {
		File file = new File("localTime");
		//where we (localTime) take this from screenShot class

		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetname).getRow(rolwcolum).getCell(columnumber).toString();


	}

}
