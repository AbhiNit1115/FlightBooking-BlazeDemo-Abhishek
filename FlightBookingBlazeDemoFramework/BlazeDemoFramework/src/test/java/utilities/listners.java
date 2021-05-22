package blazedemotests;

import org.testng.ITestNGListener;
import org.testng.ITestResult;


public class listners implements ITestNGListener{

	public void onTestStart(ITestResult result) {
		System.out.println("*************Test Startetd:**************"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*************Test is successful**************"+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("*************Test is failed**************"+result.getName());
	}
	public void onTestFinished(ITestResult context) {
		System.out.println("*************Test is Completed**************"+context.getName());
	}

}
