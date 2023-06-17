package dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Methods {
	//methods 1
	@DataProvider (name = "ur name")
	public Object[] demo () {
		Object[] s= {"demo","smaple","manuall"};
		return s;
		
	}
	@Test (dataProvider = "ur name")
	public void testmethod(String s) {
		System.out.println(s);
	}

}
