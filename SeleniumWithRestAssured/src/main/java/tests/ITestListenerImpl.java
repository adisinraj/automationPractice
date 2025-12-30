package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ITestListenerImpl implements ITestListener {

    public static WebDriver driver;
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

   /* @Override
    public void onTestFailure(ITestResult testResult){
       System.out.println(testResult.getName());
   //     System.out.println(testResult.getTestContext().getAllTestMethods().toString());
    }


    @Override
    public void onTestStart(ITestResult testResult){
        System.out.println("onTestStart");
//        System.out.println(Arrays.stream(testResult.getTestContext().getAllTestMethods()).toList());

    }

    @Override
    public void onStart(ITestContext iTestContext){
        System.out.println("On start");
       // System.out.println(Arrays.stream(iTestContext.getAllTestMethods()).toList());

    }

    @Override
    public void onFinish(ITestContext iTestContext){
        System.out.println("On finish");
      //  System.out.println(Arrays.stream(iTestContext.getAllTestMethods()).toList());

    }*/


    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        System.out.println("Starting Test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("Test failed: " + result.getThrowable());

        if (driver != null) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String destPath = "screenshots/" + result.getName() + ".png";
            try {
                Files.createDirectories(new File("screenshots").toPath());
                Files.copy(src.toPath(), new File(destPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                test.get().addScreenCaptureFromPath(destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush(); // Write everything to the report
    }


}


