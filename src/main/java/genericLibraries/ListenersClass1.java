package genericLibraries;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(genericLibraries.ItestListenderImplementaion.class)
public class ListenersClass1  {
	@Test
	public void demoForListener3() {
		System.out.println("this is test case 3");
	}
	@Test
	public void demoForListener4() {
		System.out.println("this is test case 4");
		assertEquals(true, false);
	}


}
