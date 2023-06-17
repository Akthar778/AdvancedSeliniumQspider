package listers;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListenderImplementaion  implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("this test is start "+result.getName());
	}
	public void onTestSucess(ITestResult result) {
		System.out.println("this test is sucess "+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("this test is failure "+result.getName());
	}
	public void onStart(ITestResult result) {
		System.out.println("this test is onstart "+result.getName());
	}	
	public void onFinish(ITestResult result) {
		System.out.println("this test is onFinish "+result.getName());
	}

}
