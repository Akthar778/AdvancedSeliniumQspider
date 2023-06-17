package dataProviders;

import org.testng.annotations.Test;

public class DataUtilization {
	@Test (dataProvider = "ur name",dataProviderClass = DataProvideCalsss.class)
	public void demo(String s) {
		System.out.println(s);
	}

}
