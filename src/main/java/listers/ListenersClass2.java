package listers;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(genericLibraries.ItestListenderImplementaion.class)
public class ListenersClass2  {
	@Test
	public void demoForListener5() {
		System.out.println("this is test case5");
		assertEquals(true, false);
	}
	@Test
	public void demoForListener6() {
		System.out.println("this is test case 6");
		
	}


}
