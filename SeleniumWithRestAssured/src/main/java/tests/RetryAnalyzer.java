package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // Retry up to 2 times

    public RetryAnalyzer() {
        System.out.println("RetryAnalyzer instance created: " + this.hashCode());
    }

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println(" In retry analyzer, count :"+retryCount);
            retryCount++;
            return true;
        }
        return false;
    }
}
