package takescreenshot;

import org.testng.ITestListener;

public class BaseListener extends MainDetails implements ITestListener 
{
	public void onTestFailure(ITestListener res) 
	{
		System.out.println("Test case is failed");
		failedTestCase(driver);
	}
}
