package genericLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiFilesUtility implements PropertiFilesInterface {
	public String readingDataFromPropertiFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(commondata);
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
		
	}

}
