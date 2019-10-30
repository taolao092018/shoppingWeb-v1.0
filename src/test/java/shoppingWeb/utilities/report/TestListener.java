package shoppingWeb.utilities.report;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import shoppingWeb.pageObjects.BaseTest;

import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener {
    public CaptureScreenshot cs = new CaptureScreenshot();

    public void onStart(ITestContext testContext){

    }
    public void onTestStart(ITestResult testResult)
    {

    }
    public void onFinish(ITestContext testContext){
        reporter.flush();
    }
    public void onTestSuccess(ITestResult testResult){
        test.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));

    }
    public void onTestFailure(ITestResult testResult){
        try{
            test.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(),ExtentColor.RED));
            test.addScreenCaptureFromPath(cs.captureScreenshot(testResult.getName()));
            test.log(Status.FAIL, (testResult.getThrowable()));

        }catch(IOException e) {
            e.printStackTrace();
        }

    }
    public void onTestSkipped(ITestResult testResult){

        test.log(Status.SKIP,MarkupHelper.createLabel(testResult.getName(),ExtentColor.ORANGE));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

}
