package logreport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomReportUsingITestListener implements ITestListener {

	public void onTestStart(ITestResult nameOfTest) {
		System.out.println("test started -> "+nameOfTest.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test successfully completed -> "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed -> "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
			System.out.println("Test cannot be completed and skipped ->"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("start of execution of test ->"+context.getName());
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
